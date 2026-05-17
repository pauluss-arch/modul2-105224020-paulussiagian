
public class KartuKredit extends Pembayaran implements Keamanan {
    private String nomorKartu;

    public KartuKredit(String namaPembayar, double nominal, String nomorKartu) {
        super(namaPembayar, nominal);
        this.nomorKartu = nomorKartu;
    }

    @Override
    public void prosesPembayaran() {
        double biayaAdmin = getNominal() * 0.02;
        double totalTagihan = getNominal() + biayaAdmin;
        System.out.println("Metode Pembayaran: Kartu Kredit (" + nomorKartu + ")");
        System.out.println("Biaya Admin (2%): Rp" + biayaAdmin);
        System.out.println("Total Tagihan   : Rp" + totalTagihan);
        System.out.println("Status          : Pembayaran Kartu Kredit Berhasil.");
    }

    @Override
    public boolean autentikasi() {
        System.out.println("--> Autentikasi PIN Kartu Kredit berhasil.");
        return true;
    }
}