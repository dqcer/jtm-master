package com.dqcer.platformuser.web.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dqcer.jtmcommon.base.vo.Result;
import com.dqcer.jtmcommon.entity.sys.SysRoleEntity;
import com.dqcer.jtmcommon.entity.sys.SysUserEntity;
import com.dqcer.platformuserapi.dto.SysUserDto;
import com.dqcer.platformuserapi.vo.SysUserVo;

import java.util.Set;

public interface ISysUserService extends IService<SysUserEntity>  {

    Result getUserInfo(SysUserDto sysUserDto);

    Result<Set<SysRoleEntity>> getUserRolesByUserId(Long id);

    Result<SysUserVo> getByUniqueId(Long id);
}
