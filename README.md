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
- [ ] Export the API documentation through [Swagger](https://swagger.io/).
- [ ] Work as a backend API and be availiable for both local and remote access. (Due to monetary constraints, this may not be always availiable)
- [ ] Have a detailed description of the project's infrastructure

### Technical information
We have decided to use the [Java](https://www.java.com) programing language and use [Spring Boot](https://spring.io/projects/spring-boot).





### Todo
### Casos de Uso para a Plataforma de Compra e Venda de Ingressos

O conjunto de casos de uso para a plataforma de compra e venda de ingressos descreve as interações principais que os usuários (compradores, vendedores, e administradores) têm com o sistema. Cada caso de uso detalha um processo específico, fornecendo clareza sobre o funcionamento pretendido da plataforma.

#### 1. Compra de Ingresso
- **Ator Primário:** Comprador
- **Resumo:** O comprador procura eventos, seleciona ingressos e finaliza a compra.
- **Fluxo Principal:**
  1. O comprador acessa a plataforma e navega ou pesquisa eventos.
  2. Seleciona um evento e escolhe um ou mais ingressos disponíveis.
  3. Confirma a seleção e procede para o pagamento.
  4. Insere informações de pagamento e finaliza a compra.
  5. Recebe confirmação da compra por e-mail.

#### 2. Venda de Ingresso
- **Ator Primário:** Vendedor
- **Resumo:** O vendedor lista um ingresso para venda na plataforma.
- **Fluxo Principal:**
  1. O vendedor acessa sua conta e seleciona a opção para vender ingressos.
  2. Insere informações sobre o ingresso, incluindo evento, preço e detalhes do assento.
  3. Submete o ingresso para a plataforma.
  4. Recebe notificação quando o ingresso é vendido.
  5. Recebe o pagamento na sua conta da plataforma (deve ser possível visualizar o saldo na conta).

#### 3. Gerenciamento de Eventos (Administrador)
- **Ator Primário:** Administrador
- **Resumo:** O administrador adiciona, edita ou remove eventos na plataforma.
- **Fluxo Principal:**
  1. O administrador acessa o painel administrativo.
  2. Seleciona a opção para gerenciar eventos.
  3. Adiciona um novo evento ou seleciona um existente para edição ou remoção.
  4. Atualiza as informações do evento conforme necessário.
  5. Salva as alterações, atualizando o catálogo de eventos na plataforma.

#### 4. Autenticação de Ingresso no Evento
- **Ator Primário:** Organizador do Evento
- **Resumo:** O organizador do evento valida ingressos na entrada do evento.
- **Fluxo Principal:**
  1. O organizador usa um dispositivo para escanear o código do ingresso na entrada.
  2. O sistema verifica a autenticidade e o status do ingresso.
  3. O ingresso é marcado como usado, e o portador é admitido no evento.

#### 5. Gestão de Preferências de Notificação
- **Ator Primário:** Usuário (Comprador/Vendedor)
- **Resumo:** Usuários configuram suas preferências de notificação na plataforma.
- **Fluxo Principal:**
  1. O usuário acessa as configurações de conta.
  2. Seleciona preferências de notificação.
  3. Habilita receber notificações por e-mail.
  4. Salva as alterações.

#### 6. Reembolso de Ingresso
- **Ator Primário:** Comprador
- **Resumo:** O comprador solicita reembolso para um ingresso comprado.
- **Fluxo Principal:**
  1. O comprador acessa o histórico de compras na plataforma.
  2. Seleciona o ingresso e solicita reembolso.
  3. O sistema verifica as políticas de reembolso do evento.
  4. Se aplicável, o reembolso é processado e o usuário é notificado.

#### 7. Envio de Avaliação do Vendedor
- **Ator Primário:** Comprador
- **Resumo:** Após a compra de um ingresso, o comprador envia uma avaliação sobre o vendedor.
- **Fluxo Principal:**
  1. Após a conclusão da transação, o comprador é incentivado a avaliar o vendedor.
  2. O comprador acessa a plataforma, encontra a transação no histórico de compras e seleciona a opção para avaliar o vendedor.
  3. Atribui uma nota e escreve um comentário sobre a experiência de compra.
  4. A avaliação é submetida e fica disponível para consulta por outros usuários.

#### 8. Visualização de Avaliações do Vendedor
- **Ator Primário:** Comprador Potencial
- **Resumo:** Compradores potenciais visualizam avaliações e notas de vendedores.
- **Fluxo Principal:**
  1. O comprador potencial acessa o perfil de um vendedor na plataforma.
  2. Visualiza as avaliações e notas dadas por compradores anteriores.
  3. Usa as informações para ajudar na decisão de compra.


### Modelo de Dados

#### Entidades e Atributos

1. **Tenant**
   - **TenantID** (PK): Identificador único do tenant.
   - **Nome**: Nome do tenant.
   - **InformaçõesDeContato**: Informações de contato do tenant.
   - **ConfiguraçõesEspecíficas**: Configurações específicas do tenant, como preferências de pagamento e notificação.

2. **Usuário**
   - **UserID** (PK): Identificador único do usuário.
   - **TenantID** (FK): Identificador do tenant ao qual o usuário pertence.
   - **Nome**: Nome do usuário.
   - **Email**: E-mail do usuário.

3. **Evento**
   - **EventoID** (PK): Identificador único do evento.
   - **TenantID** (FK): Identificador do tenant ao qual o evento pertence.
   - **NomeDoEvento**: Nome do evento.
   - **Tipo**: Tipo do evento (ex: festa, show, teatro).
   - **Localização**: Localização do evento.
   - **DataEHora**: Data e hora do evento.

4. **Ticket**
   - **TicketID** (PK): Identificador único do ticket.
   - **EventoID** (FK): Identificador do evento associado.
   - **TenantID** (FK): Identificador do tenant ao qual o ticket pertence.
   - **PreçoOriginal**: Preço original do ticket.
   - **IDDoVendedor** (FK): Identificador do usuário que é o vendedor do ticket.
   - **CódigoÚnicoDeVerificação**: Código para verificação da autenticidade do ticket.
   - **Status**: Status do ticket (disponível, reservado, vendido).

5. **Transação**
   - **TransaçãoID** (PK): Identificador único da transação.
   - **TenantID** (FK): Identificador do tenant ao qual a transação pertence.
   - **IDDoComprador** (FK): Identificador do usuário que é o comprador do ticket.
   - **IDDoTicket** (FK): Identificador do ticket associado.
   - **PreçoDeVenda**: Preço de venda do ticket.
   - **DataDaTransação**: Data em que a transação foi realizada.
   - **StatusDaTransação**: Status da transação (pendente, concluída, cancelada).

6. **PreferênciasDeNotificação**
   - **PreferênciasID** (PK): Identificador único das preferências de notificação.
   - **UserID** (FK): Identificador do usuário associado.
   - **ReceberEmails**: Indica se o usuário deseja receber e-mails.

#### Relacionamentos

- **Tenant** ↔ **Usuário**: Um-para-muitos.
- **Usuário** ↔ **Ticket** (como vendedor): Um-para-muitos.
- **Usuário** ↔ **Transação** (como comprador): Um-para-muitos.
- **Evento** ↔ **Ticket**: Um-para-muitos.
- **Ticket** ↔ **Transação**: Um-para-um.
- **Usuário** ↔ **PreferênciasDeNotificação**: Um-para-um.