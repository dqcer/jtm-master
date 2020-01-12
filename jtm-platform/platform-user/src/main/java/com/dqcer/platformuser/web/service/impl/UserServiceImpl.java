package com.dqcer.platformuser.web.service.impl;

import com.dqcer.jtmcommon.base.vo.Result;
import com.dqcer.platformuser.web.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private Map<String, String> businessMessage;

    @Override
    public Result getUserInfo() {
        return Result.businessMessage(businessMessage.get("100000"));
    }
}
