#language:pt
#enconding:UTF-8
#author: Nicolai Nascimento

@AutomationPratice @web @all
Funcionalidade: Validar funcionalidades do site automationpractice

  @CadastroSucesso
  Cenário: Validar cadastro efetuado com sucesso
    Dado que eu acesse o site
    E clicar em registrar
    Quando eu preencher os campos do cadastro
    Então o cadastro será efetuado com sucesso

  @ValidarLogin
  Esquema do Cenário: : Validar Login com usuário "<validade>"
    Dado que eu acesse o site
    Quando eu preencher os campos de login com usuário "<validade>"
    Então o sistema deve "<resultado_esperado>"

    Exemplos:
    | validade          | resultado_esperado        |
    | válido            | permitir o login          |
    | e-mail inválido   | bloquear o login: e-mail  |
    | senha inválida    | bloquear o login: senha   |

  @ValidarCompra
  Cenário: Validar a compra de um produto
    Dado que eu esteja logado
    Quando eu realizar a compra
    Então a compra é finalizada com sucesso