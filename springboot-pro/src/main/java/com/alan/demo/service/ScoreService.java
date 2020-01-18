package com.alan.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/22
 */

@Service
@Slf4j
public class ScoreService {

    @Async
    public void addScore() {
        // TODO: 2019/12/22 模拟睡眠五秒 用于赠送积分处理
        try {
            Thread.sleep(1000 * 5);
//            log.info("----------------处理积分-------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Async("scorePoolTaskExecutor")
    public void addScor2() throws InterruptedException {
        Thread.sleep(1000 * 5);
//        log.info("-------------------处理积分---------------------");
    }
}
