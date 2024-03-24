package minggu5;

import java.util.Scanner;

public class Pangkat {
    public int nilai, pangkat;

    public Pangkat(int nilai, int pangkat) {
        this.nilai = nilai;
        this.pangkat = pangkat;
    }

    int pangkatBF(int a, int n) {
        int hasil = 1;
        for(int i = 0; i < n; i++) {
            hasil *= a;
        }
        return hasil;
    }

    int pangkatDC(int a, int n) {
        if(n == 0) {
            return 1;
        } else {
            if(n % 2 == 1) {
                return (pangkatDC(a,n/2)*pangkatDC(a,n/2)*a);
            } else {
                return (pangkatDC(a,n/2)*pangkatDC(a,n/2));
            }
        }
    }

    public static class MainPangkat {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean running = true;

    System.out.println("==============================");
    System.out.println("Menu: ");
    System.out.println("1. Pangkat Brute Force");
    System.out.println("2. Pangkat Divide and conquer");
    System.out.println("Keluar");
    System.out.println("==============================");
    int pilihan = sc.nextInt();

    switch (pilihan) {
        case 1:
            System.out.println("Masukkan nilai yang akan dipangkatkan: ");
            int nilaiBF = sc.nextInt();
            System.out.println("Masukkan nilai pemangkat: ");
            int pangkatBF = sc.nextInt();
            Pangkat pngktBF = new Pangkat(nilaiBF, pangkatBF);
            System.out.println("Hasil pangkat menggunakan Brute Force: " + pngktBF.pangkatBF(nilaiBF, pangkatBF));
                break;
    
        case 2:
            System.out.println("Masukkan nilai yang akan dipangkatkan: ");
            int nilaiDC = sc.nextInt();
            System.out.println("Masukkan nilai pemangkat: ");
            int pangkatDC = sc.nextInt();
            Pangkat pngktDC = new Pangkat(nilaiDC, pangkatDC);
            System.out.println("Hasil pangkat menggunakan Divide and Condquer: " + pngktDC.pangkatDC(nilaiDC, pangkatDC));
                break;

        case 3:
            running = false;
            System.out.println("Program dihentikan");
            break;

    default:
    System.out.println("Pilihan tidak valid.");
    break;
            }
        }
    }
}
