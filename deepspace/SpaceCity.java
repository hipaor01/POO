

package deepspace;

import java.util.ArrayList;


class SpaceCity extends SpaceStation{
    private SpaceStation base;
    private ArrayList<SpaceStation> collaborators = new ArrayList<>();
    
    public SpaceCity(SpaceStation base, ArrayList<SpaceStation> rest){
        super(base);
        this.base = base;
        for(int i = 0; i < rest.size(); i++){
            collaborators.add(rest.get(i));
        }
    }
    
    public ArrayList<SpaceStation> getCollaborators(){
        ArrayList<SpaceStation> aux = new ArrayList<>();
        
        for(int i = 0; i < collaborators.size(); i++){
            aux.add(collaborators.get(i));
        }
        
        return aux;
    }
    
    @Override
    public float fire(){
        float potencia = super.fire();
        
        for(int i = 0; i < collaborators.size(); i++){
            potencia += collaborators.get(i).fire();
        }
        
        return potencia;
    }
    
    @Override
    public float protection(){
        float potencia = super.protection();
        
        for(int i = 0; i < collaborators.size(); i++){
            potencia += collaborators.get(i).protection();
        }
        
        return potencia;
    }
    
    @Override
    public Transformation setLoot(Loot loot){
        super.setLoot(loot);
        return Transformation.NOTRANSFORM;
    }
    
    @Override
    public SpaceCityToUI getUIversion(){
        return new SpaceCityToUI(this);
    }
    
    @Override
    public String toString(){
        String texto = "Instancia de SpaceCity con: \n";
        texto = texto + "base: \n" + super.toString();
        texto = texto + "colaboladores: \n";
        
        for(int i = 0; i < collaborators.size(); i++){
            texto = texto + collaborators.get(i).toString();
        }
        
        return texto;
    }
}
