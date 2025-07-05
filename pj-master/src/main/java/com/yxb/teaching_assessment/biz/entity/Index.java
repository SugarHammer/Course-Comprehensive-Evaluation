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
/*@Data*/
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Index对象", description="")
public class Index implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "indexid", type = IdType.AUTO)
    private Integer indexid;

    private String indexname;

    private String option1;

    private Integer score1;

    private String option2;

    private Integer score2;

    private String option3;

    private Integer score3;

    private String option4;

    private Integer score4;

    private Boolean delflg;

    public Integer getIndexid() {
        return indexid;
    }

    public void setIndexid(Integer indexid) {
        this.indexid = indexid;
    }
    public String getIndexname() {
        return indexname;
    }

    public void setIndexname(String indexname) {
        this.indexname = indexname;
    }
    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }
    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }
    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }
    public Integer getScore2() {
        return score2;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
    }
    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }
    public Integer getScore3() {
        return score3;
    }

    public void setScore3(Integer score3) {
        this.score3 = score3;
    }
    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }
    public Integer getScore4() {
        return score4;
    }

    public void setScore4(Integer score4) {
        this.score4 = score4;
    }
    public Boolean getDelflg() {
        return delflg;
    }

    public void setDelflg(Boolean delflg) {
        this.delflg = delflg;
    }

    @Override
    public String toString() {
        return "Index{" +
                "indexid=" + indexid +
                ", indexname=" + indexname +
                ", option1=" + option1 +
                ", score1=" + score1 +
                ", option2=" + option2 +
                ", score2=" + score2 +
                ", option3=" + option3 +
                ", score3=" + score3 +
                ", option4=" + option4 +
                ", score4=" + score4 +
                ", delflg=" + delflg +
                "}";
    }

}
