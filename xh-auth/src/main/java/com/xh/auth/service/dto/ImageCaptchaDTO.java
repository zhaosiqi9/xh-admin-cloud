package com.xh.auth.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 10:42
 */
@Data
@Schema(description = "图片验证码")
public class ImageCaptchaDTO {

    private String captchaKey;

    private String imageBase64;
    
}
