package com.dqcer.jtmcommon.base.vo;

import com.dqcer.jtmcommon.base.constant.GlobalConstant;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 返回前端统一格式
 *
 * @author dongqin
 * @description
 * @date 13:32 2020/1/11
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 5937332150983213894L;

    private T result;

    private String message;

    private int code;

    private String now;

    {
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(DateTimeFormatter.ofPattern(GlobalConstant.DateTimeFormatter.yyy_MM_DD_HH_MM_SSS));
        this.now =  format;
    }

    protected Result(T result, String message, int code){
        setResult(result);
        setMessage(message);
        setCode(code);
    }

    /**
     * success
     *
     * @param <T>
     * @return
     */
    public static <T> Result<T> success() {
        return Result.success(null);
    }

    /**
     * success
     *
     * @param result
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T result) {
        return new Result<T>(result, GlobalConstant.ResultEnum.SUCCESS.getMessage(), GlobalConstant.ResultEnum.SUCCESS.getCode());
    }

    /**
     * error
     *
     * @param messageBody
     * @return
     */
    public static Result businessMessage(String messageBody) {
        int index = messageBody.indexOf(",");
        if (index > -1) {
            String message = messageBody.substring(index + 1);
            int code = Integer.parseInt(messageBody.substring(0, index));
            return new Result(null, message, code);
        }
        return Result.error();
    }

    /**
     * error
     *
     * @return
     */
    public static Result error() {
        return new Result(null, GlobalConstant.ResultEnum.ERROR.getMessage(), GlobalConstant.ResultEnum.ERROR.getCode());
    }

}
