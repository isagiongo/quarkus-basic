### Project Quarkus Basic

##### You can start your environment by just running "docker-compose up"
Prometheus contains a "quarkus-basic" job which is using "{ip_app}:8080" to identify your Quarkus application on local host computer (localhost:8080) outside docker.
The com.isagiongo.services are set to be accessible via: postgres:54320, jaeger:16686, prometheus:9090, grafana:3000 e keycloak:8180

This project was based in tutorial https://www.youtube.com/playlist?list=PLZzPRVfe8BbE6pVSv_9OMQPuoeQ71ZSMH