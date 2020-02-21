FROM anapsix/alpine-java
COPY /build/libs/awsPractice-0.0.1-SNAPSHOT.jar /build/libs/awsPractice-0.0.1-SNAPSHOT.jar
ENV msgg="HOLLA"
CMD ["java","-jar","/build/libs/awsPractice-0.0.1-SNAPSHOT.jar"]
RUN ["--net", "host"]