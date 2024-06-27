# Widget Machine Emulator

## Overview
This project contains a Widget Machine emulator that uses different types of engines to produce widgets. It calculates the cost of production based on the quantity of widgets requested and the type of engine used.

## Features
- Support for multiple engine types:
    - Internal Combustion Engine (petrol/diesel)
    - Steam Engine (wood/coal)
- Dynamic cost calculation based on engine type and fuel
- RESTful API for widget production
- Extensible design for adding new engine types
- Docker support for easy deployment

## Technologies
- Java 17
- Spring Boot 3.3.1
- Maven
- JUnit 4.11
- Docker

## Getting Started

### Prerequisites
- JDK 17 or higher
- Maven 3.6 or higher
- Docker (optional)

### Installation and Running (without Docker)
1. Clone the repository:
   git clone https://github.com/PocanLin/widget-machine.git
2. Navigate to the project directory:
   cd widgets-machine
2. Build the project:
   mvn clean install
3. Run the application:
   mvn spring-boot:run

### Installation and Running (with Docker)
1. Clone the repository:
   git clone https://github.com/PocanLin/widget-machine.git
2. Navigate to the project directory:
   cd widgets-machine
2. Build the Docker image:
   docker build -t widget-machine .
3. Run the Docker container:
   docker run -p 8080:8080 widget-machine

   The application will start on `http://localhost:8080`.

## Usage
To produce widgets, send a GET request to the `/produce` endpoint with the following parameters:
- `quantity`: Number of widgets to produce
- `engineType`: Type of engine to use (`internal` or `steam`)
- `fuelType`: Type of fuel to use (`petrol`, `diesel`, `wood` or `coal`)

Example:
GET http://localhost:8080/produce?quantity=10&engineType=internal&fuelType=petrol

## API Reference
### Produce Widgets
- **URL**: `/produce`
- **Method**: `GET`
- **URL Params**:
    - `quantity=[integer]`
    - `engineType=[string]`
    - `fuelType=[string]`
- **Success Response**:
    - **Code**: 200
    - **Content**: `Cost to produce {quantity} widgets: £{cost}`
- **Error Response**:
    - **Code**: 500
    - **Content**: `{ error : "Internal Server Error" }`

## Testing
Run the tests using Maven:
mvn test

## Docker
The project includes a Dockerfile for containerization. To build and run the Docker container, follow these steps:

1. Build the Docker image:
   docker build -t widget-machine .
2. Run the Docker container:
   docker run -p 8080:8080 widget-machine

## License
- This project is created for interview purposes and is not intended for commercial use.

## Authors
- Pocan Lin

## Acknowledgments
- Thanks to Worldline for the interview opportunity :)