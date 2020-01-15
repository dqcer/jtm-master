package com.dqcer.jtmcommon.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dqcer.jtmcommon.base.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName(value = "sys_user_role")
public class SysUserRoleEntity extends BaseEntity {

    @ApiModelProperty("用户主键")
    private Long userId;

    @ApiModelProperty("权限主键")
    private Long roleId;
}
