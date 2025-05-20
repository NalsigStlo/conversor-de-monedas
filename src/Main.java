import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import records.CoinValue;
import records.ConversionRates;

import Modelos.ConexionApi;
import Modelos.Rates;

public class Main {
    public static void main(String[] args) {
        Scanner inputUsuario = new Scanner(System.in);
        ConexionApi api = new ConexionApi();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        while(true){
            Menu.mostrarMenu();
            String monedaPrincipal = inputUsuario.nextLine();

            if (monedaPrincipal.equalsIgnoreCase("7")) {
                break;
            }

            Menu.mostrarMenuSecundario(monedaPrincipal);
            String monedaSecundaria = inputUsuario.nextLine();

            String response = api.apiResponse(monedaPrincipal);
            ConversionRates rates = gson.fromJson(response, ConversionRates.class);

            if (rates.result().equalsIgnoreCase("error")) {
                System.out.println("Ocurrió un error al obtener los datos de la API, vuelva a intentar");
                break;
            }

            String valueToJson = Rates.ratesToJson(gson, rates);
            CoinValue coins = gson.fromJson(valueToJson, CoinValue.class);
            Rates miRates = new Rates(coins);

            System.out.println("Ingrese el monto que quiere convertir");
            float monto = Float.parseFloat(inputUsuario.nextLine());

            if (Integer.parseInt(monedaSecundaria) < Integer.parseInt(monedaPrincipal)){
                miRates.calculateConversion((Integer.parseInt(monedaPrincipal) - 1), (Integer.parseInt(monedaSecundaria) - 1), monto);
            } else {
                miRates.calculateConversion((Integer.parseInt(monedaPrincipal) - 1), Integer.parseInt(monedaSecundaria), monto);
            }
        }
    }
}