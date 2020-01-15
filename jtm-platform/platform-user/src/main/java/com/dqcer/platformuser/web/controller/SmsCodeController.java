package com.dqcer.platformuser.web.controller;

import com.dqcer.platformuserapi.provider.SmsCodeFeignApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SmsCodeController implements SmsCodeFeignApi {

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * @param mobile
     * @param businessType
     * @return
     */
    @Override
    public String getSmsCode(String mobile, String businessType) {
        // 该类为mock, 目前暂时没有sms的服务
        return passwordEncoder.encode("123456");
    }
}
