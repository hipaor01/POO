

package deepspace;

import java.util.ArrayList;


class NumericDamage extends Damage{
    private int nWeapons;
    
    NumericDamage(int s, int w){
        super(s);
        nWeapons = w;
    }
    
    @Override
    Damage copy(){
        return new NumericDamage(this.getNShields(), this.nWeapons);
    }
    
    public int getNWeapons(){
        return nWeapons;
    }
    
    @Override
    public void discardWeapon(Weapon w){
        if(nWeapons > 0)
            nWeapons--;
    }
    
    public boolean hasNoEffect(){
        if(super.hasNoEffect() && nWeapons == 0)
            return true;
        else
            return false;
    }
    
    @Override
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        int minNWeapons = Math.min(nWeapons, w.size());
        
        return new NumericDamage(ajustarNShields(s), minNWeapons);
    }
    
    @Override
    NumericDamageToUI getUIversion(){
        return new NumericDamageToUI(this);
    }
    
    public String toString(){
        String texto = "Instancia de NumericDamage con: \n";
        texto = texto + super.toString();
        texto = texto + "nWeapons: \n" + nWeapons + "\n";
        
        return texto;
    }
}
