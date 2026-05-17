
public class EWallet extends Pembayaran implements Keamanan {
    private String nomorHP;

    public EWallet(String namaPembayar, double nominal, String nomorHP) {
        super(namaPembayar, nominal);
        this.nomorHP = nomorHP;
    }

    @Override
    public void prosesPembayaran() {
        System.out.println("Metode Pembayaran: E-Wallet (" + nomorHP + ")");
        System.out.println("Biaya Admin     : Rp0 (Bebas Biaya)");
        System.out.println("Total Tagihan   : Rp" + getNominal());
        System.out.println("Status          : Pembayaran E-Wallet Berhasil.");
    }

    @Override
    public boolean autentikasi() {
        System.out.println("--> Autentikasi OTP E-Wallet berhasil.");
        return true;
    }
}