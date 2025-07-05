package com.yxb.teaching_assessment.biz.entity;

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
@ApiModel(value="Course对象", description="")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "课程id")
    private Integer courseid;

    @ApiModelProperty(value = "课程编号")
    private String courseno;

    @ApiModelProperty(value = "课程名称")
    private String coursename;

    @ApiModelProperty(value = "是否删除")
    private Integer isDelete;


}
