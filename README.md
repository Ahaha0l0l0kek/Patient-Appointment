# Patient-Appointment

## Сборка проекта
```sh
mvn package
```

## Запуск проекта
```sh
docker-compose up --build
```

## Описание
По части rest имеется swagger по адресу http://localhost:8081/swagger-ui/index.html

По части soap:
    WSDL схема: http://localhost:8080/ws/timetable.wsdl
    
    Запрос:
      <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ws="http://projects.my/ws">
        <soapenv:Header/>
        <soapenv:Body>
          <ws:CreateTimetableRequest>
            <!--format of date: 'yyyy-MM-dd'-->
            <ws:date>?</ws:date>
            <!--format of time: 'HH:mm'-->
            <ws:startTime>?</ws:startTime>
            <ws:endTime>?</ws:endTime>
            <!--1 or more repetitions:-->
            <ws:Doctor>
            <ws:id>?</ws:id>
            </ws:Doctor>
          </ws:CreateTimetableRequest>
        </soapenv:Body>
      </soapenv:Envelope>

    Ответ:
      <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/">
        <SOAP-ENV:Header/>
        <SOAP-ENV:Body>
          <ns2:CreateTimetableResponse xmlns:ns2="http://projects.my/ws">
            <ns2:isCreated>true</ns2:isCreated>
          </ns2:CreateTimetableResponse>
        </SOAP-ENV:Body>
      </SOAP-ENV:Envelope>
