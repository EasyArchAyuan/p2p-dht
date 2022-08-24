package com.ayuan.pojo.baseenum;

/**
 * 通用的带code/message的枚举接口
 * @author Ayuan
 */
public interface CodeEnum<T> {

    T getCode();

    String getMessage();
}
