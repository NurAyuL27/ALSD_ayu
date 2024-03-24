package minggu5;

import java.util.Scanner;

public class Sum {
    static class Perusahaan {
        int jumlahBulan;
        double keuntungan[];

        Perusahaan(int jumlahBulan) {
            this.jumlahBulan = jumlahBulan;
            this.keuntungan = new double[jumlahBulan];
        }
    }

    static double totalKeuntunganBF(Perusahaan perusahaan) {
        double totalKeuntungan = 0;
        for (double keuntunganBulan : perusahaan.keuntungan) {
            totalKeuntungan += keuntunganBulan;
        }
        return totalKeuntungan;
    }

    static double totalKeuntunganDC(double[] keuntungan, int start, int end) {
        if (start == end) {
            return keuntungan[start];
        } else {
            int mid = (start + end) / 2;
            double leftTotal = totalKeuntunganDC(keuntungan, start, mid);
            double rightTotal = totalKeuntunganDC(keuntungan, mid + 1, end);
            return leftTotal + rightTotal;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah perusahaan: ");
        int jumlahPerusahaan = sc.nextInt();
        Perusahaan[] perusahaan = new Perusahaan[jumlahPerusahaan];

        for (int i = 0; i < jumlahPerusahaan; i++) {
            System.out.println("Perusahaan ke-" + (i + 1));
            System.out.print("Masukkan jumlah bulan: ");
            int bulan = sc.nextInt();
            perusahaan[i] = new Perusahaan(bulan);
            for (int j = 0; j < bulan; j++) {
                System.out.print("Masukkan keuntungan bulan ke-" + (j + 1) + ": ");
                perusahaan[i].keuntungan[j] = sc.nextDouble();
            }
        }

        System.out.println("============================================================");
        System.out.println("Total Keuntungan (Brute Force):");
        for (int i = 0; i < jumlahPerusahaan; i++) {
            double totalKeuntunganBF = totalKeuntunganBF(perusahaan[i]);
            System.out.println("Total keuntungan perusahaan ke-" + (i + 1) + " adalah: " + totalKeuntunganBF);
        }

        System.out.println("============================================================");
        System.out.println("Total Keuntungan (Divide and Conquer):");
        for (int i = 0; i < jumlahPerusahaan; i++) {
            double totalKeuntunganDC = totalKeuntunganDC(perusahaan[i].keuntungan, 0, perusahaan[i].jumlahBulan - 1);
            System.out.println("Total keuntungan perusahaan ke-" + (i + 1) + " adalah: " + totalKeuntunganDC);
        }
    }
}