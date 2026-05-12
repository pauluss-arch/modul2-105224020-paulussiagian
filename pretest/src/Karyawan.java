abstract class Karyawan {
    
    protected String nama;

    Karyawan(String nama) {
        this.nama = nama;
    }

    abstract double hitungGaji();
}