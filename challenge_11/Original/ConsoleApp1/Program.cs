using System;
using System.Collections.Generic;
using System.IO;
using Newtonsoft.Json;

namespace ConsoleApp1 // Si tu namespace es distinto, mantenlo igual
{
    internal class Program
    {
        static void Main(string[] args)
        {
            if (args.Length == 0)
            {
                Console.WriteLine("Debes proporcionar la ruta del archivo JSON como argumento.");
                return;
            }

            string rutaArchivo = args[0];

            if (!File.Exists(rutaArchivo))
            {
                Console.WriteLine("No se encontró el archivo en la ruta proporcionada.");
                return;
            }

            try
            {
                string contenidoJson = File.ReadAllText(rutaArchivo);
                var movimientos = JsonConvert.DeserializeObject<List<Movimiento>>(contenidoJson);

                decimal saldoAnterior = 1000; // Puedes cambiar esto si lo deseas

                var generador = new GeneradorExtracto();
                string resultado = generador.Generar(movimientos, saldoAnterior);

                Console.WriteLine(resultado);
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Error al procesar el archivo: {ex.Message}");
            }
        }

    }
}
