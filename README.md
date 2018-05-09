# msg-swagger
=======

Swagger for MSG API 

###  Project Setup
- clone repo 
- import dependencies on POM.xml 
  mvn clean install or just use IntelliJ or eclipse to download dependencies

### Custom annotations 
  Filter a method to be on given Environment 
  
     @Environment(environments = {"SIT", "UAT", "PROD"}) 
   

   hide field from an endpoint
   
    @OperationHidden(operations = {"deleteValuation"})
   
   
   Known issue: 
   You have to create seperate model if you want to use same model
   for different endpoint with the same field name with different data type
    
### Deployment 
   navigate to tomcat under > conf > Catalina > localhost
   add "swagger.xml" 
   
       <Context docBase="/path/to/swagger/" path="/">
       </Context>
       
   access on browser :
   
       {yourhost}/swagger/dist/index.html

### Server Deployment
    to your local swagger repo
    # create war file in your local repo REASON: maven is not install in deployment server
    - $mvn clean install
    # upload war file to deployment server (where we create package)
    - $scp -P2023 /projects/msg/msg-swagger/target/msg-swagger-0.0.1-SNAPSHOT.war  msg@128.199.189.228:msg-swagger
    - proceed to deployment