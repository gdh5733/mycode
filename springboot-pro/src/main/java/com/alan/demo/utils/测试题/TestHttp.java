package com.alan.demo.utils.测试题;
import cn.hutool.core.lang.UUID;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Ordering;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/4/20
 */

public class TestHttp {

    public static String SECRET = "98455d163488a2";
    public static String APP_KEY = "d62a540978cf";
    public static String TOKEN = "ed72bdaef7b635ecf9279147x76d6a55";

    public static void main(String[] args) throws UnsupportedEncodingException {
        String action = "panda.shop.get";

        HttpRequest httpRequest = HttpUtil.createPost("http://test.xiongmaodangao.com/testcase/v1");
        JSONObject requestJson = new JSONObject();
        requestJson.put("token", TOKEN);
        requestJson.put("nop", "1.0.0");
        requestJson.put("action", action);
        requestJson.put("id", UUID.randomUUID().toString());

        //metas需要补充
        JSONObject metas = new JSONObject();

        Date date = new Date();
        metas.put("app_key", APP_KEY);
        metas.put("timestamp", date.getTime());

        requestJson.put("metas", metas);
        //params需要补充
        JSONObject params = new JSONObject();
        params.put("orderId", "100027526535707064");

        requestJson.put("params", params);

        //组合签名内容
        Map<String, Object> signMap = new HashMap<>();

        signMap.put("orderId", params.get("orderId"));
        signMap.put("app_key", APP_KEY);
        signMap.put("timestamp", date.getTime());


        /**************这里需要补充,签名信息********************/
        String sign = sign(action, TOKEN, SECRET, signMap);
        requestJson.put("signature",sign);
        /**********************************/

        //打印签名
        System.out.println("签名：" + sign);
        //发送请求
        httpRequest.body(requestJson.toJSONString(), "application/json; charset=utf-8");
        HttpResponse response = httpRequest.execute();
        //打印结果
        System.out.println(response.body());
    }

    /**
     * 这里需要补充签名内容
     */
    private static String sign(String action, String token, String secret, Map<String, Object> params) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();

        StringBuilder sb = stringBuilder.append(action).append(token);

        //排序
        List<String> keys = Ordering.usingToString().sortedCopy(params.keySet());

        //循环处理metas和params参数值
        for (int i = 0; i < keys.size(); i++) {
            sb.append(i);
        }

        System.out.println("待签名：" + sb.toString());
        return stringToMD5(sb.toString()).toUpperCase();
    }

    private static String stringToMD5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
}
