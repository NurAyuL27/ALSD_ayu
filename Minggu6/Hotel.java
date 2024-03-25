package Minggu6;

public class Hotel {
    String nama;
    String kota;
    int harga;
    Byte bintang;

    public Hotel(String n, String k, int h, byte b) {
        nama = n;
        kota = k;
        harga = h;
        bintang = b;
    }
}

class HotelService {
    Hotel [] rooms = new Hotel [5];
    int hitung = 0;

    void tambah (Hotel H) {
        if (hitung < rooms.length) {
            rooms [hitung] = H;
            hitung++;
        } else {
            System.out.println("Maaf, kamar sudah penuh!");
        }
    }

    void tampilAll() {
        for (Hotel room : rooms) {
                System.out.println("Nama: " + room.nama + ", Kota: " + room.kota + ", Harga: " + room.harga + ", Bintang: " + room.bintang);
        }
    }

    void bubbleSortByPrice() {
        for (int i = 0; i < hitung - 1; i++) {
            int idxMax = i;
            for (int j = i; j < hitung - i - 1; j++) {
                if (rooms[j].harga > rooms [j + 1].harga) {
                    Hotel temp = rooms[j];
                    rooms[j] = rooms [j + 1];
                    rooms [j + 1] = temp;
                }
            }
        }
    }

    void selectionSort() {
        for (int i = 0; i < hitung - 1; i++) {
            int idxMax = i;
            for (int j = i+1; j < hitung; j++) {
                if (rooms[j].bintang > rooms [idxMax].bintang) {
                    idxMax = j;
                }
            }
            Hotel temp = rooms [idxMax]; 
            rooms [idxMax] = rooms[i];
            rooms [i] = temp;
        }
    }
}

class MainHotel {
    public static void main(String[] args) {

        HotelService hotelService = new HotelService();
        Hotel hotell = new Hotel ("Hotel Mercusuar", "Blitar", 500000, (byte) 4); 
        Hotel hotel2 = new Hotel ("Hotel Burj Kalifa", "jepang", 1000000, (byte) 3); 
        Hotel hotel3 = new Hotel ("Hotel tomhawn", "solo", 520000,(byte) 5); 
        Hotel hotel4 = new Hotel ("Hotel sengkaling", "jakarta", 70000, (byte) 2); 
        Hotel hotel5 = new Hotel ("Hotel bobobox", "Singapura", 1900000, (byte ) 1);

        hotelService.tambah (hotell); 
        hotelService.tambah (hotel2); 
        hotelService.tambah (hotel3); 
        hotelService.tambah (hotel4); 
        hotelService.tambah (hotel5);

        System.out.println("=======================================================");
        System.out.println("Sebelum sorting:"); 
        hotelService.tampilAll();

        System.out.println("=======================================================");
        System.out.println("Setelah sorting harga:"); 
        hotelService.bubbleSortByPrice();
        hotelService.tampilAll();

        System.out.println("=======================================================");
        System.out.println("Setelah sorting bintang:");
        hotelService.selectionSort(); 
        hotelService.tampilAll();
        System.out.println("=======================================================");
    }
}
