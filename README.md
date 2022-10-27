
# Virtual Power Plant API

Skill test for Powerledger submitted by Luke Cannon.

## Requirements
- Java
- MySql
    - A database should be set up called 'virtualpowerplant'
    - Username = 'root', Password = 'password'
- Spring (including Spring Boot, Spring JPA)
## Usage/Examples
Recommended to use Postman or similar for sending/receiving HTTP requests.

GET request with all batteries
```http
http://localhost:8080/api/v1/battery
```

GET request with a specified postcode range (e.g. 6050 to 6070)
```http
http://localhost:8080/api/v1/battery?start=6050&end=6070
```

POST request body to add batteries to the database
```json
[
  {
    "name":"Battery 1",
    "postcode":6062,
    "wattCap":2.1
  },
  {
    "name":"Battery 2",
    "postcode":6073,
    "wattCap":5.3
  }
]
```


## Notes

Batteries are stored in the databased with the 'name' as the primary ID (names must be unique). If this is not acceptable, the structure could be modified so that an ID count is used instead.

Updating and Deleting requests were not included as they were not in the brief.

