package pt_2;
public class Buku21 {
   String judul, pengarang;
   int halaman, stok, harga;

   public Buku21() {
   
}
        public Buku21(String jud, String pg, int hal, int stok, int har) {
        judul = jud;
        pengarang = pg;
        halaman = hal;
        this.stok = stok;
        harga = har;
}
   
   void tampilInformasi() {
        System.out.println("Judul: " + judul);
        System.out.println("pengarang: " + pengarang);
        System.out.println("Jumlah halaman: " + halaman);
        System.out.println("Sisa Stok: " + stok);
        System.out.println("Harga: " + harga);
    }

   void terjual(int jml){
        stok -= jml;
    }

    void restock(int jml){
        stok += jml;
    }

    void gantiHarga(int hrg){
        harga = hrg;
    }

    int hitungHargaTotal() {
        return harga * stok;
    }

    int hitungDiskon() {
        int hargaTotal = hitungHargaTotal();
        if (hargaTotal > 150000) {
            return hargaTotal * 12 / 100;   
        } else if (hargaTotal >= 150000) {
            return hargaTotal * 5 / 100;
        } else {
            return 0;
        }
    }

    int hitungBayar() {
        int hargaTotal = hitungHargaTotal();
        int diskon = hitungDiskon();
        return hargaTotal - diskon;
    }
}