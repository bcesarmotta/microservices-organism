# Put all the instances down
docker-compose down

# rebuild all the instances
docker-compose build --no-cache

# put the things up
docker-compose up

# To run only some services
docker-compose up -d service_name
docker-compose start service_name

# Running nexus
# docker run -d -p 8081:8081 --name nexus sonatype/nexus3

# Access running container
# docker exec -it <mycontainer> bash
