package com.alan.demo.utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 文件上传 下载 工具类
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/3/9
 */

@Slf4j
public class FtpUtils {


    //ftp服务器ip地址
    private static final String FTP_ADDRESS = "192.168.1.6";

    //端口号
    private static final int FTP_PORT = 21;

    //用户名
    private static final String FTP_USERNAME = "user-file";

    //密码
    private static final String FTP_PASSWORD = "123";


    //附件路径
    private static final String FTP_BASEPATH = "/home/user-file/files";

    //上传文件
    public static Object uploadFile(String fileName, InputStream input) {
        Map<String, String> map = new HashMap<>();
        map.put("url", FTP_ADDRESS + fileName);
        boolean success = false;

        FTPClient ftp = new FTPClient();

        int reply;
        try {
            //连接FTP服务器
            ftp.connect(FTP_ADDRESS, FTP_PORT);
            //登录
            ftp.login(FTP_USERNAME, FTP_PASSWORD);
            reply = ftp.getReply();

            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return false;
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(FTP_BASEPATH);
            ftp.changeWorkingDirectory(FTP_BASEPATH);
            ftp.enterLocalActiveMode();
            ftp.storeFile(fileName, input);
            input.close();
            ftp.logout();
            success = true;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }


    /**
     * 从ftp中下载文件
     *
     * @param path     ftp文件路径
     * @param fileName ftp文件名
     * @return
     */
    public static ResponseEntity<InputStreamResource> downFile(String path, String fileName, String newName, String suffix) {

//        String route = "static" + SEPARATOR + "templates" + SEPARATOR;
//        String path = null;
        ResponseEntity<InputStreamResource> response = null;
        try {
//            path = route + filePath + SEPARATOR + fileName;
            ClassPathResource classPathResource = new ClassPathResource(path);
            InputStream inputStream = classPathResource.getInputStream();
            File file = new File(path);
            if (file == null) {
                return null;
            }
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Content-Disposition",
                    "attachment; filename="
                            + new String(newName.getBytes("gbk"), "iso8859-1") + suffix);
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            response = ResponseEntity.ok().headers(headers)
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new InputStreamResource(inputStream));
        } catch (FileNotFoundException e1) {
            log.error("找不到指定的文件", e1);
        } catch (IOException e) {
            log.error("获取不到文件流", e);
        }
        return response;

    }

}



