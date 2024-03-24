package minggu5;
import java.util.Scanner;
public class Showroom {
    public String[] merk = {"BMW", "Ford", "Nissan", "Subaru", "Subaru", "Toyota", "Toyota", "Volkswagen"};
    public String[] tipe = {"M2 Coupe", "Fiesta ST", "370Z", "BRZ", "Impreza WRX STI", "AE86 Trueno", "86/GT86", "Golf GTI"};
    public int[] tahun = {2016, 2014, 2009, 2014, 2013, 1986, 2014, 2014};
    public int[] top_acceleration = {6816, 3921, 4360, 4058, 6255, 3700, 4180, 4180};
    public int[] top_power = {728, 575, 657, 609, 703, 553, 609, 631};

    public int maxAcceleration(int low, int high) {
        if (low == high)
            return top_acceleration[low];

        int mid = (low + high) / 2;
        int lMax = maxAcceleration(low, mid);
        int rMax = maxAcceleration(mid + 1, high);

        return Math.max(lMax, rMax);
    }

    public int minAcceleration(int low, int high) {
        if (low == high)
            return top_acceleration[low];

            int mid = (low + high) / 2;
            int lMin = minAcceleration(low, mid);
            int rMin = minAcceleration(mid + 1, high);

            return Math.min(lMin, rMin);
    }

    public double averagePower() {
        int sum = 0;
        for (int power : top_power) {
            sum += power;
        }
        return (double) sum / top_power.length;
    }

    public static void main(String[] args) {
        Showroom showroom = new Showroom();

        int maxAcceleration = showroom.maxAcceleration(0, showroom.top_acceleration.length - 1);
        System.out.println("Top Acceleration tertinggi: " + maxAcceleration);

        int minAcceleration = showroom.minAcceleration(0, showroom.top_acceleration.length - 1);
        System.out.println("Top Acceleration terendah: " + minAcceleration);

        double averagePower = showroom.averagePower();
        System.out.println("Rata-rata Top Power: " + averagePower);
    }
}