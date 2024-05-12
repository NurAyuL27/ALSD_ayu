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
