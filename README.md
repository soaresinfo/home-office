# Visão Geral do Micro Serviço home-office

Projeto beca java para disseminação de conhecimento.

O domínio principal deste micro serviço consistem em garantir a orquestração do fluxo de home office para um ou mais projetos da empresa Everis;
A arquitetura utiliza um case de tecnologias que permitir a nossa API atender requisitos não funcionais como:

*	Escalabilidade;
*	Performance;
*	Modularidade/Reaproveitamento de código;
*	Automação de entregas em ambientes de alta disponibilidade e distribuídos;
*	Segurança contra ataques virtuais;

A arquitetura possui uma divisão de camadas para redução da quantidade de código nos arquivos implementados. Essa divisão foi criada seguindo o padrão MVC objetivando o baixo acoplamento entre as classe e a alta coesão;

* Significado de Baixo acoplamento: Consiste em classes com poucas dependências com intuito de baixar a complexidade do algoritmo implementado em seu interior, desta forma teremos facilidades na implementação de testes unitários e evoluções futuros;

* Alta Coesão: Uma classe que possui funcionalidades equivalentes ao seu papel dentro da arquitetura;

# URL's/Comandos importantes:

* Comando para contruir o projeto maven: mvn clean install
* Comando para contruir o projeto maven e pular os testes unitários: mvn clean install -DskipTests
* Comando para excutar a aplicação Spring Boot: mvn spring-boot:run
* URL do swagger: http://localhost:8082/home-office/swagger-ui.html
* URL do Console do H2: http://localhost:8082/home-office/h2-console


# Camadas da Arquitetura:

*	Controller: Camada responsável pela exposição de serviços Rest;
*	Service-Fachada: Camada responsável pelo isolamento dos métodos que serão consumidos pelos Controllers;
*	Service: Camada de regras de negócio que implementas os métodos das fachadas;
*	Repository: Interface responsável pelos métodos de acesso a dados: findAll, findOne, findById, etc;

