1.启动zk

2.启动各application

zkCli.sh进入zk shell

```ls /spring-cloud-services```

[app1, app2, app3, gw-zuul]

```get /spring-cloud-services/app1/```

[0f58d768-8c12-43b9-8492-19686286448d, 3f97ddc1-916e-493a-85f9-b1c4b5757cfd, d84c7d0f-9a5e-41ad-a7db-e49a786eca22]
可看到每个启动实例在zk上都有一个对应文件,实例关闭后，下次刷新时这个节点会被删除

```get /spring-cloud-services/app1/0f58d768-8c12-43b9-8492-19686286448d```

{"name":"app1","id":"0f58d768-8c12-43b9-8492-19686286448d","address":"logans-mbp.lan","port":7201,"sslPort":null,"payload":{"@class":"org.springframework.cloud.zookeeper.discovery.ZookeeperInstance","id":"application-1","name":"app1","metadata":{}},"registrationTimeUTC":1546700827334,"serviceType":"DYNAMIC","uriSpec":{"parts":[{"value":"scheme","variable":true},{"value":"://","variable":false},{"value":"address","variable":true},{"value":":","variable":false},{"value":"port","variable":true}]}}



异常处理
org.apache.zookeeper.KeeperException$UnimplementedException: KeeperErrorCode = Unimplemented for 
原因：zk客户端和服务器端的版本不一致，更换版本即可

zk启动失败
ERROR [main:ZooKeeperServerMain@81] - Unexpected exception, exiting abnormally
java.io.IOException: No snapshot found, but there are log entries. Something is broken!

解决：删除dataDir：rm -rf /tmp/zookeeper
原因：更新zk版本后，之前的数据格式不兼容

