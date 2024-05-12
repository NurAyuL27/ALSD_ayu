import java.util.Scanner;

public class Mahasiswa {
    public static class Node{
    int urutan;
    String nama;
    int nim;
    Node next;

    Node(int urutan, int nim, String nama, Node next) {
        this.urutan = urutan;
        this.nim = nim;
        this.nama = nama;
        this.next = next;
        }
    }

        Node head, tail;
    
        boolean isEmpty(){
            return head == null;
        }
    
        void print() { 
            if(!isEmpty()) {
                Node tmp = head;
                System.out.println("Isi Linked List:\t");
                while(tmp != null){
                    System.out.println("================");
                    System.out.println("Mhs " + tmp.urutan);
                    System.out.println("NIM: " + tmp.nim);
                    System.out.println("Nama: " + tmp.nama);
                    System.out.println("================");
                    tmp = tmp.next;
                }
                System.out.println(" ");
            } else{
                System.out.println("Linked List kosong");
            }
        }
    
        void addFirst(int urutan, int nim, String nama) {
            Node ndinput = new Node(urutan, nim, nama, null);
            if(isEmpty()) { 
                head = ndinput;
                tail = ndinput;
            } else{
                ndinput.next = head;
                head = ndinput;
            }
        }
    
        void addLast(int urutan, int nim, String nama){
            Node ndinput = new Node(urutan, nim, nama, null); 
            if(isEmpty()) { 
                head = ndinput;
                tail = ndinput;            
            } else{
                tail.next = ndinput;
                tail = ndinput;
            }
        }
    
        void insertAfter(int key, int urutan, int nim, String nama){
            Node ndinput = new Node(urutan, nim, nama, null);
            Node temp = head;
            while (temp != null) {
                if(temp.urutan == key) {
                    ndinput.next = temp.next;
                    temp.next = ndinput;
                    if(ndinput.next == null) { 
                        tail = ndinput;
                    }
                    break;
                }
                temp = temp.next;
            } while(temp != null);
        }
    
        void insertAt(int index, int urutan, int nim, String nama) {
            Node ndinput = new Node(urutan, nim, nama, null);
            if (index == 0) {
                addFirst(urutan, nim, nama);
            } else {
                Node temp = head;
                for(int i=0; i < index -1; i++){
                    temp = temp.next;
            } if (temp == null) {
                System.out.println("Index melebihi batas");
                return;
            }
            temp.next = new Node(urutan, nim, nama, temp.next);
            if(temp.next.next == null) {
                tail = temp.next;
            }
        }
    }

    public static class MahasiswaMain{
    public static void main(String[] args) {
        Mahasiswa mhs = new Mahasiswa();
        mhs.addFirst(1, 111, "Anton");;
        mhs.insertAt(1, 2, 112, "Prita");;
        mhs.insertAt(2, 3, 113, "Yusuf");
        mhs.insertAfter(3, 4,  114, "Doni");
        mhs.addLast(5, 115, "Sari");
        mhs.print();
        }
    }
}