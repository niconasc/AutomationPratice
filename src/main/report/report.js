$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/resources/feature/AutomationPratice.feature");
formatter.feature({
  "name": "Validar funcionalidades do site automationpractice",
  "description": "",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "name": "@AutomationPratice"
    },
    {
      "name": "@web"
    },
    {
      "name": "@all"
    }
  ]
});
formatter.scenario({
  "name": "Validar cadastro efetuado com sucesso",
  "description": "",
  "keyword": "Cenário",
  "tags": [
    {
      "name": "@AutomationPratice"
    },
    {
      "name": "@web"
    },
    {
      "name": "@all"
    },
    {
      "name": "@CadastroSucesso"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que eu acesse o site",
  "keyword": "Dado "
});
formatter.match({
  "location": "AutomationPraticeSteps.queEuAcesseSite()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "clicar em registrar",
  "keyword": "E "
});
formatter.match({
  "location": "AutomationPraticeSteps.clicarEmRegistrar()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded1.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "eu preencher os campos do cadastro",
  "keyword": "Quando "
});
formatter.match({
  "location": "AutomationPraticeSteps.euPreencherOsCamposDoCadastro()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded2.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "o cadastro será efetuado com sucesso",
  "keyword": "Então "
});
formatter.match({
  "location": "AutomationPraticeSteps.oCadastroSeraEfetuadoComSucesso()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded3.png");
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": ": Validar Login com usuário \"\u003cvalidade\u003e\"",
  "description": "",
  "keyword": "Esquema do Cenário",
  "tags": [
    {
      "name": "@ValidarLogin"
    }
  ]
});
formatter.step({
  "name": "que eu acesse o site",
  "keyword": "Dado "
});
formatter.step({
  "name": "eu preencher os campos de login com usuário \"\u003cvalidade\u003e\"",
  "keyword": "Quando "
});
formatter.step({
  "name": "o sistema deve \"\u003cresultado_esperado\u003e\"",
  "keyword": "Então "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Exemplos",
  "rows": [
    {
      "cells": [
        "validade",
        "resultado_esperado"
      ]
    },
    {
      "cells": [
        "válido",
        "permitir o login"
      ]
    },
    {
      "cells": [
        "e-mail inválido",
        "bloquear o login: e-mail"
      ]
    },
    {
      "cells": [
        "senha inválida",
        "bloquear o login: senha"
      ]
    }
  ]
});
formatter.scenario({
  "name": ": Validar Login com usuário \"válido\"",
  "description": "",
  "keyword": "Esquema do Cenário",
  "tags": [
    {
      "name": "@AutomationPratice"
    },
    {
      "name": "@web"
    },
    {
      "name": "@all"
    },
    {
      "name": "@ValidarLogin"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que eu acesse o site",
  "keyword": "Dado "
});
formatter.match({
  "location": "AutomationPraticeSteps.queEuAcesseSite()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded4.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "eu preencher os campos de login com usuário \"válido\"",
  "keyword": "Quando "
});
formatter.match({
  "location": "AutomationPraticeSteps.euPreencherOsCamposDeLoginComUsuario(String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded5.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "o sistema deve \"permitir o login\"",
  "keyword": "Então "
});
formatter.match({
  "location": "AutomationPraticeSteps.oSistemaDeve(String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded6.png");
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": ": Validar Login com usuário \"e-mail inválido\"",
  "description": "",
  "keyword": "Esquema do Cenário",
  "tags": [
    {
      "name": "@AutomationPratice"
    },
    {
      "name": "@web"
    },
    {
      "name": "@all"
    },
    {
      "name": "@ValidarLogin"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que eu acesse o site",
  "keyword": "Dado "
});
formatter.match({
  "location": "AutomationPraticeSteps.queEuAcesseSite()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded7.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "eu preencher os campos de login com usuário \"e-mail inválido\"",
  "keyword": "Quando "
});
formatter.match({
  "location": "AutomationPraticeSteps.euPreencherOsCamposDeLoginComUsuario(String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded8.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "o sistema deve \"bloquear o login: e-mail\"",
  "keyword": "Então "
});
formatter.match({
  "location": "AutomationPraticeSteps.oSistemaDeve(String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded9.png");
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": ": Validar Login com usuário \"senha inválida\"",
  "description": "",
  "keyword": "Esquema do Cenário",
  "tags": [
    {
      "name": "@AutomationPratice"
    },
    {
      "name": "@web"
    },
    {
      "name": "@all"
    },
    {
      "name": "@ValidarLogin"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que eu acesse o site",
  "keyword": "Dado "
});
formatter.match({
  "location": "AutomationPraticeSteps.queEuAcesseSite()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded10.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "eu preencher os campos de login com usuário \"senha inválida\"",
  "keyword": "Quando "
});
formatter.match({
  "location": "AutomationPraticeSteps.euPreencherOsCamposDeLoginComUsuario(String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded11.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "o sistema deve \"bloquear o login: senha\"",
  "keyword": "Então "
});
formatter.match({
  "location": "AutomationPraticeSteps.oSistemaDeve(String)"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded12.png");
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.scenario({
  "name": "Validar a compra de um produto",
  "description": "",
  "keyword": "Cenário",
  "tags": [
    {
      "name": "@AutomationPratice"
    },
    {
      "name": "@web"
    },
    {
      "name": "@all"
    },
    {
      "name": "@ValidarCompra"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que eu esteja logado",
  "keyword": "Dado "
});
formatter.match({
  "location": "AutomationPraticeSteps.queEuEstejaLogado()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded13.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "eu realizar a compra",
  "keyword": "Quando "
});
formatter.match({
  "location": "AutomationPraticeSteps.euRealizarACompra()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded14.png");
formatter.afterstep({
  "status": "passed"
});
formatter.step({
  "name": "a compra é finalizada com sucesso",
  "keyword": "Então "
});
formatter.match({
  "location": "AutomationPraticeSteps.aCompraEFinalizadaComSucesso()"
});
formatter.result({
  "status": "passed"
});
formatter.embedding("image/png", "embedded15.png");
formatter.afterstep({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});