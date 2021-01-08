FROM java:8
Expose 8090
ADD /target/reclamation-0.0.1-SNAPSHOT.jar reclamation.jar
ENTRYPOINT ["java","-jar","reclamation.jar"]
