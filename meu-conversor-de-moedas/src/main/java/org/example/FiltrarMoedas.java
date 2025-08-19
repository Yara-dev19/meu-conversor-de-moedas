package org.example;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class FiltrarMoedas {
    public static void main(String[] args) {
        String jsonResponse = "{ \"base_code\": \"USD\", \"conversion_rates\": { \"ARS\": 250.0, \"BOB\": 6.9, \"BRL\": 5.25, \"CLP\": 800.0, \"COP\": 4000.0, \"USD\": 1.0 } }";

        // Parseando o JSON
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");

        // Moedas que queremos filtrar
        String[] moedasFiltradas = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};

        System.out.println("Cotações selecionadas:");
        for (String codigo : moedasFiltradas) {
            if (rates.has(codigo)) {
                double valor = rates.get(codigo).getAsDouble();
                System.out.println(codigo + ": " + valor);
            }
        }
    }
}