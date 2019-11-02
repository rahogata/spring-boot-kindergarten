### Spring Boot Test Experiments.

This branch is to know about Spring Boot context caching.

#### Results
1. Spring Boot by default caches bean context across test classes. It means there will be only one instance is used for different test classes.
2. If ```@DirtiesContext``` annotation is used thent the Spring Boot refreshes the context, means it creates new instances per test class.
3. In integration tests also same context is used across test classes. It means beans that are autowired in various services are shared across different test classes.

