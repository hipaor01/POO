

package deepspace;


class SuppliesPackage implements Copyable <Weapon> {
    private float ammoPower;
    private float fuelUnits;
    private float shieldPower;
    
    SuppliesPackage(float ammoPower, float fuelUnits, float shieldPower){
        this.ammoPower = ammoPower;
        this.fuelUnits = fuelUnits;
        this.shieldPower = shieldPower;
    }
    
    SuppliesPackage(SuppliesPackage s){
        ammoPower = s.ammoPower;
        fuelUnits = s.fuelUnits;
        shieldPower = s.shieldPower;
    }
    
    public float getAmmoPower(){
        return this.ammoPower;
    }
    
    public float getFuelUnits(){
        return this.fuelUnits;
    }
    
    public float getShieldPower(){
        return this.shieldPower;
    }

    @Override
    public Weapon copy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String toString(){
        String texto = "Instancia de SuppliesPackage con: \n";
        texto = texto + "ammoPower: \n" + ammoPower + "\n";
        texto = texto + "fuelUnits: \n" + fuelUnits + "\n";
        texto = texto + "shieldPower: \n" + shieldPower + "\n";
        return texto;
    }
}
