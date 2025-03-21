# JSONPlaceholder API Integration

A Spring Boot application that integrates with the JSONPlaceholder API to fetch post data, process it, and return it in a structured JSON format.

## Overview

This application fetches data from the JSONPlaceholder API, extracts specific fields (userId, id, title, body), and returns the data in a structured JSON format. It includes error handling for API failures and missing data.

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher
- Spring Boot 3.x

### Installation

1. Clone the repository:
https://github.com/Aster-Shan/APITEST.git

2. Configure the application:

Add the following to your `application.properties` file:
```properties

    ## API Configuration
    api.url=https://jsonplaceholder.typicode.com/posts/1

    ## Error Handling Configuration
    spring.mvc.throw-exception-if-no-handler-found=true
    spring.web.resources.add-mappings=false

3. Build the application:

```plaintext
mvn clean install
```
4. Run the application:

```plaintext
mvn spring-boot:run
```
The application will start on port 8080 by default.

# API Endpoints

### Get Post Data

- **URL**: `/api/post`
- **Method**: GET
- **Response**: JSON object containing userId, id, title, and body fields
- **Success Response**:

```json
{
  "userId": 1,
  "id": 1,
  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
  "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
}
```

- **Error Response**:

```json
{
  "error": "Data not found"
}
```


## Approach

### Architecture

The application follows a standard Spring Boot architecture with the following components:

**Controller Layer** (`ApiController`):

1. Handles HTTP requests
2. Maps endpoints to service methods
3. Returns appropriate HTTP responses


**Service Layer** (`ApiService`):

1. Contains business logic
2. Communicates with external APIs
3. Processes data and handles errors



**Model Layer** (`ApiModel`):

1. Defines data structures
2. Maps JSON responses to Java objects



**Configuration** (`AppConfig`, `SecurityConfig`):

1. Configures application components
2. Sets up security rules
3. Creates necessary beans




### Error Handling

The application implements comprehensive error handling:

**Try-Catch Blocks**:

1. Catches exceptions during API calls
2. Returns appropriate error responses



**Global Exception Handler**:

1. Handles application-wide exceptions
2. Formats error responses consistently

**Null Checking**:

1. Validates API responses
2. Handles cases where data is missing

### Security

The application includes basic security configuration:

1. **CSRF Protection**: Disabled for API endpoints
2. **CORS**: Configured with default settings
3. **Authentication**: Disabled for this demo application
4. **Authorization**: All endpoints are publicly accessible
