## <center> LAPORAN HASIL PRAKTIKUM JOBSHEET 4

<p align="center"> 
<img src="logo polinema.png" width="300px">

 <p align="center">  Nama : Nur Ayu Lailatul Azizah
 <p align="center">  Kelas : TI 1 H
 <p align="center">  NIM : 2341720044

<center> Jln.Soekarno Hatta No.9, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 6
<center>Phone: (0341) 404424,404425
<center>E-mail: Polinema.ac.id

<center> ## JOBSHEET IV
<center> ## BRUTE FORCE DAN DIVIDE CONQUER

#### 2.1 Percobaan 1: Menghitung Nilai Faktorial dengan Algoritma Brute Force dan Divide and Conquer

- Hasil Program

package minggu5;

import java.util.Scanner;

public class Faktorial {
        public int nilai;

        int faktorialBF(int n) {
            int fakto = 1;
            for(int i = 1; i <= n; i++) {
                fakto = fakto * i;
            }
            return fakto;
        }

        int faktorialDC(int n) {
                if(n==1) {
                    return 1;
            } else {
                int fakto = n * faktorialDC(n-1);
                return fakto;
        }
    }

    public static class MainFaktorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("Masukkan jumlah elemen: ");
        int iJml = sc.nextInt();

        Faktorial[] fk = new Faktorial[iJml];
        for(int i = 0; i < iJml; i++) {
            fk[i] = new Faktorial();
            System.out.println("masukkan nilai data ke-" + (i+1) + ": ");
            int iNilai = sc.nextInt();
            fk[i].nilai = iNilai;
        }

        System.out.println("HASIL - BRUTE FORCE");
        for(int i = 0; i < iJml; i++) {
            System.out.println("Hasil penghitungan faktorial menggunakan Brute Force adalah " + fk[i].faktorialBF(fk[i].nilai));
        }

        System.out.println("HASIL - DIVIDE AND CONQUER");
        for(int i = 0; i < iJml; i++) {
            System.out.println("Hasil penghitungan faktorial menggunakan Divide and Conquer adalah " + fk[i].faktorialDC(fk[i].nilai));
        }
        }
    }
} 


- Verifikasi Hasil Percobaan

![alt text](<Screenshot 2024-03-24 121640.png>)

- Pertanyaan
1. Pada base line Algoritma Divide Conquer untuk melakukan pencarian nilai faktorial, jelaskan
perbedaan bagian kode pada penggunaan if dan else!
1. Apakah memungkinkan perulangan pada method faktorialBF() dirubah selain menggunakan
for?Buktikan!
1. Jelaskan perbedaan antara fakto *= i; dan int fakto = n * faktorialDC(n-1); !
     
- Jawaban 
1. perbedaan utama antara penggunaan if dan else pada program faktorial adalah pada tindakan yang diambil setelah kondisi diperiksa. pada if tanpa else hana ada satu tindakan yang dilakukan jika kondisi terpenuhi sedangkan pada if-else ada tindakan yang dilakukan jika kondisi terpenuhi dan tindakan lainnya jika kondisi tidak terpenuhi.
2. ya, dapat diganti dengan menggunakan perulangan while
3. perbedaanya terletak pada cara perhitungan nilai faktorial dan metode yang digunakan. pada pendekatan bruteforce perhitungan dilakukan secara berulang menggunakan perulangan sedangkan dalam pendekatan rekursif masalah dibagi menjadi masalah yang lebih kecil dan dipecahkan secara rekursif.

#### 2.2 Percobaan 2: Menghitung Hasil Pangkat dengan Algoritma Brute Force dan Divide and Conquer

- Hasil Program
  
package minggu5;

import java.util.Scanner;

public class Pangkat {
    public int nilai, pangkat;

    int pangkatBF(int a, int n) {
        int hasil = 1;
        for(int i = 0; i < n; i++) {
            hasil *= a;
        }
        return hasil;
    }

    int pangkatDC(int a, int n) {
        if(n == 0) {
            return 1;
        } else {
            if(n % 2 == 1) {
                return (pangkatDC(a,n/2)*pangkatDC(a,n/2)*a);
            } else {
                return (pangkatDC(a,n/2)*pangkatDC(a,n/2));
            }
        }
    }

    public static class MainPangkat {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("==============================");
    System.out.println("Masukkan jumlah elemen yang dihitung: ");
    int elemen = sc.nextInt();

    Pangkat[] png = new Pangkat[elemen];
    for(int i=0; i < elemen; i++) {
        png[i] = new Pangkat();
        System.out.println("Masukkan nilai ang hendak dipangkatkan: ");
        png[i].nilai = sc.nextInt();
        System.out.println("Masukkan nilai pemangkat: ");
        png[i].pangkat = sc.nextInt();
    }

    System.out.println("HASIL PANGKAT - BRUTE FORCE");
    for(int i = 0; i < elemen; i++) {
        System.out.println("Hasil dari " + png[i].nilai + " pangkat " + png[i].pangkat+ " adalah " + png[i].pangkatBF(png[i].nilai, png[i].pangkat));
    }
    System.out.println("HASIL PANGKAT - DIVINE AND CONQUER");
    for(int i = 0; i < elemen; i++) {
        System.out.println("Hasil dari " + png[i].nilai + " pangkat " + png[i].pangkat+ " adalah " + png[i].pangkatDC(png[i].nilai, png[i].pangkat));
            }
        }
    }
}




- Verifikasi Hasil Percobaan

![alt text](<Screenshot 2024-03-24 122320.png>)

- Pertanyaan
1. Jelaskan mengenai perbedaan 2 method yang dibuat yaitu PangkatBF() dan PangkatDC()!
2. Apakah tahap combine sudah termasuk dalam kode tersebut?Tunjukkan!
3. Modifikasi kode program tersebut, anggap proses pengisian atribut dilakukan dengan
konstruktor.
1. Tambahkan menu agar salah satu method yang terpilih saja yang akan dijalankan menggunakan
switch-case!
   
- jawaban
1. perbedaan antara kedua metode ini adalah dalam pendekatan yang digunakan untuk menghitung nilai pangkat bilang, dimana pangkatBF menggunakan pendekatan brute force sederhana sedangkan pangkatDC menggunakan pendekatan divide and conquer yang lebih efisien.
2. tahap "combine" untuk metode pangkatDC (Divide and Conquer) sudah diimplementasikan di dalam struktur rekursif. Pada tahap combine, hasil dari submasalah yang lebih kecil dikombinasikan untuk mendapatkan hasil akhir.
3. 
package minggu5;

import java.util.Scanner;

public class Pangkat {
    public int nilai, pangkat;

    public Pangkat(int nilai, int pangkat) {
        this.nilai = nilai;
        this.pangkat = pangkat;
    }

    int pangkatBF(int a, int n) {
        int hasil = 1;
        for(int i = 0; i < n; i++) {
            hasil *= a;
        }
        return hasil;
    }

    int pangkatDC(int a, int n) {
        if(n == 0) {
            return 1;
        } else {
            if(n % 2 == 1) {
                return (pangkatDC(a,n/2)*pangkatDC(a,n/2)*a);
            } else {
                return (pangkatDC(a,n/2)*pangkatDC(a,n/2));
            }
        }
    }

    public static class MainPangkat {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("==============================");
    System.out.println("Masukkan jumlah elemen yang dihitung: ");
    int elemen = sc.nextInt();

    Pangkat[] png = new Pangkat[elemen];
    for(int i=0; i < elemen; i++) {
        System.out.println("Masukkan nilai yang akan dipangkatkan: ");
        int nilai = sc.nextInt();
        System.out.println("Masukkan nilai pemangkat: ");
        int pangkat = sc.nextInt();
        png[i] = new Pangkat(nilai, pangkat);
    }

    System.out.println("HASIL PANGKAT - BRUTE FORCE");
    for(int i = 0; i < elemen; i++) {
        System.out.println("Hasil dari " + png[i].nilai + " pangkat " + png[i].pangkat+ " adalah " + png[i].pangkatBF(png[i].nilai, png[i].pangkat));
    }
    System.out.println("HASIL PANGKAT - DIVINE AND CONQUER");
    for(int i = 0; i < elemen; i++) {
        System.out.println("Hasil dari " + png[i].nilai + " pangkat " + png[i].pangkat+ " adalah " + png[i].pangkatDC(png[i].nilai, png[i].pangkat));
            }
        }
    }
}

4. 

package minggu5;

import java.util.Scanner;

public class Pangkat {
    public int nilai, pangkat;

    public Pangkat(int nilai, int pangkat) {
        this.nilai = nilai;
        this.pangkat = pangkat;
    }

    int pangkatBF(int a, int n) {
        int hasil = 1;
        for(int i = 0; i < n; i++) {
            hasil *= a;
        }
        return hasil;
    }

    int pangkatDC(int a, int n) {
        if(n == 0) {
            return 1;
        } else {
            if(n % 2 == 1) {
                return (pangkatDC(a,n/2)*pangkatDC(a,n/2)*a);
            } else {
                return (pangkatDC(a,n/2)*pangkatDC(a,n/2));
            }
        }
    }

    public static class MainPangkat {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("==============================");
    System.out.println("Menu: ");
    System.out.println("1. Pangkat Brute Force");
    System.out.println("2. Pangkat Divide and conquer");
    System.out.println("==============================");
    int pilihan = sc.nextInt();

    switch (pilihan) {
        case 1:
            System.out.println("Masukkan nilai yang akan dipangkatkan: ");
            int nilaiBF = sc.nextInt();
            System.out.println("Masukkan nilai pemangkat: ");
            int pangkatBF = sc.nextInt();
            Pangkat pngktBF = new Pangkat(nilaiBF, pangkatBF);
            System.out.println("Hasil pangkat menggunakan Brute Force: " + pngktBF.pangkatBF(nilaiBF, pangkatBF));
                break;
    
        case 2:
            System.out.println("Masukkan nilai yang akan dipangkatkan: ");
            int nilaiDC = sc.nextInt();
            System.out.println("Masukkan nilai pemangkat: ");
            int pangkatDC = sc.nextInt();
            Pangkat pngktDC = new Pangkat(nilaiDC, pangkatDC);
            System.out.println("Hasil pangkat menggunakan Divide and Condquer: " + pngktDC.pangkatDC(nilaiDC, pangkatDC));
                break;
    default:
    System.out.println("Pilihan tidak valid.");
    break;
            }
        }
    }
}



#### 2.3 Percobaan 3: Menghitung Sum Array dengan Algoritma Brute Force dan Divide and Conquer

- Hasil Program
  
package minggu5;

import java.util.Scanner;

public class Sum {
    int elemen;
    double keuntungan[], total;

    Sum(int elemen) {
        this.elemen = elemen;
        this.keuntungan = new double[elemen];
        this.total = 0;
    }

    double totalBF(double arr[]) {
        for(int i = 0; i < elemen; i++) {
            total = total + arr[i];
        }
        return total;
    }

    double totalDC(double arr[], int l, int r) {
        if(l == r) {
            return arr[l];
        } else if(l < r) {
            int mid = (l + r) / 2;
            double lsum = totalDC(arr, l, mid - 1);
            double rsum = totalDC(arr, mid + 1, r);
            return lsum + rsum + arr[mid];
        }
        return 0;
    }

    public static class MainSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("Program Menghitung Keuntungan Total (Satuan Juta, Misal 5,9)");
        System.out.print("Masukkan jumlah bulan: ");
        int elm = sc.nextInt();

        Sum sm = new Sum(elm);
        System.out.println("============================================================");
        for(int i = 0; i < sm.elemen; i++) {
            System.out.print("Masukkan untung bulan ke - " + (i + 1) + " = ");
            sm.keuntungan[i] = sc.nextDouble();
        }

        System.out.println("============================================================");
        System.out.println("Algoritma Brute Force");
        System.out.println("Total Keuntungan Perubahan selama " + sm.elemen + " bulan adalah = " + sm.totalBF(sm.keuntungan));
        System.out.println("============================================================");
        System.out.println("Algoritma Divide Conquer");
        System.out.println("Total keuntungan perusahaan salama " + sm.elemen + " bulan adalah = " + sm.totalDC(sm.keuntungan, 0, sm.elemen - 1));
        }
    }
}


- Verifikasi Hasil Percobaan
  
![alt text](<Screenshot 2024-03-24 122508.png>)  

- Pertanyaan
1. Mengapa terdapat formulasi return value berikut?Jelaskan!
2. Kenapa dibutuhkan variable mid pada method TotalDC()?
3. Program perhitungan keuntungan suatu perusahaan ini hanya untuk satu perusahaan saja.
Bagaimana cara menghitung sekaligus keuntungan beberapa bulan untuk beberapa
perusahaan.(Setiap perusahaan bisa saja memiliki jumlah bulan berbeda-beda)? Buktikan
dengan program!

- jawaban
1. 



#### 2.4 Latihan Praktikum

#### 2.4.1 Menambahkan Metode

1. Sebuah showroom memiliki daftar mobil dengan data sesuai tabel di bawah ini

   Tentukan:
a) top_acceleration tertinggi menggunakan Divide and Conquer!
b) top_acceleration terendah menggunakan Divide and Conquer!
c) Rata-rata top_power dari seluruh mobil menggunakan Brute Force!

- Hasil Program
  
package minggu5;
import java.util.Scanner;
public class Showroom {
    public String[] merk = {"BMW", "Ford", "Nissan", "Subaru", "Subaru", "Toyota", "Toyota", "Volkswagen"};
    public String[] tipe = {"M2 Coupe", "Fiesta ST", "370Z", "BRZ", "Impreza WRX STI", "AE86 Trueno", "86/GT86", "Golf GTI"};
    public int[] tahun = {2016, 2014, 2009, 2014, 2013, 1986, 2014, 2014};
    public int[] top_acceleration = {6816, 3921, 4360, 4058, 6255, 3700, 4180, 4180};
    public int[] top_power = {728, 575, 657, 609, 703, 553, 609, 631};

    public int maxAcceleration(int low, int high) {
        if (low == high)
            return top_acceleration[low];

        int mid = (low + high) / 2;
        int lMax = maxAcceleration(low, mid);
        int rMax = maxAcceleration(mid + 1, high);

        return Math.max(lMax, rMax);
    }

    public int minAcceleration(int low, int high) {
        if (low == high)
            return top_acceleration[low];

            int mid = (low + high) / 2;
            int lMin = minAcceleration(low, mid);
            int rMin = minAcceleration(mid + 1, high);

            return Math.min(lMin, rMin);
    }

    public double averagePower() {
        int sum = 0;
        for (int power : top_power) {
            sum += power;
        }
        return (double) sum / top_power.length;
    }

    public static void main(String[] args) {
        Showroom showroom = new Showroom();

        int maxAcceleration = showroom.maxAcceleration(0, showroom.top_acceleration.length - 1);
        System.out.println("Top Acceleration tertinggi: " + maxAcceleration);

        int minAcceleration = showroom.minAcceleration(0, showroom.top_acceleration.length - 1);
        System.out.println("Top Acceleration terendah: " + minAcceleration);

        double averagePower = showroom.averagePower();
        System.out.println("Rata-rata Top Power: " + averagePower);
    }
}

- Hasil Percobaan

![alt text](<Screenshot 2024-03-24 122548.png>)



