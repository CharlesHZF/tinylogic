# tinylogic
tinylogic  is a flyweight microservice framework.

You can add some code to the doIt method,then all is ok.

The object field  push content to client. eg. your browser. the format of data is json.


###三秒学会使用TinyLogic

第一步：新建一个maven项目。然后写个这样的类：
```java
@MicroService(value="/apps/hello2")
public class Hello2 extends DefaultHttpHandler{
	@Override
	public void doIt(Request request, Response response) {
		obj =  "hello";
	}
	
}
```

第二步：打包项目。把jar复制到｀tinylogic\webapp｀下。

第三步：双击“start.cmd”。OK啦！








###TinyLogic Conf  配置能力

你可以通过以下的代码在你的service逻辑中读取 conf.xml的你的配置：
```java

@MicroService(value="/apps/hello2")
public class Hello2 extends DefaultHttpHandler{
	@Override
	public void doIt(Request request, Response response) {
		Person p=new Person();
		p.name="HelloWorld22222";
		DefaultProperties p1 =DefaultProperties.newInstance();
		String driverClassName = PropertiesTools.get(p1, "dbcp.driverClassName", null);
		obj =  driverClassName;
	}
	
}

```
