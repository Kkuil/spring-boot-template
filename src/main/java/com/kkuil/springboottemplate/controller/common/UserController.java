package com.kkuil.springboottemplate.controller.common;

import com.kkuil.springboottemplate.utils.ResultUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


/**
 * @Author kkuil
 * @Date 2023/07/29 20:00
 * @Description 用户控制器
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    /**
     * 登录接口
     *
     * @return token
     */
    @PostMapping("/login")
    @Operation(summary = "登录", description = "登录")
    @Parameter(name = "userLoginDTO", description = "用户登录信息")
    public ResultUtil<String> login() {
        return ResultUtil.success("登录成功");
    }
}
