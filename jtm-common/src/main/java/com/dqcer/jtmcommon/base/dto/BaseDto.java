package com.dqcer.jtmcommon.base.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty("页数")
    private Integer pageNum = 1;

    @ApiModelProperty("每页数量")
    @TableField(exist = false)
    private Integer pageSize = 10;

    @ApiModelProperty("关键字")
    @TableField(exist = false)
    private String keyword;
}
