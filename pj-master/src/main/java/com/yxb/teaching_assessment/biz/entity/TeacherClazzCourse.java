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
 * InnoDB free: 31744 kB
 * </p>
 *
 * 
 * @since 2025-07-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TeacherClazzCourse对象", description="InnoDB free: 31744 kB")
public class TeacherClazzCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "tccid", type = IdType.AUTO)
    private Integer tccid;

    @ApiModelProperty(value = "教师id")
    private Integer teacherid;

    private Integer ccid;

    private String term;

    @ApiModelProperty(value = "是否删除")
    private Integer isDelete;


}
