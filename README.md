# Documentação das Classes

## Classe `Usuario`

Representa um usuário do sistema.

**Atributos:**
- `nome` (String): Nome do usuário.
- `email` (String): Endereço de e-mail do usuário.
- `senha` (String): Senha do usuário.

## Classe `Time`

Representa um time de jogadores.

**Atributos:**
- `vitorias` (int): Número de vitórias do time.
- `derrotas` (int): Número de derrotas do time.
- `imagem` (String): URL da imagem do time.
- `nome` (String): Nome do time.

## Classe `Partida`

Representa uma partida entre times.

**Atributos:**
- `times` (array de Time): Times participantes da partida.
- `data_partida` (LocalDateTime): Data e hora da partida.
- `nome_campeonato` (Campeonato): Campeonato ao qual a partida pertence.

## Classe `Campeonato`

Representa um campeonato com várias partidas.

**Atributos:**
- `nome_campeonato` (String): Nome do campeonato.
- `proximas_partidas` (array de Partida): Próximas partidas no campeonato.

---

### Exemplos de Requisições HTTP

Aqui estão exemplos de como interagir com a API usando os métodos HTTP (GET, POST, PUT, DELETE):

---
## Endpoint **Campeonato**


#### `GET /campeonatos`

Lista todos os campeonatos.

**Exemplo de retorno:**
```json
[
    {
        "nome_campeonato": "CBLOL",
        "proximas_partidas": [
            {
                "times": [
                    { 
                        "vitorias": 12,
                        "derrotas": 6,
                        "imagem":  "https://img.png.com",
                        "nome": "Loud"
                    },
                    { 
                        "vitorias": 14,
                        "derrotas": 4,
                        "imagem":  "https://img.png.com",
                        "nome": "Pain"
                    }
                ],
                "data_partida": "Mon Aug 21 2023 21:21:56"
            }
        ]
    }
]
```


#### `POST /campeonato`

Cadastra um campeonato.

**Exemplo do body da requisição:**
```json
{
  "nome_campeonato": "LCK",
  "proximas_partidas": []
}
```

#### `UPDATE /campeonato/{id}`

Atualiza um campeonato.

**Exemplo do body da requisição:**
```json
{
  "nome_campeonato": "LCK",
  "proximas_partidas": [1, 2]
}

```

#### `DELETE /campeonato/{id}`

Deleta um campeonato.

---

---
## Endpoint **Time**


#### `GET /times`

Lista todos os times.

**Exemplo de retorno:**
```json
[
    {
        "vitorias": 12,
        "derrotas": 6,
        "imagem": "https://img.png.com",
        "nome": "Loud"
    },
    {
        "vitorias": 14,
        "derrotas": 4,
        "imagem": "https://img.png.com",
        "nome": "Pain"
    }
]
```


#### `POST /time`

Cadastra um time.

**Exemplo do body da requisição:**
```json
{
  "vitorias": 4,
  "derrotas": 5,
  "imagem": "https://img.png.com",
  "nome": "Pain"
}
```

#### `UPDATE /time/{id}`

Atualiza um time.

**Exemplo do body da requisição:**
```json
{
	"vitorias": 6,
	"derrotas": 5,
	"imagem": "https://img.png.com",
	"nome": "PAIN"
}
```

#### `DELETE /time/{id}`

Deleta um time.

---

---
## Endpoint **Partida**


#### `GET /partidas`

Lista todas as partidas.

**Exemplo de retorno:**
```json
[
    {
        "times": [
            { 
                "vitorias": 12,
                "derrotas": 6,
                "imagem":  "https://img.png.com",
                "nome": "Loud"
            },
            { 
                "vitorias": 14,
                "derrotas": 4,
                "imagem":  "https://img.png.com",
                "nome": "Pain"
            }
        ],
    "data_partida": "Mon Aug 21 2023 21:21:56",
    "nome_campeonato": "CBLOL"
        
    }
]
```


#### `POST /Partida`

Cadastra uma partida.

**Exemplo do body da requisição:**
```json
{
  "times": [2, 3],
  "id_campeonato": 1,
  "data_partida": "2023-09-30T14:30:00"
}

```

#### `UPDATE /partida/{id}`

Atualiza uma partida.

**Exemplo do body da requisição:**
```json
{
  "times": [1, 8],
  "id_campeonato": 1,
  "data_partida": "2023-09-20T12:00:00"
}
```

#### `DELETE /partida/{id}`

Deleta uma partida.

---

## Endpoint **Usuario**


#### `GET /usuarios`

Lista todos os usuários.

**Exemplo de retorno:**
```json
[
    {
        "nome": "João",
        "email": "joao@example.com",
        "senha": "********"
    },
    {
        "nome": "Maria",
        "email": "maria@example.com",
        "senha": "******"
    }
]
```


#### `POST /usuario`

Cadastra um novo usuário.

**Exemplo do body da requisição:**
```json
{ 
    "nome": "Pedro",
    "email": "pedro@example.com",
    "senha": "********"
}
```

#### `UPDATE /usuario/{id}`

Atualiza um usuário.

**Exemplo do body da requisição:**
```json
{ 
    "nome": "Pedro",
    "email": "pedro2@example.com",
    "senha": "********"
}
```

#### `DELETE /usuario/{id}`

Deleta um usuário.

---

## Possíveis status code das requisições

| Código | Descrição
|-|-
| 200 | Requisição bem-sucedida
| 201 | Cadastrado com sucesso
| 204 | A requisição foi bem-sucedida, mas não há conteúdo para retornar.
| 400 | Os campos enviados são inválidos
| 404 | Página não encontrada
| 405 | Método não permitido
| 500 | Erro interno do servidor