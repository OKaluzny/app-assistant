## app-assistant

This is a simple logistic application demonstrating some capabilities of Spring Boot as backend service capabilities include:
* Microservices architecture;
* Database migration and schema change management using Liquibase;
* etc.

## How it works:
**1. Docker. First you need to install docker**
* Download Docker [Here](https://docs.docker.com/docker-for-windows/install/). Hint: Enable Hyper-V feature on windows and restart;
* Then open powershell and check:
```bash
docker info
```
or, and you see versions docker & docker compose
```bash
docker -v
```
```bash
docker-compose -v
```

**2. Spring boot app**
* Clone the repository:
```bash
git clone https://github.com/OKaluzny/microservice-assistant.git
```
* Build the maven project:
```bash
mvn clean install
```
* Now run:
```bash
docker-compose up
```

Appendix A.

All commands should be run from project root (where docker-compose.yml locates)
