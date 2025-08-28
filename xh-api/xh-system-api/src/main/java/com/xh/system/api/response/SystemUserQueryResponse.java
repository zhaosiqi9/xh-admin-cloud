// YApi QuickType插件生成，具体参考文档:https://plugins.jetbrains.com/plugin/18847-yapi-quicktype/documentation

package com.xh.system.api.response;
import java.util.Date;
import java.util.List;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class SystemUserQueryResponse {
    private String code;
    private Date updateTime;
    private String telephone;
    private String avatar;
    private Boolean enabled;
    private String password;
    private Boolean deleted;
    private Long failuresNum;
    private Date createTime;
    private Long updateBy;
    private String name;
    private Boolean autoRenewal;
    private Long id;
    private Long status;
    private Boolean allowRepeat;
}
