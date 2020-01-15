package com.dqcer.platformuser.web.controller;


import com.dqcer.jtmcommon.base.vo.Result;
import com.dqcer.jtmcommon.entity.sys.SysRoleEntity;
import com.dqcer.platformuser.web.service.ISysUserService;
import com.dqcer.platformuserapi.dto.SysUserDto;
import com.dqcer.platformuserapi.provider.UserFeignApi;
import com.dqcer.platformuserapi.vo.SysUserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@Api(tags = "用户模块")
@RestController
public class UserController implements UserFeignApi {

    ISysUserService userService;



    @Autowired
    public void setUserService(ISysUserService userService) {
        this.userService = userService;
    }


    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @Override
    public Result getUserInfo(SysUserDto sysUserDto) {
        return userService.getUserInfo(sysUserDto);
    }

    /**
     * 根据用户id获取权限集
     *
     * @param id
     * @return
     */
    @ApiOperation(value="根据用户id获取权限集")
    @Override
    public Result<Set<SysRoleEntity>> getUserRolesByUserId(Long id) {
        return userService.getUserRolesByUserId(id);
    }

    /**
     * 根据主键获取用户信息
     *
     * @param id
     * @return
     */
    @Override
    public Result<SysUserVo> getByUniqueId(Long id) {
        return userService.getByUniqueId(id);
    }
}
