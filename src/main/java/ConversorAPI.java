import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversorAPI {

    public static JsonObject obtenerDatosAPI() {
        try {
            String apiKey = "c244fdb3c2f69fdba891913d";  // Usa tu clave de API aquí
            String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";  // Endpoint para tasas de cambio

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Convertir la respuesta JSON en objeto
            JsonElement elemento = JsonParser.parseString(response.body());
            JsonObject objectRoot = elemento.getAsJsonObject();
            return objectRoot; // Retorna la respuesta completa de la API
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocurrió un error al obtener los datos: " + e.getMessage());
        }
        return null;  // Retorna null si ocurre un error
    }
}
