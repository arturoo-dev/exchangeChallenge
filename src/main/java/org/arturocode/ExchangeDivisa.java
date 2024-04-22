package org.arturocode;

import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class ExchangeDivisa {
    public Currency searchDivisa(String base_code, String target_code, double amount) {

        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");
        URI url = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + base_code + "/" + target_code + "/" + amount);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(url)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Currency.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro la divisa.");
        }
    }
}