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
## <center> DOUBLE LINKEDLIST

#### 2.1 Praktikum 1

- Hasil Program pencarian
``` java
import java.util.Scanner;

public class Node{
    int data;
    Node prev, next;

    Node(Node prev, int data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}

import java.util.Scanner;
public class DoubleLinkedList {
    Node head;
        int size;

    public DoubleLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }
        
    public void addFirst(int item) {
        if (isEmpty()) {
            head = new Node (null, item, null);
        } else {
            Node newNode = new Node (null, item, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int item) {
        if (isEmpty()) {
            addFirst (item);
        } else {
            Node current = head;
            while (current.next!= null) {
                current = current.next;
            }
            Node newNode = new Node (current, item, null);
            current.next = newNode;
            size++;
        }
    }

    public void add(int item, int index) throws Exception {
        if (isEmpty()) {
            addFirst (item);
        } else if (index < 0 || index > size) {
            throw new Exception("Nilai indeks di luar batas");
        } else {
            Node current = head;
            int i=0;
            while (i < index) {
                current = current.next;
                i++;
        }
        if (current.prev == null) {
            Node newNode = new Node (null, item, current);
            current.prev = newNode;
            head = newNode;
        } else {
            Node newNode = new Node (current.prev, item, current);
            newNode.prev = current.prev;
            newNode.next = current; 
            current.prev.next = newNode; 
            current.prev = newNode;
            }
        }
        size++;
    }
    
    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        if (!isEmpty()) {
            Node tmp = head;
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
        }
            System.out.println("\nberhasil diisi");
        } else {
            System.out.println("Linked Lists Kosong");
        }
    }

    public class DoubleLinkedLisMain {
        public static void main(String[] args) {
    
            DoubleLinkedList dll = new DoubleLinkedList();
    
            dll.print();
            System.out.println("Size: "+dll.size());
            System.out.println("===========================================");
            dll.addFirst(3);
            dll.addLast(4);
            dll.addFirst(7);
    
            dll.print();
            System.out.println("Size: "+dll.size());
            System.out.println("===========================================");
            try {
            dll.add(40, 1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    
            dll.print();
            System.out.println("Size: "+dll.size());
            System.out.println("===========================================");
            dll.clear();
    
            dll.print();
            System.out.println("Size: "+dll.size());

            System.out.println("-------------------------------------------");
            System.out.println("BUILD SUCCESS");
            System.out.println("-------------------------------------------");
        } 
    }
}
```

- Verifikasi Hasil Percobaan

![alt text](<Screenshot 2024-05-13 123235.png>)

- Pertanyaan Percobaan
1. Jelaskan perbedaan antara single linked list dengan double linked lists!
- single linkedlist hanya memiliki tautan satu arah, setiap node terdiri dari dua bagian yaotu data dan pointer dan tidak bisa kembali ke node sebelumnya.
- sedangkann double linked list setiap elemen memiliki dua tautan yaitu mengarah ke elemen berikutnya dan mengarah ke elemen sebelumnya, setiap node terdiri dari tiga bagian yaitu data pointer ke node berikutnya dan pointer ke node sebelumnya dan bisa di akses dari awal ke akhir atau sebaliknya.
2. Perhatikan class Node, di dalamnya terdapat atribut next dan prev. Untuk apakah atribut tersebut?
- atribut prev digunakan untuk menyimpan referensi ke node sebelumnya dalam linkedlist. Sedangkan atribut next digunakan untuk menyimpan referensi ke node berikutnya dalam linked list.
3. Perhatikan konstruktor pada class DoubleLinkedLists. Apa kegunaan inisialisasi atribut head dan size seperti pada gambar berikut ini?
```java
public DoubleLinkedList() {
    head = null;
    size = 0;
}
```
- kegunaan inisialisasi atribut head dan size pada class DoubleLinkedList untuk mengatur kondisi awal dari linked list objek DoubleLinkedList pertama kali dibuat.
4. Pada method addFirst(), kenapa dalam pembuatan object dari konstruktor class Node prev dianggap sama dengan null?
Node newNode = new Node(null, item, head);
- class node prev diinisialisai dengan null karena pada saat menambahkan node baru di awal, node baru tersebut tidak memiliki node sebelumnya, oleh karena itu atribut prev dari node baru di atur ke null.
5. Perhatikan pada method addFirst(). Apakah arti statement head.prev = newNode ?
- statement tersebut berfungsi untuk memperbarui referensi prev dari node yang saat ini menjadi head agar menunjuk ke node baru.
6. Perhatikan isi method addLast(), apa arti dari pembuatan object Node dengan mengisikan parameter prev dengan current, dan next dengan null?
Node newNode = new Node(current, item, null);
- Artinya adalah: Parameter prev = current menunjukkan bahwa node baru mengikuti node terakhir yang ada saat ini, sehingga current menjadi node sebelumnya dari node baru. sedangkan Parameter next = null menunjukkan bahwa node bau ini adalah node terakhir dalam list, sehingga tidak ada node berikutnya.
7. Pada method add(), terdapat potongan kode program sebagai berikut:
```java
if (current.prev == null) {
            Node newNode = new Node (null, item, current);
            current.prev = newNode;
            head = newNode;
```
jelaskan maksud dari bagian yang ditandai dengan kotak kuning.
- potongan kode di atas untuk menangani kasus dimana node baru perlu ditambahkan di awal posisi 0 dari linked list.

#### 2.2 Praktikum 2:

- Hasil Program

``` java
import java.util.Scanner;

public class Node{
    int data;
    Node prev, next;

    Node(Node prev, int data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}

import java.util.Scanner;
public class DoubleLinkedList {
    Node head;
    int size;

    public DoubleLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }
        
    public void addFirst(int item) {
        if (isEmpty()) {
            head = new Node (null, item, null);
        } else {
            Node newNode = new Node (null, item, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int item) {
        if (isEmpty()) {
            addFirst (item);
        } else {
            Node current = head;
            while (current.next!= null) {
                current = current.next;
            }
            Node newNode = new Node (current, item, null);
            current.next = newNode;
            size++;
        }
    }

    public void add(int item, int index) throws Exception {
        if (isEmpty()) {
            addFirst (item);
        } else if (index < 0 || index > size) {
            throw new Exception("Nilai indeks di luar batas");
        } else {
            Node current = head;
            int i=0;
            while (i < index) {
                current = current.next;
                i++;
        }
        if (current.prev == null) {
            Node newNode = new Node (null, item, current);
            current.prev = newNode;
            head = newNode;
        } else {
            Node newNode = new Node (current.prev, item, current);
            newNode.prev = current.prev;
            newNode.next = current; 
            current.prev.next = newNode; 
            current.prev = newNode;
            }
        }
        size++;
    }
    
    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        if (!isEmpty()) {
            Node tmp = head;
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
        }
            System.out.println("\nberhasil diisi");
        } else {
            System.out.println("Linked Lists Kosong");
        }
    }

    public void removeFirst() throws Exception {
            if (isEmpty()) {
                throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
            } else if (size == 1) {
                removeLast();
            } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (head.next == null) {
            head = null;
            size--;
            return;
        }
            Node current = head;
            while (current.next.next!= null) {
                current = current.next;
        }
        current.next = null;
        size--;
    }

    public void remove (int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Nilai indeks di luar batas");
        } else if (index == 0) {
            removeFirst();
        } else {
            Node current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current.next == null) {
                current.prev.next = null;
            } else if (current.prev == null) {
                current = current.next;
                current.prev = null;
                head = current;
            } else {
                current.prev.next = current.next; 
                current.next.prev = current.prev;
            }
            size--;
        }
    }
}

public class DoubleLinkedListMain {
        public static void main(String[] args) {
    
            DoubleLinkedList dll = new DoubleLinkedList();
        
            dll.addLast(50);
            dll.addLast(40);
            dll.addLast(10);
            dll.addLast(20);
            dll.print();
            System.out.println("Size: "+dll.size());
            System.out.println("===========================================");
            
            try {
            dll.removeFirst();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            dll.print();
            System.out.println("Size: "+dll.size());

            System.out.println("===========================================");
            
            try {
                dll.removeLast();;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            dll.print();

            System.out.println("Size: "+dll.size());
            System.out.println("===========================================");
            
            try {
                dll.remove(1);;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            dll.print();
            System.out.println("Size: "+dll.size());
    }
}
```

- Verifikasi Hasil Percobaan

![alt text](<Screenshot 2024-05-13 122937.png>)

- Pertanyaan
1. Apakah maksud statement berikut pada method removeFirst()?
head = head.next;
head.prev = null;
- statement tersebut memiliki tujuan untuk menghapus node pertama dari linked list dan memperbarui referensi head serta referensi prev dari node baru yang menjadi head.
2. Bagaimana cara mendeteksi posisi data ada pada bagian akhir pada method removeLast()?
- Untuk mendeteksinya perlu memeriksa apakah node saat ini adalah node terakhir dalam linked list jika iya maka data berada dibagian akhir, jika tidak lanjutkan iterasi ke node berikutnya.
3. Jelaskan alasan potongan kode program di bawah ini tidak cocok untuk perintah remove!
Node tmp = head.next;
head.next = tmp.next;
tmp.next.prev=head;
- alasanyya karena kode tersebut seolah olah menggeser urutan node, mencoba menghapus node kedua dan membuat node ketiga mengambil tempat node kedua, ini tidak menghapus node yang diaksud tetapi mengubah struktur linked list.
4. Jelaskan fungsi kode program berikut ini pada fungsi remove!
current.prev.next = current.next;
current.next.prev = current.prev;
- Fungsinya adalah untuk menghapus node dari linked list dengan mengatur referensi next dan prev dari node sebelumnya dan setelahnya secara tepat, melewati node yang akan dihapus.

### 2.3 Praktikum 3:

- Hasil Program

```java
import java.util.Scanner;
public class DoubleLinkedList {
    Node head;
    int size;

    public DoubleLinkedList() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }
        
    public void addFirst(int item) {
        if (isEmpty()) {
            head = new Node (null, item, null);
        } else {
            Node newNode = new Node (null, item, head);
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int item) {
        if (isEmpty()) {
            addFirst (item);
        } else {
            Node current = head;
            while (current.next!= null) {
                current = current.next;
            }
            Node newNode = new Node (current, item, null);
            current.next = newNode;
            size++;
        }
    }

    public void add(int item, int index) throws Exception {
        if (isEmpty()) {
            addFirst (item);
        } else if (index < 0 || index > size) {
            throw new Exception("Nilai indeks di luar batas");
        } else {
            Node current = head;
            int i=0;
            while (i < index) {
                current = current.next;
                i++;
        }
        if (current.prev == null) {
            Node newNode = new Node (null, item, current);
            current.prev = newNode;
            head = newNode;
        } else {
            Node newNode = new Node (current.prev, item, current);
            newNode.prev = current.prev;
            newNode.next = current; 
            current.prev.next = newNode; 
            current.prev = newNode;
            }
        }
        size++;
    }
    
    public int size() {
        return size;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void print() {
        if (!isEmpty()) {
            Node tmp = head;
            while (tmp != null) {
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
        }
            System.out.println("\nberhasil diisi");
        } else {
            System.out.println("Linked Lists Kosong");
        }
    }

    public void removeFirst() throws Exception {
            if (isEmpty()) {
                throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
            } else if (size == 1) {
                removeLast();
            } else {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void removeLast() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List masih kosong, tidak dapat dihapus!");
        } else if (head.next == null) {
            head = null;
            size--;
            return;
        }
            Node current = head;
            while (current.next.next!= null) {
                current = current.next;
        }
        current.next = null;
        size--;
    }

    public void remove (int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Nilai indeks di luar batas");
        } else if (index == 0) {
            removeFirst();
        } else {
            Node current = head;
            int i = 0;
            while (i < index) {
                current = current.next;
                i++;
            }
            if (current.next == null) {
                current.prev.next = null;
            } else if (current.prev == null) {
                current = current.next;
                current.prev = null;
                head = current;
            } else {
                current.prev.next = current.next; 
                current.next.prev = current.prev;
            }
            size--;
        }
    }

    public int getFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("Linked List kosong");
        }
        return head.data;
    }

    public int getLast() throws Exception {
        if (isEmpty()) {
            throw new Exception ("Linked List kosong");
        }
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    public int get(int index) throws Exception {
        if (isEmpty() || index >= size) {
            throw new Exception("Nilai indeks di luar batas.");
        }
        Node tmp = head;
        for (int i=0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }
}

public class DoubleLinkedListsMain {
        public static void main(String[] args) throws Exception {
    
            DoubleLinkedList dll = new DoubleLinkedList();

            System.out.println("---------------------------------------------");
            System.out.println("Size: " + dll.size());
            System.out.println("===========================================");
            dll.addFirst(3);
            dll.addLast(4);
            dll.addFirst(7);
            dll.print();
            System.out.println("Size: " + dll.size());
            System.out.println("===========================================");
            dll.add(40, 1);
            dll.print();
            System.out.println("Size: " + dll.size());
            System.out.println("===========================================");
            System.out.println("Data awal pada Linked Lists adalah: " + dll.getFirst());
            System.out.println("Data akhir pada Linked Lists adalah: " + dll.getLast());
            System.out.println("Data indeks ke-l pada Linked Lists adalah: " + dll.get(1));
    }
}
```

- Verifikasi Hasil Percobaan

![alt text](<Screenshot 2024-05-13 184944.png>)

- Pertanyaan 
1. Jelaskan method size() pada class DoubleLinkedLists!
- Method size berfungsi untuk mengembalikan jumlah elemen yang ada di dalam linked list. method ini tidak menerima parameter apapun dan mengembalikan nilai integer yang menunjukkan ukuran atau jumlah node yang ada didalam linked lisy tersebut.
2. Jelaskan cara mengatur indeks pada double linked lists supaya dapat dimulai dari indeks ke1!
- Dengan mengubah inisialisasi index dan i yang awalnya 0 menjadi 1 dan mengubah kondisi pada if menjadi index < 1 || index > size
3. Jelaskan perbedaan karakteristik fungsi Add pada Double Linked Lists dan Single Linked Lists!
- Pada DLL memiliki pointer yang menunjuk ke nodesebelum dan sesudah, sedangkan SLL hanya memiliki pointer yang merujuk ke node sebelumnya
4. Jelaskan perbedaan logika dari kedua kode program di bawah ini!
a. public boolean isEmpty(){
        if(size ==0) {
            return true;
        } else{
            return false;
        }
    }
b.     public boolean isEmpty() {
        return head == null;
    }
- Kode program pertama menggunakan variabel size untuk menentukan apakah linked list kosong. Ini diasumsikan bahwa size selalu terjaga dan sesuai dengan jumlah elemen yang sebenarnya dalam linked list. Kode program kedua hanya memeriksa keberadaan head. Jika head tidak ada, berarti linked list kosong. Pendekatan ini lebih langsung dan sederhana, terutama jika linked list hanya memiliki satu elemen, di mana size tidak terlalu relevan.

#### 2.4 Latihan Praktikum

- ketentuan tugas 1
Buat program antrian vaksinasi menggunakan queue berbasis double linked list sesuai ilustrasi
dan menu di bawah ini! (counter jumlah antrian tersisa di menu cetak(3) dan data orang yang
telah divaksinasi di menu Hapus Data(2) harus ada)
Contoh Ilustrasi Program
Menu Awal dan Penambahan Data
Cetak Data (Komponen di area merah harus ada)
Hapus Data (Komponen di area merah harus ada)

- Hasil Program
``` java
package Tugas1;
import java.util.Scanner;

public class AntrianVaksin {
    public static class Node {
        int nomorAntrian;
        String nama;
        Node prev, next;

        Node(Node prev, int nomorAntrian, String nama, Node next) {
            this.prev = prev;
            this.nomorAntrian = nomorAntrian;
            this.nama = nama;
            this.next = next;
        }
    }

    Node head;
    int size, kapasitas;

    public AntrianVaksin(int kapasitas) {
        this.size = 0;
        this.kapasitas = kapasitas;
    }

    public boolean isEmpty() {
        return head == null;
    }
    
        public void addAntrian(int nomorAntrian, String nama) {
            if (size >= kapasitas) {
                System.out.println("Antrian sudah penuh. Tidak dapat menambahkan antrian baru!");
            }
            else if (isEmpty()) {
                head = new Node(null, nomorAntrian, nama, null);
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                Node newNode = new Node(current, nomorAntrian, nama, null);
                current.next = newNode;
            }
            size++;
        }

        public void removeAntrian() throws Exception {
            if (isEmpty()) {
                throw new Exception("Antrian masih kosong, tidak dapat dihapus!");
            }
            System.out.println(head.nama + " telah selesai divaksinasi.");
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
            print();
        }

        public void print() {
            if (!isEmpty()) {
                Node tmp = head;
                System.out.println("---------------------------------------");
                System.out.println("Daftar Antrian Vaksinasi");
                System.out.println("---------------------------------------");
                System.out.printf("| %-5s | %-10s |%n", "No.", "Nama");
                while (tmp != null) {
                    System.out.printf("| %-5d | %-10s |%n", tmp.nomorAntrian, tmp.nama);
                    tmp = tmp.next;
                }
                System.out.println("---------------------------------------");
                System.out.println("Sisa antrian: " + size);
            } else {
                System.out.println("Antrian Kosong");
            }
        }

        public static void main(String[] args) throws Exception{
            Scanner sc = new Scanner(System.in);
            System.out.print("Masukkan kapasitas antrian: ");
            int kapasitas = sc.nextInt();
            System.out.println("\n+++++++++++++++++++++++++++++++++++++++");
            System.out.println("     PENGANTRI VAKSIN EXTRAVAGANZA     ");
            System.out.println("+++++++++++++++++++++++++++++++++++++++");
            AntrianVaksin v = new AntrianVaksin(kapasitas);
            int pilih;
    
            do {
                System.out.println("\n1. Tambah Data Penerima Vaksin");
                System.out.println("2. Hapus Data Antrian Vaksin Terdepan");
                System.out.println("3. Daftar Penerima Vaksin");
                System.out.println("4. Keluar");
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
                pilih = sc.nextInt();
    
                switch (pilih) {
                    case 1:
                        System.out.println("---------------------------------------");
                        System.out.println("Masukkan Data Penerima Vaksin");
                        System.out.println("---------------------------------------");
                        System.out.print("Nomor Antrian         : ");
                        int antrian = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nama Penerima Vaksin  : ");
                        String nama = sc.nextLine();
                        v.addAntrian(antrian, nama);
                        break;
        
                    case 2:
                        v.removeAntrian();
                        break;
        
                    case 3:
                        v.print();
                        break;
        
                    default:
                        break;
                }
            } while (pilih == 1 || pilih == 2 || pilih == 3);
        }
    }    
```

- Hasil Percobaan

![alt text](<Tugas1/Screenshot 2024-05-19 214727.png>)

![alt text](<Tugas1/Screenshot 2024-05-19 214815.png>)

![alt text](<Tugas1/Screenshot 2024-05-19 215300.png>)

- ketentuan tugas 2
Buatlah program daftar film yang terdiri dari id, judul dan rating menggunakan double linked lists, bentuk program memiliki fitur pencarian melalui ID Film dan pengurutan Rating secara descending. Class Film wajib diimplementasikan dalam soal ini.
Contoh Ilustrasi Program
Menu Awal dan Penambahan Data
Cetak Data
Pencarian Data

- Hasil Program
``` java 
package Tugas2;
import java.util.Scanner;

public class Film {
    public static class Node {
        int id;
        String judul;
        double rate;
        Node prev, next;

        Node(Node prev, int id, String judul, double rate, Node next) {
            this.prev = prev;
            this.id = id;
            this.judul = judul;
            this.rate = rate;
            this.next = next;
        }
    }

    Node head;
    int size;

    public Film() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void addAwal(int id, String judul, double rate) {
        Node newNode = new Node(null, id, judul, rate, head);
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
        size++;
    }

    public void addAkhir(int id, String judul, double rate) {
        if (isEmpty()) {
            addAwal(id, judul, rate);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(current, id, judul, rate, null);
        size++;
    }

    public void addTertentu(int id, String judul, double rate, int index) {
        if (index < 0 || index > size) {
            System.out.println("Indeks tidak valid!");
            return;
        }
        if (index == 0) {
            addAwal(id, judul, rate);
        } else if (index == size) {
            addAkhir(id, judul, rate);
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        Node newNode = new Node(current, id, judul, rate, current.next);
        current.next.prev = newNode;
        current.prev = newNode;
        size++;
        }
        System.out.println("Film masuk diurutan ke-" + (index + 1));
    }

    public void removeAwal() throws Exception {
        if (isEmpty()) {
            throw new Exception("Daftar Film masih kosong, tidak dapat dihapus!");
        }
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        size--;
    }

    public void removeAkhir() throws Exception {
        if (isEmpty()) {
            throw new Exception("Daftar Film masih kosong, tidak dapat dihapus!");
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        if (current.prev != null) {
            current.prev.next = null;
        } else {
            head = null;
        }
        size--;
    }

    public void removeTertentu(int id) throws Exception {
        Node current = head;
        while (current != null && current.id != id) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Film dengan ID " + id + " tidak ditemukan!");
            return;
        }
        if (current == head) {
            removeAwal();
            return;
        }
        if (current.next == null) {
            removeAkhir();;
            return;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }

    public void print() {
        if (!isEmpty()) {
            Node current = head;
            while (current != null) {
                System.out.println("ID Film: " + current.id);
                System.out.println("Judul Film: " + current.judul);
                System.out.println("Rating Film: " + current.rate);
                System.out.println("-----------------------------------");
                current = current.next;
            }
        } else {
            System.out.println("Daftar Film masih kosong");
        }
    }

    public Node searchFilm(int id) {
        Node current = head;
        while (current != null && current.id != id) {
            current = current.next;
        }
        return current;
    }

    public void urutRatingDescending() {
        if (size <= 1) {
            return;
        }
        Node current = head;
        Node next;
        for (int i = 0; i < size - 1; i++) {
            next = current.next;
            while (next != null) {
                if (current.rate < next.rate) {
                    int tempId = current.id;
                    String tempJudul = current.judul;
                    double tempRating = current.rate;
                    current.id = next.id;
                    current.judul = next.judul;
                    current.rate = next.rate;
                    next.id = tempId;
                    next.judul = tempJudul;
                    next.rate = tempRating;
                }
                current = current.next;
                next = next.next;
            }
            current = head;
        }
    }


        public static void main(String[] args) throws Exception{
            Scanner sc = new Scanner(System.in);
            Film film = new Film();
            int pilih, id, index;
            String judul;
            double rate;

            System.out.println("\n=====================================");
            System.out.println("     DAFTAR FILM LAYAR LEBAR     ");
            System.out.println("=====================================");
    
            do {
                System.out.println("\n1. Tambah Data Awal");
                System.out.println("2. Tambah Data Akhir");
                System.out.println("3. Tambah Data Index Tertentu");
                System.out.println("4. Hapus Data Pertama");
                System.out.println("5. Hapus Data Terakhir");
                System.out.println("6. Hapus Data Tertentu");
                System.out.println("7. Cetak");
                System.out.println("8. Cari ID Film");
                System.out.println("9. Urut Data Rating Film-DESC");
                System.out.println("10. Keluar");
                System.out.println("=====================================");
                pilih = sc.nextInt();
    
                switch (pilih) {
                    case 1:
                        System.out.println("\n---------------------------------------");
                        System.out.println("Masukkan Data Film Posisi Awal ");
                        System.out.println("---------------------------------------");
                        System.out.print("ID Film         : ");
                        id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Judul Film      : ");
                        judul = sc.nextLine();
                        System.out.print("Rating Film     : ");
                        rate = sc.nextDouble();
                        film.addAwal(id, judul, rate);
                        break;
        
                    case 2:
                        System.out.println("\n---------------------------------------");
                        System.out.println("Masukkan Data Film Posisi Akhir ");
                        System.out.println("---------------------------------------");
                        System.out.print("ID Film         : ");
                        id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Judul Film      : ");
                        judul = sc.nextLine();
                        System.out.print("Rating Film     : ");
                        rate = sc.nextDouble();
                        film.addAkhir(id, judul, rate);
                        break;
        
                    case 3:
                        System.out.println("\n---------------------------------------");
                        System.out.println("Masukkan Data Film ");
                        System.out.println("---------------------------------------");
                        System.out.println("Urutan ke- ");
                        System.out.print("ID Film         : ");
                        id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Judul Film      : ");
                        judul = sc.nextLine();
                        System.out.print("Rating Film     : ");
                        rate = sc.nextDouble();
                        System.out.print("Data Film ini akan masuk di urutan ke: ");
                        index = sc.nextInt();
                        index--;
                        film.addTertentu(id, judul, rate, index);
                        break;
                    case 4:
                        film.removeAwal();
                        System.out.println("Data Film Pertama telah dihapus!");
                        break;
                    case 5:
                        film.removeAkhir();
                        System.out.println("Data film terakhir telah dihapus");
                        break;
                    case 6:
                        System.out.println("\n---------------------------------------");
                        System.out.println("Hapus Data Film Tertentu");
                        System.out.println("---------------------------------------");
                        System.out.print("Masukkan ID Film yang ingin dihapus: ");
                        id = sc.nextInt();
                        film.removeTertentu(id);
                        break;
                    case 7:
                        film.print();
                        break;
                    case 8:
                        System.out.println("\n---------------------------------------");
                        System.out.println("Cari Data Film");
                        System.out.println("---------------------------------------");
                        System.out.print("Masukkan ID Film yang dicari: ");
                        id = sc.nextInt();
                        Node searchfilm = film.searchFilm(id);
                        if (searchfilm != null) {
                            System.out.println("\nData Id Film: " + id + " berada di node ke-" + film.size);
                            System.out.println("IDENTITAS:");
                            System.out.println("ID Film: " + searchfilm.id);
                            System.out.println("Judul Film: " + searchfilm.judul);
                            System.out.println("IMDB Rating: " + searchfilm.rate);
                        } else {
                            System.out.println("Film dengan ID " + id + " tidak ditemukan!");
                        }
                        break;
                    case 9:
                        film.urutRatingDescending();
                        System.out.println("\nData film telah diurutkan berdasarkan rating (descending)");
                        film.print();
                    default:
                        break;
                }
            } while (pilih == 1 || pilih == 2 || pilih == 3 || pilih == 4 || pilih == 5 || pilih == 6 || pilih == 7 || pilih == 8 || pilih == 9 || pilih == 10);
        }
    }    
```

- Hasil Percobaan

![alt text](<Tugas2/Screenshot 2024-05-20 080400.png>)

![alt text](<Tugas2/Screenshot 2024-05-20 080424.png>)

![alt text](<Tugas2/Screenshot 2024-05-20 080445.png>)

![alt text](<Tugas2/Screenshot 2024-05-20 080500.png>)

![alt text](<Tugas2/Screenshot 2024-05-20 080514.png>)