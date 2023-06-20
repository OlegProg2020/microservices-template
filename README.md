# microservices-template

Swagger for microservice-1: http://localhost:8081/swagger-ui/index.html
Swagger for microservice-2: http://localhost:8082/swagger-ui/index.html

Postman workspace: https://www.postman.com/olegprog2020/workspace/microservices-template-workspace

Zipkin is used for distributed tracing. It needs to be run separately:
```
docker run -d -p 9411:9411 openzipkin/zipkin
```
