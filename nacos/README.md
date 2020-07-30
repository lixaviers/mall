## 注册中心、配置中心
### 我这里注册中心和配置中心使用的同一套集群，你也可以分开配置

使用Nacos作为注册中心和配置中心<br>
需要修改的地方：<br>
1、将nacos1/conf中的nacos-mysql.sql导入到数据库中
2、修改每个nacos的数据库配置信息<br>
nacos1/conf下application.properties<br>
nacos2/conf下application.properties<br>
nacos3/conf下application.properties<br>
我这里规划三个节点，8848、8849、8850，如果想修改端口，nacos/conf下application.properties中，修改server.port的值，并修改nacos/conf下cluster.conf中的端口<br>
3、启动服务<br>
mac/Linux系统运行nacos*/bin下面的startup.sh<br>
windows系统运行nacos*/bin下面的startup.cmd<br>
4、停止服务<br>
mac/Linux系统运行nacos*/bin下面的shutdown.sh<br>
windows系统运行nacos*/bin下面的shutdown.cmd<br>

