# msg-swagger

Swagger for MSG API 

## Project Setup
- clone repo 
- import dependencies on POM.xml 
  mvn clean install or just use IntelliJ or eclipse to download dependencies

## Custom annotations 
   @Environment(environments = {"SIT", "UAT", "PROD"}) 
   Filter a method to be on given Environment 
   
   @OperationHidden(operations = {"deleteValuation"})
   private String asicId;
    - asicId is hidden on deleteValuation method



