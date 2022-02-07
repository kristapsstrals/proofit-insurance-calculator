# Insurance Calculator

Live demo available [here](http://proofit.kriss.tech:8080/)

---

App used to calculate premium for an insurance policy.

To start the app, use `./gradlew bootRun` command. The app exposes an `HTTP POST` endpoint for policy premium calculation on `http://<host>:8080/premium/calculate`. Example json payload:

```json
{
  "number": "TEST_POLICY_NUMBER",
  "status": "REGISTERED",
  "policyObjects": [
    {
      "name": "House",
      "subObjects": [
        {
          "name": "TV",
          "sumInsured": 200.66,
          "riskType": "FIRE"
        }
      ]
    }
  ]
}
```

- Supported policy statuses: `REGISTERED`, `APPROVED`
- Supported risk types: `FIRE`, `THEFT`

## OpenAPI

Use Swagger UI to easily interract with the API endpoint from the browser. Swagger UI available at the application root `http://<host>:8080`

## Curl

Example curl request:

```sh
curl -X 'POST' \
  'http://<host>:8080/premium/calculate' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
   "number":"TEST_POLICY_NUMBER",
   "status":"REGISTERED",
   "policyObjects":[
      {
         "name":"House",
         "subObjects":[
            {
               "name":"TV",
               "sumInsured":200.66,
               "riskType":"FIRE"
            }
         ]
      }
   ]
}'
```

response:

```json
{
  "insurancePremium": 4.82
}
```

## Implementation

Java app written using Spring Boot + Gradle for builds and JUnit for unit tests.

Unit tests cover the two test cases for acceptance criteria.

App has an HTTP entry point and HTTP Post requests with a JSON payload can be used to interact with the app. The HTTP request returns a JSON response with either the calculated insurance premium or an error message.

BigDecimal class is used for monetary values to allow easier implementation than working with integers (since it allows decimal values), while avoiding the issues of loss of precision that comes from [using float or double](https://dzone.com/articles/never-use-float-and-double-for-monetary-calculatio)

In addition to this, there is an OpenAPI UI (Swagger) for additional object(class) and enum documentation vailable at the application web address root `http://<host>:8080`.
