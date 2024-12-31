import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Menu miMenu = new Menu();

        while(true){
            int opcion = miMenu.imprimirMenu();
            String[] monedas = miMenu.obtenerMonedas(opcion);

            if (monedas[0].isEmpty() || monedas[1].isEmpty()) {
                System.out.println("Intentalo de nuevo!");
                continue;
            }
            System.out.println("Ingrese la cantidad de " + monedas[0] + " a convertir:");
            double monto = teclado.nextDouble();

            ConsultarCambioDeMoneda consulta = new ConsultarCambioDeMoneda();
            Conversor miConversor = new Conversor();
            double montoConvertido = miConversor.convertir(monedas[0], monedas[1], consulta, monto);
            String limitacionDecimales = String.format("%.2f", montoConvertido);

            System.out.println("La conversion con la tasa actual es: " + limitacionDecimales + " " + monedas[1]);
        }
    }
}