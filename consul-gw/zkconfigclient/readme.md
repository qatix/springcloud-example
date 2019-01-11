添加测试数据
```
[zk: localhost:2181(CONNECTED) 0] create /config ""
Created /config
[zk: localhost:2181(CONNECTED) 2] create /config/zk-config-client
[zk: localhost:2181(CONNECTED) 3] create /config/zk-config-client ""
Created /config/zk-config-client
[zk: localhost:2181(CONNECTED) 12] create /config/zk-config-client,dev
[zk: localhost:2181(CONNECTED) 13] create /config/zk-config-client,dev  ""
Created /config/zk-config-client,dev
[zk: localhost:2181(CONNECTED) 14] create /config/zk-config-client,dev/name "dev-name 11:26"
Created /config/zk-config-client,dev/name
[zk: localhost:2181(CONNECTED) 15] create /config/zk-config-client,dev/mylang "java"        
Created /config/zk-config-client,dev/mylang
[zk: localhost:2181(CONNECTED) 16] set /config/zk-config-client,dev/mylang "java222"  
```

zk目前支持自动更新，官方文档还没更新。

http://cloud.spring.io/spring-cloud-zookeeper/single/spring-cloud-zookeeper.html

