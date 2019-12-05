package com.lynn.blog.comment.api;

import com.lynn.blog.comment.api.impl.TestServiceErrorFeign;
import com.lynn.blog.pub.config.MyFeignConfiguration;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(value = "test",fallback = TestServiceErrorFeign.class,configuration = MyFeignConfiguration.class)
@FeignClient(value = "test",fallback = TestServiceErrorFeign.class)
//@FeignClient(value = "test")
public interface TestServiceFeign {

//    @RequestLine("GET /test")
    @GetMapping("/test")
    String test();
}
