package com.dqcer.platformuserapi.provider;

import com.dqcer.jtmcommon.base.vo.Result;
import com.dqcer.jtmcommon.entity.sys.SysRoleEntity;
import com.dqcer.platformuserapi.dto.SysUserDto;
import com.dqcer.platformuserapi.vo.SysUserVo;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(name = "platform-user")
@RequestMapping("/user")
public interface UserFeignApi {

    @GetMapping("/getUserInfo")
    Result<SysUserVo> getUserInfo(@JsonAlias SysUserDto sysUserDto);

    /**
     * 根据用户id获取权限集
     *
     * @param id
     * @return
     */
    @GetMapping("/getUserRolesByUserId/{userId}")
    Result<Set<SysRoleEntity>> getUserRolesByUserId(@PathVariable("userId") Long id);

    /**
     * 根据主键获取用户信息
     *
     * @param id
     * @return
     */
    @GetMapping("/getByUniqueId")
    Result<SysUserVo> getByUniqueId(@RequestParam("id") Long id);
}