通过Hystrix Dashboard主页面的文字介绍，我们可以知道，Hystrix Dashboard共支持三种不同的监控方式

☞默认的集群监控：通过URL:http://turbine-hostname:port/turbine.stream开启，实现对默认集群的监控。

☞指定的集群监控：通过URL:http://turbine-hostname:port/turbine.stream?cluster=[clusterName]开启，实现对clusterName集群的监控。

☞单体应用的监控：通过URL:http://hystrix-app:port/hystrix.stream开启，实现对具体某个服务实例的监控。

☞Delay：控制服务器上轮询监控信息的延迟时间，默认为2000毫秒，可以通过配置该属性来降低客户端的网络和CPU消耗。

☞Title:该参数可以展示合适的标题。
