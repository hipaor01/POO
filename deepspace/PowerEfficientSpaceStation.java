

package deepspace;


class PowerEfficientSpaceStation extends SpaceStation{
    private static final float EFFICIENCYFACTOR = 1.10f;
    
    public PowerEfficientSpaceStation(SpaceStation station){
        super(station);
    }
    
    @Override
    public float fire(){
        return super.fire()*EFFICIENCYFACTOR;
    }
    
    @Override
    public float protection(){
        return super.protection()*EFFICIENCYFACTOR;
    }
    
    @Override
    public Transformation setLoot(Loot loot){
        super.setLoot(loot);
        return Transformation.NOTRANSFORM;
    }
    
    @Override
    public String toString(){
         String texto = super.toString();
         texto = texto + "en concreto, instancia de PowerEfficientSpaceStation\n";
         return texto;
    }
    
    @Override
    public PowerEfficientSpaceStationToUI getUIversion(){
        return new PowerEfficientSpaceStationToUI(this);
    }
}
