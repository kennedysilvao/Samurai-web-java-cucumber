#language: pt
@setup
Funcionalidade: Testar

  Contexto:
    Dado que acesso a página de login

  @after
  Cenario: Login com usuario correto
    Quando informo o nome do usuário "teste@gmail.com"
    E informo a senha do usuário "pwd123"
    E clico no botão entrar
    Então vejo o usuário logado

  @after
  Esquema do Cenário: Login Incorreto
    Quando informo o nome do usuário com algum erro "<usuario>"
    E informo a senha do usuário com algum erro "<senha>"
    E clico no botão entrar
    Então vejo o resultado esperado "<resultado>"

    Exemplos:
      | usuario         | senha  | resultado            |
      | teste@gmail.com |        | Senha é obrigatória  |
      |                 | pwd123 | E-mail é obrigatório |
