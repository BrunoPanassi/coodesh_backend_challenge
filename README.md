
# Título do Projeto

Uma breve descrição sobre o que esse projeto faz e para quem ele é


# Back-End Challenge 20210221

Desafio onde consiste em criar uma Rest API com um CRON para importação de dados da API https://ll.thespacedevs.com/2.0.0/launch/ e um CRUD da mesma. Utilizado Spring Boot, Hibernate e JPA.





## Instalação

Para ter o banco de dados, tenha o Docker instalado e rode
o comando abaixo:

```bash
  sudo docker run -d -p 3306:3306 --name coodesh_mysql 
  -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=coodesh_challenge mysql
```

Após o container criado, com o seu id, rode o comando abaixo:
 ```bash
    sudo docker container start {container-id}
 ```

Com o projeto do Spring Boot em mãos, e todas as dependências
instaladas, execute o arquivo main, 
**CodeeshBackendChallengeApplication**.

Ou possa optar por rodar o comando:
```bash
    mvn spring-boot:run
```
    