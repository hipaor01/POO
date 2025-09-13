

package deepspace;
import java.util.Random;


class Dice {
    private final float NHANGARSPROB;
    private final float NSHIELDSPROB;
    private final float NWEAPONSPROB;
    private final float FIRSTSHOTPROB;
    private final float EXTRAEFFICIENCYPROB;
    private Random generator;
    
    Dice(){
        NHANGARSPROB = 0.25f;
        NSHIELDSPROB = 0.25f;
        NWEAPONSPROB = 0.33f;
        FIRSTSHOTPROB = 0.5f;
        EXTRAEFFICIENCYPROB = 0.8f;
        generator = new Random();
    }
    
    int initWithNHangars(){
        if(generator.nextFloat() < NHANGARSPROB){
            return 0;
        }else{
            return 1;
        }
    }
    
    int initWithNWeapons(){
        float probabilidadSalirDos = 2*NWEAPONSPROB;
        
        if(generator.nextFloat() < NWEAPONSPROB){
            return 1;
        }else if(generator.nextFloat() < probabilidadSalirDos){
            return 2;
        }else{
            return 3;
        }
    }
    
    int initWithNShields(){
        if(generator.nextFloat() < NSHIELDSPROB){
            return 0;
        }else{
            return 1;
        }
    }
    
    int whoStarts(int nPlayers){
        return generator.nextInt(nPlayers);
    }
    
    GameCharacter firstShot(){
        if(generator.nextFloat() < FIRSTSHOTPROB){
            return GameCharacter.SPACESTATION;
        }else{
            return GameCharacter.ENEMYSTARSHIP;
        }
    }
    
    boolean spaceStationMoves(float speed){
        if(generator.nextFloat() < speed){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean extraEfficiency(){
        if(generator.nextFloat() < EXTRAEFFICIENCYPROB)
            return true;
        else
            return false;
    }
    
    
    public String toString(){
        String texto = "Instancia de Dice con: \n";
        texto = texto + "NHANGARSPROB: \n" + NHANGARSPROB + "\n";
        texto = texto + "NSHIELDSPROB: \n" + NSHIELDSPROB + "\n";
        texto = texto + "NWEAPONSPROB: \n" + NWEAPONSPROB + "\n";
        texto = texto + "FIRSTSHOTPROB: \n" + FIRSTSHOTPROB + "\n";
        return texto;
    }
}
