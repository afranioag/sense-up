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
* admin/v1/** nesse ponto foi colocado tudo que diz respeito
à administradores. Como criar, editar, deletar e buscar usuários como também 
adicionar roles a estes.

* api/v1/** nesse ponto os usuários logados e que não tem nenhuma role adicionada a eles,
poderão simplismente usar os endpoints com verbo GET. Já usuários logados e com alguma role atribuída podem
adicionar e buscar dados como: devices, streams, data-streams.

A api usa ambientes separados para fins de testes, desenvolvimento e produção.
Ao clonar a api e usa-la localmente, deve ser observado que no arquivo application.properties 
tem uma propriedade spring.profiles.active=${APP_PROFILE:colocarAquiOAmbiente} onde temos:
* {test} - para fins de testes usando o banco-h2
* {dev} - voltado para homologação usando uma base de dados real
* {prod} - para produção. Seu ambiente deve está testado e homologado

## Arquivo import.sql

Esse arquivo está no src/main/resource/ e nele contém scripts sql para popular o banco em memoria H2
com finalidade de uso exclusimante para testes. Não alterar os dados para não causar incosistências nos TESTES Junit.


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

A api está implantada atualmente no HEROKU podendo ser acessada por: 
* https://implant-test.herokuapp.com/

# Docker
Existe uma imagem disponivel no docker-hub
Para uso seguir os passos abaixo:
-- Baixar a imagem para seu ambiente docker
* docker pull afranio653/minisense:v1

-- Criar o container
*  docker run -p 80:8080 --name {seu_valor} -e APP_PROFILE={seu_valor} -e DB_URL={seu_valor} -e DB_USERNAME={seu_valor} -e DB_PASSWORD={seu_valor} afranio653/minisense:v1
* Onde tem {seu_valor} são valores que você deve informar. Para -e você ir em variáveis de ambiente acima e verificar o que cada uma é.

* OBS se vc optar por rodar no ambiente de test, rodar apenas:
* docker run -p 80:8080 --name myapp5 -e APP_PROFILE=teste afranio653/minisense:v1
*
* URI BASE PARA ACESSAR A API NÂO IMPORTA O AMBIENTE ESCOLHIDO: http://localhost:80/


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
