package minggu3;
import java.util.Scanner;

public class InformasiMahasiswa {
    public static class Mahasiswa {
        public String nama;
        public String nim;
        public String jenisKelamin;
        public double ipk;
    }
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = sc.nextInt();
    
        Mahasiswa[] mahasiswasArray = new Mahasiswa[jumlahMahasiswa];
    
        for (int i = 0; i < jumlahMahasiswa; i++) {
            mahasiswasArray[i] = new Mahasiswa();
            System.out.println("Data mahasiswa ke-" + (i + 1));
            sc.nextLine();
            System.out.print("Masukkan Nama: ");
            mahasiswasArray[i].nama = sc.nextLine();
            System.out.print("Masukkan NIM: ");
            mahasiswasArray[i].nim = sc.nextLine();
            System.out.print("Masukkan jenis kelamin: ");
            mahasiswasArray[i].jenisKelamin = sc.nextLine();
            System.out.print("Masukkan IPK: ");
            mahasiswasArray[i].ipk = sc.nextDouble();
            System.out.println();
        }
    
        tampilkanDataMahasiswa(mahasiswasArray, jumlahMahasiswa);
        hitungRataRataIPK(mahasiswasArray, jumlahMahasiswa);
        tampilHasilIPK(mahasiswasArray, jumlahMahasiswa);
    }
    
        public static void tampilkanDataMahasiswa(Mahasiswa[] mahasiswasArray, int jumlahMahasiswa) {
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Data Mahasiswa ke-" + (i + 1));
            System.out.println("Nama : " + mahasiswasArray[i].nama);
            System.out.println("NIM : " + mahasiswasArray[i].nim);
            System.out.println("Jenis kelamin : " + mahasiswasArray[i].jenisKelamin);
            System.out.println("Nilai IPK : " + mahasiswasArray[i].ipk);
        }
    }
    
    public static void hitungRataRataIPK(Mahasiswa[] mahasiswasArray, int jumlahMahasiswa) {
        double totalIPK = 0;
        for (int i = 0; i < jumlahMahasiswa; i++) {
            totalIPK += mahasiswasArray[i].ipk;
        }
        double rataRta = totalIPK / jumlahMahasiswa;
        System.out.println();
        System.out.println("Rata rata IPK dari " + jumlahMahasiswa + " mahasiswa " + rataRta);
    }
    
    
    public static void tampilHasilIPK(Mahasiswa[] mahasiswasArray, int jumlahMahasiswa) {
        double maxlIPK = mahasiswasArray[0].ipk;
        int indexMax = 0;
        for (int i = 1; i < jumlahMahasiswa; i++) {
            if (mahasiswasArray[i].ipk > maxlIPK) {
                maxlIPK = mahasiswasArray[i].ipk;
                indexMax = i;
            }
        }
    
        System.out.println();
        System.out.println("Mahasiswa dengan IPK tertinggi: ");
        System.out.println("Nama: " + mahasiswasArray[indexMax].nama);
        System.out.println("NIM: " + mahasiswasArray[indexMax].nim);
        System.out.println("Jenis kelamin: " + mahasiswasArray[indexMax].jenisKelamin);
        System.out.println("Nilai IPK: " + mahasiswasArray[indexMax].ipk);
    }
}