package com.ayuan.process.dto;

import com.ayuan.pojo.baseenum.MessageTypeEnum;
import com.ayuan.pojo.baseenum.MethodEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Ayuan
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class MessageInfo {

    /**
     * 方法
     */
    private MethodEnum method;

    /**
     * 状态
     */
    private MessageTypeEnum status;

    /**
     * 消息id
     */
    private String messageId;
}
