
public class PengirimanUdara extends LayananPengiriman implements LacakKargo, Asuransi {
    private String nomorPenerbangan;
    private String statusSaatIni;
    private double nilaiBarang;

    public PengirimanUdara(String noResi, double beratBarang, double jarakTempuh, String nomorPenerbangan, double nilaiBarang) {
        super(noResi, beratBarang, jarakTempuh);
        this.nomorPenerbangan = nomorPenerbangan;
        this.nilaiBarang = nilaiBarang;
        this.statusSaatIni = "Menunggu Jadwal Penerbangan";
    }

    @Override
    public double hitungOngkosKirim() {
        return (getBeratBarang() * 25000) + (getJarakTempuh() * 5000);
    }

    @Override
    public double hitungPremi(double nilaiBarang) {
        return 0.03 * nilaiBarang;
    }

    @Override
    public void updateStatus(String status) {
        this.statusSaatIni = status;
    }

    @Override
    public String cekLokasiTerakhir() {
        return this.statusSaatIni;
    }

    public double getNilaiBarang() {
        return nilaiBarang;
    }
}