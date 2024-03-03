package pt_3;
import java.util.Scanner;
public class ArrayObjects {
    public static class PersegiPanjang {
        public int panjang;
        public int lebar;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan jumlah persegi panjang: ");
        int length = sc.nextInt();
        PersegiPanjang[] ppArray = new PersegiPanjang[length];

        for(int i = 0; i < length; i++) {
            ppArray[i] = new PersegiPanjang();
            System.out.println("Persegi panjang ke- " + i);
            System.out.print("Masukkan panjang: ");
            ppArray[i].panjang = sc.nextInt();
            System.out.print("Masukkan lebar: ");
            ppArray[i].lebar = sc.nextInt();
        }
        for(int i = 0; i < length; i++) {
            System.out.println("Persegi panjang ke- " + i);
            System.out.println("Panjang: " + ppArray[i].panjang + ", lebar: " + ppArray[i].lebar);
        }
    }
}
