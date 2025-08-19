package org.example;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequisicaoAPI {
    public static void main(String[] args) {
        try {
            // Cria o cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Cria a requisição para a API
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/SUA_CHAVE/latest/USD"))
                    .GET()
                    .build();

            // Envia a requisição e pega a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Imprime o corpo da resposta (JSON)
            System.out.println(response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}