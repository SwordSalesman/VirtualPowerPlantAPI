
# Virtual Power Plant API

Skill test for Powerledger submitted by Luke Cannon.

A Spring API is used to get/retrieve data from a MySQL database. Both the Spring application and the database are hosted on Azure services and are publicly accessible.

## Usage/Examples
Recommended to use Postman or similar for sending/receiving HTTP requests.

### Get Requests
GET request with all batteries
```
https://virtualpowerplant.azurewebsites.net/api/v1/battery
```

GET request with a specified postcode range (e.g. 6050 to 6070)
```
https://virtualpowerplant.azurewebsites.net/api/v1/battery?start=6050&end=6070
```

#### Example response.
The response starts with the average and total watt capacity of the batteries, then a list of the batteries (in alphabetical order)
```json
{
  "capacityAverage": 3.65,
  "capacityTotal": 14.6,
  "batteries": [
    {
      "name": "Bayswater library",
      "postcode": 6053,
      "wattCap": 6.5
    },
    {
      "name": "Morley home",
      "postcode": 6062,
      "wattCap": 2.1
    },
    {
      "name": "Mt Lawley Bakery",
      "postcode": 6060,
      "wattCap": 2.8
    },
    {
      "name": "Subiaco cafe",
      "postcode": 6008,
      "wattCap": 3.2
    }
  ]
}
```

### Post Requests
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

Updating and Deleting requests were not included as they were not in the brief. To delete and verify data for testing, the MySQL database is publicly accessible. The login details can be found in 'src/main/resources/application.properties'.


