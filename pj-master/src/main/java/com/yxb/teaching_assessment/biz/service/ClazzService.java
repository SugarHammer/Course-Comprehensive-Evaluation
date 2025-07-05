package com.yxb.teaching_assessment.biz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yxb.teaching_assessment.biz.entity.Clazz;
import com.yxb.teaching_assessment.biz.mapper.ClazzMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzService {
    @Autowired
    ClazzMapper clazzMapper;

    public List<Clazz> findAll(){
        return clazzMapper.selectList(null);
    }

    /**
     *
     * @param clazzid
     * @return
     */
    public int delete(String clazzid) {
        Clazz clazz=new Clazz();
        clazz.setClazzid(Integer.valueOf(clazzid));
        clazz.setIsDelete(1);
        QueryWrapper<Clazz> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq(" clazzid",clazz.getClazzid());
        return  clazzMapper.update(clazz,queryWrapper);
    }


    public int update(Clazz clazz) {
          QueryWrapper<Clazz> queryWrapper=new QueryWrapper<>();
          queryWrapper.eq("clazzid",clazz.getClazzid());
         return clazzMapper.update(clazz,queryWrapper);
    }

    public int save(Clazz clazz) {
        return  clazzMapper.insert(clazz);
    }

    public List<Clazz> findByid(String clazzid) {
        QueryWrapper<Clazz> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("clazzid",clazzid);
         return  clazzMapper.selectList(queryWrapper);

    }
    public Clazz findByID1(String clazzid){
        QueryWrapper<Clazz> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("clazzid",clazzid);
        return  clazzMapper.selectById(queryWrapper);
    }

    public List<Clazz> clazzfindAll(int page, int limit) {
        page =(page-1)*limit;
       return    clazzMapper.clazzfindAll(page,limit);
    }
}
