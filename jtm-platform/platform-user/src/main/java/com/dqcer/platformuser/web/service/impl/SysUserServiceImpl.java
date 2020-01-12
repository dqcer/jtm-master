package com.dqcer.platformuser.web.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dqcer.jtmcommon.base.vo.Result;
import com.dqcer.jtmcommon.entity.user.SysUserEntity;
import com.dqcer.platformuser.web.dao.SysUserDao;
import com.dqcer.platformuser.web.service.ISysUserService;
import com.dqcer.platformuserapi.dto.SysUserDto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements ISysUserService {

    @Resource
    private Map<String, String> businessMessage;

    @Override
    public Result getUserInfo(SysUserDto sysUserDto) {
        save(new SysUserEntity());
        return Result.businessMessage(businessMessage.get("100000"));
    }
}
