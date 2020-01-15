package com.dqcer.platformuser.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dqcer.jtmcommon.base.vo.Result;
import com.dqcer.jtmcommon.entity.sys.SysRoleEntity;
import com.dqcer.jtmcommon.entity.sys.SysUserEntity;
import com.dqcer.jtmcommon.entity.sys.SysUserRoleEntity;
import com.dqcer.platformuser.web.dao.SysRoleDao;
import com.dqcer.platformuser.web.dao.SysUserDao;
import com.dqcer.platformuser.web.dao.SysUserRoleDao;
import com.dqcer.platformuser.web.service.ISysUserService;
import com.dqcer.platformuserapi.dto.SysUserDto;
import com.dqcer.platformuserapi.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements ISysUserService {

    @Resource
    private Map<String, String> businessMessage;

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public Result getUserInfo(SysUserDto sysUserDto) {
        save(new SysUserEntity());
        return Result.businessMessage(businessMessage.get("100000"));
    }

    @Override
    public Result<Set<SysRoleEntity>> getUserRolesByUserId(Long id) {

        LambdaQueryWrapper<SysUserRoleEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(SysUserRoleEntity::getUserId, id);
        List<SysUserRoleEntity> entityList = sysUserRoleDao.selectList(wrapper);

        Set<Long> roles = entityList.stream().map(SysUserRoleEntity::getRoleId).collect(Collectors.toSet());
        List<SysRoleEntity> sysUserRoleEntities = sysRoleDao.selectBatchIds(roles);

        Set<SysRoleEntity> entitySet = new HashSet<>(sysUserRoleEntities);
        return Result.success(entitySet);
    }

    @Override
    public Result<SysUserVo> getByUniqueId(Long id) {
        SysUserEntity byId = getById(id);
        SysUserVo vo = (SysUserVo) byId;
        return Result.success(vo);
    }
}
