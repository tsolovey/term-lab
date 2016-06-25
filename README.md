# term-lab

The application is to demonstrate MVC usage.
 
This is a single page application. The page displays a list of medical terms. When a user clicks on one of the terms, the popup window appears inside the current page. 
The popup window contains a list of links to external resources about a term. A user may click on these reference links to view information about a medical term in a new window.

Technologies used: 
  - Spring Boot with embedded Tomcat
  - Spring MVC
  - jQuery

The application architecture is MVC based. 
  View: terms.jsp
  Controllers: TermsController.java, TermInfoController.java
  Model: Term.java, Fault.java, ExternalReference.java 

To run the application execute the following command from the root directory

java -jar target\HMS-lab-1.0-SNAPSHOT.war --spring.config.location=file:config\application.properties

You can also run the application using

mvn clean install spring-boot:run

The application URL: http://localhost:8080
