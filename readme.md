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