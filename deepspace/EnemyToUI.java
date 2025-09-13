/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

/**
 *
 * @author Profe
 */
public class EnemyToUI{
    private final String name;
    private final float ammoPower;
    private final float shieldPower;
    
    private LootToUI loot;
    private DamageToUI damage;   
    
    EnemyToUI(EnemyStarShip enemy) {
        name=enemy.getName();
        ammoPower=enemy.getAmmoPower();
        shieldPower=enemy.getShieldPower();
    
        loot=enemy.getLoot().getUIversion();
        damage = enemy.getDamage().getUIversion();
    }

    public String getName() {
        return name;
    }
    

    public float getAmmoPower() {
        return ammoPower;
    }

    public float getShieldPower() {
        return shieldPower;
    }

    public LootToUI getLoot() {
        return loot;
    }

    public DamageToUI getDamage() {
        return damage;
    }
    
    public String toString(){
      String texto = "Instancia de EnemyToUI con: \n";
      texto = texto + "ammoPower: \n" + ammoPower + "\n";
      texto = texto + "name: \n" + name + "\n";
      texto = texto + "shieldPower: \n" + shieldPower + "\n";
      texto = texto + "damage: \n" + damage.toString();
      texto = texto + "loot: \n" + loot.toString();
      return texto;
    }
    
}
