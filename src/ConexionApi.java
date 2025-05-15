import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class ConexionApi {
    private String codigoMoneda;

    public ConexionApi(String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public String getCodigoMoneda() {
        return codigoMoneda;
    }
}
