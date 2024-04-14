## <center> LAPORAN HASIL PRAKTIKUM JOBSHEET 6

<p align="center"> 
<img src="logo polinema.png" width="300px">

 <p align="center">  Nama : Nur Ayu Lailatul Azizah
 <p align="center">  Kelas : TI 1 H
 <p align="center">  NIM : 2341720044

<center> Jln.Soekarno Hatta No.9, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 6
<center>Phone: (0341) 404424,404425
<center>E-mail: Polinema.ac.id

## <center> JOBSHEET VI
## <center> SEARCHING

#### 2.1 Percobaan 1: Searching / Pencarian Menggunakan Agoritma Sequential Search

- Hasil Program pencarian
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

        public void TampilPosisi(int x, int pos) {
            if (pos != -1) {
                System.out.println("Data : " + x + " ditemukan pada indeks " + pos);
            } else {
                System.out.println("Data : " + x + " tidak ditemukan");
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
                System.out.println("---------------------------------------------------------");
                System.out.println("Data keseluruhan buku      : ");
                data.tampil();

                System.out.println("_________________________________________________________");
                System.out.println("_________________________________________________________");
                System.out.println("Pencarian data");
                System.out.println("Masukkan kode buku yang dicari");
                System.out.print("Kode buku : ");
                int cari = s.nextInt();
                System.out.println("Menggunakan sequential search");
                int posisi = data.FindSeqSearch(cari);
                data.TampilPosisi(cari, posisi);
            }
        }
        
    }
}
```
- Verifikasi Hasil Pencarian

![alt text](<pertemuan 7 percobaan 1 sebelum 1.png>)

![alt text](<pertemuan 7 percobaan 1 sebelum 2.png>)

![alt text](<pertemuan 7 4percobaan 1 sebelum 3.png>)

- Hasil Program 
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
                System.out.println("---------------------------------------------------------");
                System.out.println("Data keseluruhan buku      : ");
                data.tampil();

                System.out.println("_________________________________________________________");
                System.out.println("_________________________________________________________");
                System.out.println("Pencarian data");
                System.out.println("Masukkan kode buku yang dicari");
                System.out.print("Kode buku : ");
                int cari = s.nextInt();
                System.out.println("Menggunakan sequential search");
                int posisi = data.FindSeqSearch(cari);
                data.TampilPosisi(cari, posisi);
                data.TampilData(cari, posisi);
            }
        }
        
    }
}
```
- Verifikasi Hasil Percobaan

![alt text](<pt 7 percobaan 1 setelah.png>)

- Pertanyaan
1. Jelaskan fungsi break yang ada pada method FindSeqSearch!
2. Jika Data Kode Buku yang dimasukkan tidak terurut dari kecil ke besar. Apakah program masih dapat berjalan? Apakah hasil yang dikeluarkan benar? Tunjukkan hasil screenshoot untuk bukti dengan kode Buku yang acak. Jelaskan Mengapa hal tersebut bisa terjadi?
3. Buat method baru dengan nama FindBuku menggunakan konsep sequential search dengan tipe method dari FindBuku adalah BukuNoAbsen. Sehingga Anda bisa memanggil method tersebut pada class BukuMain seperti gambar berikut :
Buku dataBuku = data.FindBuku(cari);
dataBuku.tampilDataBuku();

- Jawaban 
1. pada method FindSeqSearch pernyataan break digunakan untuk menghentikan iterasi (perulangan) pada saat kondisi pencarian telah terpenuhi
2. pencarian masih akan berjalan karena sequintal search mencari data satu persatu dari awal hingga akhir array dan mengakibatkan pencarian lebih lama dan kurang efisien.

![alt text](<percobaan 7 percobaan 1 soal 2.png>)

3. 
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

        public void TampilPosisi(int x, int pos) {
            if (pos != -1) {
                System.out.println("Data : " + x + " ditemukan pada indeks " + pos);
            } else {
                System.out.println("Data : " + x + " tidak ditemukan");
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
                System.out.println("---------------------------------------------------------");
                System.out.println("Data keseluruhan buku      : ");
                data.tampil();

                System.out.println("_________________________________________________________");
                System.out.println("_________________________________________________________");
                System.out.println("Pencarian data");
                System.out.println("Masukkan kode buku yang dicari");
                System.out.print("Kode buku : ");
                int cari = s.nextInt();
                System.out.println("Menggunakan sequential search");
                int posisi = data.FindSeqSearch(cari);
                data.TampilPosisi(cari, posisi);
                data.TampilData(cari, posisi);
            }
        }
        
    }
}
```
Hasil Modifikasi

![alt text](<Screenshot 2024-04-14 204834.png>)

#### 2.2 Percobaan 2: Searching / Pencarian Menggunakan Binary Search

- Hasil Program

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
            }
        }
        
    }
}
```

- Verifikasi Hasil Percobaan

![alt text](<pertemuan 7 percobaan 2.png>)

- Pertanyaan
1. Tunjukkan pada kode program yang mana proses divide dijalankan!
2. Tunjukkan pada kode program yang mana proses conquer dijalankan!
4. Jika data Kode Buku yang dimasukkan tidak urut. Apakah program masih dapat berjalan? Mengapa demikian! Tunjukkan hasil screenshoot untuk bukti dengan kode Buku yang acak. Jelaskan Mengapa hal tersebut bisa terjadi?
3. Jika Kode Buku yang dimasukkan dari Kode Buku terbesar ke terkecil (missal : 20215, 20214, 20212, 20211, 20210) dan elemen yang dicari adalah 20210. Bagaimana hasil dari binary search? Apakah sesuai? Jika tidak sesuai maka ubahlah kode program binary seach agar hasilnya sesuai!

jawaban 
1. int mid = left + (right - left) / 2;
2.         public int FindBinarySearch(int cari, int left, int right) {
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
4. Program akan tetap berjalan tetapi hasilnya mungkin tidak sesuai deangan yang diharapkan hal ini terjadi karena program tidak memerlukan data yang diurutkan untuk berjalan.

![alt text](<Screenshot 2024-04-14 214218.png>)

3. outputnya pada biary search akan mengatakan data tidak ditemukan oleh karena itu harus mengubah menjadi descending 

![alt text](<Screenshot 2024-04-14 232213.png>)

#### 2.3 Percobaan 3: Percobaan Pengayaan Divide and Conquer

- Hasil Program
``` java
package minggu7;

public class MergeSorting21 {
    public void mergeSort(int[] data) {
        sort(data, 0, data.length - 1);
    }
        public void merge(int data[], int left, int middle, int right) {
            int[] temp = new int[data.length];
            for (int i = left; i <= right; i++) {
                temp[i] = data[i];
            }
            int a = left;
            int b = middle + 1;
            int c = left;

            while (a <= middle && b <= right) {
                if (temp[a] <= temp[b]) {
                    data[c] = temp[a];
                    a++;
                } else {
                    data[c] = temp[b];
                    b++;
                }
                c++;
            }
            int s = middle - a;
            for (int i = 0; i <= s; i++) {
                data[c + i] = temp[a +i];
            }
        }

            public void sort(int data[], int left, int right) {
                if (left < right) {
                    int middle = (left + right) / 2;
                    sort(data, left, middle);
                    sort(data, middle + 1, right);
                    merge(data, left, middle, right);
                }
            }

            public void printArray(int arr[]) {
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }

        public static void main(String[] args) {
            int data[] = {10, 40, 30, 50, 70, 20, 100, 90};
            System.out.println("sorting dengan merge sort");
            MergeSorting21 mSort = new MergeSorting21();
            System.out.println("data awal");
            mSort.printArray(data);
            mSort.mergeSort(data);
            System.out.println("setelah diurutkan : ");
            mSort.printArray(data);
    }
}
```

- Verifikasi Hasil Percobaan
  
![alt text](<pertemuan 7 percobaan 3.png>)

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

