# mini-sense

## Descrição

API desenvolvida como desafio para sense-up.

Um produto na área de Internet das Coisas (IoT) e Sensoreamento Remoto está sendo
desenvolvido. Trata-se de um serviço para gerenciar o estado de dispositivos IoT
instalados pelos clientes e alertar, através de um aplicativo, sobre situações ou
emergências condicionadas aos objetos, mercadorias, ou locais monitorados por esses
sensores.

## Arquitetura
A Api foi dividida em duas partes.
* admin/v1/** nesse ponto foram colocados tudo que diz respeito
a administradores. Como criar, editar, deletar e buscar usuários como também 
adicionar regras a estes.

* api/v1/** nesse ponto os usuários logados e que não tem nenhuma regra adicionadas a eles
poderão simplismente usar os endpoints com verbo GET. Já usuários logados e com alguma role aatribuída podem
adicionar devices, streams, data-streams.

A api usa ambientes separados para fins de testes, deselvomento e produção.
Ao clocar a api e usa-localmente deve ser observado que no arquivo application.properties 
tem uma propriedade spring.profiles.active=${APP_PROFILE:ambiente} onde temos:
* {test} - para fins de testes usando o banco-h2
* {dev} - voltado para homologação usando uma base de dados real
* {prod} - para produção. Seu ambiente deve está testado e homologado

## Arquivo import.sql

Esse arquivo está no src/main/resource/ e nele contém scripts sql para popular o banco em memoria H2
com finalidade de uso exclusimante para testes. Não alterar os dados para não causar incosistencias nos TESTES Junit.



## Roles
* ROLE_ADMIN tem total controle do sistema
* ROLE_OPERATOR tem acesso e permissão total apenas na api/v1/** para todos os verbos HTTP


## API (endpoints)

A descrição detalhada da API pode ser encontrada em https://implant-test.herokuapp.com/swagger-ui.html#/measurement-unit-controller/findAllUsingGET

## Arquitetura

Projeto criado com spring e java 11.
* spring-web
* spring-security
* spring-jpa
* postgreSQL
* maven
* H2
* entre outras ferramentas

## Deploy

A api está implantada atualmente no HEROKU

## Variáveis de ambiente
* APP_PROFILE - ambiente onde seu app irá rodar. Setado como default 'test'
* DB_URL - URL da base de dados.
* DB_PASSWORD - password da base de dados.
* DB_USERNAME - nome do usuário da base de dados
* CLIENT_ID - id da sua aplicação.
* CLIENT_SECRET - password da aplicação

## Collection postman
Importar no seu postman
* https://www.getpostman.com/collections/686eb0f369eb4d5bd434

Baixar colletion json
* https://github.com/afranioag/arquivos/blob/main/collections-postman/Desafio_SenseUP.postman_collection.json