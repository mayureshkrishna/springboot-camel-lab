# CUSTOMER COMMENTS Spring Boot REST Service with Camel using Maven


### Pre-requisites

#### 1. Maven

Spring Boot is compatible with Apache Maven 3.2 or above. If you donâ€™t already have Maven installed you can follow the instructions at maven.apache.org.

#### 2. GIT Bash

On Windows, if you don't already have GIT Bash installed, download [GIT Bash here](https://git-scm.com/downloads)


## Clone Code and Run

Clone Code in a working directory using

```
$ https://github.com/mayureshkrishna/spring-boot-camel.git
```

Once you have cloned the code - Lets edit Application.java to add the REST Configuration and Methods:

Rest Configuration

```
			restConfiguration().contextPath("/springbootcamellab/v1").apiContextPath("/api-doc")
            .apiProperty("api.title", "Camel REST API").apiProperty("api.version", "1.0")
			.apiProperty("cors", "true").apiContextRouteId("doc-api").bindingMode(RestBindingMode.json);
```

Rest Methods

```
			rest("/").description("Springboot Camel Lab REST service")
            .produces("application/json")
            .get("/")
			.description("Get Sample Request")
            .outType(SampleResponse.class)
            .route().routeId("sample-get-api")
            .to("direct:sampleGet-route");

			rest("/ping").description("Springboot Camel Lab REST service Ping Resource")
            .get("/").description("Ping Sample Request")
            .description("Ping Request")
            .outType(String.class)
            .route().routeId("sample-ping-api")
            .to("direct:samplePing-route");
```

Route to your Beans

```
			// Resource: Sample
			// Operation: SampleGET
			from("direct:sampleGet-route").routeId("sample-get-route").description("SampleGET-route").to(
					"bean:sampleProcessor?method=getName(${header.firstName},${header.lastName})");

			// Resource: Sample
			// Operation: SamplePING
			from("direct:samplePing-route").routeId("sample-ping-route").description("SamplePing-route")
					.to("bean:sampleProcessor?method=ping");
```

Lets Edit the SampleProcessor Bean to return some response

```
String name = firstName + ' ' + lastName;
		response.setName(name);
```


```
$ mvn clean spring-boot:run
```

Now your service is up and running on localhost:8080. You can run the ping service at [http://localhost:8080/springbootcamellab/v1/ping](http://localhost:8080/springbootcamellab/v1/ping)

Let's run the get method
http://localhost:8080/springbootcamellab/v1/?firstName=Mayuresh&lastName=Krishna(http://localhost:8080/springbootcamellab/v1/?firstName=Mayuresh&lastName=Krishna)

### RESPONSE BODY - JSON

```
[
  {
    "name": "Mayuresh Krishna"
  }
]
```