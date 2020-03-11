package com.alan.demo.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description 开启异步 自定义线程池 (springboot默认的线程池)
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/12/22
 */

@Configuration
@EnableAsync
public class SynConfiguration {

    public ThreadPoolTaskExecutor getScorePoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();

        //核心线程数
        taskExecutor.setCorePoolSize(10);

        //线程池维护线程的最大数量 只有在缓冲队列满了之后才会申请超过核心线程的数量
        taskExecutor.setMaxPoolSize(100);

        //缓存队列
        taskExecutor.setQueueCapacity(50);

        //允许的空闲时间 当超过了核心线程之外的线程在空闲时间到达之后会被销毁
        taskExecutor.setKeepAliveSeconds(200);

        //异步方法内部的线程名称
        taskExecutor.setThreadNamePrefix("score-");
        /**
         * 当线程池的任务缓存队列已满 并且线程池中的线程数达到maximumPoolSize,如果还有任务到来就会采取任务拒绝策略
         *
         */
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.initialize();
        return taskExecutor;
    }
}
