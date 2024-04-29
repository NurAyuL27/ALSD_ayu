package minggu8;
import java.util.Scanner;

public class Barang21 {
    int kode;
    String nama;
    String kategori;

    public Barang21(int kode, String nama,String kategori) {
        this.kode = kode;
        this.nama = nama;
        this.kategori = kategori;
    }

    public static class Gudang21 {
        Barang21[] tumpukan;
        int size;
        int top;
        StackKonversi stackKonversi;

        public Gudang21(int kapasitas) {
            size = kapasitas;
            tumpukan = new Barang21[size];
            top = -1;
        }

        public boolean cekKosong() {
            if (top == -1) {
                return true;
            } else {
                return false;
            }
        }

        public boolean cekPenuh() {
            if (top == size - 1) {
                return true;
            } else {
                return false;
            }
        }

        public void tambahBarang(Barang21 brg) {
            if (!cekPenuh()) {
                top++;
                tumpukan[top] = brg;
                System.out.println("Barang " + brg.nama + " berhasil ditambahkan ke Gudang");
            } else {
                System.out.println("Gagal! Tumpukan barang di Gudang sudah penuh");
            }
        }

        public Barang21 ambilBarang() {
            if (!cekKosong()) {
                Barang21 delete = tumpukan[top];
                top--;
                System.out.println("Barang " + delete.nama + " diambil dari Gudang");
                System.out.println("Kode unik dalam biner: " + konversiDesimalkeBiner(delete.kode));
                return delete;
            } else {
                System.out.println("Tumpukan barang kosong");
                return null;
            }
        }

        public Barang21 lihatBarangTerbawah() {
            if (!cekKosong()) {
                Barang21 barangTerbawah = tumpukan[0];
                System.out.println("Barang terbawah: " + barangTerbawah.nama + "(Kategori " + barangTerbawah.kategori + ")");
                return barangTerbawah;
            } else {
                System.out.println("Tumpukan barang kosong.");
                return null;
            }
        }

        public Barang21 cariBarang21(int kodeBarang21) {
            if (!cekKosong()) {
                for (int i = 0; i <= top; i++) {
                    if (tumpukan[i].kode == kodeBarang21) {
                        System.out.println("Barang dengan kode " + kodeBarang21 + " ditemukan: " + tumpukan[i].nama + "(Kategori " + tumpukan[i].kategori + ")");
                        return tumpukan[i];
                    }
                }
                System.out.println("Barang dengan kode " + kodeBarang21 + " tidak ditemukan.");
                return null;
            } else {
                System.out.println("Tumpukan barang kosong.");
                return null;
            }
        }

        public void tampilkanBarang() {
            if (!cekKosong()) {
                System.out.println("Rincian tumpukan barang di Gudang");
                for (int i = top; i >= 0; i--) {
                    System.out.printf("Kode %d: %s (Kategori %s)\n", tumpukan[i].kode, tumpukan[i].nama, tumpukan[i].kategori);
                }
            } else {
                System.out.println("Tumpukan barang kosong.");
            }
        }
    }

    public static String konversiDesimalkeBiner(int kode) {
        StackKonversi stack = new StackKonversi();
        while (kode > 0) {
            int sisa = kode % 2;
            stack.push(sisa);
            kode = kode / 2;
        }
        String biner = new String();
        while (!stack.isEmpty()) {
            biner += stack.pop();
        }
        return biner;
    }   

    public static class StackKonversi {
    int size;
    int[] tumpukanBiner;
    int top;
    
        public StackKonversi() {
            this.size = 32; 
            tumpukanBiner = new int[size];
            top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == size -1;
        }

        public void push(int data) {
            if (isFull()) {
                System.out.println("Stack penuh");
            } else {
                top++;
                tumpukanBiner[top] = data;
            }
        }

        public int pop() {
            if (isEmpty()) {
                System.out.println("Stack kosong");
                return -1;
            } else {
                int data = tumpukanBiner[top];
                top--;
                return data;
            }
        }
    }
}