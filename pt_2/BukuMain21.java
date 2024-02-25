package pt_2;
public class BukuMain21 {
    public static void main(String[] args) {
        
    Buku21 bk1 = new Buku21();

    bk1.judul = "Today Ends Tomorrow Comes";
    bk1.pengarang = "Denanda Pratiwi";
    bk1.halaman = 198;
    bk1.stok = 13;
    bk1.harga = 71000;

    bk1.tampilInformasi();
    System.out.println("Total harga: " + bk1.hitungHargaTotal());
    System.out.println("Diskon: " + bk1.hitungDiskon());
    System.out.println("Total Bayar: " + bk1.hitungBayar());

    bk1.terjual(5);

    bk1.gantiHarga(60000);

    bk1.tampilInformasi();

    Buku21 bk2 = new Buku21("Self Reward", "Maheera Ayesha", 160, 29, 59000);
    bk2.terjual(11);
    bk2.tampilInformasi();
    System.out.println("Total Harga: " + bk2.hitungHargaTotal());
    System.out.println("Diskon: " + bk2.hitungDiskon());
    System.out.println("Total Bayar: " + bk2.hitungBayar());
    }
}