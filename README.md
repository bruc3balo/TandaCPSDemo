### [Swagger documentation](http://localhost:6794/cps/swagger-ui/index.html)
#### Click above to open open ai documentation

### Sample request

**POST URI:** http://localhost:6794/cps/swagger-ui/index.html#/gw-request-controller 

Body: 
```json
{
  "amount": 10,
  "mobileNumber": 254728762287,
  "id": "feb5e3f2-fbbc-4745-844c-ee37b546f627"
}
```

# Kafka
The application is dependant of kafka to function

# Deploying

Code changes will be picked up by building a new image or passing **--build** service to **docker compose up**

Necessary health checks have been put in place to ensure container uptime and ease of debugging

### Step 1: Create Docker Network
```bash
docker network create tanda_network
```

### Step 2: Deploy Whole Infrastructure
#### For initial build to create images i.e. No images build
```bash
docker compose -f cps-demo-compose.yaml up --build -d
```
#### Start all containers without building image i.e. After successful initial build
```bash
docker compose -f cps-demo-compose.yaml up -d
```

### Step 3: Watch Logs from all containers
```bash
docker compose -f cps-demo-compose.yaml logs -f
```

### Step 4: Clean up

#### Stop all containers without deleting volume
```bash
docker compose -f cps-demo-compose.yaml down
```

#### Prune The Whole Infrastructure

```bash
docker compose -f cps-demo-compose.yaml down -v   
```

# Environment Variables
### N/B: It's bad practice to push secrets to a repository. This is just to make testing easy

The following environment variables need to be provided in order for the application to run smoothly.


[Application Environment variables](.env)
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
curl -f http://localhost:6794/cps/ping
```

##### Host
```bash
docker exec cps_api curl -f http://localhost:6794/cps/ping
```



