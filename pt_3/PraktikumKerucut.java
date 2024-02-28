package pt_3;
import java.util.Scanner;

public class PraktikumKerucut {
    public static class Kerucut {
        public double jariJari;
        public double tinggi;
        public double sisiMiring;

        double hitungLuaspermukaan() {
            return 3.14 * jariJari * (sisiMiring + jariJari);
        }

        double tinggiKerucut() {
            tinggi = Math.sqrt(Math.pow(sisiMiring, 2) - Math.pow(jariJari, 2));
            return tinggi;
        }

        double volume() {
            tinggiKerucut();
            return (3.14 * Math.pow(jariJari, 2) * tinggi) / 3;
        }
    }
}
