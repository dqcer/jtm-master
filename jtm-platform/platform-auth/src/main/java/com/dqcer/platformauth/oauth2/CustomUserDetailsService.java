package com.dqcer.platformauth.oauth2;

import com.dqcer.jtmcommon.base.vo.Result;
import com.dqcer.jtmcommon.entity.sys.SysRoleEntity;
import com.dqcer.jtmcommon.entity.sys.SysUserEntity;
import com.dqcer.platformuserapi.provider.UserFeignApi;
import com.dqcer.platformuserapi.vo.SysUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;


/**
 * 自定义
 * @author dqcer
 * @description
 * @date 15:11 2020/1/15
 */
@Slf4j
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserFeignApi userFeignApi;



    @Override
    public UserDetails loadUserByUsername(String uniqueId) {

        Result<SysUserVo> byUniqueId = userFeignApi.getByUniqueId(Long.parseLong(uniqueId));
        SysUserVo user = byUniqueId.getData();

        log.info("load user by username :{}", user.toString());

        Boolean enabled = user.getStatue().equals("1") ? true : false;

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                enabled,
                user.getAccountNonExpired(),
                user.getCredentialsNonExpired(),
                user.getAccountNonLocked(),
                this.obtainGrantedAuthorities(user));
    }

    /**
     * 获得登录者所有角色的权限集合.
     *
     * @param user
     * @return
     */
    protected Set<GrantedAuthority> obtainGrantedAuthorities(SysUserEntity user) {

        Result<Set<SysRoleEntity>> result = userFeignApi.getUserRolesByUserId(user.getId());
        Set<SysRoleEntity> roles = result.getData();

        log.info("user:{},roles:{}", user.getUsername(), roles);
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getCode())).collect(Collectors.toSet());
    }
}
