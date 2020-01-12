package com.dqcer.platformuser.web.controller;


import com.dqcer.jtmcommon.base.vo.Result;
import com.dqcer.platformuser.web.service.IUserService;
import com.dqcer.platformuserapi.producer.UserFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserFeignApi {

    IUserService userService;

    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public Result getUserInfo() {
        return userService.getUserInfo();
    }
}
