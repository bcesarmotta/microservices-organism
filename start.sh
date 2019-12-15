# Put all the instances down
docker-compose down

# rebuild all the instances
docker-compose build --no-cache

# put the things up
docker-compose up

# To run only some services
docker-compose up -d service_name
docker-compose start service_name