import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputUsuario = new Scanner(System.in);

        System.out.println(" Ingrese la moneda que desee verificar: ");

        String codigoMoneda = inputUsuario.nextLine();

        ConexionApi api = new ConexionApi(codigoMoneda);

        HttpClient cliente = HttpClient.newHttpClient();
        URI direccionApi = URI.create("https://v6.exchangerate-api.com/v6/63de5af194132dbe47c83375/latest/" + api.getCodigoMoneda());

        HttpRequest request = HttpRequest.newBuilder().uri(direccionApi).build();

    }
}