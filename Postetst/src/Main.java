// Main.java
public class Main {
    public static void main(String[] args) {
        // 1. Inisialisasi Objek Pengiriman Darat
        PengirimanDarat darat = new PengirimanDarat("DRT-001", 50, 100, "Tronton");
        
        // 2. Inisialisasi Objek Pengiriman Udara
        PengirimanUdara udara = new PengirimanUdara("UDR-999", 10, 800, "GA-123", 5000000);

        // 3. Update status operasional real-time sebelum dimasukkan ke array
        darat.updateStatus("Sedang di jalan tol Cipali");
        udara.updateStatus("Transit di Bandara Soekarno-Hatta");

        // 4. Menyimpan objek ke dalam array polimorfisme bertipe LayananPengiriman[]
        LayananPengiriman[] daftarPengiriman = { darat, udara };

        System.out.println("==================================================");
        System.out.println("       LOGISTIK-PRO: LAPORAN OPERASIONAL HARIAN   ");
        System.out.println("==================================================");

        // 5. Perulangan untuk memproses data secara polimorfik
        for (LayananPengiriman layanan : daftarPengiriman) {
            layanan.cetakResi();

            // Casting secara polimorfik untuk mengecek lokasi terakhir dari LacakKargo
            if (layanan instanceof LacakKargo) {
                LacakKargo pelacak = (LacakKargo) layanan;
                System.out.println("Lokasi Terakhir : " + pelacak.cekLokasiTerakhir());
            }

            double ongkosKirimDasar = layanan.hitungOngkosKirim();
            double totalTagihan = ongkosKirimDasar;

            System.out.println("Ongkos Kirim    : Rp " + ongkosKirimDasar);

            // 6. Pengecekan fitur asuransi menggunakan operator instanceof
            if (layanan instanceof Asuransi) {
                System.out.println("----------------- Info Asuransi -----------------");
                Asuransi komponenAsuransi = (Asuransi) layanan;
                
                // Memanggil default method dari interface
                komponenAsuransi.cetakPolis();
                
                // Karena perhitungan premi butuh nilai barang, kita cast ke PengirimanUdara
                if (layanan instanceof PengirimanUdara) {
                    PengirimanUdara pUdara = (PengirimanUdara) layanan;
                    double biayaPremi = komponenAsuransi.hitungPremi(pUdara.getNilaiBarang());
                    System.out.println("Biaya Premi     : Rp " + biayaPremi);
                    totalTagihan += biayaPremi; // Menambahkan premi ke total akhir
                }
            }

            System.out.println("--------------------------------------------------");
            System.out.println("TOTAL TAGIHAN   : Rp " + totalTagihan);
            System.out.println("==================================================\n");
        }
    }
}