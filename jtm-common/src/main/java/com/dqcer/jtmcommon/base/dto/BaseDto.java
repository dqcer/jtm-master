package com.dqcer.jtmcommon.base.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * dto 基类
 *
 * @author dongqin
 * @description
 * @date 21:49 2020/1/12
 */
@Data
public class BaseDto implements Serializable {
    private static final long serialVersionUID = -1141137490348830577L;

    @TableField(exist = false)
    private Integer pageNum = 1;

    @TableField(exist = false)
    private Integer pageSize = 10;

    @TableField(exist = false)
    private String keyword;
}
