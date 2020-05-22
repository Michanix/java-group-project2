package entities.player;

public class PlayerStats {
    private int           physDmg;
    private int          magicDmg;
    private int           physDef;
    private int          magicDef;

    public PlayerStats(WeaponType weapon, ArmorType armor) {
        setPhysDmg(weapon.getPhysDmg());
        setMagicDmg(weapon.getMagicDmg());
        setPhysDef(armor.getPhysDef());
        setMagicDef(armor.getMagDef());
    }

    public int getPhysDmg() {
        return physDmg;
    }

    // Extra damage comes from Weapons
    public void setPhysDmg(int extraDmg) {
        this.physDmg += extraDmg;
    }

    public int getMagicDmg() {
        return magicDmg;
    }

    public void setMagicDmg(int extraDmg) {
        this.magicDmg += extraDmg;
    }

    // Extra defense comes from Armor
    public int getPhysDef() {
        return physDef;
    }

    public void setPhysDef(int extraDef) {
        this.physDef += extraDef;
    }

    public int getMagicDef() {
        return magicDef;
    }

    public void setMagicDef(int extraDef) {
        this.magicDef += extraDef;
    }
}
