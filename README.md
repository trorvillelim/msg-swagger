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
    

