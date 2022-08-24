## 实现DHT网络
基于Netty实现TCP/UDP通讯,基于HttpClient+Jsoup实现Http请求和解析,
基于Guava实现布隆过滤器,基于java8函数式编程实现了Bencode编解码,
基于TrieTree实现RoutingTable,基于Elasticsearch实现全文检索,并使用了些设计模式/阻塞队列/分段锁等.

### BitTorrent协议
基于UDP和TCP通讯的协议,为了分发大体积文件.
遵守该协议的服务器结点被称为peer
当某个file被n个peer拥有,就可以peers中下载file的不同部分,然后将其拼接成整个文件
#### Torrent
种子文件里面保存了一个文件的一些元数据.eg:name,size,children信息等,也包括拥有改文件的peers服务器.
因此可以通过torrent向这些peers发送download请求,download file.


### DHT协议:一个去中心化的P2P网络.
在没有dht协议的时候,peers都需要链接到Tracker服务器,以获取到拥有某个文件的peers
基于udp通讯,规定每个node内部存储一个路由表,该routing table存储其他node或peer结点
#### 怎么获取infohash
磁力链接:magnet:?xt=urn:btih:19838A8C4DE7DC2E34382249C9A52CFD9E3BB41A
最后一长串的字符串交infohash,每个种子对应一个infohash.
必须成为dht网络中的一员,dht网络由很多node组成,每个node由160bit组成.
#### 怎么建立路由表
1.ping:检查一个结点是否在线
2.find_node:查找一个结点
3.get_peers:查找指定的某个infohash
4.announce_peer:发起一个通知,用来告诉结点下载完了

每发起一次find_node请求,对方就会返回距离被查询结点最近的前8个结点,通过不断的find_node建立路由表
#### 怎么通过一个infohash计算在哪个结点上
1.从路由表中查到最近的8个node,依次发起get_peers请求
2.如果没有查到,返回离对方最近的8个node,继续对返回的node进行get_peers请求
3.如果查到了,返回values参数,里面包含拥有该infohash的ip和port

#### Node之间的距离计算
node间的距离是通过nodeId进行异或计算的(也就是160个bit间进行异或)得出一个值,值越小,则距离越近.
由此可得出,越是高位的bit不相同(异或值为1),则值越大,距离越远(因为假设两个nodeId第1位就不同,其异或值必然大于2^160).