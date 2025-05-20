package Modelos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ConexionApi {
    private final Map<String, String> monedas = new HashMap<>(6) {
        {
            put("1", "ARS");
            put("2", "BOB");
            put("3", "BRL");
            put("4", "CLP");
            put("5", "COP");
            put("6", "USD");
        }
    };

    public String apiResponse(String codigoMoneda){
        String apiMoneda = monedas.get(codigoMoneda);

        try (HttpClient cliente = HttpClient.newHttpClient()){
            URI direccionApi = URI.create("https://v6.exchangerate-api.com/v6/63de5af194132dbe47c83375/latest/" + apiMoneda);
            HttpRequest request = HttpRequest.newBuilder().uri(direccionApi).build();
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
