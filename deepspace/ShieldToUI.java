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
public class ShieldToUI {
    private float boost;
    private int uses;

    ShieldToUI (ShieldBooster s) {
        boost=s.getBoost();
        uses=s.getUses();
    }    

    public float getBoost() {
        return boost;
    }

    public int getUses() {
        return uses;
    }
    
     public String toString(){
        String texto = "Instancia de ShieldToUI con: \n";
        texto = texto + "boost: \n" + boost + "\n";
        texto = texto + "uses: \n" + uses + "\n";
        return texto;
    }
}
