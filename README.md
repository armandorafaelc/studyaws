# Studyaws
Este projeto visa criar um estudo sobre a AWS e Localstack para execução de tecnologias disponiveis no ambiente da AWS


### Atualmente o projeto conta com as seguintes tecnologias:
- SQS(Producer e Consumer);
- SNS(Producer);
- Endpoint ("/test") para envio de mensagens testes para verificação dos serviços;
- Terraform (Subir localstack, criar serviço SQS e SNS, e subscrever o serviço SQS no tópico SNS);

### Configuração inicial

#### Subindo serviço localstack: executar o comando abaixo, na pasta ("infra") e subir o localstack:

```
docker-compose up
```

#### Criar a infra local: executar o comando abaixo, na pasta ("infra/tf") e subir o localstack:

```
terraform  init
terraform apply
```

#### Definir o profile do spring na IDE para executar o perfil local:   

```
SPRING_PROFILES_ACTIVE=localstack
```

### Execução de testes

Para executar um teste após o projeto subir, poderá chamar o seguinte endpoint(GET), no seguinte endereço:

```
http://localhost:8080/teste
```

### Diagrama do projeto

![study](https://user-images.githubusercontent.com/672980/156567408-a5b49be4-5538-43ae-b402-8ded5e2ff3fc.png)

### Serão necessários alguns softwares para configuração do projeto:
-[Docker](https://www.docker.com/)   
-[AWS Cli](https://aws.amazon.com/pt/cli/)   
-[IntelliJ](https://www.jetbrains.com/pt-br/idea/)   
-[LocalStack](https://localstack.cloud/)    
