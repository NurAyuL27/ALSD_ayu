import java.util.Scanner;
public class Fungsi1 {
    public static void main(String[] args) {
        String[] cabang = {"Royal Garden 1", "Royal Garden 2", "Royal Garden 3", "Royal Garden 4"};
        int[][] stockBunga = {
            {10, 5, 15, 7}, 
            {6, 11, 9, 12}, 
            {2, 10, 10,5},
            {5, 7, 12, 9}
        };
        int[] hargaBunga = {75000, 50000, 60000, 10000};

        System.out.println("======================================================================");
        System.out.println("|                | Aglonema   | Keladi     |Alocasia    |Mawar        ");
        System.out.println("======================================================================");

        for (int i = 0; i < cabang.length; i++) {
            System.out.printf("| %-14s | %-10d | %-10d | %-10d | %-10d |\n", 
            cabang[i], stockBunga[0][i], stockBunga[1][i], stockBunga[2][i], stockBunga[3][i], hargaBunga[i]);
        }
        System.out.println("======================================================================");
        hitungPendapatan(stockBunga, hargaBunga, cabang);
        hitungStockBungaRoyalGarden4(stockBunga);
    }

    static void hitungPendapatan(int[][] stockBunga, int[] hargaBunga, String[] cabang) {
        int totalPendapatan = 0;
        for (int i = 0; i < stockBunga.length; i++) {
            int pendapatanCabang = 0;
            for (int j = 0; j < stockBunga[i].length; j++) {
                pendapatanCabang += stockBunga[i][j] * hargaBunga[j];
            }
            System.out.println("pendapatan dari " + cabang[i] + " Rp: " + pendapatanCabang);
            totalPendapatan += pendapatanCabang;
        }
        System.out.println("\nPendapatan Seluruh cabang Rp: " + totalPendapatan);
    }

    static void hitungStockBungaRoyalGarden4(int[][] stockBunga) {
        System.out.println("===========================================");
        System.out.println("\nJumlah Stock Bunga di Royal Garden 4:");
        System.out.println("Aglonema: " + stockBunga[3][0]);
        System.out.println("Keladi: " + stockBunga[3][1]);
        System.out.println("Alocasia: " + stockBunga[3][2]);
        System.out.println("Mawar: " + stockBunga[3][3]);
        }
    static void penguranganStockBunga(int[][] stockBunga) {
        stockBunga[3][0] -= 1;
        stockBunga[3][1] -= 2;
        stockBunga[3][3] -= 5;
    }
}
