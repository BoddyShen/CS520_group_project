## [Demo](https://www.youtube.com/watch?v=_XTjmvEA4iw&t=1s&ab_channel=BoddyShen)
![Screenshot 2024-07-09 at 11 28 03 PM](https://github.com/BoddyShen/UMassenger/assets/110020304/f1892068-4067-4bbb-acbe-3db401602ccc)

# development

- refer to [wiki](https://github.com/xyw0025/CS520_group_project/wiki) for git flow


### Setting Up and Running the Development Environment

```
cd ./backend
cp src/main/resources/.env.example src/main/resources/.env
# entering the credentials -> @ wen if you dont have them yet

cd ./backend
mvn package -Dmaven.test.skip
# target folder created

java -Dspring.profiles.active=development -jar target/cs520-0.0.1-SNAPSHOT.jar
```

[frontend document](frontend/README.md)

### api-doc
start backend service, then head to: http://localhost:3000/swagger-ui/index.html

# Distributed Backend

[Config Server](https://github.com/BoddyShen/ConfigServer): The configuration is managed by Spring Cloud Config Server, ensuring centralized and dynamic configuration management across our services.<br />
[Cloud Gateway](https://github.com/BoddyShen/CloudGateway): Cloud Gateway acts as the entry point, streamlining access to our microservices through a single interface.<br />
[ms-init-setup](https://github.com/BoddyShen/ms-initial-setup): The initial setup of our microservices environment, including configuration maps, secrets, and Redis integration for caching and session management, is automated with Kubernetes, allowing for efficient deployment on the Google Cloud Platform using Google Kubernetes Engine (GKE). <br />
[Account Service](https://github.com/BoddyShen/AccountService): Manages user accounts, offering comprehensive account management capabilities.<br />
[Match Service](https://github.com/BoddyShen/MatchService): Facilitates user matching, leveraging custom logic to connect users effectively.<br />
[Chat Service](https://github.com/BoddyShen/ChatService): Employs WebSocket technology to offer real-time chat rooms, creating engaging user interactions.<br />


### Kubernetes Service Discovery & Communication 

Our system utilizes **Kubernetes** for service registration and discovery, enabling a dynamic and scalable microservices architecture. Kubernetes simplifies the process of deploying, scaling, and managing containerized applications, and it provides a robust mechanism for services to discover and communicate with each other.

**Service Registration and Discovery with Kubernetes**: Services are automatically registered in Kubernetes' internal DNS upon deployment, allowing them to be discovered and communicated with using simple DNS queries. This native integration eliminates the need for a separate service registry.

**Inter-Service Communication with Feign and Kafka**: For direct service-to-service calls, we leverage cloud.openfeign.FeignClient for its declarative REST client features, making HTTP requests straightforward and type-safe. Feign integrates seamlessly with our microservices, providing a simplified way to consume APIs of registered services.

**Asynchronous Messaging with Kafka**: To further decouple our services and handle event-driven communication, we utilize Kafka. This powerful message broker enables us to efficiently manage real-time data feeds and build reactive systems that are both resilient and scalable.

### Jenkins Integration & GCP Deployment Overview

Our development workflow is significantly enhanced through the integration of Jenkins, a leading open-source automation server, which connects to our microservices repositories. This setup ensures that any push to a repository triggers an automated Continuous Integration/Continuous Deployment (CI/CD) pipeline. Here's how it works:

**Automated Build and Deployment with Jenkins**: Jenkins is configured to monitor our microservices' repositories for changes. Upon detecting a push, it automatically initiates the CI/CD pipeline, starting with code compilation, running tests to ensure code quality and stability, and then proceeding to build Docker images.

**Docker Image Management and GCP Artifact Registry**: The newly built Docker images are then pushed to Google Cloud Platform's Artifact Registry, a secure and integrated container image storage solution. This process ensures that our Docker images are readily available for deployment and versioning is managed effectively.

**Deployment to Google Kubernetes Engine (GKE)**: Once the Docker images are stored in the Artifact Registry, the next step in our pipeline involves deploying these images to Google Kubernetes Engine (GKE). GKE allows us to leverage Kubernetes' powerful orchestration capabilities for managing our containerized applications, ensuring they are deployed, updated, and scaled seamlessly across our cloud infrastructure.


<img width="1080" alt="Screenshot 2024-02-21 at 12 51 09 AM" src="https://github.com/BoddyShen/UMassenger/assets/110020304/dd690229-1036-44e9-b7c0-e9eb62885184">
<img width="1088" alt="Screenshot 2024-02-21 at 12 51 21 AM" src="https://github.com/BoddyShen/UMassenger/assets/110020304/9fae9bef-1ed4-4a56-983f-eee7b46f8674">

