package minggu7;

import java.util.Scanner;

public class Buku21 {
    String kodeBuku;
    String judulBuku;
    int tahunTerbit;
    String pengarang;
    int stock;
    
    public Buku21(String kodeBuku, String judulBuku, int tahunTerbit, String pengarang, int stock) {
        this.kodeBuku = kodeBuku;
        this.judulBuku = judulBuku;
        this.tahunTerbit = tahunTerbit;
        this.pengarang = pengarang;
        this.stock = stock;
    }

    public void tampilDataBuku() {
        System.out.println("=========================================================");
        System.out.println("Kode buku       : " + kodeBuku);
        System.out.println("Judul buku      : " + judulBuku);
        System.out.println("Tahun terbit    : " + tahunTerbit);
        System.out.println("Pengarang       : " + pengarang);
        System.out.println("Stock           : " + stock);
    }

    public static class PencarianBuku21 {
        Buku21 listBk[] = new Buku21[5];
        int idx;

        void tambah(Buku21 m) {
            if (idx < listBk.length) {
                listBk[idx] = m;
                idx++;
            } else {
                System.out.println("Data sudah penuh!");
            }
        }

        void tampil() {
            for (Buku21 m : listBk) {
                m.tampilDataBuku();
            }
        }

        public int FindSeqSequentialSearch(String cari) {
            for (int j = 0; j < listBk.length; j++) {
                if (listBk[j].kodeBuku.equals(cari)) {
                   return j;
                }
            }
            return -1;
        }

        public int FindBinarySearch(String cari, int left, int right) {
            if (right >= left) {
                int mid = left + (right - left) / 2;
                int compareResult = listBk[mid].kodeBuku.compareTo(cari);
                if (compareResult == 0) 
                    return mid;
            else if (compareResult < 0)
                    return FindBinarySearch(cari, mid + 1, right);
            else 
                return FindBinarySearch(cari, left, mid + 1);
            }
            return -1;
        }

        public void TampilPosisi(String x, int pos) {
            if (pos != -1) {
                System.out.println("Data : " + x + " ditemukan pada indeks " + pos);
            } else {
                System.out.println("Data : " + x + " tidak ditemukan");
            }
        }

        public void TampilData(String x, int pos) {
            if (pos != -1) {
                System.out.println("Kode buku       : " + x);
                System.out.println("Judul           : " + listBk[pos].judulBuku);
                System.out.println("Tahun terbit    : " + listBk[pos].tahunTerbit);
                System.out.println("Pengarang       : " + listBk[pos].pengarang);
                System.out.println("Stock           : " + listBk[pos].stock);
            } else {
                System.out.println("Data " + x + " tidak ditemukan");
            }
        }


        public static class BukuMain21 {
            public static void main(String[] args) {
                Scanner s = new Scanner(System.in);
                Scanner s1 = new Scanner(System.in);

                PencarianBuku21 data = new PencarianBuku21();
                int jumBuku = 5;

                System.out.println("---------------------------------------------------------");
                System.out.println("Masukkan data buku secara urut dari kode buku terkecil : ");
                for (int i = 0; i < jumBuku; i++) {
                    System.out.println("---------------------------------------------------------");
                    System.out.print("Kode buku     : ");
                    String kodeBuku = s.nextLine();
                    System.out.print("Judul buku    : ");
                    String judulBuku = s1.nextLine();
                    System.out.print("Tahun terbit  : ");
                    int tahunTerbit = s.nextInt();
                    System.out.print("Pengarang     : ");
                    String pengarang = s1.nextLine();
                    System.out.print("Stock         : ");
                    int stock = s.nextInt();

                    Buku21 m = new Buku21(kodeBuku, judulBuku, tahunTerbit, pengarang, stock);
                    data.tambah(m);
                }
                System.out.println("---------------------------------------------------------");
                System.out.println("Data keseluruhan buku      : ");
                data.tampil();

                System.out.println("_________________________________________________________");
                System.out.println("_________________________________________________________");
                System.out.println("Pencarian data");
                System.out.println("Masukkan kode buku yang dicari");
                System.out.print("Kode buku : ");
                String cari = s.nextLine();
                System.out.println("=========================================================");
                System.out.println("Menggunakan Sequential Search");
                int posisi = data.FindSeqSequentialSearch(cari);
                data.TampilPosisi(cari, posisi);
                data.TampilData(cari, posisi);
                System.out.println("=========================================================");
                System.out.println("Menggunakan binary search");
                posisi = data.FindBinarySearch(cari, 0, jumBuku - 1);
                data.TampilPosisi(cari, posisi);
                data.TampilData(cari, posisi);
            }
        }
        
    }
}