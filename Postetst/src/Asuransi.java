
public interface Asuransi {
    double hitungPremi(double nilaiBarang);

    // Default method Java 8
    default void cetakPolis() {
        System.out.println("Polis Asuransi aktif: Menanggung kehilangan dan kerusakan fisik sebesar 100% dari nilai barang.");
    }
}