package pt_2;
public class Buku21 {
   String judul, pengarang;
   int halaman, stok, harga;
   
   void tampilInformasi() {
        System.out.println("Judul: " + judul);
        System.out.println("pengarang: " + pengarang);
        System.out.println("Jumlah halaman: " + halaman);
        System.out.println("Sisa Stok: " + stok);
        System.out.println("Harga: " + harga);
    }

   void terjual(int jml){
       if (stok > 0) {
            stok -= jml;
       }
    }

    void restock(int jml){
        stok += jml;
    }

    void gantiHarga(int hrg){
        harga = hrg;
    }
}