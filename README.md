# [test-flights](https://github.com/Lexxuan/test-flights)

This is a simple flights APIs.

## Depending on technology
* DB
 
## Depending on Services
* None

## Getting Started

```
git clone https://github.com/Lexxuan/test-flights.git
```
### Remote test in GSP:
```
http://35.202.31.47:8080/api/v1/swagger-ui.html

Basic auth:
username: user
password: pw
```

### Local test with GSP DB:

#### How to Bind GCP DB
Since i store flights data in GCP DB, you need to request and import the google application credentials file into GOOGLE_APPLICATION_CREDENTIALS:
```
export GOOGLE_APPLICATION_CREDENTIALS="/{path}/your-credentials.json"
```

#### How to build locally

```
mvn clean install
```

#### How to run locally

```
./go
```

#### How to test locally

```
Access:
http://localhost:8080/api/v1/swagger-ui.html

Basic auth:
username: user
password: pw
```

### Monitor Endpoints
```
/api/v1/health
/api/v1/metrics
/api/v1/trace
...
```

## References
