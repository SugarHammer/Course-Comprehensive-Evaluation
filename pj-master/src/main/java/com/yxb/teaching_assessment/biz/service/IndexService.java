package com.yxb.teaching_assessment.biz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yxb.teaching_assessment.biz.entity.Index;
import com.yxb.teaching_assessment.biz.mapper.IndexMapper;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {
    @Autowired
    IndexMapper indexMapper;
    public List<Index> findAll() {
        return indexMapper.selectList(null);
    }

    public int delete(String indexid) {
       return indexMapper.delete(indexid);
    }


    public int update(Index index) {
       return  indexMapper.updateMy(index.getIndexname(),index.getOption1(),index.getOption2(),index.getOption3(),index.getOption4(),index.getScore1(),index.getScore2(),index.getScore3(),index.getScore4(),index.getDelflg(),index.getIndexid());


    }

    public int add(Index index1) {
        return indexMapper.insert(index1);
    }
    public int insert(Index index){
      return   indexMapper.insertMy(index.getIndexname(),index.getOption1(),index.getOption2(),index.getOption3(),index.getOption4(),index.getScore1(),index.getScore2(),index.getScore3(),index.getScore4(),index.getDelflg());

    }
}
