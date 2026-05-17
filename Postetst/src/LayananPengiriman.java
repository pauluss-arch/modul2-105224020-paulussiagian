
public abstract class LayananPengiriman {
    private String noResi;
    private double beratBarang;
    private double jarakTempuh;

    public LayananPengiriman(String noResi, double beratBarang, double jarakTempuh) {
        this.noResi = noResi;
        this.beratBarang = beratBarang;
        this.jarakTempuh = jarakTempuh;
    }

    public void cetakResi() {
        System.out.println("Nomor Resi      : " + noResi);
        System.out.println("Berat Barang    : " + beratBarang + " kg");
        System.out.println("Jarak Tempuh    : " + jarakTempuh + " km");
    }

    public abstract double hitungOngkosKirim();

    // Getter untuk akses data yang aman pada kelas turunan
    public String getNoResi() {
        return noResi;
    }

    public double getBeratBarang() {
        return beratBarang;
    }

    public double getJarakTempuh() {
        return jarakTempuh;
    }
}