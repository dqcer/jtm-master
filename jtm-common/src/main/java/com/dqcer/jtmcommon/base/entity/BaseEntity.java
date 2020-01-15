package com.dqcer.jtmcommon.base.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.dqcer.jtmcommon.base.dto.BaseDto;
import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty("主键")
    private Long id;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建人id")
    private Long createUserId;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty("创建时间")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty("更新人id")
    private Long updateUserId;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty("更新时间")
    private Date updateTime;

    @ApiModelProperty("状态")
    private Integer statue;

}
