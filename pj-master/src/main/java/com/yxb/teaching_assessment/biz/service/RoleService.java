package com.yxb.teaching_assessment.biz.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.yxb.teaching_assessment.biz.entity.Role;
import com.yxb.teaching_assessment.biz.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    /**
     * 权限列表查询
     * @return
     */
    public List<Role> roleList() {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_delete",0);
        return roleMapper.selectList(queryWrapper);
    }

    /**
     * 新增权限
     * @param role
     * @return
     */
    public int saveRole(Role role) {
        return roleMapper.insert(role);
    }

    /**
     * 根据id修改权限信息
     * @param role
     * @return
     */
    public int updateRole(Role role) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("roleid",role.getRoleid());
        return roleMapper.update(role,queryWrapper);
    }

    /**
     * 逻辑删除权限
     * @param id
     * @return
     */
    public int deleteRole(int id) {
        Role role = new Role();
        role.setRoleid(id);
        role.setIsDelete(1);
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("roleid",id);
        return roleMapper.update(role,queryWrapper);
    }

    /**
     * 根据id查找权限
     * @param id
     * @return
     */
    public Role findRoleById(int id) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("roleid",id).eq("is_delete",0);
        return roleMapper.selectOne(queryWrapper);
    }

    public List<Role> findRoleByLikeName(String rolename) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_delete",0).like("rolename",rolename);
        return roleMapper.selectList(queryWrapper);

    }
}
