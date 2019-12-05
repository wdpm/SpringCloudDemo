package com.lynn.blog.pub.version;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

     // /v[1-9]/
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)/");
     
    private int apiVersion;
     
    public ApiVersionCondition(int apiVersion){
        this.apiVersion = apiVersion;
    }

    @Override
    public ApiVersionCondition combine(ApiVersionCondition other) {
        // method definition can override class level definition.
        return new ApiVersionCondition(other.getApiVersion());
    }

    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {
        Matcher m = VERSION_PREFIX_PATTERN.matcher(request.getRequestURI());
        if(m.find()){
            Integer version = Integer.valueOf(m.group(1));
            if(version >= this.apiVersion){
                return this;
            }
        }
        return null;
    }

    @Override
    public int compareTo(ApiVersionCondition other, HttpServletRequest request) {
        // prefer newer version number
        return other.getApiVersion() - this.apiVersion;
    }
 
    public int getApiVersion() {
        return apiVersion;
    }
}
