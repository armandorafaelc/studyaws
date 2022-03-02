# Studyaws
Este projeto visa criar um estudo sobre a AWS e Localstack para execução de tecnologias disponiveis no ambiente da AWS


### Atualmente o projeto conta com as seguintes tecnologias:
- SQS(Producer e Consumer);
- Endpoint ("/test") para envio de mensagens testes para verificação dos serviços;
- Terraform (Subir localstack e criar serviço SQS);

### Configuração inicial

Deverá setar o profile do spring para executar o perfil local:   

```
SPRING_PROFILES_ACTIVE=localstack
```

### Execução de testes

Para executar um teste após o projeto subir, poderá chamar o seguinte endpoint(GET), no seguinte endereço:

```
http://localhost:8080/teste
```

### Serão necessários alguns softwares para configuração do projeto:
-[Docker](https://www.docker.com/)   
-[AWS Cli](https://aws.amazon.com/pt/cli/)   
-[IntelliJ](https://www.jetbrains.com/pt-br/idea/)   
-[LocalStack](https://localstack.cloud/)    
