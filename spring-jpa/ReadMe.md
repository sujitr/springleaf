# Spring Boot example with JPA and H2

In this application we will try to check various ways to 
access DB data using Spring JPA (Which is implemented by Hibernate bundled with Spring). We are using spring platform
provided H2 database here, but with a suitable dependency and
'application.properties' file, this example can be used with any
database.

This example shows different ways to access data - 
1. Simple Entity Repositories for CRUD operations
2. Joined Entities for SQL Join operations
3. Stored Procesdure Entities for accessing results from Stored Procedures