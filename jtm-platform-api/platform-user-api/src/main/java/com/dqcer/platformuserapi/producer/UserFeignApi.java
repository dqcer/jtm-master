package com.dqcer.platformuserapi.producer;

import com.dqcer.jtmcommon.base.vo.Result;
import com.dqcer.platformuserapi.dto.SysUserDto;
import com.dqcer.platformuserapi.vo.SysUserVo;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "platform-user")
public interface UserFeignApi {

    @GetMapping("/getUserInfo")
    Result<SysUserVo> getUserInfo(@JsonAlias SysUserDto sysUserDto);
}
