🚗 My Way – Smart Parking & Car Services

My Way is a hackathon-winning project designed to simplify parking and car service navigation. This web-based platform helps users locate available parking spaces and find essential car services, including car washes, engine repairs, and more.

🌟 Features

✅ Smart Parking Finder – Locate nearby available parking spaces.
✅ Car Service Locator – Find car washes, repair shops, and maintenance centers.
✅ Real-Time Data – Get live updates on parking availability and service details.
✅ User-Friendly Interface – Easy navigation for drivers looking for quick solutions.
✅ Map Integration – View service locations and parking spots on an interactive map.

🛠 Tech Stack
 • Backend: Java Spring Boot
 • Database: PostgreSQL
 • Mapping Services: Google Maps API / OpenStreetMap / Yandex Maps API
 • Security: Spring Security
 • API Documentation: Swagger (SpringDoc OpenAPI)

🚀 Installation & Setup

Prerequisites

Ensure you have the following installed:
 • Java 23
 • Spring Boot
 • PostgreSQL
 • Maven

Steps to Run Locally
1. Clone the repository:
git clone https://github.com/Abdumalik-Java/My-way.git
cd My-way

2.Set up the database
Install PostgreSQL and create a database named myway.
Update application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/myway
spring.datasource.username=postgres
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true

3. Access the application
Open http://localhost:8080 to use the platform.

📖 Swagger API Documentation

Access the API Docs
Swagger UI: http://localhost:8080/swagger-ui.html
Raw OpenAPI JSON: http://localhost:8080/v3/api-docs

📜 License
This project is licensed under the MIT License.
