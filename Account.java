public class Account {
    private double balance;

    public Account(double initBalance) {
        if (initBalance < 0) {
            System.out.println("[Error] Saldo awal tidak boleh negatif. Diset ke 0.");
            this.balance = 0;
        } else {
            this.balance = initBalance;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public boolean deposit(double amt) {
        if (amt <= 0) {
            System.out.println("[Gagal Deposit] Nominal harus lebih dari 0.");
            return false;
        }
        this.balance += amt;
        return true;
    }

    public boolean withdraw(double amt) {
        if (amt <= 0) {
            System.out.println("[Gagal Withdraw] Nominal penarikan harus lebih dari 0.");
            return false;
        }
        if (amt > this.balance) {
            System.out.println("[Gagal Withdraw] Saldo tidak cukup! (Penarikan: Rp " + (int) amt + ")");
            return false;
        }
        this.balance -= amt;
        return true;
    }
}