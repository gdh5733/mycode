package com.alan.demo.service.elasticsearch;

import com.alan.demo.entity.NbaPlayer;
import com.alan.demo.mapper.NbaPlayerMapper;
import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/24
 */

@Service
public class NBAPlayerServiceImpl implements NBAPlayerService {

    @Resource
    private RestHighLevelClient client;

    @Resource
    private NbaPlayerMapper nbaPlayerDao;

    private static final String NBA_INDEX = "nba_latest";

    private static final int START_OFFSET = 0;

    private static final int MAX_COUNT = 1000;


    /**
     * 添加文档
     *
     * @param player 具体nba球员信息
     * @param id     文档id
     * @return
     * @throws IOException
     */
    @Override
    public boolean addPlayer(NbaPlayer player, String id) throws IOException {
        IndexRequest request = new IndexRequest(NBA_INDEX).id(id).source(beanToMap(player));
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println(JSONObject.toJSON(response));
        return false;
    }

    /**
     * 通过文档id 查找球员信息
     *
     * @param id 文档id
     * @return
     * @throws IOException
     */
    @Override
    public Map<String, Object> getPlayer(String id) throws IOException {
        GetRequest getRequest = new GetRequest(NBA_INDEX, id);
        GetResponse response = client.get(getRequest, RequestOptions.DEFAULT);
        return response.getSource();
    }

    /**
     * 通过文档id更新 球员信息
     *
     * @param player 球员信息
     * @param id     文档id
     * @return
     * @throws IOException
     */
    @Override
    public boolean updatePlayer(NbaPlayer player, String id) throws IOException {
        UpdateRequest request = new UpdateRequest(NBA_INDEX, id).doc(beanToMap(player));
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        System.out.println(JSONObject.toJSON(response));
        return true;
    }

    /**
     * 删除一个文档
     *
     * @param id
     * @return
     * @throws IOException
     */
    @Override
    public boolean deletePlayer(String id) throws IOException {
        DeleteRequest request = new DeleteRequest(NBA_INDEX, id);
        client.delete(request, RequestOptions.DEFAULT);
        return true;
    }

    /**
     * 删除全部的文档
     *
     * @return
     * @throws IOException
     */
    @Override
    public boolean deleteAllPlayer() throws IOException {
        DeleteByQueryRequest request = new DeleteByQueryRequest(NBA_INDEX);
        BulkByScrollResponse response = client.deleteByQuery(request, RequestOptions.DEFAULT);
        return true;
    }


    /**
     * 从关系型数据中 像 es服务器导入数据
     *
     * @return
     * @throws IOException
     */
    @Override
    public boolean importAll() throws IOException {
        List<NbaPlayer> list = nbaPlayerDao.selectAll();
        for (NbaPlayer player : list) {
            addPlayer(player, String.valueOf(player.getId()));
        }
        return true;
    }

    @Override
    public List<NbaPlayer> searchMatch(String key, String value) throws IOException {
        SearchRequest searchRequest = new SearchRequest(NBA_INDEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery(key, value));
        searchSourceBuilder.from(START_OFFSET);
        searchSourceBuilder.size(MAX_COUNT);
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSONObject.toJSON(response));

        SearchHit[] hits = response.getHits().getHits();
        List<NbaPlayer> playerList = new LinkedList<>();
        for (SearchHit hit : hits) {
            NbaPlayer player = JSONObject.parseObject(hit.getSourceAsString(), NbaPlayer.class);
            playerList.add(player);
        }

        return playerList;
    }

    @Override
    public List<NbaPlayer> searchTerm(String key, String value) throws IOException {
        SearchRequest searchRequest = new SearchRequest(NBA_INDEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termQuery(key, value));
        searchSourceBuilder.from(START_OFFSET);
        searchSourceBuilder.size(MAX_COUNT);
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSONObject.toJSON(response));

        SearchHit[] hits = response.getHits().getHits();
        List<NbaPlayer> playerList = new LinkedList<>();
        for (SearchHit hit : hits) {
            NbaPlayer player = JSONObject.parseObject(hit.getSourceAsString(), NbaPlayer.class);
            playerList.add(player);
        }

        return playerList;
    }


    @Override
    public List<NbaPlayer> searchMatchPrefix(String key, String value) throws IOException {
        SearchRequest searchRequest = new SearchRequest(NBA_INDEX);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.prefixQuery(key, value));
        searchSourceBuilder.from(START_OFFSET);
        searchSourceBuilder.size(MAX_COUNT);
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSONObject.toJSON(response));

        SearchHit[] hits = response.getHits().getHits();
        List<NbaPlayer> playerList = new LinkedList<>();
        for (SearchHit hit : hits) {
            NbaPlayer player = JSONObject.parseObject(hit.getSourceAsString(), NbaPlayer.class);
            playerList.add(player);
        }
        return playerList;
    }

    /**
     * 将对象转换为Map对象
     *
     * @param bean
     * @param <T>
     * @return
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = new HashMap<>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                if (beanMap.get(key) != null) {
                    map.put(key + "", beanMap.get(key));
                }
            }
        }
        return map;
    }
}
