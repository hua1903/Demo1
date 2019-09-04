FROM openjdk:8-jre-slim

# Add the jar with all the dependencies
# Maven creates container-test.jar in the target folder of my workspace.
# We need this in some location - say - /usr/share/tag folder of the container
ADD target/TestDocker-0.0.1-SNAPSHOT.jar /usr/share/TestDocker-0.0.1-SNAPSHOT.jar
ADD testng.xml /usr/share/testng.xml

# Command line to execute the test
ENTRYPOINT ["java", "-cp", "/usr/share/TestDocker-0.0.1-SNAPSHOT.jar","org.testng.TestNG", "/usr/share/testng.xml"]