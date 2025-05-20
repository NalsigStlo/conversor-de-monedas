package Modelos;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.internal.LinkedTreeMap;

import records.CoinValue;
import records.ConversionRates;

import java.util.HashMap;
import java.util.Map;

public class Rates {
    private float ars;
    private float bob;
    private float brl;
    private float clp;
    private float cop;
    private float usd;
    private static final String[] keys = {"ARS", "BOB", "BRL", "CLP", "COP", "USD"};

    public Rates(CoinValue rates) {
        this.ars = Float.parseFloat(rates.ars());
        this.bob = Float.parseFloat(rates.bob());
        this.brl = Float.parseFloat(rates.brl());
        this.clp = Float.parseFloat(rates.clp());
        this.cop = Float.parseFloat(rates.cop());
        this.usd = Float.parseFloat(rates.usd());
    }

    public static String ratesToJson(Gson gson, ConversionRates rates){
        LinkedTreeMap<String, JsonElement> reader = rates.conversion_rates();
        Map<String, Float> mapToJson = new HashMap<String, Float>(6);

        for (int i = 0; i < 6; i++) {
            mapToJson.put(keys[i].toLowerCase(), reader.get(keys[i]).getAsFloat());
        }

        return gson.toJson(mapToJson);
    }

    public void sleep(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void calculateConversion(int origen, int destino, float monto){
        String origenMoneda = keys[origen];
        String destinoMoneda = keys[destino];
        String nombreMoneda = "void";

        switch (destino){
            case 0:
                monto *= ars;
                nombreMoneda = " pesos argentinos";
                break;
            case 1:
                monto *= bob;
                nombreMoneda = " boliviano boliviano";
                break;
            case 2:
                monto *= brl;
                nombreMoneda = " real brasileño";
                break;
            case 3:
                monto *= clp;
                nombreMoneda = " peso chileno";
                break;
            case 4:
                monto *= cop;
                nombreMoneda = " peso colombiano";
                break;
            case 5:
                monto *= usd;
                nombreMoneda = " dólar estadounidense";
                break;
            default:
                System.out.println("Hubo un error en la conversion de las monedas");
                return;
        }

        System.out.println("El cambio de " + origenMoneda + " a " + destinoMoneda + " es de: " + String.valueOf(monto) + nombreMoneda);
        sleep();
    }
}
