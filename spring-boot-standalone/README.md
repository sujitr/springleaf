## spring-boot-standalone

This is a standalone command line application, of Hello World sort with very basic shell.
It uses [Spring Boot Maven Plugin](https://docs.spring.io/spring-boot/docs/current/maven-plugin/index.html) to run from command line. 
Which is very similar to normal [Exec Maven Plugin](http://www.mojohaus.org/exec-maven-plugin/index.html) to call main method, but with the Spring
CommandLineRunner bean.

#### Running the program from command line
`mvn spring-boot:run`

This will just build the program and execute spring boot with configured bean. 
You should be able to see the print-line output from the main method somewhere sandwiched between spring container instantiation, 
bean registration and deregistration and finally shutdown debug statements. For example - 

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.5.8.RELEASE)

2017-10-30 06:12:52.553  INFO 922 --- [           main] com.sujit.App                            : Starting App on 3f7f2cd332db with PID 922 (/projects/springleaf/spring-boot-standalone/target/classes started by user in /projects/spring
leaf/spring-boot-standalone)
2017-10-30 06:12:52.557  INFO 922 --- [           main] com.sujit.App                            : No active profile set, falling back to default profiles: default
2017-10-30 06:12:52.601  INFO 922 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@3368e21b: startup date [Mon Oct 30 06:12:52 UTC 2017
]; root of context hierarchy
2017-10-30 06:12:53.247  INFO 922 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
>>> Standalone Spring Boot application - Hello World!!!
2017-10-30 06:12:53.262  INFO 922 --- [           main] com.sujit.App                            : Started App in 1.054 seconds (JVM running for 13.798)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 12.526 s
[INFO] Finished at: 2017-10-30T06:12:53+00:00
[INFO] Final Memory: 27M/256M
[INFO] ------------------------------------------------------------------------
2017-10-30 06:12:53.422  INFO 922 --- [       Thread-2] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@3368e21b: startup date [Mon Oct 30 06:12:52 UTC 2017];
root of context hierarchy
2017-10-30 06:12:53.427  INFO 922 --- [       Thread-2] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
```



Although, please remember that this command is bit different from standard `mvn clean install` where even the unit tests inside "src\test" are executed. This
particular spring boot run command does not execute tests.

#### Current status of this project
The test run part of this project is having some issues, which is currently being investigated. This issue shows up when you use a normal build operation of maven 
`mvn clean install`.
