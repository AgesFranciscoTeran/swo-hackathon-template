public class EvaluadorRiesgoCredito {

    public String evaluarSolicitud(
        double arg01, int arg02, boolean arg03, int arg04, boolean arg05,
        double arg06, String arg07, String arg08, int arg09,
        String arg10, boolean arg11, int arg12, boolean arg13,
        boolean arg14, boolean arg15, boolean arg16
    ) {
        if (!arg11) {
            return "Rechazado";
        }

        if (
            ReglasNegocio.esClienteVipElegible(arg07, arg04, arg05, arg01, arg12) ||
            ReglasNegocio.esClientePremiumElegible(arg07, arg02, arg03, arg04, arg05, arg01, arg06, arg10) ||
            ReglasNegocio.esClientePublicoConGarantias(arg13, arg14, arg01, arg09, arg05, arg04, arg12) ||
            ReglasNegocio.esClienteDigitalTop(arg15, arg03, arg04, arg01, arg12, arg05, arg16) ||
            ReglasNegocio.esClienteEducadoConPerfil(arg08, arg01, arg02, arg04, arg12)
        ) {
            return "Aprobado";
        }

        if (
            ReglasNegocio.requiereRevisionPorScoreYIngresos(arg04, arg01, arg05) ||
            ReglasNegocio.requiereRevisionPorJuventud(arg07, arg02, arg03, arg06, arg01) ||
            ReglasNegocio.requiereRevisionPublicoGarantias(arg14, arg09, arg13, arg04) ||
            ReglasNegocio.requiereRevisionDigital(arg15, arg16, arg04, arg12, arg05)
        ) {
            return "Requiere Revision Manual";
        }

        return "Rechazado";
    }

    public static void main(String[] args) {
        if (args.length != 16) {
            System.out.println("Uso: java EvaluadorRiesgoCredito <ingMes> <edad> <histCred> <scCrd> <deudasAct> <monto> <tCliente> <nivelEdu> <aniosExp> <pais> <cumplePLD> <antigProd> <garantias> <sectorPublico> <clienteOnline> <tieneInversiones>");
            return;
        }
        try {
            double ingMes = Double.parseDouble(args[0]);
            int edad = Integer.parseInt(args[1]);
            boolean histCred = Boolean.parseBoolean(args[2]);
            int scCrd = Integer.parseInt(args[3]);
            boolean deudasAct = Boolean.parseBoolean(args[4]);
            double monto = Double.parseDouble(args[5]);
            String tCliente = args[6];
            String nivelEdu = args[7];
            int aniosExp = Integer.parseInt(args[8]);
            String pais = args[9];
            boolean cumplePLD = Boolean.parseBoolean(args[10]);
            int antigProd = Integer.parseInt(args[11]);
            boolean garantias = Boolean.parseBoolean(args[12]);
            boolean sectorPublico = Boolean.parseBoolean(args[13]);
            boolean clienteOnline = Boolean.parseBoolean(args[14]);
            boolean tieneInversiones = Boolean.parseBoolean(args[15]);

            EvaluadorRiesgoCredito evaluador = new EvaluadorRiesgoCredito();
            String resultado = evaluador.evaluarSolicitud(
                ingMes, edad, histCred, scCrd, deudasAct,
                monto, tCliente, nivelEdu, aniosExp, pais,
                cumplePLD, antigProd, garantias, sectorPublico, clienteOnline, tieneInversiones
            );
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("Error en los parámetros: " + e.getMessage());
        }
    }
}
