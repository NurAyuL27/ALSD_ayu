import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        String[] mataKuliah = {"Pancasila", "Konsep Teknologi Informasi", "Critical Thinking Problem Solving",
                                "Matematika Dasar", "Bahsa Inggris", "Dasar Pemrograman",
                                "Praktikum Dasar Pemrograman", "Keselmatan dan Kesehatan Kerja"};
        int[] nilaiAngka = new int[mataKuliah.length];
        String[] nilaiHuruf = new String[mataKuliah.length];
        double[] nilaiSetara = new double[mataKuliah.length];
        double[] sksNilai = new double[mataKuliah.length];
        double[] bobotNilai = {4.0, 3.5, 3.0, 2.5, 2.0, 1.0, 0.0, 0.0};
        double totalSKS = 0;
        double totalSKSNilai = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Program Menghitung IP Semester");
        System.out.println("===============================================================================");

        for (int i = 0; i < mataKuliah.length; i++) {
            System.out.print("Masukkan nilai mata kuliah " + mataKuliah[i] + ": ");
            nilaiAngka[i] = scanner.nextInt();
            nilaiHuruf[i] = konversiNilaiHuruf(nilaiAngka[i]);
            nilaiSetara[i] = konversiNilaiSetaraHuruf(nilaiHuruf[i]);
            sksNilai[i] = nilaiSetara[i] * bobotNilai[i];
            totalSKS += bobotNilai[i];
            totalSKSNilai += sksNilai[i];
        }

        double ipk = totalSKSNilai / totalSKS;
        
        System.out.println("\n=============================================================================");
        System.out.println("Mata Kuliah\t\t\tNilai Angka\tNilai Huruf\tBobot Nilai");
        System.out.println("===============================================================================");
        for (int i = 0; i < mataKuliah.length; i++) {
            System.out.printf("%-35s%-15d%-15s%.2f%n", mataKuliah[i], nilaiAngka[i], nilaiHuruf[i], bobotNilai[i] );
        }
        System.out.println("\n=============================================================================");
        System.out.println("Hasil IPK: " + ipk);
    }

    static String konversiNilaiHuruf(int nilaiAngka) {
        if (nilaiAngka >= 80) {
            return "A";
        } else if (nilaiAngka >= 73) {
            return "B+";
        } else if (nilaiAngka >= 65) {
            return "B";
        } else if (nilaiAngka >= 60) {
            return "C+";
        } else if (nilaiAngka >= 50) {
            return "C";
        } else if (nilaiAngka >= 39) {
            return "D";
        } else {
            return "E";
        }
    }

    static double konversiNilaiSetaraHuruf(String nilaiHuruf) {
        switch (nilaiHuruf) {
            case "A":
                return 4.0;
            case "B+":
                return 3.5;
            case "B":
                return 3.0;
            case "C+":
                return 2.5;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            default:
                return 0.0;
        }
    }
}
