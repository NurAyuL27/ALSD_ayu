package minggu3;
import java.util.Scanner;
public class PraktikumBola {
    public static class Bola {
        public double jariJari;
        
        double hitungLuaspermukaan() {
            return 4 * 3.14 * jariJari * jariJari;
        }

        double volume() {
            return (4 / 3) * 3.14 * (jariJari * jariJari * jariJari);
        }
    }
}
