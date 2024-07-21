
## Process Flow
#### This was created with visual paradigm online

![Transaction Process Flow](docs/sequence_diagram.png)

### [Swagger documentation](http://localhost:6794/cps/swagger-ui/index.html)
#### Click above to open open ai documentation

# Kafka
The application is dependant of kafka to function

# Deploying

Code changes will be picked up by building a new image or passing **--build** service to **docker compose up**

Necessary health checks have been put in place to ensure container uptime and ease of debugging

### Deploy Whole Infrastructure (For initial builds)
```bash
docker compose -f cps-demo-compose.yaml up --build -d
```

### Prune The Whole Infrastructure
```bash
docker compose -f cps-demo-compose.yaml down -v   
```

### Start all containers without building image (After successful initial build)
```bash
docker compose -f cps-demo-compose.yaml up -d
```


### Watch Logs
```bash
docker compose -f payment-docker-compose.yaml logs -f
```

# Environment Variables
### N/B: It's bad practice to push secrets to a repository. This is just to make testing easy

The following environment variables need to be provided in order for the application to run smoothly.


Application Environment variables
```.dotenv
kafka.servers=
```

# Testing

#### A) Testing the api while building
##### DOCKER FILE

```bash
mvn surefire:test
```

#### B) Testing the api while running
##### Shell
```bash
curl -f http://localhost:6793/payment-api/ping
```

##### Host
```bash
docker exec tanda_payment_api curl -f http://localhost:6794/cps/ping
```
