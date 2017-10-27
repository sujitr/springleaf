## spring-boot-standalone

This is a standalone command line application, of Hello World sort with very basic shell.
It uses [Spring Boot Maven Plugin](https://docs.spring.io/spring-boot/docs/current/maven-plugin/index.html) to run from command line. 
Which is very similar to normal [Exec Maven Plugin] (http://www.mojohaus.org/exec-maven-plugin/index.html) to call main method, but with the Spring
CommandLineRunner bean.

#### Running the program from command line
`mvn spring-boot:run`

This will just build the program and execute spring boot with configured bean. 
You should be able to see the print-line output from the main method somewhere sandwiched between spring container instatation, 
bean registration and deregistration and finally shutdown debug statements.

Although please remember that this command is a bit different from `mvn clean install`, where even the tests are executed. This
command does not execute tests.

#### Current status of this project
The test run part of this project is having some issues, which is currently being investigaed.
