package org.example;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequisicaoComResposta {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/SUA_CHAVE/latest/USD"))
                    .GET()
                    .build();

            // Envia a requisição e recebe a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Código de status HTTP
            System.out.println("Status da resposta: " + response.statusCode());

            // Cabeçalhos da resposta
            System.out.println("Cabeçalhos: " + response.headers());

            // Corpo da resposta (JSON)
            System.out.println("Corpo da resposta: " + response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}