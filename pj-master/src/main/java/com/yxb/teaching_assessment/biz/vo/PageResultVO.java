package com.yxb.teaching_assessment.biz.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class PageResultVO<T> extends ResultVO<T> {
    private Long page;//页数

    private Long rows;//行数

    private Long total;//总数

    public PageResultVO(Long page, Long rows, Long count) {
        this.page = page;
        this.rows = rows;
        this.total = count;
    }

    public PageResultVO(T data, Long page, Long rows, Long count) {
        super(data);
        this.page = page;
        this.rows = rows;
        this.total = count;
    }
}
