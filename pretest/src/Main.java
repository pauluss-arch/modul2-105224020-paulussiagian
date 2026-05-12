public class Main {
    public static void main(String[] args) {
        Programmer p = new Programmer("nauufal ganteng", 50000000);

        System.out.println("Nama Karyawan: " + p.nama);

        System.out.println("Total Gaji: " + p.hitungGaji());
    }
}