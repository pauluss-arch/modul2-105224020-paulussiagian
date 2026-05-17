package entitas;

import arena.Karakter;

public class Pahlawan extends Karakter {
    private int mana;
    private int level;

    public Pahlawan(String nama, int hp, int baseDamage, int mana, int level) {
        super(nama, hp, baseDamage);
        this.mana = mana;
        this.level = level;
    }

    @Override
    public int serang() {
        int dmg = baseDamage * level;
        System.out.println(nama + " menyerang biasa dan menghasilkan " + dmg + " damage!");
        return dmg;
    }

    // Overloading Method Serang dengan Skill
    public int serang(String namaSkill, int manaCost) {
        if (this.mana >= manaCost) {
            this.mana -= manaCost;
            int dmg = baseDamage * level * 2;
            System.out.println(nama + " menggunakan skill [" + namaSkill + "]! Menghasilkan " + dmg + " damage!");
            return dmg;
        } else {
            System.out.println("Mana tidak cukup untuk menggunakan skill " + namaSkill + "!");
            return 0;
        }
    }

    @Override
    public void bertahan() {
        this.isDefending = true;
        System.out.println(nama + " bersiaga dalam posisi bertahan!");
    }

    @Override
    public void gunakanItem() {
        this.hp += 30;
        System.out.println(nama + " menggunakan Potion. HP bertambah 30! (HP sekarang: " + this.hp + ")");
    }

    @Override
    public void tampilkanStatus() {
        System.out.println("\n=== STATUS PAHLAWAN ===");
        System.out.println("Nama  : " + nama);
        System.out.println("HP    : " + hp);
        System.out.println("Mana  : " + mana);
        System.out.println("Level : " + level);
        System.out.println("=======================");
    }

    // Getter dan Setter tambahan untuk Pahlawan
    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }
    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
}