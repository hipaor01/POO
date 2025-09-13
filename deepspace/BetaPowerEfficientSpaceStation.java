
package deepspace;


class BetaPowerEfficientSpaceStation extends PowerEfficientSpaceStation{
    private static final float EXTRAEFFICIENCY = 1.2f;
    
    public BetaPowerEfficientSpaceStation(SpaceStation station){
        super(station);
    }
    
    @Override
    public float fire(){
        Dice dado = new Dice();
        if(dado.extraEfficiency())
            return super.fire()*EXTRAEFFICIENCY;
        else
            return super.fire();
    }
    
    @Override
    public String toString(){
        String texto = super.toString();
        texto = texto + "en concreto, instancia de BetaPowerEfficientSpaceStation\n";
        return texto;
    }
    
    @Override
    public BetaPowerEfficientSpaceStationToUI getUIversion(){
        return new BetaPowerEfficientSpaceStationToUI(this);
    }
}
