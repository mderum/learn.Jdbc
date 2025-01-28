Docker commands 
# docker run --name give name of container(any) -e (set environment variable) MYSQL_ROOT_PASSWORD password will be saved in this variable
# -d run in background 
# -p on which port to run 
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=pass -d -p 3306:3306 mysql




#access the DB and create table 
# exec -> execute a command inside the container given
# keep the stream open and allow to interact 
#mysql -uroot -p  command line for mysql cli
docker exec -it mysql-container mysql -uroot -p



CREATE TABLE project (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    url VARCHAR(200) NOT NULL
);



application properties 
#driver which we will be using for connection 
# not used as  spring auto detects the driver version spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#url ->  jdbc:DB_NAME://DB_SERVER_LOCATION:PORT/DB_NAME
spring.datasource.url=jdbc:mysql://localhost:8080/test
spring.datasource.username=root
spring.datasource.password=root



to get started  ( mysql DB )

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>



# this connector will be specific to the  database type 
<dependency>     
    <groupId>mysql</groupId>     
    <artifactId>mysql-connector-java</artifactId>     
  <scope>runtime</scope> 
</dependency>
