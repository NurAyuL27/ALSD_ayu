package minggu5;

import java.util.Scanner;

public class Pangkat {
    public int nilai, pangkat;

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

    System.out.println("==============================");
    System.out.println("Menu: ");
    System.out.println("1. Pangkat Brute Force");
    System.out.println("2. Pangkat Divide and conquer");
    System.out.println("Keluar");
    System.out.println("==============================");
    int pilihan = sc.nextInt();

    System.out.println("==============================");
    System.out.println("Masukkan jumlah elemen yang dihitung: ");
    int elemen = sc.nextInt();

    Pangkat[] png = new Pangkat[elemen];
    for(int i=0; i < elemen; i++) {
        png[i] = new Pangkat();
        System.out.println("Masukkan nilai yang dipangkatkan: ");
        png[i].nilai = sc.nextInt();
        System.out.println("Masukkan nilai pemangkat: ");
        png[i].pangkat = sc.nextInt();
    }


    switch (pilihan) {
        case 1:
            System.out.println("HASIL PANGKAT - BRUTE FORCE");
            for(int i = 0; i < elemen; i++) {
            System.out.println("Hasil dari " + png[i].nilai + " pangkat " + png[i].pangkat+ " adalah " + png[i].pangkatBF(png[i].nilai, png[i].pangkat));
        }
            break;
    
        case 2:
            System.out.println("HASIL PANGKAT - DIVINE AND CONQUER");
            for(int i = 0; i < elemen; i++) {
            System.out.println("Hasil dari " + png[i].nilai + " pangkat " + png[i].pangkat+ " adalah " + png[i].pangkatDC(png[i].nilai, png[i].pangkat));
        }
            break;

        default:
            break;
    }
    
    
        }
    }
}