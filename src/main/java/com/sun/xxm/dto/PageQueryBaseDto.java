package com.sun.xxm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageQueryBaseDto {

    private long page;

    private long limit;

    private String keyword = "";

    public void setPage(long page) {
        if (page <= 0) {
            this.page = 1; // Default to 1 if page is 0 or less
        } else {
            this.page = page;
        }
    }

    public void setLimit(long limit) {
        if (limit <= 0) {
            this.limit = 15; // Default to 15 if limit is 0 or less
        } else {
            this.limit = limit;
        }
    }
}
