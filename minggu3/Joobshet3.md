## <center> LAPORAN HASIL PRAKTIKUM JOBSHEET 3

<p align="center"> 
<img src="logo polinema.png" width="300px">

 <p align="center">  Nama : Nur Ayu Lailatul Azizah
 <p align="center">  Kelas : TI 1 H
 <p align="center">  NIM : 2341720044

<center> Jln.Soekarno Hatta No.9, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 6
<center>Phone: (0341) 404424,404425
<center>E-mail: Polinema.ac.id

<center> ## JOBSHEET III
<center> ## ARRAY OF OBJEK

#### 2.1 Percobaan 1: Membuat Array dari Object, Mengisi dan Menampilkan

- Hasil Program

  package pt_3;

public class ArrayObjects {
    public static class PersegiPanjang {
        public int panjang;
        public int lebar;
        
    }

    public static void main(String[] args) {
        PersegiPanjang[] ppArray = new PersegiPanjang[3];

        ppArray[0] = new PersegiPanjang();
        ppArray[0].panjang = 110;
        ppArray[0].lebar = 30;

        ppArray[1] = new PersegiPanjang();
        ppArray[1].panjang = 80;
        ppArray[1].lebar = 40;
        
        ppArray[2] = new PersegiPanjang();
        ppArray[2].panjang = 100;
        ppArray[2].lebar = 20;

        System.out.println("Persegi panjang ke-0, panjang: " + ppArray[0].panjang + ", lebar: " + ppArray[0].lebar);
        System.out.println("Persegi panjang ke-1, panjang: " + ppArray[1].panjang + ", lebar: " + ppArray[1].lebar);
        System.out.println("Persegi Panjang ke-2, panjang: " + ppArray[2].panjang + ", lebar: " + ppArray[2].lebar);
    }
}


- Verifikasi Hasil Percobaan

![alt text](<Screenshot 2024-02-26 094724.png>)

- Pertanyaan
1. Berdasarkan uji coba 3.2, apakah class yang akan dibuat array of object harus selalu memiliki
atribut dan sekaligus method?Jelaskan!
2. Apakah class PersegiPanjang memiliki konstruktor?Jika tidak, kenapa dilakukan pemanggilan konstruktur pada baris program berikut :
   ppArray[1] = new PersegiPanjang();
3. Apa yang dimaksud dengan kode berikut ini:
   PersegiPanjang[] ppArray = new PersegiPanjang[3];
4. Apa yang dimaksud dengan kode berikut ini:
   ppArray[1] = new PersegiPanjang();
   ppArray[1].panjang = 80;
   ppArray[1].lebar = 40;
5. Mengapa class main dan juga class PersegiPanjang dipisahkan pada uji coba 3.2?
     
- Jawaban 
1. tidak, karena class yang akan dibuat sebagai array of object tidak harus selalu memiliki atribut dan method. seperti program di atas memiliki class PersegiPanjang tetapi hanya memiliki atribut panjang dan lebar tanpa adanya method.
2. Tidak, Karena pemanggilan konstruktor pada baris program tersebut dilakukan untuk membuat objek baru dari kelas PersegiPanjang itu terjadi karena java masih memanggil konstruktor default secara implisit meskipun konstruktor default tidak didefinisikan.
3. Kode tersebut mendeklarasikan sebuah array yang berisis objek objek dari kelas PersegiPanjang
4. ppArray[1] = new PersegiPanjang();
   adalah pembuatan objek baru dari kelas PersegiPanjang dan menyimpannya di indeks ke 1 dari array ppArray
   ppArray[1].panjang = 80;
   mengatur nilai panjang dari objaek pada indeks ke 1 dari array ppArray menjadi 80
   ppArray[1].lebar = 40;
   mengatur nilai lebar dari objaek pada indeks ke 1 dari array ppArray menjadi 40
5. untuk membantu menjaga kode program agar lebih terorganisir, mudah dibaca, dan lebih mudah rawat.

#### 2.2 Percobaan 2: Menerima Input Isian Array Menggunakan Looping

- Hasil Program
  
 package pt_3;
import java.util.Scanner;
public class ArrayObjects {
    public static class PersegiPanjang {
        public int panjang;
        public int lebar;
        
    }

    public static void main(String[] args) {
        PersegiPanjang[] ppArray = new PersegiPanjang[3];

        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 3; i++) {
            ppArray[i] = new PersegiPanjang();
            System.out.println("Persegi panjang ke- " + i);
            System.out.print("Masukkan panjang: ");
            ppArray[i].panjang = sc.nextInt();
            System.out.print("Masukkan lebar: ");
            ppArray[i].lebar = sc.nextInt();
        }
        for(int i = 0; i < 3; i++) {
            System.out.println("Persegi panjang ke- " + i);
            System.out.println("Panjang: " + ppArray[i].panjang + ", lebar: " + ppArray[i].lebar);
        }
    }
}



- Verifikasi Hasil Percobaan

![alt text](<Screenshot 2024-02-26 101118.png>)

- Pertanyaan
1. Apakah array of object dapat diimplementasikan pada array 2 Dimensi?
2. Jika jawaban soal no satu iya, berikan contohnya! Jika tidak, jelaskan!
3. Jika diketahui terdapat class Persegi yang memiliki atribut sisi bertipe integer, maka kode dibawah ini akan memunculkan error saat dijalankan. Mengapa?
   Persegi[] pgArray = new Persegi [1000];
   pgArray[5].sisi = 20;
4. Modifikasi kode program pada praktikum 3.3 agar length array menjadi inputan dengan Scanner!
5. Apakah boleh Jika terjadi duplikasi instansiasi array of objek, misalkan saja instansiasi dilakukan
pada ppArray[i] sekaligus ppArray[0]?Jelaskan !
   
- jawaban
1. Ya array of object dapat diimplementasikan pada array dua dimensi. 
2. 
   package pt_3;
import java.util.Scanner;
public class ArrayObjects {
    public static class PersegiPanjang {
        public int panjang;
        public int lebar;

        public PersegiPanjang(int panjang, int lebar) {
            this.panjang = panjang;
            this.lebar = lebar;
        }
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PersegiPanjang[][] ppArray = new PersegiPanjang[3][3];

        

        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            System.out.println("Persegi panjang ke- [" + i + "][" + j + "]");
            System.out.print("Masukkan panjang: ");
            int panjang = sc.nextInt();
            System.out.print("Masukkan lebar: ");
            int lebar = sc.nextInt();
            ppArray[i][j] = new PersegiPanjang(panjang, lebar);
            }
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
            System.out.println("Persegi panjang ke- [" + i + "][" + j + "]");
            System.out.println("Panjang: " + ppArray[i][j].panjang + ", lebar: " + ppArray[i][j].lebar);
            }
        }
    }
}
3. Persegi[] pgArray = new Persegi [1000];
   kode program tersebut tidak memiliki objek Persegi sehingga mengakibatkan pada saat mengakses kode dibawah ini 
   pgArray[5].sisi = 20;
   akan muncul NullPointerException
4. 
   package pt_3;
import java.util.Scanner;
public class ArrayObjects {
    public static class PersegiPanjang {
        public int panjang;
        public int lebar;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan panjang array: ");
        int length = sc.nextInt();
        PersegiPanjang[] ppArray = new PersegiPanjang[length];

        for(int i = 0; i < length; i++) {
            ppArray[i] = new PersegiPanjang();
            System.out.println("Persegi panjang ke- " + i);
            System.out.print("Masukkan panjang: ");
            ppArray[i].panjang = sc.nextInt();
            System.out.print("Masukkan lebar: ");
            ppArray[i].lebar = sc.nextInt();
        }
        for(int i = 0; i < length; i++) {
            System.out.println("Persegi panjang ke- " + i);
            System.out.println("Panjang: " + ppArray[i].panjang + ", lebar: " + ppArray[i].lebar);
        }
    }
}
Hasil Program 

![alt text](<Screenshot 2024-03-03 205310.png>)

5. Tidak boleh terjadi karena memungkinkan dan akan menghasilkan kesalahan komplikasi.

#### 2.3 Percobaan 3: Penambahan Operasi Matematika di Dalam Method
- Hasil Program
  
package pt_3;
import java.util.Scanner;
public class ArrayBalok {
    public static class Balok {
        public int panjang;
        public int lebar;
        public int tinggi;

       public Balok(int p, int l, int t) {
            panjang = p;
            lebar = l;
            tinggi = t;
        }

        public int hitungVolume() {
            return panjang * lebar * tinggi;
        }
    }

    public static void main(String[] args) {
       Balok[] blArray = new Balok[3];

       blArray[0] = new Balok(100, 30, 12);
       blArray[1] = new Balok(120, 40, 15);
       blArray[2] = new Balok(210, 50, 25);

        for(int i = 0; i < 3; i++) {
            System.out.println("Volume Balok ke " + i + ": " + blArray[i].hitungVolume());
        }
    }
}

- Verifikasi Hasil Percobaan
  
![alt text](<Screenshot 2024-03-03 210310.png>)

- Pertanyaan
1. Dapatkah konstruktor berjumlah lebih dalam satu kelas? Jelaskan dengan contoh!
2. Jika diketahui terdapat class Segitiga seperti berikut ini:
   public class Segitiga {
    public int alas;
    public int tinggi;
   }
Tambahkan konstruktor pada class Segitiga tersebut yang berisi parameter int a, int t yang masing-masing digunakan untuk mengisikan atribut alas dan tinggi.
3. Tambahkan method hitungLuas() dan hitungKeliling() pada class Segitiga tersebut. Asumsi segitiga adalah segitiga siku-siku. (Hint: Anda dapat menggunakan bantuan
library Math pada Java untuk mengkalkulasi sisi miring)
4. Pada fungsi main, buat array Segitiga sgArray yang berisi 4 elemen, isikan masing-masing atributnya sebagai berikut:
sgArray ke-0 alas: 10, tinggi: 4
sgArray ke-1 alas: 20, tinggi: 10
sgArray ke-2 alas: 15, tinggi: 6
sgArray ke-3 alas: 25, tinggi: 10
Kemudian menggunakan looping, cetak luas dan keliling dengan cara memanggil method hitungLuas() dan hitungKeliling().
5. Kemudian menggunakan looping, cetak luas dan keliling dengan cara memanggil method hitungLuas() dan hitungKeliling().

- jawaban
1. ya.

public class Balok {
    public int panjang;
    public int lebar;
    public int tinggi;
    
    public Balok() {
    panjang = 0;
    lebar = 0;
    tinggi = 0;
    }
    
    public Balok(int p, int 1, int t) {
    panjang = p;
    lebar = 1;
    tinggi = t;
    }
    
    public Balok(int p, int 1) {
    panjang = p;
    lebar = 1;
    tinggi = 0;
    }
    
    public Balok(int sisi) {
    panjang = sisi;
    lebar = sisi;
    tinggi = sisi;
    }
    
    public int hitungVolume() {
    return panjang * lebar * tinggi;
    }
}
2. 
   public class Segitiga {
    public int alas;
    public int tinggi;

   public Segitiga(int a, int t) {
    alas = a;
    tinggi = t;
   }
}
3. 
import java.lang.Math;
public class Segitiga {
    public int alas;
    public int tinggi;

   public Segitiga(int a, int t) {
    alas = a;
    tinggi = t;
   }
   public double hitungLuas() {
    return 0.5 * alas * tinggi;
   }
   public double hitungKeliling() {
    double sisiMiring = Math.sqrt(alas * alas + tinggi * tinggi);
    return alas + tinggi sisiMiring;
   }
}

4. 
package pt_3;
import java.lang.Math;
public class Segitiga {
    public int alas;
    public int tinggi;

   public Segitiga(int a, int t) {
    alas = a;
    tinggi = t;
   }

   public double hitungLuas() {
    return 0.5 * alas * tinggi;
   }

   public double hitungKeliling() {
    double sisiMiring = Math.sqrt(alas * alas + tinggi * tinggi);
    return alas + tinggi + sisiMiring;
   }

   public static void main(String[] args) {
        Segitiga[] sgArray = new Segitiga[4];

        sgArray[0] = new Segitiga (10, 4);
        sgArray[1] = new Segitiga (20, 10);
        sgArray[2] = new Segitiga(15, 6);
        sgArray[3] = new Segitiga (25, 10);
    }
}

5. 
    package pt_3;
import java.lang.Math;
public class Segitiga {
    public int alas;
    public int tinggi;

   public Segitiga(int a, int t) {
    alas = a;
    tinggi = t;
   }

   public double hitungLuas() {
    return 0.5 * alas * tinggi;
   }

   public double hitungKeliling() {
    double sisiMiring = Math.sqrt(alas * alas + tinggi * tinggi);
    return alas + tinggi + sisiMiring;
   }

   public static void main(String[] args) {
        Segitiga[] sgArray = new Segitiga[4];

        sgArray[0] = new Segitiga (10, 4);
        sgArray[1] = new Segitiga (20, 10);
        sgArray[2] = new Segitiga(15, 6);
        sgArray[3] = new Segitiga (25, 10);

        for (int i = 0; i < 4; i++) {
            System.out.println("Segitiga ke-" + i + ":");
            System.out.println("Alas: " + sgArray[i].alas + ", Tinggi: " + sgArray[i].tinggi);
            System.out.println("Luas: " + sgArray[i].hitungLuas());
            System.out.println("Keliling: " + sgArray[i].hitungKeliling());
            System.out.println();

        }
    }
}

   Hasil Program

![alt text](<Screenshot 2024-03-03 213241.png>)


#### 2.4 Latihan Praktikum

#### 2.4.1 Menambahkan Metode

- Program PraktikumKerucut
- Hasil Program
  
package pt_3;
import java.util.Scanner;

public class PraktikumKerucut {
    public static class Kerucut {
        public double jariJari;
        public double tinggi;
        public double sisiMiring;

        double hitungLuaspermukaan() {
            return 3.14 * jariJari * (sisiMiring + jariJari);
        }

        double tinggiKerucut() {
            tinggi = Math.sqrt((sisiMiring * sisiMiring) - (jariJari * jariJari));
            return tinggi;
        }

        double volume() {
            tinggiKerucut();
            return (3.14 * jariJari * jariJari * tinggi  ) / 3;
        }
    }
}


- Program PraktikumLimas
- Hasil Program

  package pt_3;
import java.util.Scanner;
public class PraktikumLimas {
    public static class Limas {
        public double sisiAlas;
        public double tinggi;
        public double sisiMiring;

        double sisiMiringKerucut() {
            sisiMiring = Math.sqrt(Math.pow(sisiAlas, 2) + Math.pow(tinggi, 2));
            return sisiMiring;
        }

        double hitungLuaspermukaan() {
            sisiMiringKerucut();
            return Math.pow(sisiAlas, 2) + ((sisiAlas * sisiMiring / 2) * 4);
        }

        double volume() {
            return (Math.pow(sisiAlas, 2) * tinggi) / 3;
        }
    }
}

- Program PraktikumBola
- Hasil Program

package pt_3;
import java.util.Scanner;
public class PraktikumBola {
    public static class Bola {
        public double jariJari;
        
        double hitungLuaspermukaan() {
            return (4 * 3.14 * Math.pow(jariJari, 2));
        }

        double volume() {
            return ((3.14 * Math.pow(jariJari, 3)) * 4) / 3;
        }
    }
}

- Program MainBangunRuang
- Hasil Program

package pt_3;
import java.util.Scanner;
import pt_3.PraktikumBola.Bola;
import pt_3.PraktikumKerucut.Kerucut;
import pt_3.PraktikumLimas.Limas;
public class MainBangunRuang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("KERUCUT");
        System.out.print("Masukkan jumlah kerucut: ");
        int k = sc.nextInt();
        Kerucut[] krcArray = new Kerucut[k];

        for(int i = 0; i < k; i++) {
            krcArray[i] = new Kerucut();
            System.out.println("Balok ke- " + i);
            System.out.print("Masukkan jari jari: ");
            krcArray[i].jariJari = sc.nextInt();
            System.out.print("Masukkan sisi miring: ");
            krcArray[i].sisiMiring = sc.nextInt();

        }

        System.out.println();
        for(int i = 0; i < k; i++) {
            System.out.println("Kerucut ke-" + i);
            System.out.println("Luas Permukaan: " + krcArray[i].hitungLuaspermukaan() + " Volume: " + krcArray[i].volume());
        }

        System.out.println("===========================================================================");
        System.out.println("LIMAS");
        System.out.print("Masukkan jumlah limas: ");
        int j = sc.nextInt();
        Limas[] lmsArray = new Limas[j];

        for(int f = 0; f < j; f++) {
            lmsArray[f] = new Limas();
            System.out.println("Limas ke- " + f);
            System.out.print("Masukkan sisi alas: ");
            lmsArray[f].sisiAlas = sc.nextInt();
            System.out.print("Masukkan tinggi: ");
            lmsArray[f].tinggi = sc.nextInt();

        }

        System.out.println();
        for(int f = 0; f < j; f++) {
            System.out.println("Limas ke-" + f);
            System.out.println("Luas Permukaan: " + lmsArray[f].hitungLuaspermukaan() + " volume: " + lmsArray[f].volume());
        }

        System.out.println("===========================================================================");
        System.out.println("BOLA");
        System.out.print("Masukkan jumlah bola: ");
        int o = sc.nextInt();
        Bola[] blArray = new Bola[o];

        for(int p = 0; p < o; p++) {
            blArray[p] = new Bola();
            System.out.println("Bola ke- " + p);
            System.out.print("Masukkan jari jari: ");
            blArray[p].jariJari = sc.nextInt();
        }

        System.out.println();
        for(int p = 0; p < o; p++) {
            System.out.println("Bola ke-" + p);
            System.out.println("Luas Permukaan: " + blArray[p].hitungLuaspermukaan() + " volume: " + blArray[p].volume());
        }
    }
}

- Hasil Percobaan
![alt text](<Screenshot 2024-03-03 221537.png>)
  

#### 2.4.2 Membuat informasi mahasiswa

- Hasil Program

package pt_3;
import java.util.Scanner;

public class InformasiMahasiswa {
    public static class Mahasiswa {
        public String nama;
        public String nim;
        public String jenisKelamin;
        public double ipk;
    }
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = sc.nextInt();

        Mahasiswa[] mahasiswasArray = new Mahasiswa[jumlahMahasiswa];

        for (int i = 0; i < jumlahMahasiswa; i++) {
            mahasiswasArray[i] = new Mahasiswa();
            System.out.println("Data mahasiswa ke-" + (i + 1));
            sc.nextLine();
            System.out.print("Masukkan Nama: ");
            mahasiswasArray[i].nama = sc.nextLine();
            System.out.print("Masukkan NIM: ");
            mahasiswasArray[i].nim = sc.nextLine();
            System.out.print("Masukkan jenis kelamin: ");
            mahasiswasArray[i].jenisKelamin = sc.nextLine();
            System.out.print("Masukkan IPK: ");
            mahasiswasArray[i].ipk = sc.nextDouble();
            System.out.println();
        }
        
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Data Mahasiswa ke-" + (i + 1));
            System.out.println("Nama : " + mahasiswasArray[i].nama);
            System.out.println("NIM : " + mahasiswasArray[i].nim);
            System.out.println("Jenis kelamin : " + mahasiswasArray[i].jenisKelamin);
            System.out.println("Nilai IPK : " + mahasiswasArray[i].ipk);
        }
    }
}

- Hasil Running
![alt text](<Screenshot 2024-03-03 214500.png>)
#### Modifikasi informasi mahasiswa

- Hasil Program
package pt_3;
import java.util.Scanner;

public class InformasiMahasiswa {
    public static class Mahasiswa {
        public String nama;
        public String nim;
        public String jenisKelamin;
        public double ipk;
    }
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = sc.nextInt();

        Mahasiswa[] mahasiswasArray = new Mahasiswa[jumlahMahasiswa];

        for (int i = 0; i < jumlahMahasiswa; i++) {
            mahasiswasArray[i] = new Mahasiswa();
            System.out.println("Data mahasiswa ke-" + (i + 1));
            sc.nextLine();
            System.out.print("Masukkan Nama: ");
            mahasiswasArray[i].nama = sc.nextLine();
            System.out.print("Masukkan NIM: ");
            mahasiswasArray[i].nim = sc.nextLine();
            System.out.print("Masukkan jenis kelamin: ");
            mahasiswasArray[i].jenisKelamin = sc.nextLine();
            System.out.print("Masukkan IPK: ");
            mahasiswasArray[i].ipk = sc.nextDouble();
            System.out.println();
        }

        tampilkanDataMahasiswa(mahasiswasArray, jumlahMahasiswa);
        hitungRataRataIPK(mahasiswasArray, jumlahMahasiswa);
        tampilHasilIPK(mahasiswasArray, jumlahMahasiswa);
    }

        public static void tampilkanDataMahasiswa(Mahasiswa[] mahasiswasArray, int jumlahMahasiswa) {
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Data Mahasiswa ke-" + (i + 1));
            System.out.println("Nama : " + mahasiswasArray[i].nama);
            System.out.println("NIM : " + mahasiswasArray[i].nim);
            System.out.println("Jenis kelamin : " + mahasiswasArray[i].jenisKelamin);
            System.out.println("Nilai IPK : " + mahasiswasArray[i].ipk);
        }
    }

    public static void hitungRataRataIPK(Mahasiswa[] mahasiswasArray, int jumlahMahasiswa) {
        double totalIPK = 0;
        for (int i = 0; i < jumlahMahasiswa; i++) {
            totalIPK += mahasiswasArray[i].ipk;
        }
        double rataRta = totalIPK / jumlahMahasiswa;
        System.out.println();
        System.out.println("Rata rata IPK dari " + jumlahMahasiswa + " mahasiswa " + rataRta);
    }


    public static void tampilHasilIPK(Mahasiswa[] mahasiswasArray, int jumlahMahasiswa) {
        double maxlIPK = mahasiswasArray[0].ipk;
        int indexMax = 0;
        for (int i = 1; i < jumlahMahasiswa; i++) {
            if (mahasiswasArray[i].ipk > maxlIPK) {
                maxlIPK = mahasiswasArray[i].ipk;
                indexMax = i;
            }
        }

        System.out.println();
        System.out.println("Mahasiswa dengan IPK tertinggi: ");
        System.out.println("Nama: " + mahasiswasArray[indexMax].nama);
        System.out.println("NIM: " + mahasiswasArray[indexMax].nim);
        System.out.println("Jenis kelamin: " + mahasiswasArray[indexMax].jenisKelamin);
        System.out.println("Nilai IPK: " + mahasiswasArray[indexMax].ipk);
    }
}  

- Hasil Running

 ![alt text](<Screenshot 2024-03-03 143543.png>) 



