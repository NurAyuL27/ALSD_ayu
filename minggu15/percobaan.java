package minggu15;

import java.util.Scanner;

public class percobaan {
    public static class Node21 {
        int data;
        Node21 prev, next;
        int jarak;

        Node21 (Node21 prev, int data, int jarak, Node21 next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
        this.jarak = jarak;
        }
    }

    public static class DoubleLinkedList {
        Node21 head;
        int size;
    
        public DoubleLinkedList() {
            head = null;
            size = 0;
        }
    
        public boolean isEmpty() {
            return head == null;
        }

        public void addFirst(int item, int jarak) {
            if (isEmpty()) {
                head = new Node21 (null, item, jarak, null);
            } else {
                Node21 newNode = new Node21 (null, item, jarak, head);
                head.prev = newNode;
                head = newNode;
            }
            size++;
        }

        public int getJarak (int index) throws Exception {
            if (isEmpty() || index >= size) {
                throw new Exception("Nilai indeks di luar batas");
            }
            Node21 tmp = head;
            for (int i=0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp.jarak;
        }

        public int get(int index) throws Exception {
            if (isEmpty() || index >= size) {
                throw new Exception("Nilai indeks di luar batas");
            }
            Node21 tmp = head;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp.data;
        }

        public void remove(int index) {
            Node21 current = head;
            while (current != null) {
                if (current.data == index) {
                    if (current.prev != null) {
                        current.prev.next = current.next;
                    } else {
                        head = current.next;
                    }
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                    break;
                }
                current = current.next;
            }
            size--;
        }

        public int size() {
            return size;
        }

        public void clear() {
            head = null;
            size = 0;
        }
    }

    public static class Graph {
    int vertex;
    DoubleLinkedList list[];

        public Graph(int v) {
                vertex = v;
                list = new DoubleLinkedList[v];
                for (int i=0; i < v; i++) {
                    list[i] = new DoubleLinkedList();
            }
        }

        public void addEdge(int asal, int tujuan, int jarak) {
            list[asal].addFirst(tujuan, jarak);
            //list[tujuan].addFirst(asal, jarak);
        }
        

        public void degree(int asal) throws Exception {
            int k, totalin = 0, totalout = 0;
                for (int i = 0; i < vertex; i++) {
                    for (int j = 0; j < list[i].size(); j++) {
                        if (list[i].get(j) == asal) {
                            ++totalin;
                        }
                    }
                for (k = 0; k < list[asal].size(); k++) {
                        list[asal].get(k);
                    }
                    totalout = k;
                }
            System.out.println("InDegree dari Gedung " + (char) ('A' +asal) + " : " + totalin); 
            System.out.println("OutDegree dari Gedung " + (char) ('A' + asal) + " : " + totalout);
            System.out.println("Degree dari Gedung " +(char) ('A' +asal)+" : "+ (totalin + totalout));
            //System.out.println("Degree dari Gedung " + (char) ('A' + asal) + ": " + list[asal].size());
        }
        

        public void removeEdge (int asal, int tujuan) throws Exception {
            for (int i = 0; i < vertex; i++) {
                if (i == tujuan) {
                    list[asal].remove(tujuan);
                }
            }
        }

        public void removeAllEdges() {
            for (int i=0; i < vertex; i++) {
            list[i].clear();
            }
            System.out.println("Graf berhasil dikosongkan");
        }

        public void printGraph() throws Exception {
            for (int i=0; i < vertex; i++) { 
                if (list[i].size() > 0) {
                    System.out.println("Gedung " + (char) ('A'+ i)+" terhubung dengan ");
                    for (int j = 0; j < list[i].size(); j++) {
                        System.out.print((char) ('A' + list[i].get(j))+" ("+ list[i].getJarak(j)+"m), ");
                        }
                    System.out.println("");
                }
            }
            System.out.println("");
        }

        public boolean cekEdge(int asal, int tujuan) throws Exception {
            for (int i = 0; i < list[asal].size(); i++) {
                if (list[asal].get(i) == tujuan) {
                    return true;
                }
            }
            return false;
        }

        public void updateJarak(int asal, int tujuan, int jarak) throws Exception {
            boolean success = false;
            Node21 current = list[asal].head;
            while (current != null) {
                if (current.data == tujuan) {
                    current.jarak = jarak;
                    success = true;
                    break;
                }
                current = current.next;
            }
        }

        public void hitungEdge() {
            int totalEdge = 0;
            for (int i = 0; i < vertex; i++) { // directed
                totalEdge += list[i].size();
            }
            // for (int i = 0; i < vertex; i++) { // undirected
            //     totalEdge += list[i].size();
            // }
            // totalEdge /= 2;
            System.out.println("Total edge dalam graf: " + totalEdge);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan kapasitas gedung : ");
        int v = sc.nextInt();
        Graph gedung = new Graph(v);

        while (true) {
            System.out.println("\n===========================================");
            System.out.println("|               GRAF GEDUNG               |");
            System.out.println("===========================================");
            System.out.println("| 1. Add Edge           ");
            System.out.println("| 2. Remove Edge        ");
            System.out.println("| 3. Degree             ");
            System.out.println("| 4. Print Graph        ");
            System.out.println("| 5. Cek Edge           ");
            System.out.println("| 6. Update Jarak       ");
            System.out.println("| 7. Hitung Edge        ");
            System.out.println("| 8. Exit               ");
            System.out.println("===========================================");
            System.out.print("Pilih Menu     : ");
            int pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan posisi gedung asal   : ");
                    int asal = sc.nextInt();
                    System.out.print("Masukkan posisi gedung tujuan : ");
                    int tujuan = sc.nextInt();
                    System.out.print("Masukkan jarak antar gedung   : ");
                    int jarak = sc.nextInt();
                    gedung.addEdge(asal, tujuan, jarak);
                    break;
                case 2:
                    System.out.print("Masukkan posisi gedung asal   : ");
                    asal = sc.nextInt();
                    System.out.print("Masukkan posisi gedung tujuan : ");
                    tujuan = sc.nextInt();
                    gedung.removeEdge(asal, tujuan);
                    break;
                case 3:
                    System.out.print("Masukkan gedung asal          : ");
                    asal = sc.nextInt();
                    gedung.degree(asal);
                    break;
                case 4:
                    gedung.printGraph();
                    break;
                case 5:
                    System.out.print("Masukkan posisi gedung asal   : ");
                    asal = sc.nextInt();
                    System.out.print("Masukkan posisi gedung tujuan : ");
                    tujuan = sc.nextInt();
                    boolean adaEdge = gedung.cekEdge(asal, tujuan);
                    System.out.println("Gedung " + asal + " dengan " + tujuan + " " + (adaEdge ? "bersampingan" : "tidak bersampingan"));
                    break;
                case 6:
                    System.out.print("Masukkan posisi gedung asal        : ");
                    asal = sc.nextInt();
                    System.out.print("Masukkan posisi gedung tujuan      : ");
                    tujuan = sc.nextInt();
                    System.out.println("Masukkan jarak antar gedung baru : ");
                    int jarakBaru = sc.nextInt();
                    gedung.updateJarak(asal, tujuan, jarakBaru);
                    break;
                case 7:
                    gedung.hitungEdge();
                    break;
                case 8:
                    System.out.println("Terimakasih telah menggunakan program ini.");
                    sc.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }
}