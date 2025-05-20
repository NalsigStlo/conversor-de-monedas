import java.util.ArrayList;

public class Menu {
    // Usar arraylist para determinar el menu secundario con el cual pedir la conversion.
    public static final ArrayList<String> monedas = new ArrayList<>() {
        {
            add("Peso argentino (ARS)");
            add("Boliviano boliviano (BOB)");
            add("Real brasileño (BRL)");
            add("Peso chileno (CLP)");
            add("Peso colombiano (COP)");
            add("Dólar estadounidense (USD)");
        }
    };

    public static void mostrarMenu() {
        System.out.println("""
                *********************************************
                    Bienvenido/a al conversor de Monedas
                
                ¿Qué moneda desea convertir?
                
                1. Peso argentino (ARS)
                2. Boliviano boliviano (BOB)
                3. Real brasileño (BRL)
                4. Peso chileno (CLP)
                5. Peso colombiano (COP)
                6. Dólar estadounidense (USD)
                7. Salir
                
                Elija una de las opciones entregadas:
                *********************************************
                """);
    }

    public static void mostrarMenuSecundario(String monedaPrincipal){
        ArrayList shallowCopy = (ArrayList) monedas.clone();

        shallowCopy.remove(Integer.parseInt(monedaPrincipal) - 1);

        System.out.println("""
            *********************************************
                ¿A qué moneda desea convertir?
            """);

        for (int i = 0; i < 5; i++) {
            System.out.printf(String.valueOf(i + 1) + ". %s \n", shallowCopy.get(i));
        }

        System.out.println("""
            
            Elija una de las opciones entregadas:
            *********************************************
            """);
    }
}
