class Programmer extends Karyawan {
    
    private double gajiPokok;

    Programmer(String nama, double gajiPokok) {
        super(nama);
        this.gajiPokok = gajiPokok;
    }

    @Override
    double hitungGaji() {
        return gajiPokok;
    }
}