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
@ApiModel(value="Clazz对象", description="InnoDB free: 31744 kB")
public class Clazz implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "班级id")
    @TableId(value = "clazzid", type = IdType.AUTO)
    private Integer clazzid;

    @ApiModelProperty(value = "班级编号")
    private String clazzno;

    @ApiModelProperty(value = "班级名称")
    private String classname;

    @ApiModelProperty(value = "所属部门（学院）")
    private Integer departmentid;

    @ApiModelProperty(value = "是否删除")
    private Integer isDelete;


}
