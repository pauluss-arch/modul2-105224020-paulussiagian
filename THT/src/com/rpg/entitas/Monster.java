package entitas;

import arena.Karakter;

public class Monster extends Karakter {
    private String jenisMonster;

    public Monster(String nama, int hp, int baseDamage, String jenisMonster) {
        super(nama, hp, baseDamage);
        this.jenisMonster = jenisMonster;
    }

    @Override
    public int serang() {
        System.out.println("Monster " + nama + " (" + jenisMonster + ") mencakar dan menghasilkan " + baseDamage + " damage!");
        return baseDamage;
    }

    @Override
    public void bertahan() {
        // Aturan khusus soal: monster memulihkan sedikit HP alih-alih mengurangi damage
        this.hp += 15;
        System.out.println("Monster " + nama + " mengambil langkah mundur dan memulihkan 15 HP! (HP sekarang: " + this.hp + ")");
    }

    @Override
    public void gunakanItem() {
        System.out.println("Monster " + nama + " tidak tahu cara menggunakan item.");
    }

    @Override
    public void tampilkanStatus() {
        System.out.println("\n=== STATUS MONSTER ===");
        System.out.println("Nama  : " + nama);
        System.out.println("Jenis : " + jenisMonster);
        System.out.println("HP    : " + hp);
        System.out.println("======================");
    }

    public String getJenisMonster() { return jenisMonster; }
    public void setJenisMonster(String jenisMonster) { this.jenisMonster = jenisMonster; }
}