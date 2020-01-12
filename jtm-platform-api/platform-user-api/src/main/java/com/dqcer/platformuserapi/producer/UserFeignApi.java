package com.dqcer.platformuserapi.producer;

import com.dqcer.jtmcommon.base.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "platform-user")
public interface UserFeignApi {

    @GetMapping("/getUserInfo")
    public Result getUserInfo();
}
