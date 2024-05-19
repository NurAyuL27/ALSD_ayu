## <center> LAPORAN HASIL PRAKTIKUM JOBSHEET 9

<p align="center"> 
<img src="logo polinema.png" width="300px">

 <p align="center">  Nama : Nur Ayu Lailatul Azizah
 <p align="center">  Kelas : TI 1 H
 <p align="center">  NIM : 2341720044

<center> Jln.Soekarno Hatta No.9, Jatimulyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 6
<center>Phone: (0341) 404424,404425
<center>E-mail: Polinema.ac.id

## <center> JOBSHEET IX
## <center> LINKEDLIST

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
- 
3. Jelaskan perbedaan karakteristik fungsi Add pada Double Linked Lists dan Single Linked Lists!
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
```

- Hasil Percobaan



- ketentuan tugas 2
Buatlah program daftar film yang terdiri dari id, judul dan rating menggunakan double linked lists, bentuk program memiliki fitur pencarian melalui ID Film dan pengurutan Rating secara descending. Class Film wajib diimplementasikan dalam soal ini.
Contoh Ilustrasi Program
Menu Awal dan Penambahan Data
Cetak Data
Pencarian Data

- Hasil Program
``` java  
```

- Hasil Percobaan


