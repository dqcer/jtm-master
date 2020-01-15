package com.dqcer.jtmcommon.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dqcer.jtmcommon.base.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName(value = "sys_role")
public class SysRoleEntity extends BaseEntity {

    @ApiModelProperty("标识")
    private String code;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("说明")
    private String description;

}
