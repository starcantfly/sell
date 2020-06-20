package com.star.VO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 后台返回前端信息类
 * @param <T>
 */

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> {
    /** 返回结果信息码 */
    private Integer code;
    /** 返回提示信息 */
    private String msg;
    /** 返回后台数据信息 */
    private T data;
}
