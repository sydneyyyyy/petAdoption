# Pet Adoption Agency

### Developers:
- Mark Mersman
- Emmett Riddle
- Sydney Porter
- Gregory Diaz

The Pet Adoption Agency is a web application designed to provide a simulated online pet adoption process. It contains a login portal where users can view and apply to adopt a pet from a variety of species and breeds. 

## Project Description
Pet Adoption Agency is a online portal for various species available for adoption. Users can filter through the animals by species, breeds, and gender in order to find their perfect pet. Employees have the added capability to add a pet, view applications, approve, deny, and request more information from users. 

## Features
User can login/register for an account
User can search different species and breeds to adopt
Users can apply for adoption of said animal.
Employees can login to their account
Employees can manage available pets
Employees can accept or decline adoption applications, and request information from adopter

## Further Development
- Potential adopters can submit video introduction for consideration in their applications.
- Create retain store for accessories and pet necessities.
- Implement Stripe API to accept payments online. Users can keep track of payments, search past payments, create recurring charges, and keep track of customers.

## Technologies Used
- Java
- JavaScript
- HTML5
- CSS
- Bootstrap 5
- Spring Boot
- Spring Data
- Spring MVC
- Spring Test
- PostgreSQL
- AWS RDS
- DBeaver
- Git
- Spring Tool Suite
- Maven 
- Visual Studio Code

## Spring Modules
- Spring Boot
- Spring Data JPA
- Spring Web MVC

## Required Dependencies
```
<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<version>42.2.20</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.google.code.gson/gson -->
		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.8.7</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-core</artifactId>
			<version>2.14.1</version>
		</dependency>

		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.13.2</version>
			<scope>test</scope>
		</dependency>

	</dependencies>
```