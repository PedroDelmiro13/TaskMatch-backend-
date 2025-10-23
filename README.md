# 🧩 TaskMatch

**TaskMatch** é uma plataforma full stack que conecta **clientes a prestadores de serviço**, facilitando o agendamento, pagamento e comunicação em um único lugar.  
O objetivo é simplificar o processo de contratação de serviços, proporcionando segurança e eficiência para ambos os lados.

---

## 🚀 Tecnologias Utilizadas

### Dependências
- **Java 21 + Spring Boot**
- **Spring Data MongoDB**
- **Spring Validation**
- **Spring Security + JWT**
- **Spring DevTools**
- **Lombok**
- **BCrypt** 
- **Docker** 
- **Maven** 

### Estrutura de pastas
- **src/main/java/com/taskmatch/taskmatch/**
- │
- **├── Controller/ → Endpoints REST**
- **├── DTO/ → Objetos de transferência de dados**
- **├── Enum/ → Constantes e status da aplicação**
- **├── Exception/ → Tratamento de erros e exceções personalizadas**
- **├── Model/ → Entidades persistidas no MongoDB**
- **├── Repository/ → Interfaces de acesso ao banco**
- **├── Service/ → Regras de negócio e lógica de aplicação**
- **└── TaskmatchApplication.java → Classe principal**

## 🧩 Modelagem das Entidades

A aplicação utiliza o **MongoDB** como banco de dados NoSQL, adotando uma modelagem orientada a documentos, onde cada entidade representa uma coleção independente.  
Os relacionamentos são definidos de forma **referencial**, através de **IDs** armazenados entre os documentos.

---

### 🧑‍💼 User
Representa um usuário da plataforma, podendo ser **cliente** ou **prestador de serviços**.

**Campos principais:**
- `userId`
- `name`
- `cpf`
- `email`
- `phone`
- `password`  
- `role` — perfil do usuário (`CLIENT`, `PROVIDER`, `ADMIN`)  
- `createdAt`
- `updatedAt`
- `deletedAt` 

**Relacionamentos:**
- Um `User` pode criar várias **Tasks** (se for prestador).  
- Um `User` pode realizar vários **Appointments** e **Payments**.  
- Um `User` pode participar de vários **Chats** e enviar várias **Messages**.

---

### 📋 Task
Define um serviço oferecido por um prestador.

**Campos principais:**
- `taskId`
- `title`
- `description`
- `price`
- `category`  
- `providerId` → referência ao **User** prestador  
- `availableSlots` — horários disponíveis  
- `isActive` — status de disponibilidade  

**Relacionamentos:**
- Uma **Task** pertence a um único **User (provider)**.  
- Pode ser associada a vários **Appointments**.  
- Está vinculada a **Payments** correspondentes aos agendamentos realizados.

---

### 📅 Appointment
Representa um **agendamento** entre um cliente e um prestador para execução de uma **Task**.

**Campos principais:**
- `appointmentId`
- `scheduling`
- `status`
- `rating`
- `review`  
- `userId` → cliente  
- `serviceId` → referência à **Task**  
- `createdAt`
- `updatedAt`
- `deletedAt`  

**Relacionamentos:**
- Relaciona **User (cliente)** e **Task (prestador)**.  
- Pode gerar um **Payment**.  
- Pode originar **Chat** e **Message** entre as partes envolvidas.

---

### 💬 Chat
Canal de comunicação entre usuários envolvidos em uma negociação ou serviço.

**Campos principais:**
- `chatId`
- `userId`
- `createdAt`

**Relacionamentos:**
- Um **Chat** pertence a um ou mais **Users**.  
- Contém várias **Messages**.

---

### 📨 Message
Mensagem trocada dentro de um **Chat**.

**Campos principais:**
- `messageId`
- `chatId`
- `userId`
- `content`
- `createdAt`
- `updatedAt`
- `isDeleted`

**Relacionamentos:**
- Cada **Message** pertence a um único **Chat**.  
- Está associada ao **User** que a enviou.

---

### 💰 Payment
Controla transações financeiras entre cliente e prestador.

**Campos principais:**
- `paymentId`
- `method`
- `status`
- `value`
- `transactionId`  
- `userId` → cliente pagante  
- `serviceId` → referência à **Task**  
- `requestedRefundAt`
- `refundedAt`
- `cancelReason`  

**Relacionamentos:**
- Um **Payment** está vinculado a um **User (cliente)** e uma **Task (prestador)**.  
- Pode estar associado a um **Appointment** específico.

---

### 🔗 Resumo dos Relacionamentos

| Entidade | Relacionamentos |
|-----------|----------------|
| **User** | 1:N → Task, Appointment, Payment, Chat, Message |
| **Task** | 1:N → Appointment, Payment |
| **Appointment** | N:1 → User, Task |
| **Payment** | N:1 → User, Task |
| **Chat** | 1:N → Message |
| **Message** | N:1 → Chat, User |
