## <center> LAPORAN HASIL PRAKTIKUM JOBSHEET 4

<p align="center"> 
<img src="logo polinema.png" width="300px">


 <p align="center">  Nama : Nur Ayu Lailatul Azizah
 <p align="center">  Kelas : TI 1 H
 <p align="center">  NIM : 2341720044

<center> Jln.Soekarno Hatta No.9, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 6
<center>Phone: (0341) 404424,404425
<center>E-mail: Polinema.ac.id

<center> ## JOBSHEET II
<center> ## OBJECT

#### 2.1 Percobaan 1: Deklarasi Class, Atribut dan Method

- Hasil Program

  package pt_2;

public class Buku21 {

   String judul, pengarang;

   int halaman, stok, harga;
   
   void tampilInformasi() {
    
        System.out.println("Judul: " + judul);

        System.out.println("pengarang: " + pengarang);

        System.out.println("Jumlah halaman: " + halaman);

        System.out.println("Sisa Stok: " + stok);

        System.out.println("Harga: " + harga);
    }

   void terjual(int jml){

        stok -= jml;

    }

    void restock(int jml){

        stok += jml;

    }

    void gantiHarga(int hrg){

        harga = hrg;

    }

}


- Verifikasi Hasil Percobaan

![alt text](<Screenshot 2024-02-19 102838.png>)
- Pertanyaan
1. atribut dan method
2. memiliki 5 atribut yaitu judul(string), pengarang(String), halaman(int), stok(int), harga(int)
3. 3 method yaitu tampilInformasi(), terjual(int jml), restock(int jml)
4.    void terjual(int jml){

       if (stok > 0) {

            stok -= jml;

       }

    }
5. karena parameter tersebut menentukan jumlah tambahan stok yang akan ditambahkan. Dengan demikian, pengguna dapat menentukan seberapa banyak buku yang akan ditambahkan kedalam stok dengan menambahkan nilai numerik ke parameter.

#### 2.2 Percobaan 2: Instansiasi Object, serta Mengakses Atribut dan Method

- Hasil Program
  
  package pt_2;

    public class BukuMain21 {

    public static void main(String[] args) {
        
    Buku21 bk1 = new Buku21();

    bk1.judul = "Today Ends Tomorrow Comes";

    bk1.pengarang = "Denanda Pratiwi";

    bk1.halaman = 198;

    bk1.stok = 13;

    bk1.harga = 71000;

    bk1.tampilInformasi();

    bk1.terjual(5);

    bk1.gantiHarga(60000);

    bk1.tampilInformasi();

    }

}


- Verifikasi Hasil Percobaan

![alt text](<Screenshot 2024-02-25 194857.png>)  
- Pertanyaan
1. Pada class BukuMain, tunjukkan baris kode program yang digunakan untuk proses instansiasi!
Apa nama object yang dihasilkan?
1. Bagaimana cara mengakses atribut dan method dari suatu objek?
2. Mengapa hasil output pemanggilan method tampilInformasi() pertama dan kedua berbeda?
   
- jawaban
  1. Buku21 bk1 = new Buku21();
   nama objek yang dihasilkan adalah bk1
  2. untuk mengaksesnya dari suatu objek digunakan operator titik('.'). seperti bk1.judul atau bk1.terjual()
  3. karena setelah pemanggilan method terjual(5) stok buku bk1 berkurang menjadi 88 sehingga saat method tampilInformasi() dipanggil kembali informasi yang di tampilkan akan muncul perubahan tersebut.

#### 2.3 Percobaan 3: Membuat Konstruktor
- Program Pertama
- Hasil Program
  
  package pt_2;

public class Buku21 {

   String judul, pengarang;

   int halaman, stok, harga;

   public Buku21() {
   
}

        public Buku21(String jud, String pg, int hal, int stok, int har) {

        judul = jud;

        pengarang = pg;

        halaman = hal;

        this.stok = stok;

        harga = har;

}
   
   void tampilInformasi() {

        System.out.println("Judul: " + judul);

        System.out.println("pengarang: " + pengarang);

        System.out.println("Jumlah halaman: " + halaman);

        System.out.println("Sisa Stok: " + stok);

        System.out.println("Harga: " + harga);

    }

   void terjual(int jml){

        stok -= jml;

    }

    void restock(int jml){

        stok += jml;

    }

    void gantiHarga(int hrg){

        harga = hrg;

    }

    int hitungHargaTotal() {

        return harga * stok;

    }

}

- Program Kedua
- Hasil Program
  
package pt_2;

public class BukuMain21 {

    public static void main(String[] args) {
        
    Buku21 bk1 = new Buku21();

    bk1.judul = "Today Ends Tomorrow Comes";

    bk1.pengarang = "Denanda Pratiwi";

    bk1.halaman = 198;

    bk1.stok = 13;

    bk1.harga = 71000;

    bk1.tampilInformasi();

    bk1.terjual(5);

    bk1.gantiHarga(60000);

    bk1.tampilInformasi();

    Buku21 bk2 = new Buku21("Self Reward", "Maheera Ayesha", 160, 29, 59000);

    bk2.terjual(11);

    bk2.tampilInformasi();

    }

}

- Verifikasi Hasil Percobaan

![alt text](<Screenshot 2024-02-25 195855.png>)  
- Pertanyaan
1. Pada class Buku di Percobaan 3, tunjukkan baris kode program yang digunakan untuk
mendeklarasikan konstruktor berparameter!
2. Perhatikan class BukuMain. Apa sebenarnya yang dilakukan pada baris program berikut?
3. Hapus konstruktor default pada class Buku, kemudian compile dan run program. Bagaimana
hasilnya? Jelaskan mengapa hasilnya demikian!
4. Setelah melakukan instansiasi object, apakah method di dalam class Buku harus diakses
secara berurutan? Jelaskan alasannya!
5. Buat object baru dengan nama buku<NamaMahasiswa> menggunakan konstruktor
berparameter dari class Buku!

- jawaban
1. public Buku21(String jud, String pg, int hal, int stok, int har) {
 
        judul = jud;

        pengarang = pg;

        halaman = hal;

        this.stok = stok;

        harga = har;

}
2. pada baris program tersebut, objek bk2 dari class Buku 21 dibuat menggunakan konstruktor berparameter. Konstruktor ini menginialisasi nilai atribut pada saat pembuatan objek.
3. 
![alt text](<Screenshot 2024-02-25 202330.png>)

   Akan terjadi kesalahan kompilasi. Hal ini terjadi karena menghapus konstruktor default, tidak ada konstruktor yang bisa di gunakan untuk membuat objek tanpa parameter.

4. tidak, karena kita dapat memanggil method manapun di dalam class buku sesuai kebutuhan atau urutan yang diinginkan.

5. package pt_2;

public class BukuMain21 {

    public static void main(String[] args) {
        
    Buku21 bk1 = new Buku21();

    bk1.judul = "Today Ends Tomorrow Comes";

    bk1.pengarang = "Denanda Pratiwi";

    bk1.halaman = 198;

    bk1.stok = 13;

    bk1.harga = 71000;

    bk1.tampilInformasi();

    bk1.terjual(5);

    bk1.gantiHarga(60000);

    bk1.tampilInformasi();

    Buku21 bk2 = new Buku21("Self Reward", "Maheera Ayesha", 160, 29, 59000);

    bk2.terjual(11);

    bk2.tampilInformasi();

    Buku21 bukuMahasiswa = new Buku21("Ayat Ayat Cinta", "Tereliye", 150, 10, 50000);

    bukuMahasiswa.tampilInformasi();

    }

}

![alt text](<Screenshot 2024-02-25 210500.png>)

#### 2.4 Latihan Praktikum

#### 2.4.1 Menambahkan Metode

- Program Pertama
- Hasil Program
  
package pt_2;

public class Buku21 {

   String judul, pengarang;

   int halaman, stok, harga;

   public Buku21() {
   
}
        public Buku21(String jud, String pg, int hal, int stok, int har) {

        judul = jud;

        pengarang = pg;

        halaman = hal;

        this.stok = stok;

        harga = har;
}
   
   void tampilInformasi() {

        System.out.println("Judul: " + judul);

        System.out.println("pengarang: " + pengarang);

        System.out.println("Jumlah halaman: " + halaman);

        System.out.println("Sisa Stok: " + stok);

        System.out.println("Harga: " + harga);

    }

   void terjual(int jml){

        stok -= jml;

    }

    void restock(int jml){

        stok += jml;

    }

    void gantiHarga(int hrg){

        harga = hrg;

    }

    int hitungHargaTotal() {

        return harga * stok;

    }

    int hitungDiskon() {

        int hargaTotal = hitungHargaTotal();

        if (hargaTotal > 150000) {

            return hargaTotal * 12 / 100;   

        } else if (hargaTotal >= 150000) {

            return hargaTotal * 5 / 100;

        } else {

            return 0;

        }

    }

    int hitungBayar() {

        int hargaTotal = hitungHargaTotal();

        int diskon = hitungDiskon();

        return hargaTotal - diskon;

    }

}

- Program Kedua
- Hasil Program
  
  package pt_2;

public class BukuMain21 {

    public static void main(String[] args) {
        
    Buku21 bk1 = new Buku21();

    bk1.judul = "Today Ends Tomorrow Comes";
    bk1.pengarang = "Denanda Pratiwi";

    bk1.halaman = 198;

    bk1.stok = 13;

    bk1.harga = 71000;

    bk1.tampilInformasi();

    System.out.println("Total harga: " + bk1.hitungHargaTotal());

    System.out.println("Diskon: " + bk1.hitungDiskon());

    System.out.println("Total Bayar: " + bk1.hitungBayar());

    bk1.terjual(5);

    bk1.gantiHarga(60000);

    bk1.tampilInformasi();

    Buku21 bk2 = new Buku21("Self Reward", "Maheera Ayesha", 160, 29, 59000);

    bk2.terjual(11);

    bk2.tampilInformasi();

    System.out.println("Total Harga: " + bk2.hitungHargaTotal());

    System.out.println("Diskon: " + bk2.hitungDiskon());

    System.out.println("Total Bayar: " + bk2.hitungBayar());

    }

}

- Hasil Percobaan
  
![alt text](<Screenshot 2024-02-25 204034.png>)  

#### 2.4.2 Membuat Permainan
#### Dragon

- Hasil Program
  
package pt_2;

import java.util.Scanner;

public class Dragon21 {

    int x, y, width, height;

    Scanner sc = new Scanner(System.in);    

    void moveLeft() {

        x -= 1;

        if (x < 0 || x > width) {

            detectCollision();

        } 

    }

    void moveRight() {

        x += 1;

        if (x < 0 || x > width) {

            detectCollision();

        }

    }

    void moveUp() {

        y -= 1;

        if (y < 0 || y > height) {

            detectCollision();

        } 

    }

    void moveDown() {

        y += 1;

        if (y < 0 || y > height) {

            detectCollision();

        } 

    }

    void printPosition() {

        System.out.println("Dragon position: " + x + ","  + y );

    }

    void detectCollision() {

        System.out.println("Game Over!");

        System.exit(0);
        
    }

    void loopingGame() {

        while (x > 0 && x < width && y > 0 && y < height) { 

            System.out.print("Masukkan left / right / up / down : ");

            String pilih = sc.nextLine();

            System.out.println();

            switch (pilih) {

                case "left":

                    moveLeft();

                    break;

                case "right":

                    moveRight();

                    break;

                case "up":

                    moveUp();
                    
                    break;

                case "down":

                    moveDown();

                    break;

                default:

                    break;

            }

            printPosition();

        }

    }

    public Dragon21() {

    }

    public Dragon21(int x, int y, int width, int height) {

        this.x = x;

        this.y = y;

        this.width = width;

        this.height = height;

    }

}


- Hasil Running

#### Dragon Main

- Hasil Program
  
  package pt_2;

public class DragonMain {

    public static void main(String[] args) {

        Dragon21 game = new Dragon21(5, 5, 10, 10);

            game.loopingGame();
    
    }
}

- Hasil Program

![alt text](<Screenshot 2024-02-25 204034.png>)  

