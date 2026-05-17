
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Membuat ArrayList dengan tipe data abstract class Pembayaran
        ArrayList<Pembayaran> daftarTransaksi = new ArrayList<>();

        // Mengisi objek dengan data acak
        daftarTransaksi.add(new KartuKredit("Ical", 500000, "4563-9874-2213-0988"));
        daftarTransaksi.add(new EWallet("Nopal", 150000, "081234567890"));

        // Menelusuri arraylist menggunakan perulangan (Polimorfisme)
        for (Pembayaran transaksi : daftarTransaksi) {
            transaksi.tampilkanDetail();
            
            // Pengecekan tipe menggunakan instanceof untuk memastikan implementasi Keamanan
            if (transaksi instanceof Keamanan) {
                Keamanan komponenKeamanan = (Keamanan) transaksi;
                
                // Melakukan autentikasi, jika true maka proses pembayaran dijalankan
                if (komponenKeamanan.autentikasi()) {
                    transaksi.prosesPembayaran();
                }
            }
            
            System.out.println("--------------------------------------------------");
        }
    }
}