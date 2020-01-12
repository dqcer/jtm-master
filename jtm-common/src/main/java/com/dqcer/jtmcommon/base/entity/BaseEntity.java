package com.dqcer.jtmcommon.base.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.dqcer.jtmcommon.base.dto.BaseDto;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * entity 基类
 *
 * @author dongqin
 * @description
 * @date 21:41 2020/1/12
 */
@Data
public class BaseEntity extends BaseDto implements Serializable {

    private static final long serialVersionUID = -2017285099683115405L;

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long createUserId;

    private Long updateUserId;

    private Date createTime;

    private Date updateTime;

    private Integer statue;

}
