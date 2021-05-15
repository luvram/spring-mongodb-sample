# Spring과 MongoDB
이 프로젝트는 Spring과 MongoDB를 사용을 위한 샘플이다.

## Required
- Docker
- Docker Compose

## 프로젝트 실행
```shell script
docker-compose -f docker-compose.yml up -d
gradlew clean build
java -jar build/libs/simple-0.0.1-SNAPSHOT.jar   
```

## Transactional 사용법
Spring-Data-Mongodb는 기본적으로 Transaction을 Disabled 시켜 두었다. 
`@Transactional` 을 사용하기 위해서는 다음과 같이 `TransactionManager`를 직접 설정해주어야 한다.
```java
@Bean
fun transactionManager(dbFactory: MongoDatabaseFactory): MongoTransactionManager {
    return MongoTransactionManager(dbFactory)
}
```
하지만 이렇게만 설정한다면, 다음과 같은 에러를 만날수도 있다.
```text
Transaction numbers are only allowed on a replica set member or mongos
```
`TransactionManager`의 설정과는 별개로 Transaction을 사용하기 위해서는 MongoDB에 Replica set을 설정해야한다.  
이 프로젝트에서는 다음과 같은 설정하여 테스트 하였다.

```yaml
# docker-compose 설정. 
commands: /usr/bin/mongod --replSet rs0
```  
```javascript
// MongoDB 도커 진입하여 설정
docker exec -it mongodb-simple_mongo-db_1 mongo
rs.initiate()
``` 

## 참고자료
- [https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongo.transactions](https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/#mongo.transactions)