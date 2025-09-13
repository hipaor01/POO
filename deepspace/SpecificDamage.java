

package deepspace;

import java.util.ArrayList;


class SpecificDamage extends Damage{
    private ArrayList<WeaponType> weapons = new ArrayList<>();
    
    SpecificDamage(ArrayList<WeaponType> wl, int s){
        super(s);
        for(int i = 0; i < wl.size(); i++){
            weapons.add(wl.get(i));
        }
    }
    
    @Override
    Damage copy(){
        return new SpecificDamage(this.weapons, this.getNShields());
    }
    
    public ArrayList<WeaponType> getWeapons(){
        ArrayList<WeaponType> aux = new ArrayList<WeaponType>();
        
        for(int i = 0; i < weapons.size(); i++){
            aux.add(weapons.get(i));
        }
        
        return aux;
    }
    
    private int arrayContaintsType(ArrayList<Weapon> w, WeaponType t){
        for(int i = 0; i < w.size(); i++){
            if(w.get(i).getType() == t)
                return i;
        }
        
        return -1;
    }
    
    @Override
    public void discardWeapon(Weapon w){
        boolean encontrado = false;
        
        if(weapons.size() != 0){
            int i = 0;
            while(i < weapons.size() && encontrado == false){
                if(w.getType() == weapons.get(i)){
                    weapons.remove(i);
                    encontrado = true;
                }
                i++;
            }
        }
    }
    
    @Override
    public boolean hasNoEffect(){
        if(weapons.size() == 0 && super.hasNoEffect())
            return true;
        else
            return false;
    }
    
    @Override
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s){
        ArrayList<WeaponType> aux = new ArrayList<WeaponType>();
        ArrayList<Weapon> aux2 = new ArrayList<>();
        
        for(int i = 0; i < w.size(); i++){
            aux2.add(w.get(i));
        }
        
        if(weapons.size() != 0){
            for(int i = 0; i < weapons.size(); i++){
                int indice = arrayContaintsType(aux2, weapons.get(i));
                if(indice != -1){
                    aux.add(aux2.get(indice).getType());
                    aux2.remove(indice);
                }
            }
        }
        
        return new SpecificDamage(aux, ajustarNShields(s));
    }
    
    @Override
    SpecificDamageToUI getUIversion(){
        return new SpecificDamageToUI(this);
    }
    
    public String toString(){
        String texto = "Instancia de SpecificDamage con: \n";
        
        texto = texto + super.toString();
        texto = texto + "weapons: \n";
        for(int i = 0; i < weapons.size(); i++){
            texto = texto + weapons.get(i).toString() + "\n";
        }
        
        return texto;
    }
}
