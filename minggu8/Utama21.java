package minggu8;
import java.util.Scanner;

import minggu8.Barang21.Gudang21;

public class Utama21 {
    public static void main(String[] args) {
    Gudang21 gudang21 = new Gudang21(7);
    Scanner scanner = new Scanner(System.in);

    while(true) {
        System.out.println("\nMenu:");
        System.out.println("1. Tambah Barang");
        System.out.println("2. Ambil Barang");
        System.out.println("3. Tampilkan tumpukan barang");
        System.out.println("4. Lihat barang terbawah");
        System.out.println("5. Cari Barang");
        System.out.println("6. Keluar");
        System.out.print("Pilih operasi: ");
        int Pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (Pilihan) {
            case 1:
                System.out.print("Masukkan kode barang: ");
                int kode = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Masukkan nama barang: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan nama kategori: ");
                String kategori = scanner.nextLine();
                Barang21 barangBaru = new Barang21(kode, nama, kategori);
                gudang21.tambahBarang(barangBaru);
                break;
            case 2:
                gudang21.ambilBarang();
                break;
            case 3:
                gudang21.tampilkanBarang();
                break;
            case 4:
                gudang21.lihatBarangTerbawah();
                break;
            case 5:
                System.out.print("Masukkan kode barang yang ingin dicari: ");
                int kodeCari = scanner.nextInt();
                gudang21.cariBarang21( kodeCari);
                break;
            case 6:
                System.out.println("Program selesai.");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid. silahkan coba lagi.");
            }
        }
    }
}