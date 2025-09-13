

package deepspace;


class EnemyStarShip implements SpaceFighter{
    private float ammoPower;
    private String name;
    private float shieldPower;
    private Damage damage;
    private Loot loot;
    
    
    EnemyStarShip(String n, float a, float s, Loot l, Damage d){
        ammoPower = a;
        name = n;
        shieldPower = s;
        damage = d.copy();
        loot = l;
    }
    
    EnemyStarShip(EnemyStarShip e){
        ammoPower = e.ammoPower;
        name = e.name;
        shieldPower = e.shieldPower;
        damage = e.damage.copy();
        loot = e.loot;
    }
    
    @Override
    public float fire(){
        return ammoPower;
    }
    
    public float getAmmoPower(){
        return ammoPower;
    }
    
    public Damage getDamage(){
        Damage aux = damage.copy();
        return aux;
    }
    
    public Loot getLoot(){
        return loot;
    }
    
    public String getName(){
        return name;
    }
    
    public float getShieldPower(){
        return shieldPower;
    }
    
    @Override
    public float protection(){
        return shieldPower;
    }
    
    @Override
    public ShotResult receiveShot(float shot){
        if(shieldPower < shot){
            return ShotResult.DONOTRESIST;
        }else{
            return ShotResult.RESIST;
        }
    }
    
    EnemyToUI getUIversion(){
        return new EnemyToUI(this);
    }

    
    public String toString(){
      String texto = "Instancia de EnemyStarShip con: \n";
      texto = texto + "ammoPower: \n" + ammoPower + "\n";
      texto = texto + "name: \n" + name + "\n";
      texto = texto + "shieldPower: \n" + shieldPower + "\n";
      texto = texto + "damage: \n" + damage.toString();
      texto = texto + "loot: \n" + loot.toString();
      return texto;
    }
}
