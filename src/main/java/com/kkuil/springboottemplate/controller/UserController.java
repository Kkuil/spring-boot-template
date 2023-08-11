package com.kkuil.springboottemplate.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kkuil.springboottemplate.model.common.page.PageRes;
import com.kkuil.springboottemplate.model.dto.user.AddUserDTO;
import com.kkuil.springboottemplate.model.dto.user.UpdateUserDTO;
import com.kkuil.springboottemplate.model.entity.User;
import com.kkuil.springboottemplate.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * @Author kkuil
 * @Date 2023/07/29 20:00
 * @Description 用户控制器
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * @param id       用户id
     * @param current  当前页
     * @param pageSize 每页大小
     * @return 用户列表
     * @description 获取用户列表
     */
    @GetMapping("/page")
    @Operation(summary = "分页获取用户", description = "分页获取用户")
    @Parameters({
            @Parameter(name = "id", description = "用户id"),
            @Parameter(name = "current", description = "当前页"),
            @Parameter(name = "pageSize", description = "每页大小")
    })
    public com.kkuil.common.utils.ResultUtil<PageRes<List<User>>> page(String id, int current, int pageSize) {
        Page<User> pageInfo = new Page<>();
        pageInfo.setCurrent(current);
        pageInfo.setSize(pageSize);
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.like("id", id);
        IPage<User> page = userService.page(pageInfo, userWrapper);
        PageRes<List<User>> pageRes = new PageRes<>();
        pageRes
                .setPageSize(page.getSize())
                .setCurrent(page.getCurrent())
                .setTotal(page.getTotal())
                .setData(page.getRecords());
        return com.kkuil.common.utils.ResultUtil.success("获取成功", pageRes);
    }

    /**
     * @param addUserDTO 添加用户数据传输对象
     * @return 是否添加成功
     * @description 添加用户
     */
    @PostMapping("/")
    @Operation(summary = "添加用户", description = "添加用户")
    @Parameter(name = "addUserDTO", description = "添加用户数据传输对象")
    public com.kkuil.common.utils.ResultUtil<Boolean> add(@RequestBody AddUserDTO addUserDTO) {
        User tbUser = BeanUtil.copyProperties(addUserDTO, User.class);
        boolean isSave = userService.save(tbUser);
        if (isSave) {
            return com.kkuil.common.utils.ResultUtil.success("添加成功", true);
        } else {
            return com.kkuil.common.utils.ResultUtil.error("添加失败", false);
        }
    }

    /**
     * @param id 用户id
     * @return 是否删除成功
     * @description 删除用户
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户", description = "删除用户")
    @Parameter(name = "id", description = "用户id")
    public com.kkuil.common.utils.ResultUtil<Boolean> del(@PathVariable("id") Long id) {
        boolean isSave = userService.removeById(id);
        if (isSave) {
            return com.kkuil.common.utils.ResultUtil.success("删除成功", true);
        } else {
            return com.kkuil.common.utils.ResultUtil.error("删除失败", false);
        }
    }

    /**
     * @param ids 用户id
     * @return 是否删除成功
     * @description 删除用户
     */
    @DeleteMapping("/")
    @Operation(summary = "删除一批用户", description = "删除一批用户")
    @Parameter(name = "ids", description = "用户ids")
    public com.kkuil.common.utils.ResultUtil<Boolean> del(String ids) {
        boolean isSave = userService.removeByIds(Collections.singleton(ids));
        if (isSave) {
            return com.kkuil.common.utils.ResultUtil.success("删除成功", true);
        } else {
            return com.kkuil.common.utils.ResultUtil.error("删除失败", false);
        }
    }

    /**
     * @param updateUserDTO 修改用户数据传输对象
     * @return 是否修改成功
     * @description 修改用户
     */
    @PutMapping("/")
    @Operation(summary = "修改用户", description = "修改用户")
    @Parameter(name = "updateUserDTO", description = "修改用户数据传输对象")
    public com.kkuil.common.utils.ResultUtil<Boolean> update(@RequestBody UpdateUserDTO updateUserDTO) {
        User tbUser = BeanUtil.copyProperties(updateUserDTO, User.class);
        boolean isSave = userService.updateById(tbUser);
        if (isSave) {
            return com.kkuil.common.utils.ResultUtil.success("修改成功", true);
        } else {
            return com.kkuil.common.utils.ResultUtil.error("修改失败", false);
        }
    }

    /**
     * @param id 用户id
     * @return 查询的数据
     * @description 查询用户
     */
    @GetMapping("/")
    @Operation(summary = "查询用户", description = "查询用户")
    @Parameter(name = "id", description = "查询用户数据传输对象")
    public com.kkuil.common.utils.ResultUtil<User> select(Long id) {
        return com.kkuil.common.utils.ResultUtil.success("查询成功", userService.getById(id));
    }

}
