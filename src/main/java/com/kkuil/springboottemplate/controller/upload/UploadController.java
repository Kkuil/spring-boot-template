package com.kkuil.springboottemplate.controller.upload;

import com.kkuil.springboottemplate.utils.ResultUtil;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Author Kkuil
 * @Date 2023/12/29 14:26
 * @Description 上传相关接口
 */
@RestController
@RequestMapping("upload")
@Slf4j(topic = "upload")
public class UploadController {

    /**
     * 上传封面接口
     *
     * @param cover 封面
     * @return 封面地址
     */
    @PostMapping("cover")
    @Operation(description = "上传视频封面接口")
    public ResultUtil<String> uploadCover(@RequestBody MultipartFile cover) {
//        Long accountId = RequestHolder.get().getAccountId();
//        log.info("accountId:{}", accountId);
        log.info("cover:{}", cover);
        return ResultUtil.success("");
    }
}
