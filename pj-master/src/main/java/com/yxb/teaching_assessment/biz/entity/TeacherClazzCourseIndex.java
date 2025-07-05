package com.yxb.teaching_assessment.biz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * 
 * @since 2025-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TeacherClazzCourseIndex对象", description="")
public class TeacherClazzCourseIndex implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "tcciid", type = IdType.AUTO)
    private Integer tcciid;

    private Integer tccid;

    /*private Integer indexid;*/

    private Integer score;

    private Integer userid;

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    private Integer teacherid;

    private Boolean delflag;


}
