@Scenario01
Feature: Valida Form - Practice Form

  Como um usuário de testes
  Eu desejo interagir com a aplição Web DemoQa
  Para criar Form - Practice Form

  Scenario: Preenchimento, Upload e validacao do Pop up

    Given o usuario está na páginada DemoQa
    When  ele navega para Forms e clica em Practice Form
    And  preenche o formulário de registro com dados aleatórios e faz o upload do arquivo
    And  submete o formulário
    Then um popup de sucesso com o título "Thanks for submitting the form" deve ser exibido
    And ele fecha o popup com sucesso
