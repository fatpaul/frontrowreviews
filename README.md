## Movie Review Application

This is a coding Kata to teach hexagonal architectures.


To build, run

    mvn package

Integration Tests:

    mvn integration-test

To deploy:

    mvn integration-test appengine:update
    
This will try and deploy to my app engine id called "developersdump" change to yours in the appengine-web.xml file under WEB-INF