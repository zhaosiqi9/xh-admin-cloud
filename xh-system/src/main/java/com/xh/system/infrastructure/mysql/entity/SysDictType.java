package com.xh.system.infrastructure.mysql.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xh.common.core.entity.BaseEntityPO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 字典类型表 sys_dict_type
 *
 * @author Lion Li
 */

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_dict_type")
public class SysDictType extends BaseEntityPO {

    /**
     * 字典主键
     */
    @TableId(value = "dict_id")
    private Long dictId;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 备注
     */
    private String remark;

}
