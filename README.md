# microservices-template

Required parameters to define for microservice-1 and microservice-2:
1. SPRING_DATASOURCE_URL
2. SPRING_DATASOURCE_USERNAME
3. SPRING_DATASOURCE_PASSWORD
And non-required for microservice-1, microservice-2 and audit:
1. KAFKA_BOOTSTRAP_SERVERS (default: "localhost:29092")

Swagger for microservice-1: http://localhost:8081/swagger-ui/index.html

Swagger for microservice-2: http://localhost:8082/swagger-ui/index.html

Postman workspace: https://www.postman.com/olegprog2020/workspace/microservices-template-workspace

Zipkin is used for distributed tracing. It needs to be run separately:
```
docker run -d -p 9411:9411 openzipkin/zipkin
```
Redis is used for caching. To run Redis, execute:
```
docker run -d --name redis-stack-server -p 6379:6379 redis/redis-stack-server:latest
```
Kafka is also used on port 29092. To start , you can use:
```
version: '2'
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:latest
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000
    ports:
      - 22181:2181
  
  kafka:
    image: confluentinc/cp-kafka:latest
    depends_on:
      - zookeeper
    ports:
      - 29092:29092
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:9092,PLAINTEXT_HOST://localhost:29092
      KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: PLAINTEXT:PLAINTEXT,PLAINTEXT_HOST:PLAINTEXT
      KAFKA_INTER_BROKER_LISTENER_NAME: PLAINTEXT
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
```
and
```
docker-compose up -d
```
