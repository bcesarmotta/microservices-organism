# Microservices Organism
This project was created by myself with the purpous of study, apply and improve my knowledges in microservices architecture and its implementation.

## Getting Started
These instructions will guide you through the understanding and configuration of the entire project.
After you following this tutorial, will get you a copy of the project up and running on your local machine for development and testing purposes.

## The Project
This project consists in a related communication between campaigns, supporters members and football teams where one or more campaigns can be related to a football team, and a Football Team can be associated to a given customer (in this case the suporter member)

### Architecture
This project was designed based on Domain Drive Design concepts, and it works following microvervices concepts, exchanging data through API requests and Queue/Messaging (assynchronous requests).

#### Context Diagram
[Working on it]

#### Integration Diagram
[Working on it]

### Pre-requisites
To get this project working, you will need to install the following technologies:

```
Nexus
Docker
Docker-compose
```

### Run
To get this project up, run the folowing steps:

```
docker restart nexus
docker-compose down
docker-compose build --no-cache
docker-compose up
```

After run these steps, you will be able to check the available APIs for the following services

```
/campaign
/supporter-member
/football-team
```

You will also able to check the Eureka Service discovery and the Gateway API.

### Postman Collections

The collections that I created to test this project can be found in the following link: [Postman Collections](https://www.getpostman.com/collections/cf6ad297081e9a205654).

### Next steps
- [ ] Add a guideline to explain how this project works
- [ ] Add nexus Repository to docker-compose
- [ ] Add authentication api with Go Lang
- [ ] Add Authorization api with Go Lang
