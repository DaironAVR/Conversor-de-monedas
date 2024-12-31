public record Divisas (String monedaBase, String monedaAConvertir, double conversion_rate) {
    public double getTasaDeConversion() {
        return conversion_rate;
    }
}
