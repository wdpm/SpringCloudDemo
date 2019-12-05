package com.lynn.blog.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class TestHystrixCommand extends HystrixCommand<String> {

    public TestHystrixCommand(String groupKey){
        super(HystrixCommandGroupKey.Factory.asKey(groupKey));
    }

    @Override
    protected String run() {
        try {
            //模拟HTTP请求超时
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "TestHystrixCommand ok!";// #mock do something here.
    }

    @Override
    protected String getFallback() {
        return "TestHystrixCommand fallback.";
    }
}
