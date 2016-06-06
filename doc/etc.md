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
