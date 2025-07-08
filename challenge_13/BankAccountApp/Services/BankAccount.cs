using BankAccountApp.Models;

namespace BankAccountApp.Services;

public class BankAccount
{
    private decimal _balance = 0;
    private readonly List<Transaction> _history = new();

    public decimal GetBalance() => _balance;

    public void Deposit(decimal amount)
    {
        if (amount <= 0)
            throw new ArgumentException("El monto del depósito debe ser mayor que cero.");

        _balance += amount;
        _history.Add(new Transaction("Depósito", amount));
    }

    public void Withdraw(decimal amount)
    {
        if (amount <= 0)
            throw new ArgumentException("El monto del retiro debe ser mayor que cero.");

        if (amount > _balance)
            throw new InvalidOperationException("Fondos insuficientes para realizar el retiro.");

        _balance -= amount;
        _history.Add(new Transaction("Retiro", -amount));
    }

    public List<Transaction> GetHistory() => _history;
}
