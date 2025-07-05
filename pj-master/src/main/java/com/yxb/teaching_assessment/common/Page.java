package com.yxb.teaching_assessment.common;

import lombok.Data;

import java.io.Serializable;
@Data
public class Page implements  Serializable {
    private  int page;//当前页
    private int count;//总页数
    private int limit;//每页中的数据条数


}
