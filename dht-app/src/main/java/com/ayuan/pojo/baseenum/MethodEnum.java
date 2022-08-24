package com.ayuan.pojo.baseenum;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Ayuan
 */
@AllArgsConstructor
@Getter
public enum MethodEnum implements CodeEnum<String> {

    /**
     * DHT网络请求api枚举
     */
    PING("ping", "心跳检查"),
    FIND_NODE("find_node", "查找NODE"),
    GET_PEERS("get_peers", "通过INFO-HASH查找peer"),
    ANNOUNCE_PEER("announce_peer", "宣布自己也有infohash");

    private String code;
    private String message;

}
