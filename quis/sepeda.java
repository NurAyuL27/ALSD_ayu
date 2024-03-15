package quis;

import java.util.Scanner;

public class sepeda {
    int dmtr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sepeda[] sepedaArray = new sepeda[3];

        for(int i = 0; i < 3; i++) {
            sepedaArray[i] = new sepeda();
            System.out.println("Sepeda ke: " + (i));
            sepedaArray[i].dmtr = sc.nextInt();
            System.out.println("Diameter sepeda adalah: ");
        }


    }
}
