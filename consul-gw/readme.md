### 启动
启动consul
在三台机器分别启动
```
consul agent  -bootstrap-expect 2  -server   -data-dir /data/consul/data -node=cn1 -bind=192.168.99.100 -config-dir /data/consul/etc/consul.d -enable-script-checks=true  -datacenter=dc1 -client 0.0.0.0 -ui

consul agent -server -data-dir /data/consul/data -node=cn3 -bind=192.168.99.101 -config-dir /data/consul/etc/consul.d -enable-script-checks=true  -datacenter=dc1  -join 192.168.99.100 -client 0.0.0.0 -ui

consul agent -server -data-dir /data/consul/data -node=cn3 -bind=192.168.99.102 -config-dir /data/consul/etc/consul.d -enable-script-checks=true  -datacenter=dc1  -join 192.168.99.100 -client 0.0.0.0 -ui

```
consul option说明文档
https://www.consul.io/docs/agent/options.html

然后使用浏览器打开

```http://192.168.99.101:8500/ui```

即可看到consul控制台


### 使用feign时注意事项
1.@PathVariable形式的参数,则要用value=""标明对应的参数,否则会抛出IllegalStateException异常
2.yml文件中开启 feign.hystrix.enable=true
