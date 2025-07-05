package com.yxb.teaching_assessment.biz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yxb.teaching_assessment.biz.entity.Menu;
import com.yxb.teaching_assessment.biz.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> selectAll() {
        return menuMapper.selectList(null);
    }

    public int save(Menu menu) {
        return menuMapper.insert(menu);
    }

    public int update(Menu menu) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("menuid",menu.getMenuid());
        return menuMapper.update(menu,queryWrapper);
    }

    public Menu findById(String menuid) {
        QueryWrapper<Menu> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("menuid",menuid);
        return menuMapper.selectOne(queryWrapper);
    }

    public List<Menu> findByLikeName(String menuname) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("menuname",menuname);
        return menuMapper.selectList(queryWrapper);
    }

    public int deleteById(String menuid) {
        Menu menu = new Menu();
        menu.setMenuid(Integer.valueOf(menuid));
        menu.setDelflag(1);
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("menuid",menu.getMenuid());
        return menuMapper.update(menu,queryWrapper);
    }
}
