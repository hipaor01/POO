

package deepspace;


class Weapon implements CombatElement{
    private String name;
    private WeaponType type;
    private int uses;
    
    Weapon(String name, WeaponType type, int uses){
        this.name = name;
        this.type = type;
        this.uses = uses;
    }
    
    Weapon(Weapon w){
        name = w.name;
        type = w.type;
        uses = w.uses;
    }
    
    public WeaponType getType(){
        return this.type;
    }
    
    @Override
    public int getUses(){
        return this.uses;
    }
    
    public float power(){
        return this.type.getPower();
    }
    
    @Override
    public float useIt(){
        if(this.uses > 0){
            this.uses--;
            return power();
        }else{
            return 1.0f;
        }
    }
    
    WeaponToUI getUIversion(){
        return new WeaponToUI(this);
    }

    
    public String toString(){
        String texto = "Instancia de Weapon con: \n";
        texto = texto + "name: \n" + name + "\n";
        texto = texto + "type: \n" + type.name() + "\n";
        texto = texto + "uses: \n" + uses + "\n";
        return texto;
    }
}
