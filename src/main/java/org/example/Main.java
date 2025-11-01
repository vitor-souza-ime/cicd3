package org.example;

import io.javalin.Javalin;

public class Main {

    public static void main(String[] args) {
        // Inicia servidor Javalin na porta 8080
        Javalin app = Javalin.create().start(8080);

        // Rota principal
        app.get("/", ctx -> ctx.html("<h1>Aplicação de Teste com Javalin</h1>"));

        System.out.println("Servidor rodando em http://localhost:8080");
    }

    // Método vulnerável para SAST
    public String consultaInsegura(String input) {
        return "SELECT * FROM usuarios WHERE nome = '" + input + "'";
    }
}


/*
SAST - Static Application Security Testing:
O SAST é uma análise de segurança que atua diretamente sobre o código fonte ou binários da aplicação,
sem precisar executá-la. Ele permite identificar vulnerabilidades como SQL Injection, Cross-Site Scripting
(XSS), uso indevido de senhas ou dados sensíveis, e outros problemas de segurança antes que a aplicação
esteja rodando. No projeto, o método consultaInsegura(String input) é um exemplo clássico de vulnerabilidade
que o SAST consegue detectar. É uma abordagem preventiva, funcionando como uma inspeção do "projeto" da
aplicação para detectar falhas de design e de lógica que possam causar problemas de segurança.
*/

/*
DAST - Dynamic Application Security Testing:
O DAST é uma análise de segurança que atua sobre a aplicação em execução, ou seja, durante o runtime.
Ele interage com a aplicação através de requisições HTTP/HTTPS, simulando ataques e observando como a
aplicação responde. Permite detectar vulnerabilidades que só aparecem quando a aplicação está rodando,
como endpoints expostos, falhas de autenticação, headers inseguros e problemas de configuração do servidor.
No projeto, o OWASP ZAP realiza o DAST acessando http://localhost:8080, testando a aplicação Javalin em execução.
Enquanto o SAST lê o "projeto da casa", o DAST verifica a casa pronta, descobrindo problemas que só aparecem
quando tudo está ligado.
*/
