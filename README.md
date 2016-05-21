# tinylogic
tinylogic  is a flyweight microservice framework.

You can add some code to the doIt method,then all is ok.

The object field  push content to client. eg. your browser. the format of data is json.

```
dependency:copy-dependencies -DoutputDirectory=target/lib
```

```xml
 <build>
   	<plugins>
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-jar-plugin</artifactId>
			<configuration>
				<archive>
					<manifest>
						<mainClass>com.charles.panda.siamese.server.httpserver.MyHttpServer</mainClass>
						<addClasspath>true</addClasspath>
						<classpathPrefix>../lib</classpathPrefix>
					</manifest>
				</archive>
				<classesDirectory>
				</classesDirectory>
			</configuration>
		</plugin>
		</plugins>
		</build>
```

```cmd
java -jar C:/Users/Hezf/Documents/dev/svn/alogic/workspace/tinylogic/target/tinylogic-0.0.1-SNAPSHOT.jar
```
