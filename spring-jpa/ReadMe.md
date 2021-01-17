# Spring Boot example with JPA and H2

In this application we will try to check various ways to 
access DB data using Spring JPA (Which is implemented by Hibernate bundled with Spring). We are using spring platform
provided H2 database here, but with a suitable dependency and
'application.properties' file, this example can be used with any other
database.

## What is the nature of this JPA application?
This is not a web application, instead its a simple command line stand-alone application.
The DB is spawned in memory and filled with data while the application starts and after 
the application terminates all those data and the DB is purged.

## What happens to all the queries and joins, where to see the results?
After the data is seeded in the in-memory DB (while the application starts), the CommandLineRunner bean
executes the various queries as programmed. The results of these queries are shown in the logs.

## What is the objective of this project?
This example shows different ways to access data - 
1. Simple Entity Repositories for CRUD operations
2. Joined Entities for SQL Join operations
3. Stored Procedure Entities for accessing results from Stored Procedures