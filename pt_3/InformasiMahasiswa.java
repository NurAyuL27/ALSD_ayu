package pt_3;
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
        
        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Data Mahasiswa ke-" + (i + 1));
            System.out.println("Nama : " + mahasiswasArray[i].nama);
            System.out.println("NIM : " + mahasiswasArray[i].nim);
            System.out.println("Jenis kelamin : " + mahasiswasArray[i].jenisKelamin);
            System.out.println("Nilai IPK : " + mahasiswasArray[i].ipk);
        }
    }
}