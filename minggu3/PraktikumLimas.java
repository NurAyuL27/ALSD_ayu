package minggu3;
import java.util.Scanner;
public class PraktikumLimas {
    public static class Limas {
        public double sisiAlas;
        public double tinggi;
        public double sisiMiring;

        double sisiMiringKerucut() {
            sisiMiring = Math.sqrt(Math.pow(sisiAlas/2, 2) + Math.pow(tinggi, 2));
            return sisiMiring;
        }

        double hitungLuaspermukaan() {
            sisiMiringKerucut();
            return Math.pow(sisiAlas, 2) + ((sisiAlas * sisiMiring / 2) * 4);
        }

        double volume() {
            return Math.pow(sisiAlas, 2) * tinggi / 3;
        }
    }
}
