import java.text.DecimalFormat;

public class Conversor {

    public double convertir(String monedaBase, String monedaAConvertir, ConsultarCambioDeMoneda consulta, double montoBase) {
        Divisas resultado = consulta.buscaTipoMoneda(monedaBase, monedaAConvertir);

        double tasaDeConversion = resultado.getTasaDeConversion();
        double montoEquivalente = montoBase * tasaDeConversion;


        return montoEquivalente;
    }
}