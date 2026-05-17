package arena;

public abstract class Karakter implements AksiBertarung {
    protected String nama;
    protected int hp;
    protected int baseDamage;
    protected boolean isDefending;

    public Karakter(String nama, int hp, int baseDamage) {
        this.nama = nama;
        this.hp = hp;
        this.baseDamage = baseDamage;
        this.isDefending = false;
    }

    public void terimaDamage(int damage) {
        int damageDiterima = damage;
        if (isDefending) {
            damageDiterima = damage / 2;
            isDefending = false; 
            System.out.println(nama + " bertahan! Damage berkurang menjadi " + damageDiterima);
        }
        
        this.hp -= damageDiterima;
        if (this.hp < 0) {
            this.hp = 0;
        }
        System.out.println(nama + " menerima " + damageDiterima + " damage. (Sisa HP: " + this.hp + ")");
    }

    public abstract void tampilkanStatus();

    // Getter dan Setter
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }

    public int getBaseDamage() { return baseDamage; }
    public void setBaseDamage(int baseDamage) { this.baseDamage = baseDamage; }

    public boolean isDefending() { return isDefending; }
    public void setDefending(boolean defending) { isDefending = defending; }
}