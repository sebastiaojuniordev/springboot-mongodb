# SpringBoot MongoDB
Build a simple CRUD App with Spring Boot and MongoDB

## Installation


```bash
mvn clean install
```
## Configuration
Check the application.properties file

## Run

```
mvn spring-boot:run
```

## Usage
**Insert**:
```
curl --request POST \
  --url http://localhost:8080/springboot-mongodb/student \
  --header 'Content-Type: application/json' \
  --data '{
	"name": "Ana",
	"age": 22
}'
```
**Update**:
```
curl --request PUT \
  --url http://localhost:8080/springboot-mongodb/student \
  --header 'Content-Type: application/json' \
  --data '{
	"id": "606e694e04aae720dae244f9",
	"name": "Sebastião Junior",
	"age": 25
}'
```
**Find by ID**:
```
curl --request GET \
  --url http://localhost:8080/springboot-mongodb/student/606e63d70528ba657e39b360
```

**Find all**:
```
curl --request GET \
  --url http://localhost:8080/springboot-mongodb/student
```

**Delete**:
```
curl --request DELETE \
  --url http://localhost:8080/springboot-mongodb/student/606e63d70528ba657e39b360
```


## License
[MIT](https://choosealicense.com/licenses/mit/)