package com.dqcer.jtmcommon.entity.sys;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dqcer.jtmcommon.base.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName(value = "sys_user")
public class SysUserEntity extends BaseEntity {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("登录名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("非过期账户")
    private Boolean accountNonExpired;

    @ApiModelProperty("非过期凭证")
    private Boolean credentialsNonExpired;

    @ApiModelProperty("非锁定账户")
    private Boolean accountNonLocked;
}
