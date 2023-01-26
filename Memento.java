import java.util.ArrayList;
import java.util.List;

// Originator class
class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public Memento save() {
        return new Memento(balance);
    }

    public void restore(Memento m) {
        this.balance = m.getBalance();
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public int getBalance() {
        return balance;
    }
}

// Memento class
class Memento {
    private final int balance;

    public Memento(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
}

// Caretaker class
class BankAccountCaretaker {
    private List<Memento> mementos = new ArrayList<>();

    public void addMemento(Memento m) {
        mementos.add(m);
    }

    public Memento getMemento(int index) {
        return mementos.get(index);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccountCaretaker caretaker = new BankAccountCaretaker();
        BankAccount account = new BankAccount(1000);

        // deposit money
        account.deposit(500);
        caretaker.addMemento(account.save()); // save state before withdrawal

        // withdraw money
        account.withdraw(200);
        caretaker.addMemento(account.save()); // save state before withdrawal

        // undo last withdrawal
        account.restore(caretaker.getMemento(1));
        System.out.println("Current balance: " + account.getBalance()); // 700
    }
}
