package pt_3;
import java.util.Scanner;
public class PraktikumBola {
    public static class Bola {
        public double jariJari;
        
        double hitungLuaspermukaan() {
            return (4 * 3.14 * Math.pow(jariJari, 2));
        }

        double volume() {
            return 3.14 * Math.pow(jariJari, 3) * (4 / 3);
        }
    }
}
