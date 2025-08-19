package org.example;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Scanner;

public class ConversorDeMoedas {

    public static void main(String[] args) {
        // JSON de exemplo (substitua depois pela API real)
        String jsonResponse = "{ \"base_code\": \"USD\", \"conversion_rates\": { \"ARS\": 250.0, \"BOB\": 6.9, \"BRL\": 5.25, \"CLP\": 800.0, \"COP\": 4000.0, \"USD\": 1.0 } }";
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=== Conversor de Moedas ===");
            System.out.println("1 - Converter Moeda");
            System.out.println("2 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    // Recebe dados do usuário
                    System.out.print("Digite a moeda de origem (USD, BRL, etc.): ");
                    String moedaOrigem = scanner.nextLine().toUpperCase();

                    System.out.print("Digite a moeda de destino (USD, BRL, etc.): ");
                    String moedaDestino = scanner.nextLine().toUpperCase();

                    System.out.print("Digite o valor a ser convertido: ");
                    double valor = scanner.nextDouble();

                    // Verifica se as moedas existem
                    if (!rates.has(moedaOrigem) || !rates.has(moedaDestino)) {
                        System.out.println("Moeda inválida!");
                        break;
                    }

                    // Faz a conversão
                    double taxaOrigem = rates.get(moedaOrigem).getAsDouble();
                    double taxaDestino = rates.get(moedaDestino).getAsDouble();
                    double valorConvertido = converter(valor, taxaOrigem, taxaDestino);

                    System.out.printf("%.2f %s = %.2f %s\n", valor, moedaOrigem, valorConvertido, moedaDestino);
                    break;

                case 2:
                    continuar = false;
                    System.out.println("Programa encerrado. Obrigada por usar o conversor!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }

    // Método para conversão entre moedas
    public static double converter(double valor, double taxaOrigem, double taxaDestino) {
        return valor / taxaOrigem * taxaDestino;
    }
}
