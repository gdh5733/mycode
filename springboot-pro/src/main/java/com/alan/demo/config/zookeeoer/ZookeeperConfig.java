package com.alan.demo.config.zookeeoer;

import org.springframework.context.annotation.Configuration;

/**
 * @Description zookeeper配置文件
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/13
 */

@Configuration
public class ZookeeperConfig {

    private final static String CONNECTSTRING = "192.168.1.6:2181";

    private final static int SESSION_TIMEOUT = 50 * 1000;

//    public Zookeeper
}
