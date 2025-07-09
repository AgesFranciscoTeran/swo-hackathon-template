using Xunit;
using BankAccountApp.Services;

namespace BankAccountApp.Tests;

public class BankAccountTests
{
    [Fact]
    public void Deposit_ValidAmount_UpdatesBalance()
    {
        var account = new BankAccount();
        account.Deposit(100);
        Assert.Equal(100, account.GetBalance());
    }

    [Fact]
    public void Deposit_NegativeAmount_ThrowsException()
    {
        var account = new BankAccount();
        Assert.Throws<ArgumentException>(() => account.Deposit(-50));
    }

    [Fact]
    public void Withdraw_ValidAmount_UpdatesBalance()
    {
        var account = new BankAccount();
        account.Deposit(200);
        account.Withdraw(50);
        Assert.Equal(150, account.GetBalance());
    }

    [Fact]
    public void Withdraw_InsufficientFunds_ThrowsException()
    {
        var account = new BankAccount();
        account.Deposit(100);
        Assert.Throws<InvalidOperationException>(() => account.Withdraw(150));
    }

    [Fact]
    public void GetHistory_ReturnsTransactions()
    {
        var account = new BankAccount();
        account.Deposit(100);
        account.Withdraw(50);
        var history = account.GetHistory();

        Assert.Equal(2, history.Count);
        Assert.Equal("Depósito", history[0].Type);
        Assert.Equal("Retiro", history[1].Type);
    }
}
