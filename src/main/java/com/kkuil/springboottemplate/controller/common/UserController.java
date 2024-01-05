package com.kkuil.springboottemplate.controller.common;

import com.kkuil.springboottemplate.domain.common.page.PageRes;
import com.kkuil.springboottemplate.domain.dto.user.AddUserDTO;
import com.kkuil.springboottemplate.domain.dto.user.UpdateUserDTO;
import com.kkuil.springboottemplate.domain.dto.user.UserLoginDTO;
import com.kkuil.springboottemplate.domain.dto.user.UserRegistryDTO;
import com.kkuil.springboottemplate.domain.entity.User;
import com.kkuil.springboottemplate.service.IUserService;
import com.kkuil.springboottemplate.utils.ResultUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public ResultUtil<PageRes<List<User>>> page(String id, int current, int pageSize) {
        return ResultUtil.success("获取成功", new PageRes<>());
    }

    /**
     * @param addUserDTO 添加用户数据传输对象
     * @return 是否添加成功
     * @description 添加用户
     */
    @PostMapping("/")
    @Operation(summary = "添加用户", description = "添加用户")
    @Parameter(name = "addUserDTO", description = "添加用户数据传输对象")
    public ResultUtil<Boolean> add(@RequestBody AddUserDTO addUserDTO) {
        return ResultUtil.success("添加成功", true);
    }

    /**
     * @param id 用户id
     * @return 是否删除成功
     * @description 删除用户
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户", description = "删除用户")
    @Parameter(name = "id", description = "用户id")
    public ResultUtil<Boolean> del(@PathVariable("id") Long id) {
        return ResultUtil.error("删除失败", true);
    }

    /**
     * @param ids 用户id
     * @return 是否删除成功
     * @description 删除用户
     */
    @DeleteMapping("/")
    @Operation(summary = "删除一批用户", description = "删除一批用户")
    @Parameter(name = "ids", description = "用户ids")
    public ResultUtil<Boolean> del(String ids) {
        return ResultUtil.success("删除成功", true);
    }

    /**
     * @param updateUserDTO 修改用户数据传输对象
     * @return 是否修改成功
     * @description 修改用户
     */
    @PutMapping("/")
    @Operation(summary = "修改用户", description = "修改用户")
    @Parameter(name = "updateUserDTO", description = "修改用户数据传输对象")
    public ResultUtil<Boolean> update(@RequestBody UpdateUserDTO updateUserDTO) {
        return ResultUtil.success("修改成功", true);
    }

    /**
     * @param id 用户id
     * @return 查询的数据
     * @description 查询用户
     */
    @GetMapping("/")
    @Operation(summary = "查询用户", description = "查询用户")
    @Parameter(name = "id", description = "查询用户数据传输对象")
    public ResultUtil<User> select(Long id) {
        return ResultUtil.success("查询成功", new User());
    }

    /**
     * 登录接口
     *
     * @param userLoginDTO 用户登录信息
     * @return token
     */
    @PostMapping("/login")
    @Operation(summary = "登录", description = "登录")
    @Parameter(name = "userLoginDTO", description = "用户登录信息")
    public ResultUtil<String> login(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        return ResultUtil.success("登录成功");
    }

    /**
     * 登录接口
     *
     * @param userRegistryDTO 用户登录信息
     * @return token
     */
    @PostMapping("/registry")
    @Operation(summary = "注册", description = "注册")
    @Parameter(name = "userRegistryDTO", description = "用户注册信息")
    public ResultUtil<Boolean> login(@Valid @RequestBody UserRegistryDTO userRegistryDTO) {
        return ResultUtil.success("注册成功", true);
    }

}
