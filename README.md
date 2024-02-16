There we have bunch of other services, that works after we run docker-compose file:

////
"""docker compose -up -d
////

And then we will have:

-Zipkin -- http://localhost:9411/

-pgAdmin -- http://localhost:5050/

-postgres(will be reachable and managable with pgAdmin)  -- localhost:5432

-rabbitMq -- http://localhost:15672/   --  username:guest&password:guest (by default)


To run every jar of microservice: 

mvn clean

mvn package or install

java -jar <paraticular jar in target directory>
