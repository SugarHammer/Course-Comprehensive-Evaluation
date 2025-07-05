package com.yxb.teaching_assessment.biz.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *
 */
public abstract class AbstractBaseCtrl {
    @Autowired
    protected HttpServletRequest request;

    protected ResultVO success(Object data){
        return new ResultVO<>(data);
    }
    protected ResultVO success(Object count,Object data){
        return new ResultVO<>(count,data);
    }
    protected ResultVO success(){
        return new ResultVO<>();
    }
    protected  ResultVoPage success1(Object data){ return new ResultVoPage<>(data);}
    protected  ResultVoPage success1(Object count,Object data){ return new ResultVoPage<>(count,data);}
    /*protected PageResultVO success(IPage page){
        return new PageResultVO(page.getRecords(),page.getCurrent(),page.getSize(),page.getTotal());
    }*/

    protected ResultVO failed(){
        return new ResultVO<>(false,"5001","失败",null);
}

    protected ResultVO exception(){
        return new ResultVO<>(false,"500","异常",null);
    }

    protected ResultVO error(){
        return new ResultVO<>(false,"600","错误",null);
    }

    protected ResultVO error(String msg){
        return new ResultVO<>(false,"600",msg,null);
    }
}
