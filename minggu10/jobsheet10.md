## <center> LAPORAN HASIL PRAKTIKUM JOBSHEET 10

<p align="center"> 
<img src="logo polinema.png" width="300px">

 <p align="center">  Nama : Nur Ayu Lailatul Azizah
 <p align="center">  Kelas : TI 1 H
 <p align="center">  NIM : 2341720044

<center> Jln.Soekarno Hatta No.9, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 6
<center>Phone: (0341) 404424,404425
<center>E-mail: Polinema.ac.id

## <center> JOBSHEET X
## <center> STACK

#### 2.1 Praktikum 1

- Hasil Program pencarian
``` java
package minggu10;

import java.util.Scanner;

public class Queue {
    int[] data;
    int front;
    int rear;
    int size;
    int max;

    public Queue(int n) {
        max = n;
        data = new int[max];
        size = 0;
        front = rear = -1;
    }

    public boolean IsEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    public void peek() {
        if (!IsEmpty()) {
            System.out.println("Elemen terdepan: " + data[front]);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void print() {
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.print(data[i] + " ");
                i = (i + 1) % max;
            } 
            System.out.println(data[i] + " ");
            System.out.println("Jumlah elemen = " + size);
        }
    }

    public void clear() {
        if (!IsEmpty()) {
            front = rear = -1;
            size = 0;
            System.out.println("Queue berhasil dikosongkan");
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void Enqueue(int dt) {
        if (IsFull()) {
            System.out.println("Queue sudah penuh");
        } else {
            if (IsEmpty()) {
                front = rear = 0;
            } else {
                if (rear == max - 1) {
                    rear = 0;
                } else {
                    rear++;
                }
            }
            data[rear] = dt;
            size++;
        }
    }

    public int Dequeue() {
        int dt = 0;
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            dt = data[front];
            size--;
            if (IsEmpty()) {
                front = rear = -1;
            } else {
                if (front == max -1) {
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return dt;
    }

    public static void menu() {
        System.out.println("Masukkan operasi yang diinginkan: ");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek");
        System.out.println("5. Clear");
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue: ");

        int n = sc.nextInt();
        Queue Q = new Queue(n);

        int pilih;
        do {
            menu();
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("Masukkan data baru: ");
                    int dataMasuk = sc.nextInt();
                    Q.Enqueue(dataMasuk);
                    break;
                case 2:
                    int dataKeluar = Q.Dequeue();
                    if (dataKeluar != 0) {
                        System.out.println("Data yang dikeluarkan: " + dataKeluar);
                        break;
                    }
                case 3:
                    Q.print();
                    break;
                case 4:
                    Q.peek();
                    break;
                case 5:
                    Q.clear();
                    break;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5);
    }
}
```

- Verifikasi Hasil Percobaan

![alt text](<Screenshot 2024-05-01 185630.png>)

- Pertanyaan
1. Pada konstruktor, mengapa nilai awal atribut front dan rear bernilai -1, sementara atribut size bernilai 0?
2. Pada method Enqueue, jelaskan maksud dan kegunaan dari potongan kode berikut!
```java
if (rear == max -1) {
    rear = 0;
}
```
3. Pada method Dequeue, jelaskan maksud dan kegunaan dari potongan kode berikut!
```java
if (rear == max -1) {
    rear = 0;
}
```
4. Pada method print, mengapa pada proses perulangan variabel i tidak dimulai dari 0 (int i=0), melainkan int i=front?
5. Perhatikan kembali method print, jelaskan maksud dari potongan kode berikut!
```java
i = (i + l) % max;
```
6. Tunjukkan potongan kode program yang merupakan queue overflow!
7. Pada saat terjadi queue overflow dan queue underflow, program tersebut tetap dapat berjalan dan hanya menampilkan teks informasi. Lakukan modifikasi program sehingga pada saat terjadi queue overflow dan queue underflow, program dihentikan!

- Jawaban 
1. Karena kondisi tersebut menunjukkan bahwa antrian masih kosong.
2. Potongan kode tersebut digunakan untuk menangani kasus dimana rear sudah berada diujung maksimum array dan masih terdapat ruangan kosong diawal array.
3. Potongan kode tersebut memiliki maksud dan kegunaan untuk mengatur kembali nilai rear ke 0 jika rear sudah mencapai batas maksimum array dan masih ada elemen diantrian yang perlu dihapus.
4. Penggunaan tersebut memiliki tujuan untuk memulai iterasi dari elemen terdepan dalam antrian.
5. Potongan kode tersebut digunakan untuk mengatur indeks iterasi i agar melingkar kembali keawal array jika sudah mencapai batas maksimum array(max).
6. Potongan kode tersebut terdapat pada method Enqueue
```java
if (rear == max - 1) {
```
7. 
```java
package minggu10;

import java.util.Scanner;

public class Queue {
    int[] data;
    int front;
    int rear;
    int size;
    int max;

    public Queue(int n) {
        max = n;
        data = new int[max];
        size = 0;
        front = rear = -1;
    }

    public boolean IsEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean IsFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    public void peek() {
        if (!IsEmpty()) {
            System.out.println("Elemen terdepan: " + data[front]);
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void print() {
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
        } else {
            int i = front;
            while (i != rear) {
                System.out.print(data[i] + " ");
                i = (i + 1) % max;
            } 
            System.out.println(data[i] + " ");
            System.out.println("Jumlah elemen = " + size);
        }
    }

    public void clear() {
        if (!IsEmpty()) {
            front = rear = -1;
            size = 0;
            System.out.println("Queue berhasil dikosongkan");
        } else {
            System.out.println("Queue masih kosong");
        }
    }

    public void Enqueue(int dt) {
        if (IsFull()) {
            System.out.println("Queue sudah penuh");
            System.exit(0);
        } else {
            if (IsEmpty()) {
                front = rear = 0;
            } else {
                if (rear == max - 1) {
                    rear = 0;
                } else {
                    rear++;
                }
            }
            data[rear] = dt;
            size++;
        }
    }

    public int Dequeue() {
        int dt = 0;
        if (IsEmpty()) {
            System.out.println("Queue masih kosong");
            System.exit(0);
        } else {
            dt = data[front];
            size--;
            if (IsEmpty()) {
                front = rear = -1;
            } else {
                if (front == max -1) {
                    front = 0;
                } else {
                    front++;
                }
            }
        }
        return dt;
    }

    public static void menu() {
        System.out.println("Masukkan operasi yang diinginkan: ");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. Print");
        System.out.println("4. Peek");
        System.out.println("5. Clear");
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue: ");

        int n = sc.nextInt();
        Queue Q = new Queue(n);

        int pilih;
        do {
            menu();
            pilih = sc.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("Masukkan data baru: ");
                    int dataMasuk = sc.nextInt();
                    Q.Enqueue(dataMasuk);
                    break;
                case 2:
                    int dataKeluar = Q.Dequeue();
                    if (dataKeluar != 0) {
                        System.out.println("Data yang dikeluarkan: " + dataKeluar);
                        break;
                    }
                case 3:
                    Q.print();
                    break;
                case 4:
                    Q.peek();
                    break;
                case 5:
                    Q.clear();
                    break;
            }
        } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5);
    }
}
```
Hasil Modifikasi

![alt text](<Screenshot 2024-05-06 083505.png>)


#### 2.2 Praktikum 2:

- Hasil Program

``` java
package minggu10;

import java.util.Scanner;

public class Nasabah {
    String norek;
    String nama;
    String alamat;
    int umur;
    double saldo;

    Nasabah(String norek,  String nama,  String alamat,  int umur, double saldo) {
        this.norek = norek;
        this.nama = nama;
        this.alamat = alamat;
        this.umur = umur;
        this.saldo = saldo;
    }
    
    Nasabah() {
        
    }

    public static class Queue {
        Nasabah[] data;
        int front;
        int rear;
        int size;
        int max;
    
        public Queue(int n) {
            max = n;
            data = new Nasabah[max];
            size = 0;
            front = rear = -1;
        }
    
        public boolean IsEmpty() {
            if (size == 0) {
                return true;
            } else {
                return false;
            }
        }
    
        public boolean IsFull() {
            if (size == max) {
                return true;
            } else {
                return false;
            }
        }
    
        public void peek() {
            if (!IsEmpty()) {
                System.out.println("Elemen terdepan: " + data[front].norek + " " + data[front].nama + " " + data[front].alamat + " " + data[front].umur + " " + data[front].saldo);
            } else {
                System.out.println("Queue masih kosong");
            }
        }
    
        public void print() {
            if (IsEmpty()) {
                System.out.println("Queue masih kosong");
            } else {
                int i = front;
                while (i != rear) {
                    System.out.println("Nasabah: " + data[i].norek + " " + data[i].nama + " " + data[i].alamat + " " + data[i].umur + " " + data[i].saldo);
                    i = (i + 1) % max;
                } 
                System.out.println(data[i].norek + " " + data[i].nama + " " + data[i].alamat + " " + data[i].umur + " " + data[i].saldo);
                System.out.println("Jumlah elemen = " + size);
            }
        }
    
        public void clear() {
            if (!IsEmpty()) {
                front = rear = -1;
                size = 0;
                System.out.println("Queue berhasil dikosongkan");
            } else {
                System.out.println("Queue masih kosong");
            }
        }
    
        public void Enqueue(Nasabah dt) {
            if (IsFull()) {
                System.out.println("Queue sudah penuh");
            } else {
                if (IsEmpty()) {
                    front = rear = 0;
                } else {
                    if (rear == max - 1) {
                        rear = 0;
                    } else {
                        rear++;
                    }
                }
                data[rear] = dt;
                size++;
            }
        }
    
        public Nasabah Dequeue() {
            Nasabah dt = new Nasabah();
            if (IsEmpty()) {
                System.out.println("Queue masih kosong");
            } else {
                dt = data[front];
                size--;
                if (IsEmpty()) {
                    front = rear = -1;
                } else {
                    if (front == max -1) {
                        front = 0;
                    } else {
                        front++;
                    }
                }
            }
            return dt;
        }
    }

    public static void menu() {
        System.out.println("Pilih menu: ");
        System.out.println("1. Antrian baru");
        System.out.println("2. Antrian keluar");
        System.out.println("3. Cek Antrian terdepan");
        System.out.println("4. Cek Semua Antrian");
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue: ");

        int jumlah = sc.nextInt();
        Queue antri = new Queue(jumlah);

        int pilih;
        do {
            menu();
            pilih = sc.nextInt();
            sc.nextLine();
            switch (pilih) {
                case 1:
                    System.out.print("No Rekening: ");
                    String norek = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Alamat: ");
                    String alamat = sc.nextLine();
                    System.out.print("Umur: ");
                    int umur = sc.nextInt();
                    System.out.print("Saldo: ");
                    double saldo = sc.nextDouble();
                    Nasabah nb = new Nasabah (norek, nama, alamat, umur, saldo);
                    sc.nextLine();
                    antri. Enqueue (nb);
                    break;
                case 2:
                Nasabah data = antri.Dequeue();
                if (! "".equals(data.norek) &&!"".equals(data.nama) && !"".equals(data.alamat) && data.umur != 0 && data.saldo != 0) {
                    System.out.println("Antrian yang keluar: " + data.norek + ""+data.nama + data.alamat + " " + data.umur + ""+ data.saldo);
                    break;
                }
                case 3:
                    antri.peek();
                    break;
                case 4:
                antri.print();
                break;
            }
        }while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4);
    }
}
```

- Verifikasi Hasil Percobaan

![alt text](<Screenshot 2024-05-03 181635.png>)

![alt text](<Screenshot 2024-05-03 181651.png>)

- Pertanyaan
1. Pada class QueueMain, jelaskan fungsi IF pada potongan kode program berikut!
```java
                if (! "".equals(data.norek) &&!"".equals(data.nama) && !"".equals(data.alamat) && data.umur != 0 && data.saldo != 0) {
                    System.out.println("Antrian yang keluar: " + data.norek + ""+data.nama + data.alamat + " " + data.umur + ""+ data.saldo);
                    break;
                }
```
2. Lakukan modifikasi program dengan menambahkan method baru bernama peekRear pada class Queue yang digunakan untuk mengecek antrian yang berada di posisi belakang! Tambahkan pula daftar menu 5. Cek Antrian paling belakang pada class QueueMain sehingga method peekRear dapat dipanggil!


jawaban 
1. Fungsi potongan kode program tersebut adalah untuk memeriksa apakah semua atribut objek data dalam class QueueMain memiliki nilai yang valid sebelum mencetak informasi antrian yang keluar
2. 
```java
package minggu10;

import java.util.Scanner;

public class Nasabah {
    String norek;
    String nama;
    String alamat;
    int umur;
    double saldo;

    Nasabah(String norek,  String nama,  String alamat,  int umur, double saldo) {
        this.norek = norek;
        this.nama = nama;
        this.alamat = alamat;
        this.umur = umur;
        this.saldo = saldo;
    }
    
    Nasabah() {
        
    }

    public static class Queue {
        Nasabah[] data;
        int front;
        int rear;
        int size;
        int max;
    
        public Queue(int n) {
            max = n;
            data = new Nasabah[max];
            size = 0;
            front = rear = -1;
        }
    
        public boolean IsEmpty() {
            if (size == 0) {
                return true;
            } else {
                return false;
            }
        }
    
        public boolean IsFull() {
            if (size == max) {
                return true;
            } else {
                return false;
            }
        }
    
        public void peek() {
            if (!IsEmpty()) {
                System.out.println("Elemen terdepan: " + data[front].norek + " " + data[front].nama + " " + data[front].alamat + " " + data[front].umur + " " + data[front].saldo);
            } else {
                System.out.println("Queue masih kosong");
            }
        }

        public void peekRear() {
            if (!IsEmpty()) {
                System.out.println("Elemen terbelakang: " + data[rear].norek + " " + data[rear].nama + " " + data[rear].alamat + " " + data[rear].umur + " " + data[rear].saldo);
            } else {
                System.out.println("Queue masih kosong");
            }
        }
    
        public void print() {
            if (IsEmpty()) {
                System.out.println("Queue masih kosong");
            } else {
                int i = front;
                while (i != rear) {
                    System.out.println("Nasabah: " + data[i].norek + " " + data[i].nama + " " + data[i].alamat + " " + data[i].umur + " " + data[i].saldo);
                    i = (i + 1) % max;
                } 
                System.out.println(data[i].norek + " " + data[i].nama + " " + data[i].alamat + " " + data[i].umur + " " + data[i].saldo);
                System.out.println("Jumlah elemen = " + size);
            }
        }
    
        public void clear() {
            if (!IsEmpty()) {
                front = rear = -1;
                size = 0;
                System.out.println("Queue berhasil dikosongkan");
            } else {
                System.out.println("Queue masih kosong");
            }
        }
    
        public void Enqueue(Nasabah dt) {
            if (IsFull()) {
                System.out.println("Queue sudah penuh");
            } else {
                if (IsEmpty()) {
                    front = rear = 0;
                } else {
                    if (rear == max - 1) {
                        rear = 0;
                    } else {
                        rear++;
                    }
                }
                data[rear] = dt;
                size++;
            }
        }
    
        public Nasabah Dequeue() {
            Nasabah dt = new Nasabah();
            if (IsEmpty()) {
                System.out.println("Queue masih kosong");
            } else {
                dt = data[front];
                size--;
                if (IsEmpty()) {
                    front = rear = -1;
                } else {
                    if (front == max -1) {
                        front = 0;
                    } else {
                        front++;
                    }
                }
            }
            return dt;
        }
    }

    public static void menu() {
        System.out.println("Pilih menu: ");
        System.out.println("1. Antrian baru");
        System.out.println("2. Antrian keluar");
        System.out.println("3. Cek Antrian terdepan");
        System.out.println("4. Cek Semua Antrian");
        System.out.println("5. Cek Antrian paling belakang");
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue: ");

        int jumlah = sc.nextInt();
        Queue antri = new Queue(jumlah);

        int pilih;
        do {
            menu();
            pilih = sc.nextInt();
            sc.nextLine();
            switch (pilih) {
                case 1:
                    System.out.print("No Rekening: ");
                    String norek = sc.nextLine();
                    System.out.print("Nama: ");
                    String nama = sc.nextLine();
                    System.out.print("Alamat: ");
                    String alamat = sc.nextLine();
                    System.out.print("Umur: ");
                    int umur = sc.nextInt();
                    System.out.print("Saldo: ");
                    double saldo = sc.nextDouble();
                    Nasabah nb = new Nasabah (norek, nama, alamat, umur, saldo);
                    sc.nextLine();
                    antri. Enqueue (nb);
                    break;
                case 2:
                Nasabah data = antri.Dequeue();
                if (! "".equals(data.norek) &&!"".equals(data.nama) && !"".equals(data.alamat) && data.umur != 0 && data.saldo != 0) {
                    System.out.println("Antrian yang keluar: " + data.norek + ""+data.nama + data.alamat + " " + data.umur + ""+ data.saldo);
                    break;
                }
                case 3:
                    antri.peek();
                    break;
                case 4:
                    antri.print();
                    break;
                case 5:
                    antri.peekRear();
                    break;
            }
        }while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4);
    }
}
```
Hasil Modifikasi

![alt text](<Screenshot 2024-05-04 091230.png>)

#### 2.4 Latihan Praktikum

- ketentuan 
Buatlah program antrian untuk mengilustasikan pesanan disebuah warung. Ketika seorang
pembeli akan mengantri, maka dia harus mendaftarkan nama, dan nomor HP seperti yang
digambarkan pada Class diagram berikut:
Pembeli
nama: String
noHP: int
Pembeli(nama: String, noHP: int)

Class diagram Queue digambarkan sebagai berikut:
Queue
antrian: Pembeli[]
front: int
rear: int
size: int
max: int
Queue(n: int)
isEmpty(): boolean
isFull(): boolean
enqueue(antri: Pembeli): void
dequeue(): int
print(): void
peek(): void
peekRear(): void
peekPosition(nama: String): void
daftarPembeli(): void

Keterangan:
• Method create(), isEmpty(), isFull(), enqueue(), dequeue() dan print(), kegunaannya sama seperti yang telah dibuat pada Praktikum
• Method peek(): digunakan untuk menampilkan data Pembeli yang berada di posisi antrian paling depan
• Method peekRear(): digunakan untuk menampilkan data Pembeli yang berada di posisi antrian paling belakang
• Method peekPosition(): digunakan untuk menampilkan seorang pembeli (berdasarkan nama) posisi antrian ke berapa
• Method daftarPembeli(): digunakan untuk menampilkan data seluruh pembeli 

- Hasil Program
``` java  
package minggu10;

import java.util.Scanner;

public class Pembeli {
    String nama;
    int noHP;

    Pembeli(String nama, int noHP) {
        this.nama = nama;
        this.noHP = noHP;
    }

    public static class Queue {
        Pembeli[] antrian;
        int front;
        int rear;
        int size;
        int max;

        public Queue(int n) {
            max = n;
            antrian = new Pembeli[max];
            size = 0;
            front = rear = -1;
        }

        public boolean IsEmpty() {
            if (size == 0) {
                return true;
            } else {
                return false;
            }
        }
    
        public boolean IsFull() {
            if (size == max) {
                return true;
            } else {
                return false;
            }
        }

        public void peek() {
            if (!IsEmpty()) {
                System.out.println("Pembelian terdepan: " + antrian[front].nama + " " + antrian[front].noHP);
            } else {
                System.out.println("Antrian masih kosong");
            }
        }

        public void peekRear() {
            if (!IsEmpty()) {
                System.out.println("Pembelian terbelakang: " + antrian[rear].nama + " " + antrian[rear].noHP);
            } else {
                System.out.println("Antrian masih kosong");
            }
        }

        public void peekPosition(String nama) {
            if (!IsEmpty()) {
                for (int i = 0; i < size; i++) {
                    if (antrian[i].nama.equals(nama)) {
                        System.out.println("Pembeli " + nama + " berada diposisi antrian ke-" + (i + 1));
                        return;
                    }
                }
                System.out.println("Pembeli " + nama + " tidak ditemukan dalam antrian");
            } else {
                System.out.println("Antrian masih kosong");
            }
        }

        public void print() {
            if (IsEmpty()) {
                System.out.println("Antrian masih kosong");
            } else {
                int i = front;
                while (i != rear) {
                    System.out.println("Pembeli: " + antrian[i].nama + " " + antrian[i].noHP);
                    i = (i + 1) % max;
                } 
                System.out.println("Pembeli: " + antrian[i].nama + " " + antrian[i].noHP);
                System.out.println("Jumlah elemen = " + size);
            }
        }

        public void daftarPembeli() {
            if (IsEmpty()) {
                System.out.println("Antrian masih kosong");
            } else {
                System.out.println("Daftar Anggota Pembeli keseluruhan: ");
                for (int i = 0; i < max; i++) {
                    if (antrian[i] != null) {
                    System.out.println((i + 1) + ". " + antrian[i].nama + " " + antrian[i].noHP);
                } else {
                    System.out.println((i + 1) + ". Data dihapus");
                    }
                }
            }
        }

        public void Enqueue(Pembeli pembeli) {
            if (IsFull()) {
                System.out.println("Queue sudah penuh");
            } else {
                if (IsEmpty()) {
                    front = rear = 0;
                } else {
                    if (rear == max - 1) {
                        rear = 0;
                    } else {
                        rear++;
                    }
                }
                antrian[rear] = pembeli;
                size++;
            }
        }

        public int Dequeue() {
            Pembeli pembeli = null;
            if (IsEmpty()) {
                System.out.println("Queue masih kosong");
            } else {
                pembeli = antrian[front];
                size--;
                if (IsEmpty()) {
                    front = rear = -1;
                } else {
                    if (front == max -1) {
                        front = 0;
                    } else {
                        front++;
                    }
                }
            }
            return front;
            }
        } 
    
    public static void menu() {
        System.out.println("Pilih menu: ");
        System.out.println("1. Tambah Pembeli");
        System.out.println("2. Hapus Pembeli Terdepan");
        System.out.println("3. Cek Pembeli Terdepan");
        System.out.println("4. Cek Pembeli Terbelakang");
        System.out.println("5. Cek Posisi Antrean");
        System.out.println("6. Cek Posisi Pembeli");
        System.out.println("7. Daftar Pembeli");
        System.out.println("----------------------------------");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan kapasitas queue: ");

        int jumlah = sc.nextInt();
        sc.nextLine();
        Queue antrian = new Queue(jumlah);

        int pilih;
        do {
            menu();
            pilih = sc.nextInt();
            sc.nextLine();
            switch (pilih) {
                case 1:
                    System.out.print("Nama Pembeli: ");
                    String nama = sc.nextLine();
                    System.out.print("Nomor HP: ");
                    int noHP = sc.nextInt();
                    sc.nextLine();
                    Pembeli pembeli = new Pembeli(nama, noHP);
                    antrian.Enqueue(pembeli);
                    break;
                case 2:
                    int idx = antrian.Dequeue();
                    if (idx != -1) {
                        System.out.println("Pembeli terdepan telah dihapus");
                    }
                    break;
                case 3:
                    antrian.peek();
                    break;
                case 4:
                    antrian.peekRear();
                    break;
                case 5:
                    antrian.print();
                    break;
                case 6:
                    System.out.print("Nama Pembeli: ");
                    String cariNama = sc.nextLine();
                    antrian.peekPosition(cariNama);
                    break;
                case 7:
                    antrian.daftarPembeli();
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5 || pilih == 6 || pilih == 7);
    }
}
```
- Hasil Percobaan

![alt text](<Screenshot 2024-05-06 001847.png>)

![alt text](<Screenshot 2024-05-06 001904.png>)

![alt text](<Screenshot 2024-05-06 001932.png>)

![alt text](<Screenshot 2024-05-06 002128.png>)



