# Microservices Organism
This project was created by myself with the purpous of study, apply and improve my knowledges in microservices architecture and its implementation.

## Getting Started
These instructions will guide you through the understanding and configuration of the entire project.
After you following this tutorial, will get you a copy of the project up and running on your local machine for development and testing purposes.

## The Project
This project consists in a communication between campaigns versus supporters versus footballTeam, where one or more campaigns related to a football team can be associated to a given customer (in this case the suporter member)

### Architecture
This project was designed based on Domain Drive Design concepts, and it work as a part of a micro-services environment, exchanging data through API requests and Queue/Messaging (assynchronous requests).

#### Patterns

```
- HTTP REST for Apis
- Eureka for Service Discovery
- Zuul for Api Gateway
```

### Prerequisites
To get this project working, you will need to install the following technologies:

```
Docker
Docker-compose
```

### Run
To get this project up, run the folowing steps:

```
docker-compose down
docker-compose build --no-cache
docker-compose up
```

After run these steps, you will be able to check the available apis

```
/campaign
/supporter-member
/football-team
```

### Postman Collections

The collections that I created to test this project can be found in the following link: [Postman Collections](https://www.getpostman.com/collections/cf6ad297081e9a205654).


### Next steps
- [ ] Add unit tests
- [ ] Add a script to insert initial data
- [ ] Add a guideline to explain how this project flows
- [ ] Verify the Queue flow 
- [ ] Add nexus Repository to docker-compose
