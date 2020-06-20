package com.star.utils;

import java.util.Random;

/**
 * 生成主键
 * 格式：时间+随机数
 */
public class KeyUtil {

    //加synchronized防止生成重复主键
    public static synchronized String getUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return  System.currentTimeMillis() + String.valueOf(number);
    }
}
