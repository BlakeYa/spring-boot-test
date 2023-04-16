package org.example.mystarter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * ZQ Zhang 2022/5/26-1:58 PM
 * 线程池配置类
 * 开启同步注解  
 * 当在配置类上使用 @EnableAsync 注解时，Spring 会查找所有带有 @Async 注解的方法，并在调用 
 * 这些方法时使用异步执行。这意味着这些方法的调用将在单独的线程中执行，而不会阻塞调用线程。
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {

    // 创建ThreadPoolTaskExecutor线程池对象
    @Bean("myThread")
    public ThreadPoolTaskExecutor bugUpdateThreadExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //最大线程数
        executor.setMaxPoolSize(5);
        //核心线程数
        executor.setCorePoolSize(5);
        //任务队列大小
        executor.setQueueCapacity(2000);
        //线程前缀名
        executor.setThreadNamePrefix("async-");
        //线程存活时间-默认60秒
        executor.setKeepAliveSeconds(30);
        //没有任务分配的所有线程，在等待 keepAliveTime 时间后全部回收掉。
        executor.setAllowCoreThreadTimeOut(true);
        /*
         * 拒绝处理策略
         * CallerRunsPolicy()：交由调用方线程运行，比如 main 线程。
         * AbortPolicy()：直接抛出异常。
         * DiscardPolicy()：直接丢弃。
         * DiscardOldestPolicy()：丢弃队列中最老的任务。
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        executor.initialize();
        return executor;
    }
}
