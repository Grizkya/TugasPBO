public class BankDemo {
    public static void main(String[] args) {
        Bank bank1 = new Bank();

        // 1. Tambah customer
        bank1.addCustomer("Ghaitsa", "Rizky Amalia");
        Customer customer1 = bank1.getCustomer(0);

        // 2. Tambah Akun Pertama (Index 0) dan Akun Kedua (Index 1)
        customer1.addAccount(new Account(100000));
        customer1.addAccount(new Account(250000));

        System.out.println("=== CEK DAFTAR AKUN AWAL ===");
        System.out.println("Jumlah Akun: " + customer1.getNumOfAccounts());
        System.out.println("Akun 1 : Rp " + (int) customer1.getAccount(0).getBalance());
        System.out.println("Akun 2 : Rp " + (int) customer1.getAccount(1).getBalance());
        System.out.println("-----------------------------------");

        // === TRANSAKSI PADA AKUN PERTAMA (INDEX 0) ===
        System.out.println("--- Transaksi Akun 1 ---");
        bank1.deposit(customer1, 0, 500000);  // Deposit Rp 500.000
        bank1.withdraw(customer1, 0, 150000); // Withdraw Rp 150.000

        // === TRANSAKSI PADA AKUN KEDUA (INDEX 1) ===
        System.out.println("--- Transaksi Akun 2 ---");
        bank1.deposit(customer1, 1, 50000);   // Deposit Rp 50.000
        bank1.withdraw(customer1, 1, 100000); // Withdraw Rp 100.000

        System.out.println("-----------------------------------");
        System.out.println("=== CEK SALDO AKHIR DAN TOTAL TRANSAKSI ===");
        System.out.println("Saldo Akhir Akun 1: Rp " + (int) customer1.getAccount(0).getBalance());
        System.out.println("Saldo Akhir Akun 2: Rp " + (int) customer1.getAccount(1).getBalance());
        System.out.println("Total Transaksi Seluruh Akun: " + Bank.totalTransactions);

        // Customer kedua
        System.out.println("\n----------------------------------------------------------------------\n");

        Bank bank2 = new Bank();

        // 1. Tambah customer
        bank2.addCustomer("Jane", "Doe");
        Customer customer2 = bank2.getCustomer(0);

        // 2. Tambah Akun Pertama (Index 0) dan Akun Kedua (Index 1)
        customer2.addAccount(new Account(200000));
        customer2.addAccount(new Account(150000));

        System.out.println("=== CEK DAFTAR AKUN AWAL ===");
        System.out.println("Jumlah Akun: " + customer2.getNumOfAccounts());
        System.out.println("Akun 1 : Rp " + (int) customer2.getAccount(0).getBalance());
        System.out.println("Akun 2 : Rp " + (int) customer2.getAccount(1).getBalance());
        System.out.println("-----------------------------------");

        // === TRANSAKSI PADA AKUN PERTAMA (INDEX 0) ===
        System.out.println("--- Transaksi Akun 1 ---");
        bank2.deposit(customer2, 0, 100000);  // Deposit Rp 100.000
        bank2.withdraw(customer2, 0, 50000); // Withdraw Rp 50.000

        // === TRANSAKSI PADA AKUN KEDUA (INDEX 1) ===
        System.out.println("--- Transaksi Akun 2 ---");
        bank2.deposit(customer2, 1, 150000);   // Deposit Rp 150.000
        bank2.withdraw(customer2, 1, 50000); // Withdraw Rp 50.000

        System.out.println("-----------------------------------");
        System.out.println("=== CEK SALDO AKHIR DAN TOTAL TRANSAKSI ===");
        System.out.println("Saldo Akhir Akun 1: Rp " + (int) customer2.getAccount(0).getBalance());
        System.out.println("Saldo Akhir Akun 2: Rp " + (int) customer2.getAccount(1).getBalance());
        System.out.println("Total Transaksi Seluruh Akun: " + Bank.totalTransactions);
    }
}