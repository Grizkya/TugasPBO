# Banking System – Latihan OOP Java

Latihan pemrograman berorientasi objek (OOP) dalam bahasa Java yang mensimulasikan sistem perbankan sederhana. Program mengelola data nasabah (`Customer`), rekening bank (`Account`), dan operasi transaksi di tingkat bank (`Bank`).

Tujuan latihan ini adalah memperkuat pemahaman tentang relasi antarkelas, enkapsulasi, dan struktur data dinamis menggunakan `ArrayList`.

---

## 📂 Struktur File

```plaintext
Tugas-PBO-Banking/
├── Account.java    # Saldo dan transaksi dasar (deposit & withdraw)
├── Customer.java   # Informasi nasabah dan daftar rekeningnya
├── Bank.java       # Daftar nasabah, transaksi global, dan pencatatan
└── BankDemo.java   # Kelas utama (main) untuk simulasi pengujian
```

---

## 🏗️ Desain dan Relasi Kelas

Arsitektur program menerapkan konsep **Composition** dan **Association**:

```plaintext
Bank  ──(1..*)──▶  Customer  ──(0..*)──▶  Account
```

- **`Bank`** memiliki banyak `Customer` (menggunakan `ArrayList<Customer>`).
- **`Customer`** dapat memiliki banyak `Account` (menggunakan `ArrayList<Account>`), sehingga satu nasabah bisa memiliki lebih dari satu rekening, misalnya tabungan utama dan rekening investasi.
- **`Account`** menyimpan data saldo (`balance`) secara privat beserta aturan validasinya.

| Kelas | Atribut | Metode Utama |
|---|---|---|
| `Account` | `balance` | `getBalance()`, `deposit()`, `withdraw()` |
| `Customer` | `firstName`, `lastName`, `accounts` | `getFirstName()`, `getLastName()`, `addAccount()`, `getAccount()`, `getNumOfAccounts()` |
| `Bank` | `customers`, `numberOfCustomers`, `totalTransactions` (static) | `addCustomer()`, `getNumOfCustomers()`, `getCustomer()`, `deposit()`, `withdraw()` |

---

## 🛠️ Prasyarat

- Java Development Kit (JDK) 8 atau lebih baru
- Text editor atau IDE (IntelliJ IDEA, VS Code, Eclipse, dll.)

## ▶️ Cara Menjalankan

1. Simpan keempat file (`Account.java`, `Customer.java`, `Bank.java`, `BankDemo.java`) dalam satu folder, misalnya `Tugas-PBO-Banking`.

2. Buka terminal/CMD dan masuk ke folder tersebut:
```bash
   cd path/to/Tugas-PBO-Banking
```

3. Kompilasi semua file sekaligus:
```bash
   javac *.java
```

4. Jalankan program:
```bash
   java BankDemo
```

---

## 💡 Penjelasan Kode dan Konsep OOP

### 1. `Account.java`
Merepresentasikan rekening bank individu milik seorang nasabah.

- **Atribut:** `balance` (`double`), bersifat `private` untuk menjaga keamanan data saldo.
- **Konstruktor:** menginisialisasi saldo awal dengan validasi. Jika saldo awal negatif, program mencetak pesan kesalahan dan menyetel saldo menjadi `0`.
- **Metode:**
  - `getBalance()`: mengembalikan saldo saat ini.
  - `deposit(double amt)`: menambah saldo jika `amt > 0`; mengembalikan `true` jika berhasil dan `false` jika gagal.
  - `withdraw(double amt)`: mengurangi saldo jika `amt > 0` dan saldo mencukupi (`amt <= balance`).

### 2. `Customer.java`
Merepresentasikan nasabah atau pemilik rekening di bank.

- **Atribut:** `firstName`, `lastName`, dan `ArrayList<Account> accounts` untuk menampung beberapa rekening milik satu nasabah.
- **Konstruktor:** menginisialisasi nama depan dan nama belakang.
- **Metode:**
  - `getFirstName()` dan `getLastName()`: mengakses nama nasabah.
  - `addAccount(Account acct)`: menambahkan rekening baru ke daftar rekening nasabah.
  - `getAccount(int index)`: mengambil rekening berdasarkan indeks.
  - `getNumOfAccounts()`: mengembalikan jumlah rekening yang dimiliki nasabah.

### 3. `Bank.java`
Merepresentasikan institusi bank yang mengelola koleksi nasabah.

- **Atribut:**
  - `ArrayList<Customer> customers`: daftar nasabah.
  - `numberOfCustomers`: jumlah nasabah terdaftar.
  - `static int totalTransactions`: variabel kelas yang mencatat total transaksi sukses di seluruh bank secara global.
- **Metode:**
  - `addCustomer(String f, String l)`: membuat nasabah baru dari nama depan dan belakang, lalu mendaftarkannya ke bank.
  - `getNumOfCustomers()`: mengembalikan jumlah nasabah terdaftar.
  - `getCustomer(int index)`: mengambil nasabah berdasarkan indeks.
  - `deposit(...)` dan `withdraw(...)`: memproses transaksi pada rekening tertentu dan menaikkan `totalTransactions` jika transaksi berhasil.

### 4. `BankDemo.java`
Kelas pengujian (`main`) yang mensimulasikan skenario penggunaan sistem perbankan:

- Membuat bank pertama (`bank1`), mendaftarkan nasabah `Ghaitsa Rizky Amalia`, dan membuat dua rekening dengan saldo awal berbeda.
- Menjalankan serangkaian deposit dan penarikan pada rekening nasabah pertama.
- Melanjutkan simulasi dengan bank dan nasabah kedua (`Jane Doe`) untuk menguji independensi objek, skalabilitas `ArrayList`, dan akurasi variabel statis `totalTransactions`.

---

## 🚀 Hasil Eksekusi

Saat `BankDemo` dikompilasi dan dijalankan, terminal menampilkan output berikut:

<img width="1428" height="812" alt="Hasil eksekusi BankDemo" src="https://github.com/user-attachments/assets/0c100644-c5c3-4647-99c7-114d3165549d" />

---

## 👩‍💻 Author

| | |
|---|---|
| **Nama** | Ghaitsa Rizky Amalia |
| **NIM** | F1D02510052 |
