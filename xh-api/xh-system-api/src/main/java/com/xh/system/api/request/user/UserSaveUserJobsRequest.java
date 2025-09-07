package com.xh.system.api.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class UserSaveUserJobsRequest {

    @Schema(title = "用户id或者用户组的id", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long userId;
    @Schema(title = "数据类型", allowableValues = {"1", "2"}, description = "1：用户，2：用户组", requiredMode = Schema.RequiredMode.REQUIRED)
    private Integer type;
    @Schema(title = "岗位信息")
    private List<UserSaveUserJobsRequestJob> jobData;


}
