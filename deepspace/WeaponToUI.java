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
public class WeaponToUI {
    private WeaponType type;
    private float power;
    private int uses;  
    
    WeaponToUI(Weapon w) {
        type=w.getType();
        power=w.power();
        uses=w.getUses();
    }  

    public WeaponType getType() {
        return type;
    }

    public float getPower() {
        return power;
    }

    public int getUses() {
        return uses;
    }
    
    
     public String toString(){
        String texto = "Instancia de WeaponToUI con: \n";
        texto = texto + "power: \n" + power + "\n";
        texto = texto + "type: \n" + type.name() + "\n";
        texto = texto + "uses: \n" + uses + "\n";
        return texto;
    }
}
