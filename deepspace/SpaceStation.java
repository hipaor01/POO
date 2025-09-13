

package deepspace;

import java.util.ArrayList;



class SpaceStation implements SpaceFighter{
    private static final int MAXFUEL = 100;
    private static final float SHIELDLOSSPERUNITSHOT = 0.1f;
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    private Damage pendingDamage;
    private ArrayList<Weapon> weapons = new ArrayList<>();
    private Hangar hangar;
    private ArrayList<ShieldBooster> shieldBoosters = new ArrayList<>();
    
    SpaceStation(String n, SuppliesPackage supplies){
        name = n;
        if(supplies != null){
            ammoPower = supplies.getAmmoPower();
            assignFuelValue(supplies.getFuelUnits());
            shieldPower = supplies.getShieldPower();
        }else{
            ammoPower = 0.0f;
            assignFuelValue(0.0f);
            shieldPower = 0.0f;
        }
        nMedals = 0;
        pendingDamage = null;
        weapons = new ArrayList<Weapon>();
        shieldBoosters = new ArrayList<ShieldBooster>();
        hangar = null;
    }
    
    public SpaceStation(SpaceStation station){
        name = station.name;
        ammoPower = station.ammoPower;
        assignFuelValue(station.fuelUnits);
        shieldPower = station.shieldPower;
        nMedals = station.nMedals;
        pendingDamage = station.pendingDamage;
        for(int i = 0; i < station.weapons.size(); i++){
            weapons.add(station.weapons.get(i));
        }
        for(int i = 0; i < station.shieldBoosters.size(); i++){
            shieldBoosters.add(station.shieldBoosters.get(i));
        }
        hangar = station.hangar;
    }
    
    private void assignFuelValue(float f){
        if(f <= MAXFUEL){
            fuelUnits = f;
        }else{
            fuelUnits = MAXFUEL;
        }
    }
    
    private void cleanPendingDamage(){
        if(pendingDamage.hasNoEffect())
            pendingDamage = null;
    }
    
    public boolean receiveWeapon(Weapon w){
        Weapon aux = new Weapon(w);
        if(hangar != null){
            return hangar.addWeapon(aux);
        }else{
            return false;
        }
    }
    
    public boolean receiveShieldBooster(ShieldBooster s){
        ShieldBooster aux = new ShieldBooster(s);
        if(hangar != null){
            return hangar.addShieldBooster(aux);
        }else{
            return false;
        }
    }
    
    public void receiveHangar(Hangar h){
        Hangar aux = new Hangar(h);
        if(hangar == null)
            hangar = aux;
    }
    
    public void discardHangar(){
        hangar = null;
    }
    
    public void receiveSupplies(SuppliesPackage s){
        ammoPower += s.getAmmoPower();
        assignFuelValue(fuelUnits + s.getFuelUnits());
        shieldPower += s.getShieldPower();
    }
    
   public void setPendingDamage(Damage d){
       pendingDamage = d.adjust(weapons, shieldBoosters);
       cleanPendingDamage();
   }
   
   public void mountWeapon(int i){
       Weapon aux;
       
       if(hangar != null){
           if((i >= 0) && (i < hangar.getWeapons().size())){
            aux = hangar.removeWeapon(i);
            if(aux != null){
                weapons.add(aux);
            }
           }
       }
   }
   
   public void mountShieldBooster(int i){
       ShieldBooster aux;
       
       if(hangar != null){
           if((i >= 0) && (i < hangar.getShieldBoosters().size())){
            aux = hangar.removeShieldBooster(i);
            if(aux != null){
                shieldBoosters.add(aux);
            }
           }
       }
   }
   
   public void discardWeaponInHangar(int i){
       if(hangar != null){
           hangar.removeWeapon(i);
       }
   }
   
   public void discardShieldBoosterInHangar(int i){
       if(hangar != null){
           hangar.removeShieldBooster(i);
       }
   }
   
   public float getSpeed(){
       return fuelUnits/MAXFUEL;
   }
   
   public void move(){
       if(fuelUnits >= 0 && fuelUnits >= (getSpeed()*fuelUnits))
            fuelUnits = fuelUnits - getSpeed()*fuelUnits;
       else
           fuelUnits = 0;
   }
   
   public boolean validState(){
       if(pendingDamage == null || pendingDamage.hasNoEffect()){
           return true;
       }else{
           return false;
       }
   }
   
   public void cleanUpMountedItems(){
       for(int i = 0; i < weapons.size(); i++){
           if(weapons.get(i).getUses() == 0){
               weapons.remove(i);
           }
       }
       
       for(int i = 0; i < shieldBoosters.size(); i++){
           if(shieldBoosters.get(i).getUses() == 0){
               shieldBoosters.remove(i);
           }
       }
   }
   
   public float getAmmoPower(){
       return ammoPower;
   }
   
   public float getFuelUnits(){
       return fuelUnits;
   }
   
   public Hangar getHangar(){
       return hangar;
   }
   
   public String getName(){
       return name;
   }
   
   public int getNMedals(){
       return nMedals;
   }
   
   public Damage getPendingDamage(){
       return pendingDamage;
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
   
   public float getShieldPower(){
       return shieldPower;
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
   
   public void discardShieldBooster(int i){
       int size = shieldBoosters.size();
       
       if(i >= 0 && i < size){
           shieldBoosters.remove(i);
           if(pendingDamage != null){
               pendingDamage.discardShieldBooster();
               cleanPendingDamage();
           }
       }
   }
   
   public void discardWeapon(int i){
       int size = weapons.size();
       
       if(i >= 0 && i < size){
           Weapon w = weapons.remove(i);
           if(pendingDamage != null){
               pendingDamage.discardWeapon(w);
               cleanPendingDamage();
           }
       }
   }
   
   @Override
   public float fire(){
       int size = weapons.size();
       float factor = 1;
       Weapon w;
       
       for(int i = 0; i < size; i++){
           w = weapons.get(i);
           factor *= w.useIt();
       }
       return ammoPower * factor;
   }
   
   public SpaceStationToUI getUIversion(){
       return new SpaceStationToUI(this);
   }
   
   @Override
   public float protection(){
       int size = shieldBoosters.size();
       float factor = 1;
       ShieldBooster s;
       
       for(int i = 0; i < size; i++){
           s = shieldBoosters.get(i);
           factor *= s.useIt();
       }
       return shieldPower*factor;
   }
   
   @Override
   public ShotResult receiveShot(float shot){
       float myProtection = protection();
       
       if(myProtection >= shot){
           shieldPower = shieldPower - SHIELDLOSSPERUNITSHOT*shot;
           shieldPower = Math.max(0.0f, shieldPower);
           return ShotResult.RESIST;
       }else{
           shieldPower = 0.0f;
           return ShotResult.DONOTRESIST;
       }
   }
   
   public Transformation setLoot(Loot loot){
       CardDealer dealer = CardDealer.getInstance();
       int h = loot.getNHangars();
       
       if(h > 0){
           Hangar hangar = dealer.nextHangar();
           receiveHangar(hangar);
       }
       
       int elements = loot.getNSupplies();
       for(int i = 0; i < elements; i++){
           SuppliesPackage sup = dealer.nextSuppliesPackage();
           receiveSupplies(sup);
       }
       
       elements = loot.getNWeapons();
       for(int i = 0; i < elements; i++){
           Weapon weap = dealer.nextWeapon();
           receiveWeapon(weap);
       }
       
       elements = loot.getNShields();
       for(int i = 0; i < elements; i++){
           ShieldBooster sh = dealer.nextShieldBooster();
           receiveShieldBooster(sh);
       }
       
       int medals = loot.getNMedals();
       nMedals += medals;
       
       boolean getEfficient = loot.getEfficient();
       boolean spaceCity = loot.spaceCity();
       
       if(getEfficient)
           return Transformation.GETEFFICIENT;
       else
           if(spaceCity)
               return Transformation.SPACECITY;
           else
               return Transformation.NOTRANSFORM;
   }
   
   public String toString(){
       String texto = "Instancia de SpaceStation con: \n";
       texto = texto + "ammoPower: \n" + ammoPower + "\n";
       texto = texto + "fuelUnits: \n" + fuelUnits + "\n";
       texto = texto + "name: \n" + name + "\n";
       texto = texto + "nMedals: \n" + nMedals + "\n";
       texto = texto + "shieldPower: \n" + shieldPower + "\n";
       if(pendingDamage != null)
        texto = texto + "pendingDamage: \n" + pendingDamage.toString();
       texto = texto + "weapons: \n";
       for(int i = 0; i < weapons.size(); i++){
           texto = texto + weapons.get(i).toString();
       }
       if(hangar != null)
        texto = texto + "hangar: \n" + hangar.toString();
       texto = texto + "shieldBoosters: \n";
       for(int i = 0; i < shieldBoosters.size(); i++){
           texto = texto + shieldBoosters.get(i).toString();
       }
       return texto;
   }
}
