import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private Scanner teclado = new Scanner(System.in);

    public int imprimirMenu() {
        int opcion = -1;
        while(true) {
            System.out.println("""
                    
                    *** CONVERSOR DE MONEDA *** 
                    *** Menu de Opciones    ***
                    
                    1. Dolar Estadounidense a Peso Colombiano
                    2. Peso Colombiano a Dolar Estadounidesnse
                    3. Peso Colombiano a Euro
                    4. Euro a Peso Colombiano 
                    5. Pesos Colombianos a Real Brasileño
                    6. Real Brasileño a Pesos Colombianos
                    7. Peso Colombiano a peso mexicano
                    8. peso mexicano a Pesos Colombiano                                 
                    
                    9. Salir
                    
                    Opción:""");

            try{
                opcion = teclado.nextInt();
                if (opcion >= 1 && opcion <= 9){
                    break;
                }else {
                    System.out.println("Solo elige opciones entre 1 y 7.");
                }
            } catch(InputMismatchException e) {
                System.out.println("Entrada inavalida. Solo se aceptan valores numericos entre 1 y 7.");
                teclado.next();
            }
        }
        return opcion;
    }

    public String[] obtenerMonedas(int opcion){
        String monedaBase = "";
        String monedaAConvertir = "";

        switch(opcion){

            case 1: monedaBase = "USD"; monedaAConvertir = "COP"; break;
            case 2: monedaBase = "COP"; monedaAConvertir = "USD"; break;
            case 3: monedaBase = "COP"; monedaAConvertir = "EUR"; break;
            case 4: monedaBase = "EUR"; monedaAConvertir = "COP"; break;
            case 5: monedaBase = "COP"; monedaAConvertir = "BRL"; break;
            case 6: monedaBase = "BRL"; monedaAConvertir = "COP"; break;
            case 7: monedaBase = "COP"; monedaAConvertir = "MXN"; break;
            case 8: monedaBase = "MXN"; monedaAConvertir = "COP"; break;
            case 9:
                System.out.println("Programa terminado");
                System.exit(0); break;
            default: System.out.println("Opción no permitida.");
        }
        return new String[]{monedaBase, monedaAConvertir};
    }
}