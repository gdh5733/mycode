package com.alan.demo.utils.juc.其它;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Descriptionv ForkJoinPool 分支/合并框架  工作窃取
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/2
 */

public class TestForkJoinPool {


    public static void main(String[] args) {
        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L, 100000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();

        System.out.println("耗费时间为:" + Duration.between(start, end));
    }
}

class ForkJoinSumCalculate extends RecursiveTask<Long> {

    private static final long serialVersionUID = 5232453952276485270L;


    private long start;
    private long end;

    private static final long THURSHOLD = 10000L;  //临界值


    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        long length = end - start;
        if (length <= THURSHOLD) {
            long sum = 0L;

            for (long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;

            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, middle);
            left.fork();  //进行拆分  同时压入线程队列

            ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle + 1, end);
            right.fork();//进行拆分 同时压入线程队列

            return left.join() + right.join();
        }
    }
}
