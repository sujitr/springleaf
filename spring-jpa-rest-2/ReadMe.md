# Spring Boot REST example with JPA and H2

This is the most comprehensive and quickest method to 
implement fully functioning REST endpoints, automatically
with the Spring Boot & JPA, without writing any explicit
controller and rest handlers.

Spring Boot supports a few well known in-memory databases out of the box, for example with H2, HSQL or Apache Derby).
But for other databases like SQLite and more general propietary
products, you have to look deeper in making the connection
from Spring Boot to the database.

That's important because, Spring be default use Hibernate as the
JPA implementation and Hikari for connection pooling. This combination
works flawlessly with aforementioned databases. But for others, you
need to do considerable plumbing.

Having said that, with proper configuration and correct drivers and dialects,
Spring Boot does work with majority of Databases.

## Breakdown of this example
This example uses H2 im-memory database. The application seeds the data
into the database at startup via the records mentioned in src/main/resources/data.sql file.
And that's about it. The HAL explorer brings up a nice browser based UI to 
explore the REST endpoints when the application starts up.

Just run the Spring Boot application and point the browser at - 

1. http://localhost:8080/countses/
2. http://localhost:8080/

With this application you have all the REST commands implemented
for you as endpoints - 

* GET
* POST
* DELETE
* PUT
* PATCH

This example follows the tutorial at - https://developersoapbox.com/creating-a-rest-api-effortlessly-with-spring-rest-repositories/