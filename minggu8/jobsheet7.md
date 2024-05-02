## <center> LAPORAN HASIL PRAKTIKUM JOBSHEET 7

<p align="center"> 
<img src="logo polinema.png" width="300px">

 <p align="center">  Nama : Nur Ayu Lailatul Azizah
 <p align="center">  Kelas : TI 1 H
 <p align="center">  NIM : 2341720044

<center> Jln.Soekarno Hatta No.9, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 6
<center>Phone: (0341) 404424,404425
<center>E-mail: Polinema.ac.id

## <center> JOBSHEET VII
## <center> STACK

#### 2.1 Percobaan 1: Penyimpanan Tumpukan Barang dalam Gudang

- Hasil Program pencarian
``` java
package minggu8;
import java.util.Scanner;

public class Barang21 {
    int kode;
    String nama;
    String kategori;

    public Barang21(int kode, String nama,String kategori) {
        this.kode = kode;
        this.nama = nama;
        this.kategori = kategori;
    }

    public static class Gudang21 {
        Barang21[] tumpukan;
        int size;
        int top;

        public Gudang21(int kapasitas) {
            size = kapasitas;
            tumpukan = new Barang21[size];
            top = -1;
        }

        public boolean cekKosong() {
            if (top == -1) {
                return true;
            } else {
                return false;
            }
        }

        public boolean cekPenuh() {
            if (top == size - 1) {
                return true;
            } else {
                return false;
            }
        }

        public void tambahBarang(Barang21 brg) {
            if (!cekPenuh()) {
                top++;
                tumpukan[top] = brg;
                System.out.println("Barang " + brg.nama + " berhasil ditambahkan ke Gudang");
            } else {
                System.out.println("Gagal! Tumpukan barang di Gudang sudah penuh");
            }
        }

        public Barang21 ambilBarang() {
            if (!cekKosong()) {
                Barang21 delete = tumpukan[top];
                top--;
                System.out.println("Barang " + delete.nama + " diambil dari Gudang");
                return delete;
            } else {
                System.out.println("Tumpukan barang kosong");
                return null;
            }
        }

        public Barang21 lihatBarangTeratas() {
            if (!cekKosong()) {
                Barang21 barangTeratas = tumpukan[top];
                System.out.println("Barang teratas: " + barangTeratas.nama);
                return barangTeratas;
            } else {
                System.out.println("Tumpukan barang kosong.");
                return null;
            }
        }

        public void tampilkanBarang() {
            if (!cekKosong()) {
                System.out.println("Rincian tumpukan barang di Gudang");
                for (int i = 0; i <= top; i++) {
                    System.out.printf("Kode %d: %s (Kategori %s)\n", tumpukan[i].kode, tumpukan[i].nama, tumpukan[i].kategori);
                }
            } else {
                System.out.println("Tumpukan barang kosong.");
            }
        }
    }    
}
```

``` java
package minggu8;
import java.util.Scanner;

import minggu8.Barang21.Gudang21;

public class Utama21 {
    public static void main(String[] args) {
    Gudang21 gudang21 = new Gudang21(7);
    Scanner scanner = new Scanner(System.in);

    while(true) {
        System.out.println("\nMenu:");
        System.out.println("1. Tambah Barang");
        System.out.println("2. Ambil Barang");
        System.out.println("3. Tampilkan tumpukan barang");
        System.out.println("4. Keluar");
        System.out.print("Pilih operasi: ");
        int Pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (Pilihan) {
            case 1:
                System.out.print("Masukkan kode barang: ");
                int kode = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Masukkan nama barang: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan nama kategori: ");
                String kategori = scanner.nextLine();
                Barang21 barangBaru = new Barang21(kode, nama, kategori);
                gudang21.tambahBarang(barangBaru);
                break;
            case 2:
                gudang21.ambilBarang();
                break;
            case 3:
                gudang21.tampilkanBarang();
                break;
            case 4:
                break;
            default:
                System.out.println("Pilihan tidak valid. silahkan coba lagi.");
            }
        }
    }
}
```

- Verifikasi Hasil Percobaan

![alt text](<Screenshot 2024-04-26 103536.png>)

![alt text](<Screenshot 2024-04-26 103520.png>)

- Pertanyaan
1. Lakukan perbaikan pada kode program, sehingga keluaran yang dihasilkan sama dengan verifikasi
hasil percobaan! Bagian mana saja yang perlu diperbaiki?
2. Berapa banyak data barang yang dapat ditampung di dalam tumpukan? Tunjukkan potongan kode
programnya!
3. Mengapa perlu pengecekan kondisi !cekKosong() pada method tampilkanBarang? Kalau kondisi
tersebut dihapus, apa dampaknya?
4. Modifikasi kode program pada class Utama sehingga pengguna juga dapat memilih operasi lihat
barang teratas, serta dapat secara bebas menentukan kapasitas gudang!
5. Commit dan push kode program ke Github


- Jawaban 
1. memperbaiki tanda pada tampilkanBarang yang sebelumnya < menjadi >, menukar top dengan 0, mengubah i++ menjadi i--
``` java   
        public void tampilkanBarang() {
            if (!cekKosong()) {
                System.out.println("Rincian tumpukan barang di Gudang");
                for (int i = top; i >= 0; i--) {
                    System.out.printf("Kode %d: %s (Kategori %s)\n", tumpukan[i].kode, tumpukan[i].nama, tumpukan[i].kategori);
                }
            } else {
                System.out.println("Tumpukan barang kosong.");
            }
        }
```
2. Tumpukan dapat menampung hingga 7 barang.
``` java
Gudang21 gudang21 = new Gudang21(7);
```
3. Pengecekan kondisi !cekKosong() pada method tampilkanBarang() dilakukan untuk memastikan bahwa sebelum mencoba untuk menampilkan barang-barang dalam tumpukan, apakah tumpukan tersebut kosong atau tidak. Dampaknya adalah bahwa program tidak akan memeriksa apakah tumpukan kosong sebelum mencoba untuk menampilkannya.
4. 
``` java
        public Barang21 lihatBarangTeratas() {
            if (!cekKosong()) {
                Barang21 barangTeratas = tumpukan[top];
                System.out.println("Barang teratas: " + barangTeratas.nama + "(Kategori " + barangTeratas.kategori + ")");
                return barangTeratas;
            } else {
                System.out.println("Tumpukan barang kosong.");
                return null;
            }
        }

package minggu8;
import java.util.Scanner;

import minggu8.Barang21.Gudang21;

public class Utama21 {
    public static void main(String[] args) { 
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan kapasitas gudang: ");
        int kapasitasGudang = scanner.nextInt();
        Gudang21 gudang21 = new Gudang21(kapasitasGudang);

        while(true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Ambil Barang");
            System.out.println("3. Lihat Barang Teratas");
            System.out.println("4. Tampilkan tumpukan barang");
            System.out.println("5. Keluar");
            System.out.print("Pilih operasi: ");
            int Pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (Pilihan) {
                case 1:
                    System.out.print("Masukkan kode barang: ");
                    int kode = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan nama kategori: ");
                    String kategori = scanner.nextLine();
                    Barang21 barangBaru = new Barang21(kode, nama, kategori);
                    gudang21.tambahBarang(barangBaru);
                    break;
                case 2:
                    gudang21.ambilBarang();
                    break;
                case 3:
                    gudang21.lihatBarangTeratas();
                    break;
                case 4:
                    gudang21.tampilkanBarang();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. silahkan coba lagi.");
            }
        }
    }
}
```

![alt text](<Screenshot 2024-04-28 111002.png>)

![alt text](<Screenshot 2024-04-28 111046.png>)

![alt text](<Screenshot 2024-04-28 111059.png>)

#### 2.2 Percobaan 2: Konversi Kode Barang ke Biner

- Hasil Program

``` java
package minggu8;
import java.util.Scanner;

public class Barang21 {
    int kode;
    String nama;
    String kategori;

    public Barang21(int kode, String nama,String kategori) {
        this.kode = kode;
        this.nama = nama;
        this.kategori = kategori;
    }

    public static class Gudang21 {
        Barang21[] tumpukan;
        int size;
        int top;
        StackKonversi stackKonversi;

        public Gudang21(int kapasitas) {
            size = kapasitas;
            tumpukan = new Barang21[size];
            top = -1;
        }

        public boolean cekKosong() {
            if (top == -1) {
                return true;
            } else {
                return false;
            }
        }

        public boolean cekPenuh() {
            if (top == size - 1) {
                return true;
            } else {
                return false;
            }
        }

        public void tambahBarang(Barang21 brg) {
            if (!cekPenuh()) {
                top++;
                tumpukan[top] = brg;
                System.out.println("Barang " + brg.nama + " berhasil ditambahkan ke Gudang");
            } else {
                System.out.println("Gagal! Tumpukan barang di Gudang sudah penuh");
            }
        }

        public Barang21 ambilBarang() {
            if (!cekKosong()) {
                Barang21 delete = tumpukan[top];
                top--;
                System.out.println("Barang " + delete.nama + " diambil dari Gudang");
                System.out.println("Kode unik dalam biner: " + konversiDesimalkeBiner(delete.kode));
                return delete;
            } else {
                System.out.println("Tumpukan barang kosong");
                return null;
            }
        }

        public void tampilkanBarang() {
            if (!cekKosong()) {
                System.out.println("Rincian tumpukan barang di Gudang");
                for (int i = top; i >= 0; i--) {
                    System.out.printf("Kode %d: %s (Kategori %s)\n", tumpukan[i].kode, tumpukan[i].nama, tumpukan[i].kategori);
                }
            } else {
                System.out.println("Tumpukan barang kosong.");
            }
        }
    }

    public static String konversiDesimalkeBiner(int kode) {
        StackKonversi stack = new StackKonversi();
        while (kode > 0) {
            int sisa = kode % 2;
            stack.push(sisa);
            kode = kode / 2;
        }
        String biner = new String();
        while (!stack.isEmpty()) {
            biner += stack.pop();
        }
        return biner;
    }   

    public static class StackKonversi {
    int size;
    int[] tumpukanBiner;
    int top;
    
        public StackKonversi() {
            this.size = 32; 
            tumpukanBiner = new int[size];
            top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == size -1;
        }

        public void push(int data) {
            if (isFull()) {
                System.out.println("Stack penuh");
            } else {
                top++;
                tumpukanBiner[top] = data;
            }
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack kosong");
                return -1;
            } else {
                int data = tumpukanBiner[top];
                top--;
                return data;
            }
        }


    }
}

package minggu8;
import java.util.Scanner;

import minggu8.Barang21.Gudang21;

public class Utama21 {
    public static void main(String[] args) {
    Gudang21 gudang21 = new Gudang21(7);
    Scanner scanner = new Scanner(System.in);

    while(true) {
        System.out.println("\nMenu:");
        System.out.println("1. Tambah Barang");
        System.out.println("2. Ambil Barang");
        System.out.println("3. Tampilkan tumpukan barang");
        System.out.println("4. Keluar");
        System.out.print("Pilih operasi: ");
        int Pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (Pilihan) {
            case 1:
                System.out.print("Masukkan kode barang: ");
                int kode = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Masukkan nama barang: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan nama kategori: ");
                String kategori = scanner.nextLine();
                Barang21 barangBaru = new Barang21(kode, nama, kategori);
                gudang21.tambahBarang(barangBaru);
                break;
            case 2:
                gudang21.ambilBarang();
                break;
            case 3:
                gudang21.tampilkanBarang();
                break;
            case 4:
                break;
            default:
                System.out.println("Pilihan tidak valid. silahkan coba lagi.");
            }
        }
    }
}
```

- Verifikasi Hasil Percobaan

![alt text](<Screenshot 2024-04-28 210425.png>)

- Pertanyaan
1. Pada method konversiDesimalKeBiner, ubah kondisi perulangan menjadi while (kode != 0), bagaimana hasilnya? Jelaskan alasannya!
2. Jelaskan alur kerja dari method konversiDesimalKeBiner!


jawaban 
1. Hasilnya akan tetap sama meskipun kode nya dirubah menjadi (kode != 0) Hal tersebut terjadi karena kode sebelumnya dan kode (kode != 0) memiliki kondisi yang setara.
2. - method menerima bilangan bulat menjadi parameter
   - membuat objek dari kelas StackKonversi untuk menyimpan sisa pembagian
   - Melakukan perulangan sampai bilangan desimal menjadi 0
   - menghitung sisa pembagian bilangan desimal dengan 2, dan menambahkan sisa ke dalam stack
   - setelah selesai perulangannya, melakukan pengosongan stack untuk menyusun kembali sisa sisa pembagiann yang terakhir hingga pertama dimasukkan
   - mengembalikkan hasil konversi ke dalam bentuk string

#### 2.3 Percobaan 3: Konversi Notasi Infix ke Postfix

- Hasil Program
``` java
package minggu8;
import java.util.Scanner;

public class Postfix21 {
    int n;
    int top;
    char[] stack;

    public Postfix21(int total) {
        n = total;
        top = -1;
        stack = new char[n];
        push ('(');
    }

    public void push(char c) {
        top++;
        stack[top] = c;
    }

    public char pop() {
        char item = stack[top];
        top--;
        return item;
    }

    public boolean IsOperand(char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == ' ' || c == '.') {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsOperator(char c) {
        if (c == '^' || c == '%' || c == '/' || c == '*' || c == '-' || c == '+') {
            return true;
        } else {
            return false;
        }
    }

    public int derajat(char c) {
        switch (c) {
            case '^':
                return 3;
            case '%':
                return 2;
            case '/':
                return 2;
            case '*':
                return 2;
            case '-':
                return 1;
            case '+':
                return 1;
            default:
                return 0;
        }
    }

    public String konversi(String Q) {
        String p = "";
        char c;
        for (int i = 0; i < n; i++) {
            c = Q.charAt(i);
            if (IsOperand(c)) {
                p = p + c;
            }
            if (c == '(') {
                push(c);
            }
            if (c == ')') {
                while (stack[top] != '(') {
                    p = p + pop();
                }
                pop();
            }
            if (IsOperator(c)) {
                while (derajat(stack[top]) >= derajat(c)) {
                    p = p + pop();
                }
                push(c);
            }
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String P, Q;

        System.out.println("Masukkan ekspresi matematika (infinix) : ");
        Q = sc.nextLine();
        Q = Q.trim();
        Q = Q + ")";

        int total = Q.length();
        Postfix21 post = new Postfix21(total);
        P = post.konversi(Q);
        System.out.println("Postfix: " + P);
    }
}
```

- Verifikasi Hasil Percobaan
  
![alt text](<Screenshot 2024-04-29 213601.png>)

-Pertanyaan
1. Pada method derajat, mengapa return value beberapa case bernilai sama? Apabila return value diubah dengan nilai berbeda-beda setiap case-nya, apa yang terjadi?
2. Jelaskan alur kerja method konversi!
3. Pada method konversi, apa fungsi dari potongan kode berikut? 
   c = Q.charAt(i);

-Jawaban
1. Beberapa return value yang sama karena operator operator tsb memiliki prioritas yang sama dalam aturan presedensi operator matematika. dan jika case pada setiap return diubah menjadi berbeda beda, maka urutan operator memiliki pengaruh berbeda dalam konversi menjadi postfix
2. - membuat string kosong p yang akan menyimpan ekspresi postfix yang dihasilkan.
   - Menginisialisasi sebuah stack dengan satu elemen pertama berisi kurung buka (.
   - iterasi melalui setiap karakter dalam ekspresi infix Q
   - Untuk setiap karakter c dalam ekspresi infix:
        - Jika c adalah operand (angka, huruf, spasi, atau titik), tambahkan c ke dalam string p.
        - Jika c adalah kurung buka (, dorong karakter tersebut ke dalam stack.
        - Jika c adalah kurung tutup ):
            - Keluarkan dan tambahkan semua operator dari stack ke dalam string p sampai ditemukan kurung buka.
            - Keluarkan kurung buka dari stack.
        - Jika c adalah operator (+, -, *, /, %, ^):
            - Bandingkan prioritas operator c dengan operator teratas di stack.
            - Jika prioritas operator di stack lebih besar atau sama dengan prioritas operator c, keluarkan operator dari stack dan tambahkan ke dalam string p.
            - Ulangi proses ini hingga tidak terpenuhi kondisi prioritas.
            - Setelah itu, dorong operator c ke dalam stack.
    - Setelah semua karakter dievaluasi, kembalikan string p yang berisi ekspresi postfix. 
3. Digunakan untuk mengambil karakter pada posisi i dari string Q dan menyimpan kedalam variabel c.

#### 2.4 Latihan Praktikum

- ketentuan 
Perhatikan dan gunakan kembali kode program pada Percobaan 1. Tambahkan dua method berikut pada class Gudang:
• Method lihatBarangTerbawah digunakan untuk mengecek barang pada tumpukan terbawah
• Method cariBarang digunakan untuk mencari ada atau tidaknya barang berdasarkan kode barangnya atau nama barangnya

- Hasil Program
``` java  
package minggu8;
import java.util.Scanner;

public class Barang21 {
    int kode;
    String nama;
    String kategori;

    public Barang21(int kode, String nama,String kategori) {
        this.kode = kode;
        this.nama = nama;
        this.kategori = kategori;
    }

    public static class Gudang21 {
        Barang21[] tumpukan;
        int size;
        int top;
        StackKonversi stackKonversi;

        public Gudang21(int kapasitas) {
            size = kapasitas;
            tumpukan = new Barang21[size];
            top = -1;
        }

        public boolean cekKosong() {
            if (top == -1) {
                return true;
            } else {
                return false;
            }
        }

        public boolean cekPenuh() {
            if (top == size - 1) {
                return true;
            } else {
                return false;
            }
        }

        public void tambahBarang(Barang21 brg) {
            if (!cekPenuh()) {
                top++;
                tumpukan[top] = brg;
                System.out.println("Barang " + brg.nama + " berhasil ditambahkan ke Gudang");
            } else {
                System.out.println("Gagal! Tumpukan barang di Gudang sudah penuh");
            }
        }

        public Barang21 ambilBarang() {
            if (!cekKosong()) {
                Barang21 delete = tumpukan[top];
                top--;
                System.out.println("Barang " + delete.nama + " diambil dari Gudang");
                System.out.println("Kode unik dalam biner: " + konversiDesimalkeBiner(delete.kode));
                return delete;
            } else {
                System.out.println("Tumpukan barang kosong");
                return null;
            }
        }

        public Barang21 lihatBarangTerbawah() {
            if (!cekKosong()) {
                Barang21 barangTerbawah = tumpukan[0];
                System.out.println("Barang terbawah: " + barangTerbawah.nama + "(Kategori " + barangTerbawah.kategori + ")");
                return barangTerbawah;
            } else {
                System.out.println("Tumpukan barang kosong.");
                return null;
            }
        }

        public Barang21 cariBarang21(int kodeBarang21) {
            if (!cekKosong()) {
                for (int i = 0; i <= top; i++) {
                    if (tumpukan[i].kode == kodeBarang21) {
                        System.out.println("Barang dengan kode " + kodeBarang21 + " ditemukan: " + tumpukan[i].nama + "(Kategori " + tumpukan[i].kategori + ")");
                        return tumpukan[i];
                    }
                }
                System.out.println("Barang dengan kode " + kodeBarang21 + " tidak ditemukan.");
                return null;
            } else {
                System.out.println("Tumpukan barang kosong.");
                return null;
            }
        }

        public void tampilkanBarang() {
            if (!cekKosong()) {
                System.out.println("Rincian tumpukan barang di Gudang");
                for (int i = top; i >= 0; i--) {
                    System.out.printf("Kode %d: %s (Kategori %s)\n", tumpukan[i].kode, tumpukan[i].nama, tumpukan[i].kategori);
                }
            } else {
                System.out.println("Tumpukan barang kosong.");
            }
        }
    }

    public static String konversiDesimalkeBiner(int kode) {
        StackKonversi stack = new StackKonversi();
        while (kode > 0) {
            int sisa = kode % 2;
            stack.push(sisa);
            kode = kode / 2;
        }
        String biner = new String();
        while (!stack.isEmpty()) {
            biner += stack.pop();
        }
        return biner;
    }   

    public static class StackKonversi {
    int size;
    int[] tumpukanBiner;
    int top;
    
        public StackKonversi() {
            this.size = 32; 
            tumpukanBiner = new int[size];
            top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == size -1;
        }

        public void push(int data) {
            if (isFull()) {
                System.out.println("Stack penuh");
            } else {
                top++;
                tumpukanBiner[top] = data;
            }
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack kosong");
                return -1;
            } else {
                int data = tumpukanBiner[top];
                top--;
                return data;
            }
        }
    }
}

package minggu8;
import java.util.Scanner;

import minggu8.Barang21.Gudang21;

public class Utama21 {
    public static void main(String[] args) {
    Gudang21 gudang21 = new Gudang21(7);
    Scanner scanner = new Scanner(System.in);

    while(true) {
        System.out.println("\nMenu:");
        System.out.println("1. Tambah Barang");
        System.out.println("2. Ambil Barang");
        System.out.println("3. Tampilkan tumpukan barang");
        System.out.println("4. Lihat barang terbawah");
        System.out.println("5. Cari Barang");
        System.out.println("6. Keluar");
        System.out.print("Pilih operasi: ");
        int Pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (Pilihan) {
            case 1:
                System.out.print("Masukkan kode barang: ");
                int kode = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Masukkan nama barang: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan nama kategori: ");
                String kategori = scanner.nextLine();
                Barang21 barangBaru = new Barang21(kode, nama, kategori);
                gudang21.tambahBarang(barangBaru);
                break;
            case 2:
                gudang21.ambilBarang();
                break;
            case 3:
                gudang21.tampilkanBarang();
                break;
            case 4:
                gudang21.lihatBarangTerbawah();
                break;
            case 5:
                System.out.print("Masukkan kode barang yang ingin dicari: ");
                int kodeCari = scanner.nextInt();
                gudang21.cariBarang21( kodeCari);
                break;
            case 6:
                System.out.println("Program selesai.");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid. silahkan coba lagi.");
            }
        }
    }
}
```
- Hasil Percobaan

![alt text](<Screenshot 2024-04-29 221233.png>)

![alt text](<Screenshot 2024-04-29 221248.png>)


