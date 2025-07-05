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
@ApiModel(value="Teacher对象", description="")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "教师id")
    @TableId(value = "teacherid", type = IdType.AUTO)
    private Integer teacherid;

    @ApiModelProperty(value = "教师编号")
    private String teacherno;

    @ApiModelProperty(value = "教师姓名")
    private String teachername;

    @ApiModelProperty(value = "是否删除")
    private Integer isDelete;


}
