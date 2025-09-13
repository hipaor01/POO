
package deepspace;


class Loot {
    private int nSupplies;
    private int nWeapons;
    private int nShields;
    private int nHangars;
    private int nMedals;
    private boolean getEfficient;
    private boolean spaceCity;
    
    Loot(int nSupplies, int nWeapons, int nShields, int nHangars, int nMedals){
        this.nSupplies = nSupplies;
        this.nWeapons = nWeapons;
        this.nShields = nShields;
        this.nHangars = nHangars;
        this.nMedals = nMedals;
        this.getEfficient = false;
        this.spaceCity = false;
    }
    
    Loot(int nSupplies, int nWeapons, int nShields, int nHangars, int nMedals, boolean ef, boolean city){
        this(nSupplies,nWeapons,nShields,nHangars,nMedals);
        this.getEfficient = ef;
        this.spaceCity = city;
    }
    
    public int getNSupplies(){
        return this.nSupplies;
    }
    
    public int getNWeapons(){
        return this.nWeapons;
    }
    
    public int getNShields(){
        return this.nShields;
    }
    
    public int getNHangars(){
        return this.nHangars;
    }
    
    public int getNMedals(){
        return this.nMedals;
    }
    
    public boolean getEfficient(){
        return getEfficient;
    }
    
    public boolean spaceCity(){
        return spaceCity;
    }
    
    LootToUI getUIversion(){
        return new LootToUI(this);
    }
    
    public String toString(){
        String texto = "Instancia de Loot con: \n";
        texto = texto + "nSupplies: \n" + nSupplies + "\n";
        texto = texto + "nWeapons: \n" + nWeapons + "\n";
        texto = texto + "nShields: \n" + nShields + "\n";
        texto = texto + "nHangars: \n" + nHangars + "\n";
        texto = texto + "nMedals: \n" + nMedals + "\n";
        texto = texto + "getEfficient: \n" + getEfficient + "\n";
        texto = texto + "spaceCity: \n" + spaceCity + "\n";
        return texto;
    }
}
