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

- Pertanyaan
1. Jelaskan perbedaan antara single linked list dengan double linked lists!
single linkedlist hanya memiliki tautan satu arah, setiap node terdiri dari dua bagian yaotu data dan pointer dan tidak bisa kembali ke node sebelumnya.
sedangkann double linked list setiap elemen memiliki dua tautan yaitu mengarah ke elemen berikutnya dan mengarah ke elemen sebelumnya, setiap node terdiri dari tiga bagian yaitu data pointer ke node berikutnya dan pointer ke node sebelumnya dan bisa di akses dari awal ke akhir atau sebaliknya.
2. Perhatikan class Node, di dalamnya terdapat atribut next dan prev. Untuk apakah atribut tersebut?
3. Perhatikan konstruktor pada class DoubleLinkedLists. Apa kegunaan inisialisasi atribut head dan
size seperti pada gambar berikut ini?
4. Pada method addFirst(), kenapa dalam pembuatan object dari konstruktor class Node prev dianggap sama dengan null?
Node newNode = new Node(null, item, head);
5. Perhatikan pada method addFirst(). Apakah arti statement head.prev = newNode ?
6. Perhatikan isi method addLast(), apa arti dari pembuatan object Node dengan mengisikan parameter prev dengan current, dan next dengan null?
Node newNode = new Node(current, item, null);
7. Pada method add(), terdapat potongan kode program sebagai berikut:
jelaskan maksud dari bagian yang ditandai dengan kotak kuning.

- Jawaban 
1. 


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
2. Bagaimana cara mendeteksi posisi data ada pada bagian akhir pada method removeLast()?
3. Jelaskan alasan potongan kode program di bawah ini tidak cocok untuk perintah remove!
4. Jelaskan fungsi kode program berikut ini pada fungsi remove!

jawaban 


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
1. 

- Jawaban

#### 2.4 Latihan Praktikum

- ketentuan tugas 1
Implementasikan ilustrasi Linked List Berikut. Gunakan 4 macam penambahan data yang telah dipelajari sebelumnya untuk menginputkan data.

- Hasil Program
``` java  
```

- Hasil Percobaan

