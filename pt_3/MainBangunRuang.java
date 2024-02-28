package pt_3;
import java.util.Scanner;
import pt_3.PraktikumBola.Bola;
import pt_3.PraktikumKerucut.Kerucut;
import pt_3.PraktikumLimas.Limas;
public class MainBangunRuang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("KERUCUT");
        System.out.print("Masukkan jumlah kerucut: ");
        int k = sc.nextInt();
        Kerucut[] krcArray = new Kerucut[k];

        for(int i = 0; i < k; i++) {
            krcArray[i] = new Kerucut();
            System.out.println("Balok ke- " + i);
            System.out.print("Masukkan jari jari: ");
            krcArray[i].jariJari = sc.nextInt();
            System.out.print("Masukkan sisi miring: ");
            krcArray[i].sisiMiring = sc.nextInt();

        }

        System.out.println();
        for(int i = 0; i < k; i++) {
            System.out.println("Kerucut ke-" + i);
            System.out.println("Luas Permukaan: " + krcArray[i].hitungLuaspermukaan() + " Volume: " + krcArray[i].volume());
        }

        System.out.println("===========================================================================");
        System.out.println("LIMAS");
        System.out.print("Masukkan jumlah limas: ");
        int j = sc.nextInt();
        Limas[] lmsArray = new Limas[j];

        for(int f = 0; f < j; f++) {
            lmsArray[f] = new Limas();
            System.out.println("Limas ke- " + f);
            System.out.print("Masukkan sisi alas: ");
            lmsArray[f].sisiAlas = sc.nextInt();
            System.out.print("Masukkan tinggi: ");
            lmsArray[f].tinggi = sc.nextInt();

        }

        System.out.println();
        for(int f = 0; f < j; f++) {
            System.out.println("Limas ke-" + f);
            System.out.println("Luas Permukaan: " + lmsArray[f].hitungLuaspermukaan() + " volume: " + lmsArray[f].volume());
        }

        System.out.println("===========================================================================");
        System.out.println("BOLA");
        System.out.print("Masukkan jumlah bola: ");
        int o = sc.nextInt();
        Bola[] blArray = new Bola[o];

        for(int p = 0; p < o; p++) {
            blArray[p] = new Bola();
            System.out.println("Bola ke- " + p);
            System.out.print("Masukkan jari jari: ");
            blArray[p].jariJari = sc.nextInt();
        }

        System.out.println();
        for(int p = 0; p < o; p++) {
            System.out.println("Bola ke-" + p);
            System.out.println("Luas Permukaan: " + blArray[p].hitungLuaspermukaan() + " volume: " + blArray[p].volume());
        }
    }
}
