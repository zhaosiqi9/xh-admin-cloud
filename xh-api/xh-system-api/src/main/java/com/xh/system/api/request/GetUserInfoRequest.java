package com.xh.system.api.request;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 23:54
 */
@Data
@Accessors(chain = true)
public class GetUserInfoRequest {
    
    private Long userId;
    
    private String userName;
    
    private boolean enabled = true;
}
