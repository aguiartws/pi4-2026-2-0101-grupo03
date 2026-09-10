# Projeto Acadêmico

Estrutura simples usando HTML/CSS/JS no front-end e um servidor Java com Socket no back-end, tudo rodando via Docker.

## Estrutura de pastas

```
projeto-academico/
├── docker-compose.yml
├── frontend/
│   ├── index.html
│   ├── css/
│   │   └── style.css
│   └── js/
│       └── main.js
└── server/
    ├── Dockerfile
    └── src/
        └── Server.java
```

## Como rodar

Com Docker e Docker Compose instalados, na raiz do projeto:

```bash
docker compose up --build
```

- Front-end disponível em: http://localhost:8080
- Servidor Java (Socket) escutando na porta: 12345

Para parar:

```bash
docker compose down
```

## Observação importante sobre o Socket

O `Server.java` usa `ServerSocket` puro (TCP), que é o que normalmente se pede em disciplinas de redes/sistemas distribuídos. Só um detalhe pra não travar o grupo depois: **navegador não conversa direto com socket TCP puro** — JS no browser só fala HTTP ou WebSocket. Então, por enquanto, o `main.js` só demonstra a ideia; se o requisito exigir que o front converse com o servidor Java em tempo real, o caminho mais simples é trocar `ServerSocket` por um `WebSocket` no Java (mesma ideia, poucas mudanças), ou colocar uma pequena API HTTP na frente. Se quiser, eu já deixo isso pronto também, é só pedir.

## Divisão sugerida de trabalho

- **frontend/**: quem for mexer em HTML/CSS/JS
- **server/**: quem for mexer no Java
- **docker-compose.yml**: mexe só quem for ajustar portas/serviços
