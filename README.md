## Docker hub repository, and workflow with him in local machine
  I have an docker hub repository, that contains all the neccessary images for **pulling** and **running** them and creating containers. In code i have configurations for every microservice that allows me to push my code like image to my docker hub, then i can pull them through my docker and run them as containers:
`docker compose pull` - pull all the images that mentioned in docker-compose.yml file;
`docker compose up -d` runs all the containers in docker file;
`docker compose stop` can basically stop all the containers that mentioned in docker file;
`docker compose start` obviously will start all the containers;

## Zipkin
  Zipkin collects timing data from various parts of your application and lets you see the entire flow of a request as it traverses through different services. It's located on this port below: 
> http://localhost:9411
## PgAdmin
> http://localhost:5050/
  It's UI for working with database.
## Postgres
Will be reachable and managable with pgAdmin
> localhost:5432
## RabbitMQ
Message broker that helps to talk customer service with notification service asynchronously. AMQP - advanced message queue protocol.(Message queues have their own protocols for talking)
> http://localhost:15672/
And credentials of course:
> username:guest (by default)
> password:guest (by default)


## To run every jar of microservice: 

- `mvn clean`

- `mvn package` or `mvn install`

- `java -jar <paraticular jar in target directory>`
