# Imate Visitors Management System

## Description

The **Imate Visitors Management System** is a Java-based application built with Spring Boot that manages relationships between visitors and inmates. The system allows users to manage visitors, their associated inmates, addresses, and related data through a RESTful API. 

### Features
- Manage visitors and their details (name, age, social security number, contact number).
- Manage inmates and their details (name, age, gender, committed crimes).
- Handle addresses associated with both visitors and inmates.
- Many-to-many relationships between visitors and inmates.

## Technologies Used
- **Java 17**
- **Spring Boot** - For building the RESTful API.
- **Hibernate** - For ORM (Object-Relational Mapping).
- **PostgreSQL** - For database management.
- **Jackson** - For JSON serialization and deserialization.
- **Maven** - For project management and build automation.


API Endpoints
Visitor Endpoints
GET /visitors - Retrieve a list of all visitors.
POST /visitors - Create a new visitor.
GET /visitors/{id} - Retrieve a specific visitor by ID.
PUT /visitors/{id} - Update a specific visitor by ID.
DELETE /visitors/{id} - Delete a specific visitor by ID.
Inmate Endpoints
GET /imates - Retrieve a list of all inmates.
POST /imates - Create a new inmate.
GET /imates/{id} - Retrieve a specific inmate by ID.
PUT /imates/{id} - Update a specific inmate by ID.
DELETE /imates/{id} - Delete a specific inmate by ID.
Address Endpoints
GET /addresses - Retrieve a list of all addresses.
POST /addresses - Create a new address.
GET /addresses/{id} - Retrieve a specific address by ID.
PUT /addresses/{id} - Update a specific address by ID.
DELETE /addresses/{id} - Delete a specific address by ID.
