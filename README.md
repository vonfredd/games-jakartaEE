# RESTful web service 
- JakartaEE
- Docker
- WildFly application server

## You need an .env file in root with this data
```
DB_NAME: db
DB_USERNAME: root
DB_PASSWORD: password
DB_CONNECTION_URL=jdbc:mysql://db:3306/${DB_NAME}
```

## How to use
- Open IDE
- Clone this repository
- Start docker
- Run `mvn package -DskipTests`
- Run `docker-compose up --build`
- Go to http://localhost:8080/games-jakartaEE-1.0-SNAPSHOT/api/games
- Use an API dev/testing tool (e.g Postman) to try the applications different endpoints


## How to end
- Run `docker-compose down -v --rmi local`    (This command stops and removes image,containers, networks and volumes created by the docker-compose.yml)

