package com.exchangerate;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CurrencyConverter {
    private static final String API_KEY = "2b959fde8f3237bedc0681e7"; // Insira sua chave da API aqui
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public double convert(String fromCurrency, String toCurrency, double amount) throws Exception {
        String response = HttpClient.get(API_URL + fromCurrency);
        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();


        if (!jsonObject.has("conversion_rates")) {
            throw new RuntimeException("Erro ao obter taxas de câmbio.");
        }

        double rate = jsonObject.getAsJsonObject("conversion_rates").get(toCurrency).getAsDouble();
        return amount * rate;
    }
}
