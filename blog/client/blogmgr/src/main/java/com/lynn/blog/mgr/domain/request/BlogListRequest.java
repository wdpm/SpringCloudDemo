package com.lynn.blog.mgr.domain.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BlogListRequest {

    @NotNull
    private Long categoryId;
    @NotNull
    private Integer offset;
    @NotNull
    private Integer limit;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
