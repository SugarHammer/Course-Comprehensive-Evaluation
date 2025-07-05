package com.yxb.teaching_assessment.biz.controller;

import com.yxb.teaching_assessment.biz.entity.Index;
import com.yxb.teaching_assessment.biz.mapper.IndexMapper;
import com.yxb.teaching_assessment.biz.service.IndexService;
import com.yxb.teaching_assessment.biz.vo.AbstractBaseCtrl;
import com.yxb.teaching_assessment.biz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "调查问卷")
@RequestMapping("/index")
public class IndexController extends AbstractBaseCtrl {
   @Autowired
    IndexService indexService;
  @Autowired
    IndexMapper indexMapper;
    @ApiOperation(value = "问卷查询")
    @GetMapping("/findAll")
    public ResultVO findAll(){
        List<Index> list=indexMapper.findAll();
       return  success(list);
   }

    @GetMapping("/delete")
    @ApiOperation(value ="删除班级" )
    public  ResultVO delete (@RequestParam("indexid") String Indexid){
        if(Indexid==null){
            return error("获取问题失败");
        }else {
            int ret=indexService.delete(Indexid);
            if(ret==1){
                return  success("删除问题成功");
            }else {
                return error("删除问题失败");
            }
        }

    }



   @PostMapping("/add")
    @ApiOperation(value = "增加问题")
    public  ResultVO add(@RequestBody Index index1){
        int ret =indexService.insert(index1);
        if(ret==1){
            return success("新增成功");
        }else {
            return  error("新增失败");
        }
    }
    @PostMapping("/update")
    @ApiOperation(value = "更改问题")
    public ResultVO update(@RequestBody Index index){
       if(index.getIndexid()==null){
           return error("获取问题失败");
       }else {
           int ret= indexService.update(index);
           if(ret==1){
               return success("更改成功");
           }else {
               return error("更改失败");
           }
       }
    }
    @ApiOperation(value = "问卷查询分页")
    @GetMapping("/findAllpage")
     public ResultVO findAllPage(@RequestParam("page") int page,@RequestParam("limit") int limit){
        List<Index> list=indexMapper.findAllPage(page,limit);
    int count=indexMapper.findAll().size();
        return  success(count,list);
    }



}
