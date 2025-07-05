package com.yxb.teaching_assessment.biz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
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
@ApiModel(value="Student对象", description="")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学生id")
    @TableId(value = "studentid", type = IdType.AUTO)
    private Integer studentid;

    @ApiModelProperty(value = "学号")
    private String studentno;

    @ApiModelProperty(value = "姓名")
    private String studentname;

    @ApiModelProperty(value = "班级id")
    private Integer clazzid;

    @ApiModelProperty(value = "是否删除")
    private Integer isDelete;



}
