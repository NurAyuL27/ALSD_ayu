import java.util.Scanner;
public class ArrayPlat {
    public static void main(String[] args) {
        char[] KODE = {'A', 'B', 'D', 'E', 'F', 'G', 'H', 'L', 'N', 'T'};
        String[][] KOTA = {
            {"B A N T E N"},
            {"J A K A R T A"},
            {"B A N D U N G"},
            {"C I R E B O N"},
            {"B O G O R"},
            {"P E K A L O N G A N"},
            {"S E M A R A N G"},
            {"S U R A B A Y A"},
            {"M A L A N G"},
            {"T E G A L"}
        };

        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kode plat nomor: ");
        char kodePlat = scanner.next().charAt(0);

        String kota = "";
        for (int i = 0; i < KODE.length; i++) {
            if (kodePlat == KODE[i]) {
                kota = KOTA[i][0];
                break;
            }
        }

        if (!kota.equals("")) {
            System.out.println("Kota untuk kode plat " + kodePlat + " adalah: " + kota);
        } else {
            System.out.println("Kode plat nomor tidak ditemukan.");
        }

        scanner.close();
    }
}
