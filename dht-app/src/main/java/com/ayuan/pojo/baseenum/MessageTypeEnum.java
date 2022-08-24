package com.ayuan.pojo.baseenum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Ayuan
 */
@Getter
@AllArgsConstructor
public enum MessageTypeEnum implements CodeEnum<String> {
    /**
     * 消息类型枚举
     */
    QUERY("q", "查询"),
    RESPONSE("r", "返回信息"),
    ERROR("e", "错误信息");

    private String code;
    private String message;
}
