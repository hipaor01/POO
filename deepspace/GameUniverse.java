

package deepspace;

import java.util.ArrayList;


public class GameUniverse {
    private static final int WIN = 10;
    private int currentsStationIndex;
    private int turns;
    private GameStateController gameState;
    private Dice dice;
    private SpaceStation currentStation;
    private EnemyStarShip currentEnemy;
    private ArrayList<SpaceStation> spaceStations;
    private boolean haveSpaceCity;
    
    public GameUniverse(){
        gameState = new GameStateController();
        turns = 0;
        dice = new Dice();
        spaceStations = new ArrayList<SpaceStation>();
        currentsStationIndex = 0;
        haveSpaceCity = false;
    }
    
    
    protected void makeStationEfficient(){
        spaceStations.remove(currentsStationIndex);
        if(dice.extraEfficiency())
            currentStation = new BetaPowerEfficientSpaceStation(currentStation);
        else
            currentStation = new PowerEfficientSpaceStation(currentStation);
        spaceStations.add(currentsStationIndex, currentStation);
    }
    
    protected void createSpaceCity(){
        if(haveSpaceCity == false){
            spaceStations.remove(currentsStationIndex);
            currentStation = new SpaceCity(currentStation, spaceStations);
            spaceStations.add(currentsStationIndex, currentStation);
            haveSpaceCity = true;
        }
    }
    
    public boolean haveAWinner(){
        if(currentStation.getNMedals() == WIN){
            return true;
        }else{
            return false;
        }
    }
    
    public void mountShieldBooster(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT){
            currentStation.mountShieldBooster(i);
        }
    }
    
    public void mountWeapon(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT){
            currentStation.mountWeapon(i);
        }
    }
    
    public void discardHangar(){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT){
            currentStation.discardHangar();
        }
    }
    
    public void discardShieldBoosterInHangar(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT){
            currentStation.discardShieldBoosterInHangar(i);
        }
    }
    
    public void discardWeaponInHangar(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT){
            currentStation.discardWeaponInHangar(i);
        }
    }
    
    public GameState getState(){
        return gameState.getState();
    }
    
    public void discardShieldBooster(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT){
            currentStation.discardShieldBooster(i);
        }
    }
    
    public void discardWeapon(int i){
        if(gameState.getState() == GameState.INIT || gameState.getState() == GameState.AFTERCOMBAT){
            currentStation.discardWeapon(i);
        }
    }
    
    CombatResult combat(SpaceStation station, EnemyStarShip enemy){
        GameCharacter ch = dice.firstShot();
        float fire;
        ShotResult result;
        boolean enemyWins;
        CombatResult combatResult;
        
        if(ch == GameCharacter.ENEMYSTARSHIP){
            fire = enemy.fire();
            result = station.receiveShot(fire);
            
            if(result == ShotResult.RESIST){
                fire = station.fire();
                result = enemy.receiveShot(fire);
                enemyWins = (result == ShotResult.RESIST);
            }else{
                enemyWins = true;
            }
        }else{
            fire = station.fire();
            result = enemy.receiveShot(fire);
            enemyWins = (result == ShotResult.RESIST);
        }
        
        if(enemyWins){
            float s = station.getSpeed();
            boolean moves = dice.spaceStationMoves(s);
            
            if(!moves){
                Damage damage = enemy.getDamage();
                station.setPendingDamage(damage);
                combatResult = CombatResult.ENEMYWINS;
            }else{
                station.move();
                combatResult = CombatResult.STATIONESCAPES;
            }
        }else{
            Loot aLoot = enemy.getLoot();
            Transformation trans = station.setLoot(aLoot);
            if(trans == Transformation.GETEFFICIENT){
                makeStationEfficient();
                combatResult = CombatResult.STATIONWINSANDCONVERTS;
            }else{
                if(trans == Transformation.SPACECITY){
                    createSpaceCity();
                    combatResult = CombatResult.STATIONWINSANDCONVERTS;
                }else{
                    combatResult = CombatResult.STATIONWINS;
                }
            }
        }
        
        gameState.next(turns, spaceStations.size());
        
        return combatResult;
    }
    
    public CombatResult combat(){
        GameState state = gameState.getState();
        
        if((state == GameState.BEFORECOMBAT) || (state == GameState.INIT)){
            return  combat(currentStation, currentEnemy);
        }else{
            return CombatResult.NOCOMBAT;
        }
    }
    
    public GameUniverseToUI getUIversion(){
        return new GameUniverseToUI(this.currentStation, this.currentEnemy);
    }
    
    public void init(ArrayList<String> names){
        GameState state = gameState.getState();
        
        if(state == GameState.CANNOTPLAY){
            CardDealer dealer = CardDealer.getInstance();
            
            for(int i = 0; i < names.size(); i++){
                SuppliesPackage supplies = dealer.nextSuppliesPackage();
                SpaceStation station = new SpaceStation(names.get(i),supplies);
                int nh = dice.initWithNHangars();
                int nw = dice.initWithNWeapons();
                int ns = dice.initWithNShields();
                Loot lo = new Loot(0,nw,ns,nh,0,false,false);
                station.setLoot(lo);
                spaceStations.add(station);
            }
            
            currentsStationIndex = dice.whoStarts(names.size());
            currentStation = spaceStations.get(currentsStationIndex);
            currentEnemy = dealer.nextEnemy();
            gameState.next(turns, spaceStations.size());
        }
    }
    
    public boolean nextTurn(){
        GameState state = gameState.getState();
        
        if(state == GameState.AFTERCOMBAT){
            boolean stationState = currentStation.validState();
            
            if(stationState){
                currentsStationIndex = (currentsStationIndex + 1)%spaceStations.size();
                turns++;
                currentStation = spaceStations.get(currentsStationIndex);
                currentStation.cleanUpMountedItems();
                CardDealer dealer = CardDealer.getInstance();
                currentEnemy = dealer.nextEnemy();
                gameState.next(turns, spaceStations.size());
                return true;
            }
            
            return false;
        }
        
        return false;
    }
    
    protected SpaceStation getCurrentStation(){
        return currentStation;
    }
    
    protected EnemyStarShip getCurrentEnemy(){
        return currentEnemy;
    }
    
    protected Dice getDice(){
        return dice;
    }
    
    protected int getTurns(){
        return turns;
    }
    
    protected ArrayList<SpaceStation> getSpaceStations(){
        return spaceStations;
    }
    
    protected GameStateController getGameState(){
        return gameState;
    }
    
    public String toString(){
        String texto = "Instancia de GameUniverse con: \n";
        texto = texto + "currentsStationIndex: \n" + currentsStationIndex + "\n";
        texto = texto + "turns: \n" + turns + "\n";
        texto = texto + "gameState: \n" + gameState.toString();
        texto = texto + "dice: \n" + dice.toString();
        texto = texto + "currentStation: \n" + currentStation.toString();
        texto = texto + "currentEnemy: \n" + currentEnemy.toString();
        texto = texto + "spaceStations: \n";
        for(int i = 0; i < spaceStations.size(); i++){
            texto = texto + spaceStations.get(i).toString();
        }
        return texto;
    }
}
