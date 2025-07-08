public class EvaluadorRiesgoCredito {

    public String evaluarSolicitud(
        double ingMes, int edad, boolean histCred, int scCrd, boolean deudasAct,
        double monto, String tCliente, String nivelEdu, int aniosExp,
        String pais, boolean cumplePLD, int antigProd, boolean garantias,
        boolean sectorPublico, boolean clienteOnline, boolean tieneInversiones
    ) {
        if (!cumplePLD) {
            return "Rechazado";
        }

        if (
            ReglasNegocio.esClienteVipElegible(tCliente, scCrd, deudasAct, ingMes, antigProd) ||
            ReglasNegocio.esClientePremiumElegible(tCliente, edad, histCred, scCrd, deudasAct, ingMes, monto, pais) ||
            ReglasNegocio.esClientePublicoConGarantias(garantias, sectorPublico, ingMes, aniosExp, deudasAct, scCrd, antigProd) ||
            ReglasNegocio.esClienteDigitalTop(clienteOnline, histCred, scCrd, ingMes, antigProd, deudasAct, tieneInversiones) ||
            ReglasNegocio.esClienteEducadoConPerfil(nivelEdu, ingMes, edad, scCrd, antigProd)
        ) {
            return "Aprobado";
        }

        if (
            ReglasNegocio.requiereRevisionPorScoreYIngresos(scCrd, ingMes, deudasAct) ||
            ReglasNegocio.requiereRevisionPorJuventud(tCliente, edad, histCred, monto, ingMes) ||
            ReglasNegocio.requiereRevisionPublicoGarantias(sectorPublico, aniosExp, garantias, scCrd) ||
            ReglasNegocio.requiereRevisionDigital(clienteOnline, tieneInversiones, scCrd, antigProd, deudasAct)
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
