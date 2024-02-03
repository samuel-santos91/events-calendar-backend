# events-calendar-backend

## Description
* This Spring Boot backend application serves as the backend for the events-calendar frontend. 
* It provides RESTful APIs to manage the events' information.
### Purpose
* The purpose of this project was to:
    * practice building a backend with Spring Boot
    * integrate a server with a frontend
    * integrate a database with a server
### Tech Stack
* Spring Boot
* MySQL (database)

## Features 
 - RESTful API for events management (CRUD operations);
 - Database integration (<strong>MySQL</strong>) for persistent data storage;
 - Error handling.

## Getting Started
### Prerequisites
 - Java Development Kit (JDK) 8 or higher installed;
 - Eclipse IDE or any Java development environment;
 - MySQL database.

### Installation
 - Clone this repository;
 - Import project into your IDE;
 - Configure the database connection application.properties;
 - Configure cors in WebConfig.java;
 - Run the application.

### Frontend repository
Refer to https://github.com/samuel-santos91/events-calendar

### API Endpoints
 - GET /url/byMonthAndYear/{year}/{month}: Retrieve all events of specified month.
 - GET /url/byDate/{date}: Retrieves all events in a specified date.
 - GET /url/{eventID}: Retrieves an event with specified ID.
 - POST /url/: Create a new event.
 - PATCH /url/{eventID}: Updates an event.
 - DELETE /url/{eventID}: Delete an event.

