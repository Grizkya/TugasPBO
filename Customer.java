import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private ArrayList<Account> accounts;

    public Customer(String f, String l) {
        this.firstName = f;
        this.lastName = l;
        this.accounts = new ArrayList<Account>();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    // Menambahkan akun baru ke daftar akun milik customer
    public void addAccount(Account acct) {
        this.accounts.add(acct);
    }

    // Mengambil akun berdasarkan indeks
    public Account getAccount(int index) {
        if (index >= 0 && index < accounts.size()) {
            return accounts.get(index);
        }
        return null;
    }

    // Mendapatkan total jumlah akun milik customer
    public int getNumOfAccounts() {
        return accounts.size();
    }
}