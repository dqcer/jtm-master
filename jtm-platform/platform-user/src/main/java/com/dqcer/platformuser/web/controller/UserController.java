package com.dqcer.platformuser.web.controller;


import com.dqcer.jtmcommon.base.vo.Result;
import com.dqcer.platformuser.web.service.ISysUserService;
import com.dqcer.platformuserapi.dto.SysUserDto;
import com.dqcer.platformuserapi.producer.UserFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserFeignApi {

    ISysUserService userService;

    @Autowired
    public void setUserService(ISysUserService userService) {
        this.userService = userService;
    }


    @Override
    public Result getUserInfo(SysUserDto sysUserDto) {
        return userService.getUserInfo(sysUserDto);
    }
}
