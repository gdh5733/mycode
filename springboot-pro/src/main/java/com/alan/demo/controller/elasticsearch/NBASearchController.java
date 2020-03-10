package com.alan.demo.controller.elasticsearch;

import com.alan.demo.entity.NbaPlayer;
import com.alan.demo.service.elasticsearch.NBAPlayerService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/24
 */
@RestController
@RequestMapping("/elasticsearch-nba")
public class NBASearchController {

    @Autowired
    private NBAPlayerService nbaPlayerService;

    @ApiOperation(value = "从数据中查出数据", notes = "从数据中查出数据")
    @GetMapping("/importAll")
    public String importAll() {
        try {
            nbaPlayerService.importAll();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }


    @ApiOperation(value = "使用direct交换机发送", notes = "发送消息")
    @GetMapping("/searchMatch")
    public List<NbaPlayer> searchMatch(@RequestParam(value = "displayNameEn", required = false) String displayNameEn) {
        try {
            return nbaPlayerService.searchMatch("displayNameEn", displayNameEn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "通过term匹配查询", notes = "通过term匹配查询")
    @GetMapping("/searchTerm")
    public List<NbaPlayer> searchTerm(@RequestParam(value = "country", required = false) String country,
                                      @RequestParam(value = "teamName", required = false) String teamName) {
        try {
            if (StringUtils.isNoneBlank(country)) {
                return nbaPlayerService.searchTerm("country", country);
            } else if (StringUtils.isNoneBlank(teamName)) {
                return nbaPlayerService.searchTerm("teamName", teamName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "使用searchMatchPrefix", notes = "使用searchMatchPrefix")
    @GetMapping("/searchMatchPrefix")
    public List<NbaPlayer> searchMatchPrefix(@RequestParam(value = "displayNameEn", required = false) String displayNameEn) {
        try {
            return nbaPlayerService.searchMatchPrefix("displayNameEn", displayNameEn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "查询文档信息", notes = "查询文档信息")
    @GetMapping("/searchDoc")
    public Map<String, Object> searchOneDoc(@RequestParam(value = "docid", required = true) String docid) {
        try {
            Map<String, Object> map = nbaPlayerService.getPlayer(docid);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
