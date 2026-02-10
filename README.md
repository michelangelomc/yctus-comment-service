# yctus-comment-service
serviço de comentários
## 🏗️ Microsserviço 1: CommentService

### 📡 Responsabilidades

- Expor uma API REST para criação e consulta de comentários
- Enviar novos comentários para moderação via POST síncrono (RestClient)
- Armazenar apenas comentários **aprovados**

### 🔌 Endpoints

```http
POST   /api/comments      # Criar novo comentário
GET    /api/comments/{id} # Obter comentário específico
GET    /api/comments      # Listar comentários (paginado)
```

### 🎮 Controller: CommentController

#### `POST /api/comments`
**Cria um novo comentário**

**Entrada (CommentInput):**
```json
{
  "text": "string",
  "author": "string"
}
```

**Respostas:**
- `201 Created` - CommentOutput (se aprovado)
- `422 Unprocessable Entity` - com motivo (se rejeitado)

#### `GET /api/comments/{id}`
**Retorna detalhes de um comentário**

**Respostas:**
- `200 OK` - CommentOutput
- `404 Not Found` - se não existir

#### `GET /api/comments`
**Lista comentários aprovados com paginação**

**Parâmetros:**
- `page` - número da página
- `size` - quantidade por página

**Resposta:**
```json
{
  "page": 0,
  "size": 10,
  "totalElements": 45,
  "totalPages": 5,
  "content": [
    {
      "id": "UUID",
      "text": "string",
      "author": "string",
      "createdAt": "2023-11-15T10:00:00Z"
    }
  ]
}
```

### 📦 DTOs

#### CommentInput
```json
{
  "text": "string",
  "author": "string"
}
```

#### CommentOutput
```json
{
  "id": "UUID",
  "text": "string",
  "author": "string",
  "createdAt": "2023-11-15T10:00:00Z"
}
```

### 🔗 Integração com ModerationService

O CommentService faz uma chamada **POST** para `/api/moderate` do ModerationService.

**Requisição:**
```json
{
  "text": "string",
  "commentId": "UUID"
}
```

**Resposta Esperada:**
```json
{
  "approved": true,
  "reason": "string"
}
```

### ✔️ Regras de Validação

- ⚠️ ID deve ser UUID
- 🚫 Comentários rejeitados **não são armazenados**

### ⚙️ Requisitos Técnicos

- 🗄️ **Banco de dados:** H2
- ⏱️ **Timeout:** 5 segundos para chamadas ao ModerationService
- 🔌 **Cliente HTTP:** RestClient (síncrono)
- 🛡️ **Tratamento de Erros:**
  - Erros gerais na integração → `502 Bad Gateway`
  - Timeout na integração → `504 Gateway Timeout`
  - Comentário não encontrado → `404 Not Found`
