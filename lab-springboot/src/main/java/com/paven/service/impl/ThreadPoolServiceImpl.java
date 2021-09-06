package com.paven.service.impl;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.paven.service.ThreadPoolService;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

/**
 * @author cpw
 * @date 2021/9/3 11:06 上午
 */
@Service
public class ThreadPoolServiceImpl implements ThreadPoolService {

    /**
     * 初始化线程池。
     */
    private final ExecutorService executors = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build(), new ThreadPoolExecutor.CallerRunsPolicy());


}
