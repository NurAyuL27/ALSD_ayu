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
            System.out.print("Isi Linked List");
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
            for(int i=0;i < index; i++){
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

![alt text](<Screenshot 2024-05-06 103315.png>)

- Pertanyaan
1. 

- Jawaban 
1. 


#### 2.2 Praktikum 2:

- Hasil Program

``` java

```

- Verifikasi Hasil Percobaan


- Pertanyaan
1. 

jawaban 
1. 

#### 2.4 Latihan Praktikum

- ketentuan 


- Hasil Program
``` java  

```
- Hasil Percobaan





