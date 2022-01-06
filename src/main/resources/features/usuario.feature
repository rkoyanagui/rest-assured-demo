#language: pt
@usuario
Funcionalidade: Usuário
  Como usuário
  Desejo me cadastrar
  Para depois consultar meu cadastro

  @cadastro @negativo
  Cenário: Cadastrar usuário sem primeiro nome
    * não consigo cadastrar um usuário sem primeiro nome

  @cadastro @negativo
  Cenário: Cadastrar usuário sem sobrenome
    * não consigo cadastrar um usuário sem sobrenome

  @cadastro @negativo
  Cenário: Cadastrar usuário vazio
    * não consigo cadastrar um usuário vazio
