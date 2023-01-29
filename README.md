#Evision Website Server
##실행 전 확인

- Mysql이 켜져있는지, evision 데이터베이스가 생성 및 실행되어 있는지 확인하기
```sql
create database if not exists evision;
use evision;
```
- application-security.properties를 해당하는 위치에 생성하기
```text
# Website-Server/src/main/resources/application-security.properties

spring.jpa.properties.hibernate.format_sql=true
spring.datasource.url=jdbc:mysql://localhost:3306/evision
spring.datasource.username={mysql 실행시 사용한 username}
spring.datasource.password={mysql 실행시 사용한 password}
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```