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
