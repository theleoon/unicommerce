## UniCommerce

##### COMO COMPILAR E RODAR A APLICAÇÃO
- Gerar o .jar do projeto com mvn clean package
- Executar o .jar através do console utilizando o comando java -jar -Dspring.profiles.active=prod unicommerce-0.0.1-SNAPSHOT.jar

##### COMO RODAR A APLICAÇÃO
- Faça o download do .jar disponibilizado no Trello pelo instrutor
- Executar o .jar através do console utilizando o comando: java -jar -Dspring.profiles.active=prod unicommerce-api.jar
- Caso queira alterar o profile em uso, altere para prod ou test o argumento no comando utilizado anteriormente.

##### DADOS DE ACESSO A BASE DE DADOS PRÉ CONFIGURADOS
- spring.datasource.url=jdbc:mysql://localhost:3306/unicommerce
- spring.datasource.username=root
- spring.datasource.password=alura123

Caso seja necessário, poderá sobreescrever essas configurações passando os parâmetros via linha de comando.