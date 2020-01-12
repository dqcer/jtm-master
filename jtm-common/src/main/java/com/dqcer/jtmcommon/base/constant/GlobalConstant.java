package com.dqcer.jtmcommon.base.constant;

import lombok.Getter;

/**
 * 全局常量
 *
 * @author dongqin
 * @description
 * @date 14:28 2020/1/12
 */
public class GlobalConstant {

    /**通用状态码*/
    @Getter
    public enum ResultEnum {

        SUCCESS(0, "操作成功"),
        ERROR(-1, "系统异常");

        ResultEnum(int code, String message){
            this.code = code;
            this.message = message;
        }

        private int code;

        private String message;

    }

    /**时间格式*/
    public interface DateTimeFormatter{

        public static final String yyy_MM_DD_HH_MM_SSS = "yyyy-MM-DD HH:MM:SSS";
    }
}
