# Report Application
This is a Spring Boot application that consumes Order Creation 
Payloads from a Kafka topic and generates a report of orders 
grouped by date. The application also supports a date range 
filter for the report.

## Dependencies
The following dependencies are used in this application:
* Spring Boot 
* Spring Web
* Spring Kafka
* Lombok
* MySQL


### How to Run
* Clone the repository to your local machine.
* Install the required dependencies using Maven by running the command mvn install.
* Start the application using the command mvn spring-boot:run.



### Endpoints
The following endpoints are available:

`/api/report/orders` - Returns an Order report grouped by date. Supports the following query parameters:
startDate - The start date for the report (required), 
endDate - The end date for the report (required). <br>

Sample Request <br>
`GET /report?startDate=2022-01-01&endDate=2022-01-31` <br>

Sample Response <br>
`[
{
"date": "2022-01-02",
"totalOrders": 10,
"totalAmount": 500.00
},
{
"date": "2022-01-03",
"totalOrders": 15,
"totalAmount": 750.00
},
{
"date": "2022-01-04",
"totalOrders": 20,
"totalAmount": 1000.00
},
...
]`

Kafka Consumer
The application subscribes to a Kafka topic from 
[this](https://github.com/ife0luwa/Sales-and-Inventory-Management-Application) Kafka producer to consume 
Order Creation Payloads.





