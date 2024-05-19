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
            head.prev = head;
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
        current.prev.next = null;
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
            System.out.println("Daftar Film masih kosong");
            return;
        }
            Node current = head;
            System.out.println("---------------------------------------");
            System.out.println("Daftar Film Layar Lebar");
            System.out.println("---------------------------------------");
            System.out.printf("| %-10s | %-30s | %-10.2f |%n", "ID Film.", "Judul Film", "Rating");
            while (current != null) {
                System.out.printf("| %-10s | %-30s | %-10.2f |%n", current.id, current.judul, current.rate);
                current = current.next;
            }
            System.out.println("---------------------------------------");
            System.out.println("Sisa antrian: " + size);
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
