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
@ApiModel(value="ClazzCourse对象", description="")
public class ClazzCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ccid", type = IdType.AUTO)
    private Integer ccid;

    @ApiModelProperty(value = "班级id")
    private Integer clazzid;

    @ApiModelProperty(value = "课程id")
    private Integer courseid;

    @ApiModelProperty(value = "学期")
    private String term;


}
