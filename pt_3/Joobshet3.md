## <center> LAPORAN HASIL PRAKTIKUM JOBSHEET 4

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
2. Apakah class PersegiPanjang memiliki konstruktor?Jika tidak, kenapa dilakukan pemanggilan
konstruktur pada baris program berikut :
3. Apa yang dimaksud dengan kode berikut ini:
4. Apa yang dimaksud dengan kode berikut ini:
5. Mengapa class main dan juga class PersegiPanjang dipisahkan pada uji coba 3.2?
     
- Jawaban 

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
Algoritma dan Struktur Data 2023-2024
4 Tim Ajar Algoritma dan Struktur Data 2023-2024
Jurusan Teknologi Informasi-Politeknik Negeri Malang
3. Jika diketahui terdapat class Persegi yang memiliki atribut sisi bertipe integer, maka kode
dibawah ini akan memunculkan error saat dijalankan. Mengapa?
4. Modifikasi kode program pada praktikum 3.3 agar length array menjadi inputan dengan Scanner!
5. Apakah boleh Jika terjadi duplikasi instansiasi array of objek, misalkan saja instansiasi dilakukan
pada ppArray[i] sekaligus ppArray[0]?Jelaskan !
   
- jawaban


#### 2.3 Percobaan 3: Penambahan Operasi Matematika di Dalam Method
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

![alt text](<Screenshot 2024-02-26 103025.png>)
- Pertanyaan

- jawaban


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
  
![alt text](<Screenshot 2024-02-25 204034.png>)  

#### 2.4.2 Membuat Permainan
#### Dragon

- Hasil Program


- Hasil Running

#### Dragon Main

- Hasil Program
  

- Hasil Program

![alt text](<Screenshot 2024-02-25 204034.png>)  

