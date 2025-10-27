$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/Cenário01_PracticeForm.feature");
formatter.feature({
  "name": "Valida Form - Practice Form",
  "description": "  Como um usuário de testes\n  Eu desejo interagir com a aplição Web DemoQa\n  Para criar Form - Practice Form",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Scenario01"
    }
  ]
});
formatter.scenario({
  "name": "Preenchimento, Upload e validacao do Pop up",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Scenario01"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "o usuario está na páginada DemoQa",
  "keyword": "Given "
});
formatter.match({
  "location": "PracticeFormSteps.o_usuario_está_na_páginada_DemoQa()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "ele navega para Forms e clica em Practice Form",
  "keyword": "When "
});
formatter.match({
  "location": "PracticeFormSteps.eleNavegaParaFormsEClicaEmPracticeForm()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "preenche o formulário de registro com dados aleatórios e faz o upload do arquivo",
  "keyword": "And "
});
formatter.match({
  "location": "PracticeFormSteps.preencheOFormulárioDeRegistroComDadosAleatóriosEFazOUploadDoArquivo()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "submete o formulário",
  "keyword": "And "
});
formatter.match({
  "location": "PracticeFormSteps.submeteOFormulário()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "um popup de sucesso com o título \"Thanks for submitting the form\" deve ser exibido",
  "keyword": "Then "
});
formatter.match({
  "location": "PracticeFormSteps.umPopupDeSucessoComOTítuloDeveSerExibido(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "ele fecha o popup com sucesso",
  "keyword": "And "
});
formatter.match({
  "location": "PracticeFormSteps.eleFechaOPopupComSucesso()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});