# spring-microservices-project

This project is an academic project.

It presents the management of a travel agency.
It is composed of 4 micro-services:
Human Ressources:management of the employees of the agency.
Client:management of clients .
Promotions :management of promotions.
Offres: management of the offers.

Every micro service has it own data base (h2) and they can communicate through Feign Dependency.
 
Those micrservices are deployed on Eureka Server with Zuul as a proxy.

The port of eureka server is 8761.
The port of Zuul is 8762.
To test the micro services: 
localhost:8762/"name of the service"/path

