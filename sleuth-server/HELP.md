# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.mtb.cloud.sleuth-server' is invalid and this project uses 'com.mtb.cloud.sleuthserver' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)


####################Spring Cloud Sleuth Server details
Spring Cloud Sleuth provides Spring Boot auto-configuration for distributed tracing.

Features
Sleuth configures everything you need to get started. This includes where trace data (spans) are reported to, how many traces to keep (sampling), if remote fields (baggage) are sent, and which libraries are traced.

Specifically, Spring Cloud Sleuth…​

Adds trace and span ids to the Slf4J MDC, so you can extract all the logs from a given trace or span in a log aggregator.

Instruments common ingress and egress points from Spring applications (servlet filter, rest template, scheduled actions, message channels, feign client).

If spring-cloud-sleuth-zipkin is available then the app will generate and report Zipkin-compatible traces via HTTP. By default it sends them to a Zipkin collector service on localhost (port 9411). Configure the location of the service using spring.zipkin.baseUrl.
