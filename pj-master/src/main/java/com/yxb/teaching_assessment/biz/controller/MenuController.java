package com.yxb.teaching_assessment.biz.controller;

import com.yxb.teaching_assessment.biz.entity.Menu;
import com.yxb.teaching_assessment.biz.service.MenuService;
import com.yxb.teaching_assessment.biz.vo.AbstractBaseCtrl;
import com.yxb.teaching_assessment.biz.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "权限管理模块接口")
@RequestMapping("/menu")
public class MenuController extends AbstractBaseCtrl {
    @Autowired
    MenuService menuService;

    /**
     * 权限列表展示
     * @return
     */
    @PostMapping("/list")
    @ApiOperation(value = "权限列表")
    public ResultVO MenuList(){
        List<Menu> menuList = menuService.selectAll();
        return success(menuList);
    }

    /**
     * 权限新增
     * @param menu
     * @return
     */
    @PostMapping("/save")
    @ApiOperation(value = "新增权限")
    public ResultVO menuSave(@RequestBody Menu menu){
        int ret = menuService.save(menu);
        if (ret==1){
            return success("权限新增成功");
        }else {
            return error("权限新增失败");
        }
    }

    /**
     * 权限修改
     * @param menu
     * @return
     */
    @PostMapping("/update")
    @ApiOperation(value = "权限修改")
    public ResultVO menuUpdate(@RequestBody Menu menu){
        if (menu.getMenuid()==null){
            return error("修改失败");
        }else {
            int ret = menuService.update(menu);
            if (ret==1){
                return success("修改成功");
            }else {
                return error("修改失败");
            }
        }
    }

    /**
     * 根据id查找权限
     * @param menuid
     * @return
     */
    @PostMapping("/findOne")
    @ApiOperation(value = "根据id查找权限")
    public ResultVO FindById(@RequestParam("menuid")String menuid){
        if (menuid==null){
            return error("权限id获取失败");
        }else {
            Menu menu = menuService.findById(menuid);
            if (menu==null){
                return success("查找失败，id不存在");
            }else {
                return success(menu);
            }
        }
    }

    /**
     * 根据权限名称模糊查询
     * @param menuname
     * @return
     */
    @PostMapping("finkLike")
    @ApiOperation(value = "根据名称模糊查询权限")
    public ResultVO findByLike(@RequestParam("menuname")String menuname){
        if (menuname==null){
            menuname="";
        }
        List<Menu> menuList = menuService.findByLikeName(menuname);
        return success(menuList);
    }

    /**
     * 权限删除（逻辑删除）
     * @param menuid
     * @return
     */
    @PostMapping("/delete")
    @ApiOperation(value = "权限删除")
    public ResultVO deleteMenu(@RequestParam("menuid")String menuid){
        if (menuid==null){
            return success("获取权限失败");
        }else {
            int ret  = menuService.deleteById(menuid);
            if (ret==1){
                return success("删除成功");
            }else {
                return success("删除失败");
            }
        }
    }
}
