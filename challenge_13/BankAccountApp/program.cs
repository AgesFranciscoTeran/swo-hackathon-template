using BankAccountApp.Models;
using BankAccountApp.Services;

Console.WriteLine("=== Bienvenido al Gestor de Cuenta Bancaria ===");
var account = new BankAccount();

while (true)
{
    Console.WriteLine("\n1. Consultar saldo");
    Console.WriteLine("2. Realizar depósito");
    Console.WriteLine("3. Realizar retiro");
    Console.WriteLine("4. Ver historial");
    Console.WriteLine("5. Salir");

    Console.Write("Opción: ");
    var option = Console.ReadLine();

    try
    {
        switch (option)
        {
            case "1":
                Console.WriteLine($"Saldo actual: {account.GetBalance():C}");
                break;

            case "2":
                Console.Write("Monto a depositar: ");
                decimal deposit = Convert.ToDecimal(Console.ReadLine());
                account.Deposit(deposit);
                Console.WriteLine("Depósito exitoso.");
                break;

            case "3":
                Console.Write("Monto a retirar: ");
                decimal withdrawal = Convert.ToDecimal(Console.ReadLine());
                account.Withdraw(withdrawal);
                Console.WriteLine("Retiro exitoso.");
                break;

            case "4":
                var history = account.GetHistory();
                if (!history.Any())
                {
                    Console.WriteLine("Sin transacciones registradas.");
                }
                else
                {
                    foreach (var tx in history)
                        Console.WriteLine($"{tx.Date:g} - {tx.Type} - {tx.Amount:C}");
                }
                break;

            case "5":
                Console.WriteLine("Gracias por usar el gestor bancario. Hasta pronto.");
                return;

            default:
                Console.WriteLine("Opción inválida. Intente de nuevo.");
                break;
        }
    }
    catch (Exception ex)
    {
        Console.WriteLine($"⚠️ Error: {ex.Message}");
    }
}
