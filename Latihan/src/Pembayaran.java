
public abstract class Pembayaran {
    private String namaPembayar;
    private double nominal;

    public Pembayaran(String namaPembayar, double nominal) {
        this.namaPembayar = namaPembayar;
        this.nominal = nominal;
    }

    public void tampilkanDetail() {
        System.out.println("Nama Pembayar   : " + namaPembayar);
        System.out.println("Nominal Awal    : Rp" + nominal);
    }

    public abstract void prosesPembayaran();

    // Getter ditambahkan khusus untuk membantu kelas anak mengakses nilai nominal
    public double getNominal() {
        return this.nominal;
    }
}