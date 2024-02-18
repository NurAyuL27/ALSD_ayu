import java.util.Scanner;
public class FungsiRumus {
   public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("===========================================");
        System.out.println("Program hitung Kecepatan, Jarak, dan Waktu");
        System.out.println("===========================================");
        System.out.println("Menu:");
        System.out.println("1. Hitung Kecepatan");
        System.out.println("2. Hitung Jarak");
        System.out.println("3. Hitung Waktu");
        System.out.println("4. Keluar");
        System.out.println("============================================");
        System.out.print("Pilih Menu (1/2/3/4): ");
        int menu = scanner.nextInt();
        if (menu == 4) {
            break;
        }
        double Kecepatan, jarak, waktu;
        switch (menu) {
            case 1:
                System.out.print("Masukkan jarak (km): ");
                jarak = scanner.nextDouble();
                System.out.print("Masukkan waktu (jam): ");
                waktu = scanner.nextDouble();
                Kecepatan = hitungKecepatan(jarak, waktu);
                System.out.println("Kecepatan adalah: " + Kecepatan + "km/jam");
                break;
            case 2:
                System.out.print("Masukkan Kecepatan (km/jam): ");
                Kecepatan = scanner.nextDouble();
                System.out.print("Masukkan waktu (jam): ");
                waktu = scanner.nextDouble();
                jarak = hitungJarak(Kecepatan, waktu);
                System.out.println("Jarak adalah: " + jarak + " km");
                break;
            case 3:
                System.out.print("Masukkan jarak (km): ");
                Kecepatan = scanner.nextDouble();
                System.out.print("Masukkan kecepatan (km/jam): ");
                jarak = scanner.nextDouble();
                waktu = hitungWaktu(jarak, Kecepatan);
                System.out.printf("Waktu adalah: %.2f jam%n", waktu);
                break;
            default:
                System.out.print("Menu tidak valid");
            }
        }
        scanner.close();
   } 
   public static double hitungKecepatan(double jarak, double waktu) {
        return jarak / waktu;
    }

    public static double hitungJarak(double kecepatan, double waktu) {
        return kecepatan * waktu;
    }

    public static double hitungWaktu(double jarak, double kecepatan) {
        return jarak / kecepatan;
    }
}
