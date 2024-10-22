<h1> Cool Tickets </h1>

### Authors

| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/112208993?v=4" width=115><br><sub>Arthur Both</sub>](https://github.com/ArthurBoth) |  [<img loading="lazy" src="https://avatars.githubusercontent.com/u/107195856?v=4" width=115><br><sub>Isabela Araujo</sub>](https://github.com/belakraujo) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/101745159?v=4" width=115><br><sub>Paola Lopes</sub>](https://github.com/ThePaola) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/111612705?v=4" width=115><br><sub>Vitor Jacom</sub>](https://github.com/VitorJacom) |
|---|---|---|---|

This is the README document, here will be showed some informations about the project.

### Introduction
This is an assignment made for our *Software Construction* class.
The goal of this project is to build a simple Backend API to further our understanding of software projects.

#### Specifications
This project should implement all functional requirements of an online platform for selling tickets for events such as parties, concerts and plays. The platform must support users re-selling tickets, secure monetary transfers, ticket authentication, and integration with official systems for ticket validation.

An in-depth explanation of the assignment can be found [here](https://github.com/tecmx/csw242-system-docs?tab=readme-ov-file#documenta%C3%A7%C3%A3o-da-plataforma-de-compra-e-venda-de-ingressos).

### This system aims to
- [X] Export the API documentation through [Swagger](https://swagger.io/).
- [ ] Work as a backend API and be availiable for both local and remote access. (Due to monetary constraints, this may not be always availiable)
- [ ] Have a detailed description of the project's infrastructure

### Running the project locally
#### Requirements
* [Docker](https://www.docker.com/)
* [Java 17](https://www.oracle.com/br/java/technologies/downloads/) or higher
* [Apache Maven](https://maven.apache.org/download.cgi)

#### Step-by-step guide
1. First it is necessary to run the database trough Docker using ```docker compose up```
2. Then, on the root directory, run ```mvw spring-boot:run``` to start the project
3. Lastly, the it can be tested on swagger at localhost:8080/swagger-ui/index.html
