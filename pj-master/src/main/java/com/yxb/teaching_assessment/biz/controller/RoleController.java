package com.yxb.teaching_assessment.biz.controller;

import com.yxb.teaching_assessment.biz.entity.Role;
import com.yxb.teaching_assessment.biz.service.RoleService;
import com.yxb.teaching_assessment.biz.vo.AbstractBaseCtrl;
import com.yxb.teaching_assessment.biz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "角色管理模块")
@RequestMapping("/role")
public class RoleController extends AbstractBaseCtrl {
    @Autowired
    RoleService roleService;

    /**
     * 角色列表
     * @return
     */
    @PostMapping("/list")
    @ApiOperation(value = "角色列表")
    public ResultVO roleList(){
        List<Role> roleList = roleService.roleList();
        return success(roleList);
    }

    /**
     * 角色列表
     * @param role
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "角色新增")
    public ResultVO roleSave(@RequestBody Role role){
        //数据校验
        if (role==null){
            return error("数据不存在");
        }else {
            //数据处理（新增操作）
            role.setIsDelete(0);

            int ret = roleService.saveRole(role);
            //新增是否成功
            if (ret==1){
                return success("角色新增成功");
            }else {
                return error("角色权限失败");
            }
        }
    }

    /**
     * 角色信息修改
     * @param role
     * @return
     */
    @PostMapping("update")
    @ApiOperation(value = "角色信息修改")
    public ResultVO updateRole(@RequestBody Role role){
        int ret = roleService.updateRole(role);
        return success("修改角色成功");
    }

    /**
     * 角色删除（逻辑删除）
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @ApiOperation(value = "删除权限")
    public ResultVO deleteRole(@RequestParam("roleid")int id){
        int ret = roleService.deleteRole(id);
        if (ret==1){
            return success("删除角色成功");
        }else {
            return error("删除角色失败");
        }
    }

    /**
     * 根据id查找角色
     * @param id
     * @return
     */
    @PostMapping("/role")
    @ApiOperation(value = "根据id查找角色")
    public ResultVO findRoleById(@RequestParam("roleid")int id){
        Role role = roleService.findRoleById(id);
        return success(role);
    }

    /**
     * 根据角色名称模糊查询角色列表
     * @param rolename
     * @return
     */
    @PostMapping("/roleLike")
    @ApiOperation(value = "根据权限名称模糊查找权限")
    public ResultVO findRoleByname(@RequestParam("rolename")String rolename){
        if (rolename==null){
            rolename="";
        }
        List<Role> roleList = roleService.findRoleByLikeName(rolename);
        return success(roleList);
    }
}
