package com.dqcer.platformauth.oauth2;

import com.dqcer.jtmcommon.base.vo.Result;
import com.dqcer.platformuserapi.provider.SmsCodeFeignApi;
import com.dqcer.platformuserapi.provider.UserFeignApi;
import com.dqcer.platformuserapi.vo.SysUserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * 手机验证码登陆, 用户相关获取
 */
@Slf4j
@Service("mobileUserDetailsService")
public class MobileUserDetailsService extends CustomUserDetailsService {

    @Autowired
    private UserFeignApi userFeignApi;

    @Autowired
    private SmsCodeFeignApi smsCodeFeignApi;

    @Override
    public UserDetails loadUserByUsername(String uniqueId) {

        Result<SysUserVo> byUniqueId = userFeignApi.getByUniqueId(Long.valueOf(uniqueId));
        SysUserVo user = byUniqueId.getData();

        log.info("load user by mobile:{}", user.toString());

        Boolean enabled = user.getStatue().equals("1") ? true : false;

        // 如果为mobile模式，从短信服务中获取验证码（动态密码）
        String credentials = smsCodeFeignApi.getSmsCode(uniqueId, "LOGIN");

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                credentials,
                enabled,
                user.getAccountNonExpired(),
                user.getCredentialsNonExpired(),
                user.getAccountNonLocked(),
                super.obtainGrantedAuthorities(user));
    }
}