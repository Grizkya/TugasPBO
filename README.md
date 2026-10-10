# Banking System OOP Exercise

Tugas ini merupakan latihan pemrograman berorientasi objek (OOP) dalam bahasa Java yang mensimulasikan sistem perbankan sederhana. Program ini mengelola data nasabah (`Customer`), rekening bank (`Account`), serta operasi transaksi di tingkat bank (`Bank`). Tugas ini dikembangkan untuk memperkuat pemahaman mengenai relasi antar kelas, enkapsulasi, dan struktur data dinamis menggunakan `ArrayList`.

---

## 📂 Struktur File dan Folder

```text
Tugas-PBO-Banking/
│
├── Account.java        # Mengelola saldo dan transaksi dasar (deposit & withdraw)
├── Customer.java       # Menyimpan informasi nasabah dan daftar rekeningnya
├── Bank.java           # Mengelola daftar nasabah, transaksi global, dan pencatatan
└── BankDemo.java       # Kelas utama (main) untuk menjalankan simulasi pengujian

```

---

## 🏗️ Desain & Relasi Kelas (UML Relationship)

Arsitektur program ini menerapkan konsep **Composition** dan **Association** dalam OOP:

* **`Bank` memiliki banyak `Customer**` (hubungan agregasi/komposisi menggunakan `ArrayList<Customer>`).
* **`Customer` dapat memiliki banyak `Account**` (hubungan komposisi menggunakan `ArrayList<Account>`), memungkinkan satu nasabah mempunyai lebih dari satu rekening bank (misalnya rekening tabungan utama dan rekening investasi).
* **`Account`** berdiri sendiri sebagai entitas privat yang memegang data saldo (`balance`) beserta aturan bisnis validasinya.



---

## 🛠️ Prasyarat & Cara Menjalankan (Prerequisites & Usage)

Pastikan perangkat komputer Anda telah terinstal perangkat lunak berikut sebelum menjalankan program:

* **Java Development Kit (JDK)** versi 8 atau versi terbaru.
* Text editor atau IDE pilihan Anda (seperti **IntelliJ IDEA**, **VS Code**, atau **Eclipse**).

### Langkah-langkah Kompilasi dan Eksekusi via Terminal/CMD:

1. Simpan keempat file kelas (`Account.java`, `Customer.java`, `Bank.java`, dan `BankDemo.java`) ke dalam satu direktori folder yang sama (misalnya `Tugas-PBO-Banking`).
2. Buka terminal atau Command Prompt, lalu arahkan direktori ke folder tersebut:
```bash
cd path/to/Tugas-PBO-Banking

```


3. Kompilasi seluruh berkas kode sumber Java secara bersamaan:
```bash
javac *.java

```


4. Jalankan program utama melalui kelas eksekusi `BankDemo`:
```bash
java BankDemo

```



---

## 💡 Penjelasan Kode & Konsep OOP

### 1. `Account.java`

Kelas ini merepresentasikan rekening bank individu milik seorang nasabah.

* **Atribut:** `balance` (tipe data `double`) yang bersifat privat untuk menjaga keamanan data saldo berjalan.


* **Konstruktor:** Menginisialisasi saldo awal dengan validasi ketat. Jika saldo awal bernilai negatif, program akan mencetak pesan kesalahan dan otomatis menyetel saldo menjadi `0`.


* **Metode Utama:**
* `getBalance()`: Mengembalikan nilai saldo rekening saat ini.


* `deposit(double amt)`: Menambahkan saldo jika nominal transaksi bernilai lebih dari 0 (`> 0`), mengembalikan nilai `true` jika berhasil dan `false` jika gagal.


* `withdraw(double amt)`: Mengurangi saldo apabila nominal penarikan valid (`> 0`) dan saldo di rekening mencukupi (`amt <= balance`).





### 2. `Customer.java`

Kelas ini merepresentasikan nasabah atau pemilik akun di bank.

* **Atribut:** `firstName`, `lastName`, serta `ArrayList<Account> accounts` untuk menampung daftar beberapa rekening yang dapat dimiliki oleh satu nasabah.


* **Konstruktor:** Menginisialisasi nama depan (`firstName`) dan nama belakang (`lastName`) nasabah.


* **Metode Utama:**
* `getFirstName()` & `getLastName()`: Mengakses informasi nama nasabah.


* `addAccount(Account acct)`: Menambahkan objek rekening baru ke dalam koleksi akun nasabah.
* `getAccount(int index)`: Mengambil rekening tertentu berdasarkan indeks posisinya dengan aman.


* `getNumOfAccounts()`: Mengembalikan total jumlah rekening yang aktif dimiliki oleh nasabah tersebut.





### 3. `Bank.java`

Kelas ini merepresentasikan institusi bank secara keseluruhan yang bertugas mengelola koleksi nasabah.

* **Atribut:** `ArrayList<Customer> customers` (daftar nasabah), `numberOfCustomers`, serta variabel `static int totalTransactions` (variabel kelas untuk mencatat akumulasi total transaksi yang sukses terjadi di seluruh bank secara global).
* **Metode Utama:**
* `addCustomer(String f, String l)`: Membuat objek nasabah baru berdasarkan nama depan dan belakang, lalu mendaftarkannya ke dalam daftar nasabah bank.


* `getNumOfCustomers()`: Mengembalikan jumlah total nasabah yang terdaftar pada bank tersebut.


* `getCustomer(int index)`: Mengambil data referensi nasabah berdasarkan indeks tertentu.


* `deposit(...)` & `withdraw(...)`: Memfasilitasi proses transaksi pada rekening spesifik milik nasabah dan secara otomatis menaikkan nilai penghitung `totalTransactions` jika transaksi berhasil dilakukan.



### 4. `BankDemo.java`

Kelas pengujian (`main` method) yang mensimulasikan skenario nyata penggunaan sistem perbankan:

* Menginisialisasi objek bank pertama (`bank1`) dan mendaftarkan nasabah bernama `Ghaitsa Rizky Amalia` beserta pembuatan dua rekening dengan saldo awal berbeda.
* Melakukan serangkaian pengujian transaksi deposit dan penarikan tunai pada masing-masing rekening milik nasabah pertama.
* Melanjutkan simulasi untuk bank dan nasabah kedua (`Jane Doe`) guna menguji independensi objek, skalabilitas `ArrayList`, serta akurasi penghitungan variabel statis `totalTransactions`.

---

## 🚀 Hasil Eksekusi (Output)

Ketika program `BankDemo.java` dikompilasi dan dijalankan, output di terminal akan menampilkan rincian sebagai berikut:

```text
=== CEK DAFTAR AKUN AWAL ===
Jumlah Akun: 2
Akun 1 : Rp 100000
Akun 2 : Rp 250000
-----------------------------------
--- Transaksi Akun 1 ---
Deposit Rp 500000 berhasil pada akun ke-1 milik Ghaitsa Rizky Amalia
Withdraw Rp 150000 berhasil dari akun ke-1 milik Ghaitsa Rizky Amalia
--- Transaksi Akun 2 ---
Deposit Rp 50000 berhasil pada akun ke-2 milik Ghaitsa Rizky Amalia
Withdraw Rp 100000 berhasil dari akun ke-2 milik Ghaitsa Rizky Amalia
-----------------------------------
=== CEK SALDO AKHIR DAN TOTAL TRANSAKSI ===
Saldo Akhir Akun 1: Rp 450000
Saldo Akhir Akun 2: Rp 200000
Total Transaksi Seluruh Akun: 4

----------------------------------------------------------------------

=== CEK DAFTAR AKUN AWAL ===
Jumlah Akun: 2
Akun 1 : Rp 200000
Akun 2 : Rp 150000
-----------------------------------
--- Transaksi Akun 1 ---
Deposit Rp 100000 berhasil pada akun ke-1 milik Jane Doe
Withdraw Rp 50000 berhasil dari akun ke-1 milik Jane Doe
--- Transaksi Akun 2 ---
Deposit Rp 150000 berhasil pada akun ke-2 milik Jane Doe
Withdraw Rp 50000 berhasil dari akun ke-2 milik Jane Doe
-----------------------------------
=== CEK SALDO AKHIR DAN TOTAL TRANSAKSI ===
Saldo Akhir Akun 1: Rp 250000
Saldo Akhir Akun 2: Rp 250000
Total Transaksi Seluruh Akun: 8

```

---

## 👩‍💻 Author

Nama: Ghaitsa Rizky Amalia

NIM: F1D02510052
