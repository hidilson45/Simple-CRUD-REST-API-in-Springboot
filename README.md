# Collection Postaman
https://elements.getpostman.com/redirect?entityId=23194361-2000c21b-d775-4b6b-ad79-26332af898f7&entityType=collection

# Dados de conexão com o banco H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# Configuração do cliente web do banco H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Configuração para mostrar o SQL no console
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Configuração do Maven Resources Plugin
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-resources-plugin</artifactId>
	<version>3.1.0</version>
</plugin>

# No terminal exevutar o camando para instalar as dependências necessárias
mvn clean install -U
