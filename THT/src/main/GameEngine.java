package main;

import entitas.Pahlawan;
import entitas.Monster;
import java.util.Scanner;

public class GameEngine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("       SELAMAT DATANG DI RPG ARENA       ");
        System.out.println("=========================================");
        System.print("Masukkan nama Pahlawan Anda: ");
        String namaPahlawan = scanner.nextLine();

        // Inisialisasi objek Pahlawan (Nama, HP, Base Damage, Mana, Level)
        Pahlawan pahlawan = new Pahlawan(namaPahlawan, 150, 15, 50, 1);

        // Membuat Array berisi 3 buah objek Monster yang berbeda
        Monster[] daftarMonster = new Monster[3];
        daftarMonster[0] = new Monster("Goblin Kroco", 40, 10, "Kecil");
        daftarMonster[1] = new Monster("Orc Prajurit", 70, 15, "Menengah");
        daftarMonster[2] = new Monster("Naga Purba", 120, 25, "Boss");

        System.out.println("\n" + pahlawan.getNama() + " memasuki dungeon tipe Survival!");
        System.out.println("Anda harus mengalahkan 3 monster berturut-turut.");

        boolean menangDungeon = true;

        // Nested Loop: Outer Loop menelusuri array monster
        for (int i = 0; i < daftarMonster.length; i++) {
            Monster monsterSaatIni = daftarMonster[i];
            System.out.println("\n=========================================");
            System.out.println(" Monster " + (i + 1) + " Muncul: " + monsterSaatIni.getNama() + "!");
            System.out.println("=========================================");

            // Inner Loop (Battle Loop) berjalan selama HP Pahlawan > 0 dan HP Monster > 0
            while (pahlawan.getHp() > 0 && monsterSaatIni.getHp() > 0) {
                pahlawan.tampilkanStatus();
                monsterSaatIni.tampilkanStatus();

                System.out.println("\n--- Giliran Anda ---");
                System.out.println("1. Serang Biasa");
                System.out.println("2. Gunakan Skill (Kamehameha - Cost: 20 Mana)");
                System.out.println("3. Bertahan / Heal (Gunakan Potion)");
                System.print("Pilih opsi (1-3): ");
                
                int pilihan = scanner.nextInt();
                int damagePahlawan = 0;

                switch (pilihan) {
                    case 1:
                        damagePahlawan = pahlawan.serang();
                        monsterSaatIni.terimaDamage(damagePahlawan);
                        break;
                    case 2:
                        // Menggunakan metode Overloading serang(Skill, Mana)
                        damagePahlawan = pahlawan.serang("Kamehameha", 20);
                        if (damagePahlawan > 0) {
                            monsterSaatIni.terimaDamage(damagePahlawan);
                        } else {
                            // Jika mana kurang, dianggap hangus gilirannya karena salah strategi
                            System.out.println("Giliran terbuang karena kehabisan Mana!");
                        }
                        break;
                    case 3:
                        // Pahlawan bersiap bertahan sekalian memulihkan darah
                        pahlawan.bertahan();
                        pahlawan.gunakanItem();
                        break;
                    default:
                        System.out.println("Pilihan tidak valid! Anda mematung di giliran ini.");
                        break;
                }

                // Cek apakah monster sudah mati setelah diserang pahlawan
                if (monsterSaatIni.getHp() <= 0) {
                    System.out.println("\n[SISTEM] " + monsterSaatIni.getNama() + " telah dikalahkan!");
                    break; // Keluar dari battle loop untuk monster ini
                }

                // Giliran Balasan Monster (Kecerdasan buatan acak sederhana)
                System.out.println("\n--- Giliran Musuh ---");
                // Monster memiliki 80% peluang menyerang dan 20% peluang bertahan/heal
                if (Math.random() > 0.2) {
                    int damageMonster = monsterSaatIni.serang();
                    pahlawan.terimaDamage(damageMonster);
                } else {
                    monsterSaatIni.bertahan();
                }

                // Cek kondisi kekalahan pahlawan di tengah pertempuran
                if (pahlawan.getHp() <= 0) {
                    System.out.println("\n[SISTEM] Anda telah tumbang di medan perang.");
                    menangDungeon = false;
                    break;
                }
            }

            // Jika pahlawan mati di tengah jalan, hentikan loop pencarian monster selanjutnya
            if (!menangDungeon) {
                break;
            }
        }

        // Penentuan akhir kondisi permainan di luar looping utama
        System.out.println("\n=========================================");
        if (menangDungeon && pahlawan.getHp() > 0) {
            System.out.println("SELAMAT! " + pahlawan.getNama() + " berhasil menamatkan Dungeon!");
        } else {
            System.out.println("GAME OVER! Anda gagal bertahan di Dungeon.");
        }
        System.out.println("=========================================");
        
        scanner.close();
    }
}