import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarCambioDeMoneda {
    public Divisas buscaTipoMoneda(String monedaBase, String monedaAConvertir) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/e0317b49a6c7ebf44d240e27/pair/" + monedaBase + "/" + monedaAConvertir);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Divisas.class);
        } catch (Exception e) {
            throw new RuntimeException("Moneda no hallada o inexistente!");
        }
    }
}
