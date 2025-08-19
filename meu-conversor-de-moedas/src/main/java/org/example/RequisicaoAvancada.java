package org.example;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class RequisicaoAvancada {
    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/SUA_CHAVE/latest/USD"))
                    .timeout(Duration.ofSeconds(10))           // Tempo máximo de espera
                    .header("Accept", "application/json")      // Cabeçalho que indica que esperamos JSON
                    .GET()                                      // Método GET
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}