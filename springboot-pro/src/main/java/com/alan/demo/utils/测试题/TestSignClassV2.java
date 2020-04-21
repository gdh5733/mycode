package com.alan.demo.utils.测试题;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.google.common.collect.Ordering;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 题目2根据代码模板完善功能
 * 返回正确请求内容
 * {"msg":"处理成功","result":"请求成功：[b9b88e31-45a3-4f65-b8e2-a303f1399e04]","code":200}
 */
public class TestSignClassV2 {

    public static String SECRET = "98455d163488a2";
    public static String APP_ID = "d62a540978cf";

    public static void main(String[] args) throws UnsupportedEncodingException {
        String requestUrl = "http://test.xiongmaodangao.com/testcase/v2";
        HttpRequest httpRequest = HttpUtil.createPost(requestUrl);
        /**start 加入请求参数**/
        Map<String, Object> map = new HashMap<>();

        Date date = new Date();
        long timestamp = date.getTime();
        map.put("app_id", APP_ID);
        map.put("timestamp", timestamp);
        map.put("shopCode", "T0008");
        map.put("shopId", "1001");
        /**end 加入请求参数**/

        /**start 签名**/
        String sign = sign(requestUrl, map, SECRET);

        map.put("sig", sign);
        /**end 签名**/

        //加入请求参数
        httpRequest.form(map);

        //发送请求
        HttpResponse response = httpRequest.execute();
        //打印结果
        System.out.println(response.body());
    }

    //补充方法
    private static String sign(String uri, Map<String, Object> params, String secret) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        /**start 补充签名**/
        List<String> keys = Ordering.usingToString().sortedCopy(params.keySet());//key排序
        stringBuilder.append(uri).append("?");
        for (String k : keys) {
            try {
                stringBuilder.append(k).append("=").append(URLDecoder.decode(String.valueOf(params.get(k)), "utf-8")).append("&");

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        stringBuilder.append("sig");
        stringBuilder.append("=").append(secret);

        /**end 补充签名**/
        System.out.println("待签名：" + stringBuilder.toString());
        return stringToMD5(stringBuilder.toString()).toLowerCase();
    }

    //MD5
    public static String stringToMD5(String plainText) {
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
