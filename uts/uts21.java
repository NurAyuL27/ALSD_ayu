package uts;
import java.util.Scanner;

public class uts21 {
    static int[] angka = {1, 33, 14, 0, 29, 25, 12, 28, 18, 49, 11, 32, 15, 30, 45, 28, 36};

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = angka[i];
            int j = i - 1;

            while (j >= 0 && angka[j] > key) {
                angka[j + 1] = angka[j];
                j = j - 1;
            }
            angka[j + 1] = key;
        }
    }

    public static int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = angka.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (angka[mid] == x) {
                return mid;
            }
            if (angka[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = angka.length;

        System.out.println("Angka sebelum diurutkan: ");
        for (int i = 0; i < n; i++) {
            System.out.print(angka[i] + " ");
        }
        System.out.println();
        insertionSort(angka);

        System.out.println("Angka Setelah diurutkan:");
        for (int i = 0; i < n; i++) {
            System.out.print(angka[i] + " ");
        }

        System.out.println();

        System.out.println("Masukkan Angka yang ingin dicari: ");
        int x = scanner.nextInt();

        int result = binarySearch(angka, x);

        if (result == -1) {
            System.out.println("Angka tidak ditemukan.");
        } else {
            System.out.println("Angka ditemukan pada indeks ke-" + result + " .");
        }
    }
}
