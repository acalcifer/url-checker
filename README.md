# Local setup

1) Run postgres container locally
 ```bash
   docker-compose up -d
   ```
2) Start in dev mode
```bash
./gradlew bootRun
```

# For production

1) Go to [docker-compose.yml](docker-compose.yml)
2) Uncomment config for containers "postgres" and "app", and comment "postgres_dev"
3) Go to [application.yml:13](src/main/resources/application.yml) and set correct postgres url
4) After you have corrected the configs for docker and the spring boot app

run docker container
 ```bash
   docker-compose up -d
   ```
and make a production build
```bash
./gradlew build
```
