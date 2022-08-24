package com.ayuan.pojo.entitys.peer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.Date;

/**
 * 存储info_hash信息
 * @author Ayuan
 */
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class InfoHash {

    private Long id;

    /**
     * infoHash信息,16进制形式
     */
    private String infoHash;

    /**
     * 如果是announce_peer类型(type == 1),则保存其peer的ip:ports
     */
    private String peerAddress = "";

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

}
