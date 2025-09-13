

package deepspace;

import java.util.ArrayList;


abstract class Damage {
    private int nShields;
    
    Damage(int s){
        nShields = s;
    }
    
    abstract Damage copy();
    public abstract void discardWeapon(Weapon w);
    
    public void discardShieldBooster(){
        if(nShields > 0)
            nShields--;
    }
    
    public boolean hasNoEffect(){
        return (nShields == 0);
    }
    
    
    public int getNShields(){
        return nShields;
    }
    
    protected int ajustarNShields(ArrayList<ShieldBooster> s){
        return Math.min(nShields, s.size());
    }
    
    public abstract Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s);
    
    
    abstract DamageToUI getUIversion();
    
    public String toString(){
        String texto = "nShields: \n" + nShields + "\n";
        return texto;
    }
}
