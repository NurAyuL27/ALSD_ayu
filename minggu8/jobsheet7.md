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

#### 2.3 Percobaan 3: Percobaan Pengayaan Divide and Conquer

- Hasil Program
``` java

```

- Verifikasi Hasil Percobaan
  


#### 2.4 Latihan Praktikum

- ketentuan 
1. Modifikasi percobaan searching diatas dengan ketentuan berikut ini
a. Ubah tipe data dari kode Buku yang awalnya int menjadi String
b. Tambahkan method untuk pencarian kode Buku (bertipe data String) dengan menggunakan
sequential search dan binary search.
2. Modifikasi percobaan searching diatas dengan ketentuan berikut ini
a. Tambahkan method pencarian judul buku menggunakan sequential search dan binary
search. Sebelum dilakukan searching dengan binary search data harus dilakukan pengurutan
dengan menggunakan algoritma Sorting (bebas pilih algoritma sorting apapun)! Sehingga
ketika input data acak, maka algoritma searching akan tetap berjalan
b. Buat aturan untuk mendeteksi hasil pencarian judul buku yang lebih dari 1 hasil dalam
bentuk kalimat peringatan! Pastikan algoritma yang diterapkan sesuai dengan kasus yang
diberikan!

- Hasil Program modifikasi 1
``` java  
package minggu7;

import java.util.Scanner;

public class Buku21 {
    String kodeBuku;
    String judulBuku;
    int tahunTerbit;
    String pengarang;
    int stock;
    
    public Buku21(String kodeBuku, String judulBuku, int tahunTerbit, String pengarang, int stock) {
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
        this.tahunTerbit = tahunTerbit;
        this.pengarang = pengarang;
        this.stock = stock;
    }

    public void tampilDataBuku() {
        System.out.println("=========================================================");
        System.out.println("Kode buku       : " + kodeBuku);
        System.out.println("Judul buku      : " + judulBuku);
        System.out.println("Tahun terbit    : " + tahunTerbit);
        System.out.println("Pengarang       : " + pengarang);
        System.out.println("Stock           : " + stock);
    }

    public static class PencarianBuku21 {
        Buku21 listBk[] = new Buku21[5];
        int idx;

        void tambah(Buku21 m) {
            if (idx < listBk.length) {
                listBk[idx] = m;
                idx++;
            } else {
                System.out.println("Data sudah penuh!");
            }
        }

        void tampil() {
            for (Buku21 m : listBk) {
                m.tampilDataBuku();
            }
        }

        public Buku21 FindBuku(String cari) {
            for (int j = 0; j < listBk.length; j++) {
                if (listBk[j].kodeBuku == cari) {
                    return listBk[j];
                    }
                }
            return null;
        }

        public int FindSeqSequentialSearch(String cari) {
            for (int j = 0; j < listBk.length; j++) {
                if (listBk[j].kodeBuku.equals(cari)) {
                   return j;
                }
            }
            return -1;
        }

        public int FindBinarySearch(String cari, int left, int right) {
            int mid;
            if (right >= left) {
                mid = left + (right - left) / 2;
                if (cari.equals(listBk[mid].kodeBuku)) {
                    return (mid);
                } else if (listBk[mid].kodeBuku.compareToIgnoreCase(cari) > 0) {
                    return FindBinarySearch(cari, left, mid - 1);
                } else {
                    return FindBinarySearch(cari, mid + 1, right);
                }
            }
            return -1;
        }

        public void TampilPosisi(String x, int pos) {
            if (pos != -1) {
                System.out.println("Data : " + x + " ditemukan pada indeks " + pos);
            } else {
                System.out.println("Data : " + x + " tidak ditemukan");
            }
        }

        public void TampilData(String x, int pos) {
            if (pos != -1) {
                System.out.println("Kode buku       : " + x);
                System.out.println("Judul           : " + listBk[pos].judulBuku);
                System.out.println("Tahun terbit    : " + listBk[pos].tahunTerbit);
                System.out.println("Pengarang       : " + listBk[pos].pengarang);
                System.out.println("Stock           : " + listBk[pos].stock);
            } else {
                System.out.println("Data " + x + " tidak ditemukan");
            }
        }


        public static class BukuMain21 {
            public static void main(String[] args) {
                Scanner s = new Scanner(System.in);
                Scanner s1 = new Scanner(System.in);

                PencarianBuku21 data = new PencarianBuku21();
                int jumBuku = 5;

                System.out.println("---------------------------------------------------------");
                System.out.println("Masukkan data buku secara urut dari kode buku terkecil : ");
                for (int i = 0; i < jumBuku; i++) {
                    System.out.println("---------------------------------------------------------");
                    System.out.print("Kode buku     : ");
                    String kodeBuku = s.nextLine();
                    System.out.print("Judul buku    : ");
                    String judulBuku = s1.nextLine();
                    System.out.print("Tahun terbit  : ");
                    int tahunTerbit = s.nextInt();
                    s.nextLine();
                    System.out.print("Pengarang     : ");
                    String pengarang = s1.nextLine();
                    System.out.print("Stock         : ");
                    int stock = s.nextInt();
                    s.nextLine();

                    Buku21 m = new Buku21(kodeBuku, judulBuku, tahunTerbit, pengarang, stock);
                    data.tambah(m);
                }
                System.out.println("---------------------------------------------------------");
                System.out.println("Data keseluruhan buku      : ");
                data.tampil();

                System.out.println("_________________________________________________________");
                System.out.println("_________________________________________________________");
                System.out.println("Pencarian data");
                System.out.println("Masukkan kode buku yang dicari");
                System.out.print("Kode buku : ");
                String cari = s.nextLine();
                System.out.println("=========================================================");
                System.out.println("Menggunakan Sequential Search");
                int posisi = data.FindSeqSequentialSearch(cari);
                data.TampilPosisi(cari, posisi);
                data.TampilData(cari, posisi);
                System.out.println("=========================================================");
                System.out.println("Menggunakan binary search");
                posisi = data.FindBinarySearch(cari, 0, jumBuku - 1);
                data.TampilPosisi(cari, posisi);
                data.TampilData(cari, posisi);
            }
        }
        
    }
}
```
- Hasil Percobaan

![alt text](<pertemuan 7 latihan praktikum 1.png>)

- Hasil Program modifikasi 2
``` java
package minggu7;

import java.util.Scanner;

public class Buku21 {
    int kodeBuku;
    String judulBuku;
    int tahunTerbit;
    String pengarang;
    int stock;
    
    public Buku21(int kodeBuku, String judulBuku, int tahunTerbit, String pengarang, int stock) {
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
        this.tahunTerbit = tahunTerbit;
        this.pengarang = pengarang;
        this.stock = stock;
    }

    public void tampilDataBuku() {
        System.out.println("=========================================================");
        System.out.println("Kode buku       : " + kodeBuku);
        System.out.println("Judul buku      : " + judulBuku);
        System.out.println("Tahun terbit    : " + tahunTerbit);
        System.out.println("Pengarang       : " + pengarang);
        System.out.println("Stock           : " + stock);
    }

    public static class PencarianBuku21 {
        Buku21 listBk[] = new Buku21[5];
        int idx;

        void tambah(Buku21 m) {
            if (idx < listBk.length) {
                listBk[idx] = m;
                idx++;
            } else {
                System.out.println("Data sudah penuh!");
            }
        }

        void tampil() {
            for (Buku21 m : listBk) {
                m.tampilDataBuku();
            }
        }

        public Buku21 FindBuku(int cari) {
            for (int j = 0; j < listBk.length; j++) {
                if (listBk[j].kodeBuku == cari) {
                    return listBk[j];
                    }
                }
            return null;
        }

        public int FindSeqSearch(int cari) {
            int posisi = -1;
            for (int j = 0; j < listBk.length; j++) {
                if (listBk[j].kodeBuku == cari) {
                   posisi = j;
                    break;
                }
            }
            return posisi;
        }

        public int FindBinarySearch(int cari, int left, int right) {
            if (right >= left) {
                int mid = left + (right - left) / 2;
                if (listBk[mid].kodeBuku == cari) 
                    return (mid);
                if (listBk[mid].kodeBuku > cari) 
                    return FindBinarySearch(cari, left, mid - 1);
                return FindBinarySearch(cari, mid + 1, right);
            }
            return -1;
        }

        public void TampilPosisi(int x, int pos) {
            if (pos != -1) {
                System.out.println("Data : " + x + " ditemukan pada indeks " + pos);
            } else {
                System.out.println("Data : " + x + " tidak ditemukan");
            }
        }

        public void TampilData(int x, int pos) {
            if (pos != -1) {
                System.out.println("Kode buku       : " + x);
                System.out.println("Judul           : " + listBk[pos].judulBuku);
                System.out.println("Tahun terbit    : " + listBk[pos].tahunTerbit);
                System.out.println("Pengarang       : " + listBk[pos].pengarang);
                System.out.println("Stock           : " + listBk[pos].stock);
            } else {
                System.out.println("Data " + x + " tidak ditemukan");
            }
        }

        public void FindJudulSequentialSearch(String cari) {
            int count = 0;
            for (int j = 0; j < listBk.length; j++) {
                if (listBk[j].judulBuku.equalsIgnoreCase(cari)) {
                    count++;
                    System.out.println("Buku dengan judul " + cari + " ditemukan pada indeks " + j);
                    listBk[j].tampilDataBuku();
                }
            }
            if (count == 0) {
                System.out.println("Buku dengan judul " + cari + " tidak ditemukan");
            } else if (count > 1) {
                System.out.println("Ditemukan buku lebih dari satu judul " + cari + " :");
            }
        }

        public void FindJudulBinarySearch(String judul) {
            sortBukuByJudul();

            int left = 0;
            int right = listBk.length - 1;
            boolean found = false;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int compareResult = listBk[mid].judulBuku.compareToIgnoreCase(judul);
                
                if (compareResult == 0) {
                    found = true;
                    int start = mid;
                    int end = mid;

                    while (start > 0 && listBk[start - 1].judulBuku.equalsIgnoreCase(judul)) {
                        start--;
                    }
                    while (end < listBk.length - 1 && listBk[end + 1].judulBuku.equalsIgnoreCase(judul)) {
                        end++;
                    }

                    System.out.println("Buku dengan judul " + judul + " ditemukan pada indeks " + (start) + " sampai " + (end));
                    for (int i = start; i <= end; i++) {
                        listBk[i].tampilDataBuku();
                    }
                    break;
                } else if (compareResult < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } if (!found) {
                System.out.println("Buku dengan judul " + judul + " tidak ditemukan");
            }
        }

        private void sortBukuByJudul() {
            for (int i = 0; i < listBk.length - 1; i++) {
                for (int j = 0; j < listBk.length - i -1; j++) {
                    if (listBk[j] != null && listBk[j + 1] != null && listBk[j].kodeBuku > listBk[j + 1].kodeBuku) {
                        Buku21 temp = listBk[j];
                        listBk[j] = listBk[j + 1];
                        listBk[j + 1] = temp;
                    }
                }
            }
        }


        public static class BukuMain21 {
            public static void main(String[] args) {
                Scanner s = new Scanner(System.in);
                Scanner s1 = new Scanner(System.in);

                PencarianBuku21 data = new PencarianBuku21();
                int jumBuku = 5;

                System.out.println("---------------------------------------------------------");
                System.out.println("Masukkan data buku : ");
                for (int i = 0; i < jumBuku; i++) {
                    System.out.println("---------------------------------------------------------");
                    System.out.print("Kode buku     : ");
                    int kodeBuku = s.nextInt();
                    System.out.print("Judul buku    : ");
                    String judulBuku = s1.nextLine();
                    System.out.print("Tahun terbit  : ");
                    int tahunTerbit = s.nextInt();
                    System.out.print("Pengarang     : ");
                    String pengarang = s1.nextLine();
                    System.out.print("Stock         : ");
                    int stock = s.nextInt();

                    Buku21 m = new Buku21(kodeBuku, judulBuku, tahunTerbit, pengarang, stock);
                    data.tambah(m);
                }
                data.sortBukuByJudul();

                System.out.println("---------------------------------------------------------");
                System.out.println("Data keseluruhan buku      : ");
                data.tampil();

                System.out.println("_________________________________________________________");
                System.out.println("_________________________________________________________");
                System.out.println("Pencarian data");
                System.out.println("Masukkan kode buku yang dicari");
                System.out.print("Kode buku : ");
                int cari = s.nextInt();
                System.out.println("=========================================================");
                System.out.println("Menggunakan Sequential Search");
                int posisi = data.FindSeqSearch(cari);
                data.TampilPosisi(cari, posisi);
                data.TampilData(cari, posisi);
                System.out.println("=========================================================");
                System.out.println("Menggunakan binary search");
                posisi = data.FindBinarySearch(cari, 0, jumBuku - 1);
                data.TampilPosisi(cari, posisi);
                data.TampilData(cari, posisi);


                System.out.println("=========================================================");
                System.out.println("Pencarian judul buku");
                System.out.println("Masukkan judul buku yang dicari: ");
                String judulCari = s1.nextLine();
                System.out.println("=========================================================");
                System.out.println("Menggunakan Sequential Search");
                data.FindJudulSequentialSearch(judulCari);
                System.out.println("=========================================================");
                System.out.println("Menggunakan Binary Search");
                data.FindJudulBinarySearch(judulCari);
            }
        }
        
    }
}
```

- Hasil Percobaan

![alt text](<Screenshot 2024-04-14 214218.png>)

![alt text](<Screenshot 2024-04-14 232213.png>)

