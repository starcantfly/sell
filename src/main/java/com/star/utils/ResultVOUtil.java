package com.star.utils;

import com.star.VO.ResultVO;

public class ResultVOUtil {

    /** 成功返回结果 */
    public static ResultVO seccess(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功！");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO seccess(){
        return seccess(null);
    }
    /** 返回失败  */
    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
