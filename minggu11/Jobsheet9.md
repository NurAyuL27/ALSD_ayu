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

public class Node {
    int data;
    Node next;

    Node(int nilai, Node berikutnya) {
    data = nilai;
    next = berikutnya;
    }
}

import java.util.Scanner;
public class SingleLinkedList {
    Node head, tail;

    boolean isEmpty(){
        return head == null;
    }

    void print() { 
        if(!isEmpty()) {
            Node tmp = head;
            System.out.print("Isi Linked List:\t");
            while(tmp != null){
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("");
        } else{
            System.out.println("Linked List kosong");
        }
    }

    void addFirst(int input) {
        Node ndInput = new Node (input, null);
        if(isEmpty()) { 
            head = ndInput;
            tail = ndInput;
        } else{
            ndInput.next = head;
            head = ndInput;
        }
    }

    void addLast(int input){
        Node ndInput = new Node(input, null); 
        if(isEmpty()) { 
            head = ndInput;
            tail = ndInput;            
        } else{
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    void insertAfter(int key, int input){
        Node ndInput = new Node(input, null);
        Node temp = head;
        do{
            if(temp.data == key) {
                ndInput.next= temp.next;
                temp.next = ndInput;
                if(ndInput.next != null) { 
                    tail=ndInput;
                    break;
                }
            }
            temp = temp.next;
        } while(temp != null);
    }

    void insertAt(int index, int input) {
        Node ndInput = new Node(input, null);
        if (index < 0) {
            System.out.println("perbaiki logikanya!" + "kalau indeksnya -1 bagaimana???");
        } else if(index ==0){
            addFirst(input);
        } else{
            Node temp = head;
            for(int i=0;i < index -1; i++){
                temp = temp.next;
            }
            temp.next= new Node (input, temp.next);
            if(temp.next.next==null) {
                tail=temp.next;
            }
        }
    }
}

public class SLLMain {
    public static void main(String[] args) {
        SingleLinkedList singLL=new SingleLinkedList();

        singLL.print();
        singLL.addFirst (890);
        singLL.print();
        singLL.addLast(760);
        singLL.print();
        singLL.addFirst(700);
        singLL.print();
        singLL.insertAfter (700, 999);
        singLL.print();
        singLL.insertAt (3, 833);
        singLL.print();
    }
}
```

- Verifikasi Hasil Percobaan

![alt text](<Screenshot 2024-05-06 111805.png>)

- Pertanyaan
1. Mengapa hasil compile kode program di baris pertama menghasilkan “Linked List Kosong”?
2. Jelaskan kegunaan variable temp secara umum pada setiap method!
3. Perhatikan class SingleLinkedList, pada method insertAt Jelaskan kegunaan kode berikut 
```java
if(temp.next.next == null) tail=temp.next;
```

- Jawaban 
1. Pesan tersebut muncul karena pada saat itu belum ditambahkan elemen apapun dalam linkedlist.
2. Secara umum variabel temp digunakan dalam linkedlist untuk menyimpan referensi sementara kesimpul saat melakukan operasi seperti penambahan penghapusan atau pencarian.
3. Kode tersebut pada method insertArt digunakan untuk memperbarui referensi tail jika simpul baru ditambahkan sebagai elemen terakhir dalam linke list.


#### 2.2 Praktikum 2:

- Hasil Program

``` java
import java.util.Scanner;
public class SingleLinkedList {
    Node head, tail;

    boolean isEmpty(){
        return head == null;
    }

    void print() { 
        if(!isEmpty()) {
            Node tmp = head;
            System.out.print("Isi Linked List:\t");
            while(tmp != null){
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("");
        } else{
            System.out.println("Linked List kosong");
        }
    }

    void addFirst(int input) {
        Node ndInput = new Node (input, null);
        if(isEmpty()) { 
            head = ndInput;
            tail = ndInput;
        } else{
            ndInput.next = head;
            head = ndInput;
        }
    }

    void addLast(int input){
        Node ndInput = new Node(input, null); 
        if(isEmpty()) { 
            head = ndInput;
            tail = ndInput;            
        } else{
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    void insertAfter(int key, int input){
        Node ndInput = new Node(input, null);
        Node temp = head;
        do{
            if(temp.data == key) {
                ndInput.next= temp.next;
                temp.next = ndInput;
                if(ndInput.next != null) { 
                    tail=ndInput;
                    break;
                }
            }
            temp = temp.next;
        } while(temp != null);
    }

    void insertAt(int index, int input) {
        Node ndInput = new Node(input, null);
        if (index < 0) {
            System.out.println("perbaiki logikanya!" + "kalau indeksnya -1 bagaimana???");
        } else if(index ==0){
            addFirst(input);
        } else{
            Node temp = head;
            for(int i = 0; i < index -1; i++){
                temp = temp.next;
            }
            temp.next= new Node (input, temp.next);
            if(temp.next.next==null) {
                tail=temp.next;
            }
        }
    }

    int getData(int index) {
        Node tmp = head;
        for(int i=0; i < index;i++){
        tmp = tmp.next;
        } return tmp.data;
    }

    int indexOf(int key) {
        Node tmp = head;
        int index = 0;
        while(tmp!= null && tmp.data != key) {
            tmp = tmp.next;
            index++;
        }
        if(tmp == null) {
            return -1;
        } else{
            return index;
        }
    }

    void removeFirst(){
        if(isEmpty()){
            System.out.println("Linked list masih kosong," + "tidak dapat dihapus ");
        }else if(head == tail){
            head = tail = null;
        } else{
            head = head.next;
        }
    }

    void removeLast(){
        if(isEmpty()){
            System.out.println("Linked list masih kosong," + "tidak dapat dihapus");
        }else if(head == tail) {
            head = tail = null;
        } else{
            Node temp = head;
            while(temp.next == null) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp.next;
        }
    }

    void remove(int key) {
        if(isEmpty()){
            System.out.println("Linked list masih kosong," + "tidak dapat dihapus");
        }else{
            Node temp = head;
            while(temp!=null){
                if(temp.data == key && temp == head){
                removeFirst();
                break;
                } else if(temp.next.data == key) {
                    temp.next = temp.next.next;
                    if(temp.next == null){
                        tail = temp;
                    }
                    break;
                }
            }
            temp = temp.next;
        }
    }

    public void removeAt(int index) {
        if (index == 0) {
            removeFirst();
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            if (temp.next == null) {
                tail = temp;
            }
        }
    }
}

public class SLLMain {
    public static void main(String[] args) {
        SingleLinkedList singLL=new SingleLinkedList();

        singLL.print();
        singLL.addFirst (890);
        singLL.print();
        singLL.addLast(760);
        singLL.print();
        singLL.addFirst(700);
        singLL.print();
        singLL.insertAfter (700, 999);
        singLL.print();
        singLL.insertAt (3, 833);
        singLL.print();

        System.out.println("Data pada indeks ke-1="+singLL.getData(1));
        System.out.println("Data 3 berada pada indeks ke-"+singLL.indexOf (760));
        
        singLL.remove (999);
        singLL.print();
        singLL.removeAt(0);
        singLL.print();
        singLL.removeFirst();
        singLL.print();
        singLL.removeLast();
        singLL.print();
    }
}
```

- Verifikasi Hasil Percobaan

![alt text](<Screenshot 2024-05-06 111805.png>)

- Pertanyaan
1. Mengapa digunakan keyword break pada fungsi remove? Jelaskan!
2. Jelaskan kegunaan kode dibawah pada method remove
```java
else if (temp.next.data == key) {
    temp.next = temp.next.next;
}
```

jawaban 
1. keyword break digunakan dalam fungsi remove untuk menghentikan iterasi setelah operasi penghapusan dilakukan.
2. Kode tersebut digunakan untuk menghapus simpul yang terletak ditengah atau di akhir linkedlist

#### 2.4 Latihan Praktikum

- ketentuan tugas 1
Implementasikan ilustrasi Linked List Berikut. Gunakan 4 macam penambahan data yang telah dipelajari sebelumnya untuk menginputkan data.

- Hasil Program
``` java  
import java.util.Scanner;
public class SingleLinkedList {
    Node head, tail;

    boolean isEmpty(){
        return head == null;
    }

    void print() { 
        if(!isEmpty()) {
            Node tmp = head;
            System.out.print("Isi Linked List:\t");
            while(tmp != null){
                System.out.print(tmp.data + "\t");
                tmp = tmp.next;
            }
            System.out.println("");
        } else{
            System.out.println("Linked List kosong");
        }
    }

    void addFirst(int input) {
        Node ndInput = new Node (input, null);
        if(isEmpty()) { 
            head = ndInput;
            tail = ndInput;
        } else{
            ndInput.next = head;
            head = ndInput;
        }
    }

    void addLast(int input){
        Node ndInput = new Node(input, null); 
        if(isEmpty()) { 
            head = ndInput;
            tail = ndInput;            
        } else{
            tail.next = ndInput;
            tail = ndInput;
        }
    }

    void insertAfter(int key, int input){
        Node ndInput = new Node(input, null);
        Node temp = head;
        do{
            if(temp.data == key) {
                ndInput.next= temp.next;
                temp.next = ndInput;
                if(ndInput.next != null) { 
                    tail=ndInput;
                    break;
                }
            }
            temp = temp.next;
        } while(temp != null);
    }

    void insertAt(int index, int input) {
        Node ndInput = new Node(input, null);
        if (index < 0) {
            System.out.println("perbaiki logikanya!" + "kalau indeksnya -1 bagaimana???");
        } else if(index ==0){
            addFirst(input);
        } else{
            Node temp = head;
            for(int i=0;i < index -1; i++){
                temp = temp.next;
            }
            temp.next= new Node (input, temp.next);
            if(temp.next.next==null) {
                tail=temp.next;
            }
        }
    }
}
```
- Hasil Percobaan

![alt text](<Screenshot 2024-05-12 161138.png>)

- Ketentuan tugas 2
Buatlah implementasi program antrian layanan unit kemahasiswaan sesuai dengan kondisi yang ditunjukkan pada soal nomor 1! Ketentuan
a. Implementasi antrian menggunakan Queue berbasis Linked List!
b. Program merupakan proyek baru, bukan modifikasi dari soal nomor 1!

- Hasil program
```java
import java.util.Scanner;

public class LayananKemahasiswaan {
    public static class Mahasiswa {
        String nama;
        int nim;

        Mahasiswa(int nim, String nama) {
            this.nim = nim;
            this.nama = nama;
        }
    }

    public static class Node {
        Mahasiswa data;
        Node next;

        Node(Mahasiswa data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class Queue {
        Node front, rear;
        Queue() {
            front = rear = null;
        }

        boolean isEmpty() {
            return front == null;
        }

        void enqueue(Mahasiswa mahasiswa) {
            Node newNode = new Node(mahasiswa);
            if (rear == null) {
                front = rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
        }

        void dequeue() {
            if (isEmpty()) {
                System.out.println("Antrian kosong");
                return;
            }
            Node temp = front;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            System.out.println("Mahasiswa yang dilayani: " + temp.data.nama);
        }
        
        void display() {
            if (isEmpty()) {
                System.out.println("Antrian kosong");
                return;
            }
            Node temp = front;
            System.out.println("Antrian layanan:");
            while (temp != null) {
                System.out.println("NIM: " + temp.data.nim + ", Nama: " + temp.data.nama);
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah mahasiswa ke antrian");
            System.out.println("2. Layani mahasiswa berikutnya");
            System.out.println("3. Tampilkan antrian");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Masukkan NIM mahasiswa: ");
                    int nim = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan nama mahasiswa: ");
                    String nama = scanner.nextLine();
                    Mahasiswa mahasiswa = new Mahasiswa(nim, nama);
                    queue.enqueue(mahasiswa);
                    System.out.println("Mahasiswa berhasil ditambahkan ke antrian");
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.display();
                    break;
                case 4:
                    System.out.println("Program selesai");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    } 
}
```

- Hasil Percobaan
![alt text](<Screenshot 2024-05-12 162719.png>)
