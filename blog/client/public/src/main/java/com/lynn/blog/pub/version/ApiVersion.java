package com.lynn.blog.pub.version;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * define API version number
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Mapping
@Documented
public @interface ApiVersion {

    /**
     * version number: 1,2,3,...
     * @return
     */
    int value();
}
