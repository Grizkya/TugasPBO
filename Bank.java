import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers;
    private int numberOfCustomers;

    // VARIABEL STATIC: Mencatat total transaksi seluruh nasabah di bank
    public static int totalTransactions = 0;

    public Bank() {
        this.customers = new ArrayList<Customer>();
        this.numberOfCustomers = 0;
    }

    public void addCustomer(String f, String l) {
        Customer c = new Customer(f, l);
        customers.add(c);
        numberOfCustomers++;
    }

    public int getNumOfCustomers() {
        return numberOfCustomers;
    }

    public Customer getCustomer(int index) {
        if (index >= 0 && index < customers.size()) {
            return customers.get(index);
        }
        return null;
    }

    // Method deposit untuk rekening spesifik nasabah
    public void deposit(Customer customer, int accountIndex, double amount) {
        Account acc = customer != null ? customer.getAccount(accountIndex) : null;
        if (acc != null) {
            boolean success = acc.deposit(amount);
            if (success) {
                totalTransactions++;
                System.out.println("Deposit Rp " + (int) amount + " berhasil pada akun ke-" + (accountIndex + 1) + " milik " + customer.getFirstName() + " " + customer.getLastName());
            }
        } else {
            System.out.println("[Error] Akun/Rekening tidak ditemukan.");
        }
    }

    // Method withdraw untuk rekening spesifik nasabah
    public void withdraw(Customer customer, int accountIndex, double amount) {
        Account acc = customer != null ? customer.getAccount(accountIndex) : null;
        if (acc != null) {
            boolean success = acc.withdraw(amount);
            if (success) {
                totalTransactions++;
                System.out.println("Withdraw Rp " + (int) amount + " berhasil dari akun ke-" + (accountIndex + 1) + " milik " + customer.getFirstName() + " " + customer.getLastName());
            }
        } else {
            System.out.println("[Error] Akun/Rekening tidak ditemukan.");
        }
    }
}