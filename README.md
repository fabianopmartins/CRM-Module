# COAD

Seguem abaixo as instruções para configuração do ambiente e inicialização do módulo desenvolvido para o teste.

Em anexo está o script de criação e inserção do banco de dados(MYSQL).

Tecnologias e Ferramentas utilizadas no desenvolvimento do módulo - Ferramentas: Java(versão JDk1.8), Spring Tool Suite-4(versão 4.4.0), MYSQL Server(versão 8.0), MySQL Workbench(versão 8.0 CE) - Tecnologias: Java, Spring Boot, Thymeleaf, Bootstrap, HTML5, CSS3, JavaScript, Jquery, Ajax , MYSQL, Maven.

Ferramentas necessárias para a configuração do ambiente:

- Java (versão JDK1.8)
- Spring Tool Suite 4 (versão 4.4.0)
- MYSQL Server (versão 8.0)
- É necessária a criação de um usuário coad e uma senha coadcoad para acesso ao banco de dados(MYSQL).

Comando a serem executados via terminal para criação e permissão do usuário e senha ao banco de dados(MYSQL):

- CREATE USER 'novousuario'@'coad' IDENTIFIED BY 'coadcoad';
- GRANT ALL PRIVILEGES ON * . * TO 'coad'@'localhost';
- FLUSH PRIVILEGES;

Foi criado um script de criação e inserção do banco de dados COAD.

Após todo a ambiente configurado, rodar a aplicação clicando com o botão direito na classe CoadApplication.java que está no pacote(com.app.coad), link inicial do módulo (http://localhost:8080/inicio).
