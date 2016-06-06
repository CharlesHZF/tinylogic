## TinyLogic 配置


TinyLogic根目录下有个conf.xml。

以下是具体的配置内容：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
	<property>
		<name>dbcp.driverClassName</name>
		<value>org.mariadb.jdbc.Driver</value>
	</property>
	<property>
		<name>dbcp.url</name>
		<value>jdbc:mysql://localhost:3306/itportal</value>
	</property>
	<property>
		<name>dbcp.username</name>
		<value>root</value>
	</property>
	<property>
		<name>dbcp.password</name>
		<value>123456</value>
	</property>
	<property>
		<name>dbcp.maxActive</name>
		<value>30</value>
	</property>
	<property>
		<name>dbcp.maxIdle</name>
		<value>10</value>
	</property>
	<property>
		<name>dbcp.minIdle</name>
		<value>5</value>
	</property>
	<property>
		<name>dbcp.maxWait</name>
		<value>1000</value>
	</property>
	<property>
		<name>dbcp.removeAbandoned</name>
		<value>true</value>
	</property>
	<property>
		<name>dbcp.removeAbandonedTimeout</name>
		<value>180</value>
	</property>
	
	
	
	
	<!-- log conf start -->
	 <!--日志输出实现提供者-->
	<property>
		<name>clog.logger</name>
		<value>ConsoleLogger</value>
	</property>
	<!--日志级别 i w e-->
	<property>
		<name>clog.level</name>
		<value>info</value>
	</property>
	<!-- 文件的目录 -->
	<property>
		<name>clog.dir</name>
		<value>/log/</value>
	</property>
	<!-- 文件的前缀 -->
	<property>
		<name>clog.file.pre</name>
		<value>test</value>
	</property>
	
	
	<!-- log conf end -->
	
	
	<!-- tinylogic conf start -->
	<property>
		<name>tinylogic.server.count</name>
		<value>100</value>
	</property>
	<property>
		<name>tinylogic.server.port</name>
		<value>9000</value>
	</property>
	<property>
		<name>tinylogic.server.context</name>
		<value>com.importsource.tinylogic.server.httpserver.AnnotationContext</value>
	</property>
	
	<!-- tinylogic conf end -->
	
</configuration>
```

###配置文件规则说明

配置文件必须是以上的格式。没有很复杂的层次结构。我们认为keyvalue就可以解决世界上所有的配置问题。你信不信，我反正信！

另外也不要见什么都往配置文件放，配置解决不了解世界上所有的问题，解决了一部分就不错了！你信不信，我反正信！



###配置数据库的参数
```xml
<property>
		<name>dbcp.driverClassName</name>
		<value>org.mariadb.jdbc.Driver</value>
	</property>
	<property>
		<name>dbcp.url</name>
		<value>jdbc:mysql://localhost:3306/itportal</value>
	</property>
	<property>
		<name>dbcp.username</name>
		<value>root</value>
	</property>
	<property>
		<name>dbcp.password</name>
		<value>123456</value>
	</property>
	<property>
		<name>dbcp.maxActive</name>
		<value>30</value>
	</property>
	<property>
		<name>dbcp.maxIdle</name>
		<value>10</value>
	</property>
	<property>
		<name>dbcp.minIdle</name>
		<value>5</value>
	</property>
	<property>
		<name>dbcp.maxWait</name>
		<value>1000</value>
	</property>
	<property>
		<name>dbcp.removeAbandoned</name>
		<value>true</value>
	</property>
	<property>
		<name>dbcp.removeAbandonedTimeout</name>
		<value>180</value>
	</property>
```



###配置log的参数
```xml
<!-- log conf start -->
	 <!--日志输出实现提供者-->
	<property>
		<name>clog.logger</name>
		<value>ConsoleLogger</value>
	</property>
	<!--日志级别 i w e-->
	<property>
		<name>clog.level</name>
		<value>info</value>
	</property>
	<!-- 文件的目录 -->
	<property>
		<name>clog.dir</name>
		<value>/log/</value>
	</property>
	<!-- 文件的前缀 -->
	<property>
		<name>clog.file.pre</name>
		<value>test</value>
	</property>
	
	
	<!-- log conf end -->
```



