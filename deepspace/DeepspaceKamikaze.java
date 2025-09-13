/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package deepspace;

/**
 *
 * @author usuario
 */
public class DeepspaceKamikaze extends GameUniverse{
    @Override
    CombatResult combat(SpaceStation station, EnemyStarShip enemy){
        GameCharacter ch = getDice().firstShot();
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
            boolean moves = getDice().spaceStationMoves(s);
            
            if(!moves){
                Damage damage = enemy.getDamage();
                station.setPendingDamage(damage);
                combatResult = CombatResult.ENEMYWINS;
                for(int i = 0; i < getCurrentStation().getWeapons().size(); i++){
                    getCurrentStation().discardWeapon(i);
                }
                for(int i = 0; i < getCurrentStation().getShieldBoosters().size(); i++){
                    getCurrentStation().discardShieldBooster(i);
                }
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
        
        getGameState().next(getTurns(), getSpaceStations().size());
        
        return combatResult;
    }
    
    
    
    @Override
    public CombatResult combat(){
        GameState state = getState();
        
        if((state == GameState.BEFORECOMBAT) || (state == GameState.INIT)){
            for(int i = 0; i < getCurrentStation().getHangar().getWeapons().size(); i++){
                getCurrentStation().mountWeapon(i);
            }
            for(int i = 0; i < getCurrentStation().getHangar().getShieldBoosters().size(); i++){
                getCurrentStation().mountShieldBooster(i);
            }
            return  combat(getCurrentStation(), getCurrentEnemy());
        }else{
            return CombatResult.NOCOMBAT;
        }
    }
    
}
