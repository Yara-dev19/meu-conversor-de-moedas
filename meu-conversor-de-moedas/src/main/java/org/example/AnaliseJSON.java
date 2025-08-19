package org.example;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class AnaliseJSON {
    public static void main(String[] args) {
        String jsonResponse = "{ \"base_code\": \"USD\", \"conversion_rates\": { \"BRL\": 5.25, \"EUR\": 0.93 } }";

        // Parseando a resposta JSON
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

        // Acessando propriedades
        String base = jsonObject.get("base_code").getAsString();
        JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");
        double brlRate = rates.get("BRL").getAsDouble();
        double eurRate = rates.get("EUR").getAsDouble();

        // Imprimindo os resultados
        System.out.println("Moeda base: " + base);
        System.out.println("Cotação BRL: " + brlRate);
        System.out.println("Cotação EUR: " + eurRate);
    }
    
}
