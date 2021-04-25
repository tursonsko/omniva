# JSON to MySQL database convert

1. This app was created to get data from API and save into Database. 
2. There is daily update also added. 
    1. For test provided 10 seconds fixedRate, but one line above there is commented annotation with 1 day in miliseconds.

## Local setup
1) To install the app locally, please clone this repo: "git clone https://github.com/tursonsko/omniva.git"
2) Open Docker CLI and go to path with project resources (..src/main/resources)
3) provide command "docker-compose up -d"
4) Run app in your IDE or in Shell

## Further improvements
1) Need to check why id of each DTO object is "0" and does not show before saving into DB.
Because of this, I had to check objects in the update method with name, not with id
2) Add more security, right now, only protection against unrecognized fields in response to API is provided
