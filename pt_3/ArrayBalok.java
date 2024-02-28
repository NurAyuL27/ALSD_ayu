package pt_3;

import java.util.Scanner;

import pt_3.PraktikumKerucut.Kerucut;

public class ArrayBalok {
    public static class Balok {
        public int panjang;
        public int lebar;
        public int tinggi;

        double hitungVolume() {
            return ( panjang * lebar * tinggi);
        }

       // public Balok(int p, int l, int t) {
            //panjang = p;
            //lebar = l;
            //tinggi = t;
        //}

        //public int hitungVolume() {
            //return panjang * lebar * tinggi;
        //}
   // }

    //public static void main(String[] args) {
       // Balok[] blArray = new Balok[3];

       // blArray[0] = new Balok(100, 30, 12);
       // blArray[1] = new Balok(120, 40, 15);
       // blArray[2] = new Balok(210, 50, 25);
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
        System.out.println("Masukkan jumlah balok: ");
        int k = sc.nextInt();
        Balok[] blkArray = new Balok[k];

        for(int i = 0; i < k; i++) {
            blkArray[i] = new Balok();
            System.out.println("Balok ke- " + i);
            System.out.print("Masukkan panjang: ");
            blkArray[i].panjang = sc.nextInt();
            System.out.print("Masukkan lebar: ");
            blkArray[i].lebar = sc.nextInt();
            System.out.println("Masukkan tinggi: ");
            blkArray[i].tinggi = sc.nextInt();
            }
            System.out.println();
            for(int i = 0; i < k; i++) {
            System.out.println("Balok ke-" + i);
            System.out.println("Volume Balok: " + blkArray[i].hitungVolume());
        }
        }
    }
}
