## This is sample project to learn Spring Boot with Kotlin

## Annotations Used
###  @SpringBootApplication -- Used to identify Application Class
### @SpringBootTest -- Used to Identify Test Class 
### Static -> This Folder/Directory is used to add Static resource in project
### index.html -> Home Page when open localhost:Port_Number in a Web Browser

### @RestController --> Used to identify Class which handles REST Request 
### @RequestMapping --> Used to identify API End point Paths in  REST Request
### ex: @RequestMapping("api/hello") ,  EndPoint: localhost:8080/api/hello

###  @GetMapping("Path") --> Used to identify get Method /Function  , Path is Optional 
### ex: @RequestMapping("api/hello") class name { <br /> @GetMapping() fun hello()=  "Some String" <br />}
### http://localhost:8080/api/hello <br /> Note: You can not have multiple method with same GetMapping <br /> ex:  @RequestMapping("api/hello") class name { <br /> @GetMapping() fun hello()=  "Some String"  <br />  @GetMapping() fun hello2()=  "Another String" <br /> }

### This project will have a  4 layer architecture, <br /> 1.Data Layer (Models and Serialization) <br /> 2.Service Layer (Service and Business Logic) <br /> 3.Data Source (Data Retrieval and Storage) <br /> 4.Web Layer (Controllers and Rest Mappings) 

### @Repository --> Used to Identify the data source class which is used to get data from some where 

### @Service --> Used to Identify a service class 
### @SpringBootTest @AutoConfigureMockMvc for a test Class -> @SpringBootTest helps to provide spring application context <br /> @AutoConfigureMockMvc -> Provides MockMvc automatically when test runs 