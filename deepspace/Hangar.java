

package deepspace;

import java.util.ArrayList;


class Hangar implements Copyable <Hangar>{
    private int maxElements;
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private ArrayList<ShieldBooster> shieldBoosters = new ArrayList<>();
    
    Hangar(int capacity){
        maxElements = capacity;
    }
    
    Hangar(Hangar h){
        maxElements = h.maxElements;
        for(int i = 0; i < h.weapons.size(); i++){
            weapons.add(h.weapons.get(i));
        }
        for(int i = 0; i < h.shieldBoosters.size(); i++){
            shieldBoosters.add(h.shieldBoosters.get(i));
        }
    }
    
    private boolean spaceAvailable(){
        if((weapons.size() + shieldBoosters.size()) < maxElements){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean addWeapon(Weapon w){
        if(spaceAvailable() && w != null){
            weapons.add(w);
            return true;
        }else{
            return false;
        }
    }
    
    public boolean addShieldBooster(ShieldBooster s){
        if(spaceAvailable() && s != null){
            shieldBoosters.add(s);
            return true;
        }else{
            return false;
        }
    }
    
    public Weapon removeWeapon(int w){
        if( w < 0 || w >= weapons.size()){
            return null;
        }else{
            return weapons.remove(w);
        }
    }
    
    public ShieldBooster removeShieldBooster(int s){
        if( s < 0 || s >= shieldBoosters.size()){
            return null;
        }else{
            return shieldBoosters.remove(s);
        }
    }
    
    public int getMaxElements(){
        return maxElements;
    }
    
    public ArrayList<ShieldBooster> getShieldBoosters(){
        ArrayList<ShieldBooster> aux = new ArrayList<>();
        
        if(shieldBoosters != null){
            for(int i = 0; i < shieldBoosters.size(); i++){
                aux.add(shieldBoosters.get(i));
            }
        }else{
            aux = null;
        }
        
        return aux;
    }
    
    public ArrayList<Weapon> getWeapons(){
        ArrayList<Weapon> aux = new ArrayList<>();
        
        if(weapons != null){
            for(int i = 0; i < weapons.size(); i++){
                aux.add(weapons.get(i));
            }
        }else{
            aux = null;
        }
        
        return aux;
    }
    
    HangarToUI getUIversion(){
        return new HangarToUI(this); 
   }

    @Override
    public Hangar copy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String toString(){
        String texto = "Instancia de Hangar con: \n";
        texto = texto + "maxElements: \n" + maxElements + "\n";
        texto = texto + "weapons: \n";
        for(int i = 0; i < weapons.size(); i++){
            texto = texto + weapons.get(i).toString();
        }
        texto = texto + "shieldBoosters: \n";
        for(int i = 0; i < shieldBoosters.size(); i++){
            texto = texto + shieldBoosters.get(i).toString();
        }
        return texto;
    }
}
