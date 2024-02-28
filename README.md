# FilmesList

## Requisitos

- [ ] CRUD Movimentações
- [ ] CRUD Categorias
- [ ] Dashboard
- [ ] Autenticação

## Endpoints

### Categorias

`GET` /filmes

Lista todos os filmes que cadastradas no sistema.

`200` sucesso

---

`GET` /filmes/{id}

Retorna as informações de um filmes com o `id` informado.

**códigos de status**

`200` sucesso
`404` id não encontrado

---
`POST` /filmes

Cadastrar um novo filme.

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|-----------
|Nome|String|✅|Ñovo Nome do Filme
|Foto|String|✅|Nova Capa do Filme
|Descrição|string|❌|Nova Descrição do filme que foi inserido 

**códigos de status**

`201` criado com sucesso
`400` validação falhou

---

`DELETE` /filmes/{id} 

Apaga o filme com o `id` informado.

**códigos de status**

`204` apagado com sucesso
`404` id não encontrado

---

`PUT` /filme/{id} 

Altera o filme com o `id` informado.

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|-----------
|Nome|String|✅|Ñovo Nome do Filme
|Foto|String|✅|Nova Capa do Filme
|Descrição|string|✅|Nova Descrição do filme que foi inserido 

**códigos de status**

`200` sucesso
`404` id não encontrado
`400` validação falhou

---

**Schema**

```js
{
    "id": 1,
    "nome": "The prisioners",
    "url": "https://exemplo.com/imagem1.jpg"
    "Descrição": "Filme de suspense"

}

```