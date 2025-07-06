public class ReglasNegocio {

    public static boolean esClienteVipElegible(String tipoCliente, int score, boolean tieneDeudas, double ingresos, int antiguedadProducto) {
        return tipoCliente.equals("VIP")
            && score > 690
            && !tieneDeudas
            && ingresos >= 4200
            && antiguedadProducto >= 2;
    }

    public static boolean esClientePremiumElegible(String tipoCliente, int edad, boolean historial, int score, boolean tieneDeudas, double ingresos, double monto, String pais) {
        return tipoCliente.equals("Premium")
            && edad > 28
            && edad < 65
            && historial
            && score >= 700
            && !tieneDeudas
            && ingresos >= 3900
            && monto <= ingresos * 10
            && (pais.equals("Colombia") || pais.equals("México"));
    }

    public static boolean esClientePublicoConGarantias(boolean garantias, boolean esPublico, double ingresos, int experiencia, boolean tieneDeudas, int score, int antiguedadProducto) {
        return garantias
            && esPublico
            && ingresos >= 2500
            && experiencia >= 3
            && !tieneDeudas
            && score >= 660
            && antiguedadProducto >= 1;
    }

    public static boolean esClienteDigitalTop(boolean esDigital, boolean historial, int score, double ingresos, int antiguedadProducto, boolean tieneDeudas, boolean tieneInversiones) {
        return esDigital
            && historial
            && score >= 720
            && ingresos >= 5000
            && antiguedadProducto >= 1
            && !tieneDeudas
            && tieneInversiones;
    }

    public static boolean esClienteEducadoConPerfil(String nivelEdu, double ingresos, int edad, int score, int antiguedadProducto) {
        return nivelEdu.equals("Postgrado")
            && ingresos > 4500
            && edad < 60
            && score > 680
            && antiguedadProducto >= 2;
    }

    public static boolean requiereRevisionPorScoreYIngresos(int score, double ingresos, boolean tieneDeudas) {
        return score >= 620
            && ingresos >= 2000
            && !tieneDeudas;
    }

    public static boolean requiereRevisionPorJuventud(String tipoCliente, int edad, boolean historial, double monto, double ingresos) {
        return tipoCliente.equals("Nuevo")
            && edad < 30
            && historial
            && monto <= ingresos * 4;
    }

    public static boolean requiereRevisionPublicoGarantias(boolean esPublico, int experiencia, boolean garantias, int score) {
        return esPublico
            && experiencia >= 1
            && garantias
            && score >= 600;
    }

    public static boolean requiereRevisionDigital(boolean esDigital, boolean tieneInversiones, int score, int antiguedadProducto, boolean tieneDeudas) {
        return esDigital
            && !tieneInversiones
            && score >= 680
            && antiguedadProducto >= 0
            && !tieneDeudas;
    }
}
