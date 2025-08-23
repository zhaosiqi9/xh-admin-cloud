package com.xh.system.api.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/23 00:04
 */
@Data
@Accessors(chain = true)
public class GetUserInfoResponse {

    private GetUserInfoResponseUser user;

    private List<GetUserInfoResponseRole> roleList = new ArrayList<>();

    private List<GetUserInfoResponseOrg> orgList = new ArrayList<>();

    private List<GetUserInfoResponseJob> jobList = new ArrayList<>();


}
