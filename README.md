# Automation Pratice - Automação de Testes [ Web ]

Este projeto tem como objetivo automatizar os testes **Web** utilizando Java + Selenium (bonigarcia) + Cucumber + ReportBuilder

## Tecnologias utilizadas

* [Maven](https://maven.apache.org/) - Dependency Management
* [Selenium Webdriver](https://www.seleniumhq.org/projects/webdriver/) - Web Automation Framework
* [Webdriver Manager](https://github.com/bonigarcia/webdrivermanager) - Dependência de gestão de drivers (executores) de browsers
* [RestAssured](http://rest-assured.io/) - Serviços REST em Java
* [Report Builder](https://github.com/rajatthareja/ReportBuilder/) - Cucumber JSON Report
* [Cucumber](https://cucumber.io/) - BDD
* [JUnit](https://junit.org/junit5) - Framework Test para Java

## Versionamento

Nós utilizamos [GIT](https://git-scm.com/) para versionamento.  

## IDE

Utilize o IDE de sua preferência, lembrando que as configurações do Maven devem ser setadas no programa caso não venha configurado.
 * [Configurar variável Maven](http://www.matera.com/blog/post/tutorial-instalacao-apache-maven-configuracao-eclipse)


## Configurando o ambiente

 * Faça o download do JDK/JRE [clicando aqui](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
 * Configure a variável de ambiente  [JAVA_HOME](https://www.devmedia.com.br/preparacao-do-ambiente-para-desenvolvimento-em-java/25188)
 * Configure o Maven [clicando aqui](http://luizricardo.org/2014/06/instalando-configurando-e-usando-o-maven-para-gerenciar-suas-dependencias-e-seus-projetos-java/)
## Entendendo a arquitetura do framework

**Onde executo os testes ?! :**
 
 * Na classe RunTest.java.

Path da classe:
> ../src/test/java/runner/RunTest.java

**Como executo os testes ?! :** 

Editar no `Runner` a tag com a "@" do CT ou da suíte desejada antes de executá-lo, ex :


| **@web**              |            **@all**             | **@< Texto do CT >** |
|                     ---|                          ---| ---|
|  Testes automatizados frontend    |   Todos os testes   | Testes automatizados do CT específico | 

Também é possível executar os testes via linha de comando conforme abaixo:

| Exemplo: |
| :---:   |
| mvn test -Dcucumber.options="--tags @tag_desejada" |

Package com as `.feature` para consulta das tags:
> ../src/main/resources/feature/*

Package com os `Steps` :
> ../src/main/java/steps/*

Package com as `Pages` :
> ../src/main/pages/*

**O que são properties ?! :** 

Properties são arquivos que falicitam na "flexibilidade" de execução do projeto evitando alterações no código fonte:

Exemplo: Alteração da variável URL modificando o ambiente de execução dos testes.

Package com os `.properties` :
> ../src/main/resources/properties/*.properties

**Como escolho o navegador que realizará a execução dos testes**

Abrir o arquivo `web.properties` citado no caminha acima e alterar, campo `navegador` para uma das opções listadas no comentário e salvar o arquivo.

## REPORT

O framework possui um `report` gerado em HTML exibindo todo resumo e detalhe da execução:

Package com o `report` :
>../src/main/report/*.html>

Neste report é possível ver o resumo da execução na aba `OVERVIEW` onde há gráficos informando o resultado dos testes a nível de feature e de cenário.

Para visualização mais detalhada acessar a aba `FEATURES` onde haverá tabelado as funcionalidades e seu resultado. Clicando em uma funcionalida e em um cenário é possível ver a execução de cada step com o print de seu resultado.

Também é possíver ver a execução de uma forma geral na aba `SUMMARY` onde listará todas as execuções e seus status. Clicando em uma linha da coluna `Scenário` é possível ver os steps da execução e seus prints.

Para mais detalhes veja a documentação oficial [clicando aqui.](https://reportbuilderjava.rajatthareja.com/)

## Autor

* **Nicolai Peixoto** - *Email :* - [Nicolai Peixoto](nicolai_nascimento@hotmail.com)

:)
