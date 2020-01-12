package com.dqcer.jtmcommon.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.dqcer.jtmcommon.base.entity.BaseEntity;
import lombok.Data;

@Data
@TableName(value = "sys_user")
public class SysUserEntity extends BaseEntity {
}
