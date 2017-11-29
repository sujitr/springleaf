## Spring REST with Spring Security

This is an attempt to secure a Spring REST service with Spring Security

**Background**
> In a standard web application, the authentication process may be automatically triggered when the client tries to access a secured resource without being authenticated – this is usually done by redirecting to a login page so that the user can enter credentials. 
> However, for a REST Web Service, this behavior doesn’t make much sense – Authentication should only be done by a request to the correct URI and all other requests should simply fail with a 401 UNAUTHORIZED status code if the user is not authenticated.
> We need to adapt and override Spring Security to communicate using HTTP protocols status only. And this adaptations have many flavor to it.

For more on this Entry-Point concept check this [link](http://www.baeldung.com/securing-a-restful-web-service-with-spring-security). The project at this link describes the 
implementation with Maven.

But we are going to try a new implementation with Gradle and with our trusted Hello World! REST service on SpringBoot. 

Guides to consult - 
1. [link-1](https://dzone.com/articles/secure-rest-services-using).
2. [link-2](http://www.springboottutorial.com/securing-rest-services-with-spring-boot-starter-security).
3. [link-3](https://www.codesandnotes.be/2014/09/21/beginning-spring-security-authentication-on-spring-boot/).
4. [link-4](https://www.codesandnotes.be/2014/10/31/restful-authentication-using-spring-security-on-spring-boot-and-jquery-as-a-web-client/).


#### Iteration One
Just added the spring security dependency, which adds default filter-chain based security check with every request. In this case when you start the service, 
logs would show something like - 

```
Mapping filter: 'springSecurityFilterChain' to: [/*]
...
Using default security password: 062d0f1c-6a26-4204-8cb0-44327de064f4
```

And after that if you try accessing the REST source link, you should get a 401 HTTP error. This is HTTP Basic authentication.

#### Iteration Two
Overriding security details in a properties file. Still this is HTTP Basic authentication. And multiple users cannot be supported here.

#### Iteration Three
Configuring custom User and Roles for access restrictions, by building our own AuthenticationManager configuration. The easiest way is to extend an instance of a WebSecurityConfigurerAdapter and override whatever we need, then expose that adapter as a bean.
However HTTP Basic authentication is unavailable here : Spring Security now presents you a basic form to enter your credentials.

#### Iteration Four
In order to restore the HTTP Basic authentication, we override another configuration() method from the extended WebSecurityConfigurerAdapter.





