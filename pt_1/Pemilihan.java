import java.util.Scanner;
public class Pemilihan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Program Menghitung Nilai Akhir");
        System.out.println("===============================");

        System.out.print("Masukkan nilai tugas : ");
        int nilaiTugas = input.nextInt();
        System.out.print("Masukkan nilai Kuis : ");
        int nilaiKuis = input.nextInt();
        System.out.print("Masukkan nilai UTS : ");
        int nilaiUts = input.nextInt();
        System.out.print("Masukkan nilai UAS : ");
        int nilaiUas = input.nextInt();

        System.out.println("========================");
        System.out.println("========================");

        if(nilaiTugas < 0 || nilaiTugas > 100 || nilaiKuis < 0 || nilaiKuis > 100 || nilaiUts < 0 || nilaiUts > 100 || nilaiUas < 0 || nilaiUas > 100) {
        System.out.println("nilai tidak valid");

        System.out.println("=========================");
        System.out.println("=========================");

        return;
    }
        double nilaiAkhir = (0.2 * nilaiTugas) + (0.2 * nilaiKuis) + (0.3 * nilaiUts) + (0.4 * nilaiUas);

        String nilaiHuruf;
        if(nilaiAkhir >= 80) {
            nilaiHuruf = "A";
        } else if (nilaiAkhir >= 73) {
            nilaiHuruf = "B+";
        } else if (nilaiAkhir >= 65) {
            nilaiHuruf = "B";
        } else if (nilaiAkhir >= 60) {
            nilaiHuruf = "C+";
        } else if (nilaiAkhir >= 50) {
            nilaiHuruf = "C";
        } else if (nilaiAkhir >= 39) {
            nilaiHuruf = "D";
        } else {
            nilaiHuruf = "E";
        }

      String keterangan;
      if (nilaiHuruf.equals("A") || nilaiHuruf.equals("B") || nilaiHuruf.equals("B+") || nilaiHuruf.equals("C") || nilaiHuruf.equals("C+") || nilaiHuruf.equals("D") || nilaiHuruf.equals("E")) {
        keterangan = "LULUS";
      }  else {
        keterangan = "TIDAK LULUS";
      }

      System.out.println("Nilai akhir : " + nilaiAkhir);
      System.out.println("Nilai huruf : " + nilaiHuruf);

      System.out.println("======================");
      System.out.println("======================");
      System.out.println("SELAMAT ANDA LULUS " + keterangan);
    }
}