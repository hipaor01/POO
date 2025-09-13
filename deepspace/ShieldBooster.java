

package deepspace;


class ShieldBooster implements CombatElement{
    private String name;
    private float boost;
    private int uses;
    
    ShieldBooster(String name, float boost, int uses){
        this.name = name;
        this.boost = boost;
        this.uses = uses;
    }
    
    ShieldBooster(ShieldBooster s){
        name = s.name;
        boost = s.boost;
        uses = s.uses;
    }
    
    public float getBoost(){
        return this.boost;
    }
    
    @Override
    public int getUses(){
        return this.uses;
    }
    
    @Override
    public float useIt(){
        if(this.uses > 0){
            this.uses--;
            return this.boost;
        }else{
            return 1.0f;
        }
    }
    
    ShieldToUI getUIversion(){
        return new ShieldToUI(this);
    }

    
    public String toString(){
        String texto = "Instancia de ShieldBooster con: \n";
        texto = texto + "name: \n" + name + "\n";
        texto = texto + "boost: \n" + boost + "\n";
        texto = texto + "uses: \n" + uses + "\n";
        return texto;
    }
}
