# kafka-tester
- Cloud Data Streaming Service의 QA또는 테스트를 위한 간단한 샘플소스 
- 메세지를 프로듀스 와 동시에 컨슘하여 큐의 정상작동 여부를 테스트 한다.
- CMAK 의 consumer Group에 정상적으로 표시되기 위한 데이터를 입출력 한다. 

## 로컬에서 사용 방법
git clone 
tomcat server start 

- application.properties에서 브로커 정보만 변경 하면 됨. 

## Swagger URL 
http://localhost:8080/swagger-ui.index.html

## 사용방법
### Message Produce
```
Method : POST
url : /produce 
Param : { "message" : "test-message"}
memo : POST 방식으로 json으로 메시지를 프로듀싱 할 수 있음
```
```
Method : GET
url : /produce?message=test-message
memo : GET으로 URL에 message 파라미터에 메시지를 프로듀싱 할 수 있음
```
```
* 비표준
Method : GET
url : /produce/{test-message}
memo : GET 방식으로 URL 의 {test-message} 위치에 메시지를 프로듀싱 할 수 있음. 
```

### Message Consume
```
Method : GET
url : /getKafkaDataLast
memo : 해당 토픽에 마지막 데이터를 consume 함. 
```


