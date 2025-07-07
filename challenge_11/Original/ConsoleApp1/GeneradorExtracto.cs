using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

public class GeneradorExtracto
{
    public string Generar(List<Movimiento> movimientos, decimal saldoAnterior)
    {
        var sb = new StringBuilder();
        sb.AppendLine("=== Extracto Mensual ===");
        sb.AppendLine($"Saldo anterior: {saldoAnterior:C}");

        decimal saldoActual = saldoAnterior;

        foreach (var mov in movimientos.OrderBy(m => m.Fecha))
        {
            saldoActual += mov.Monto;
            sb.AppendLine($"{mov.Fecha:dd/MM/yyyy} | {mov.Descripcion} | {mov.Monto:C} | Saldo: {saldoActual:C}");
        }

        sb.AppendLine($"Saldo final: {saldoActual:C}");
        return sb.ToString();
    }
}
