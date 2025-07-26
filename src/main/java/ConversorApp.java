import com.google.gson.JsonObject;
import java.util.Scanner;


public class ConversorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Para leer datos por teclado

        // Llamamos a la API para obtener los datos
        JsonObject objectRoot = ConversorAPI.obtenerDatosAPI();
        //________________________________________________________
        // Extraemos las tasas de cambio del JSON
        JsonObject conversionRates = objectRoot.getAsJsonObject("conversion_rates");
        double tasaARS = conversionRates.get("ARS").getAsDouble();
        double tasaBRL = conversionRates.get("BRL").getAsDouble();
        double tasaCOP = conversionRates.get("COP").getAsDouble();
        double tasaPEN = conversionRates.get("PEN").getAsDouble();

        //_________________________________________________________
        // Mostrar menú
        Menu.mostrarMenu();

        //_________________________________________________________
        System.out.println("Elija una de las opciones mostradas: ");
        int opcion;
        // Obtener opción del usuario
        do {
            opcion = scanner.nextInt();

            // Validación para que el usuario elija una opción entre 1 y 9
            if (opcion < 1 || opcion > 9) {
                System.out.println("Opción no válida, por favor elija una opción entre 1 y 9: ");
            }
        } while (opcion < 1 || opcion > 9);

        //_________________________________________________________
        // Obtener monto a convertir
        System.out.print("Ingrese el monto a convertir: ");
        double monto = scanner.nextDouble();
        scanner.close();

        //_________________________________________________________
        // Lógica de conversión según la opción seleccionada
        double resultado = 0;
        switch (opcion) {
            case 1:
                resultado = Conversor.convertirMoneda(monto, tasaARS);
                System.out.println("El monto en Peso argentino es: " + resultado);
                break;
            case 2:
                resultado = Conversor.convertirMoneda(monto, 1 / tasaARS);
                System.out.println("El monto en Dólar es: " + resultado);
                break;
            case 3:
                resultado = Conversor.convertirMoneda(monto, tasaBRL);
                System.out.println("El monto en Real brasileño es: " + resultado);
                break;
            case 4:
                resultado = Conversor.convertirMoneda(monto, 1 / tasaBRL);
                System.out.println("El monto en Dólar es: " + resultado);
                break;
            case 5:
                resultado = Conversor.convertirMoneda(monto, tasaCOP);
                System.out.println("El monto en Peso colombiano es: " + resultado);
                break;
            case 6:
                resultado = Conversor.convertirMoneda(monto, 1 / tasaCOP);
                System.out.println("El monto en Dólar es: " + resultado);
                break;
            case 7:
                resultado = Conversor.convertirMoneda(monto, tasaPEN);
                System.out.println("El monto en Sol Peruano es: " + resultado);
                break;
            case 8:
                resultado = Conversor.convertirMoneda(monto, 1 / tasaPEN);
                System.out.println("El monto en Dólar es: " + resultado);
                break;
            case 9:
                System.out.println("¡Hasta luego!");
                break;
            default:
                System.out.println("Opción no válida, elija una opción entre 1 y 7.");
        }
    }
}
