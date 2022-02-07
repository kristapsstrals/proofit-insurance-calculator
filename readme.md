# Insurance Calculator

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
