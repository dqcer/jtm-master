package com.dqcer.platformuser.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dqcer.jtmcommon.base.vo.Result;
import com.dqcer.jtmcommon.entity.user.SysUserEntity;
import com.dqcer.platformuserapi.dto.SysUserDto;

public interface ISysUserService extends IService<SysUserEntity>  {

    Result getUserInfo(SysUserDto sysUserDto);
}
