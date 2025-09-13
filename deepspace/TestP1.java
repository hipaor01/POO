
package deepspace;


/*
public class TestP1 {
    public static void main(String[] args){
        Loot botin1 = new Loot(1,2,3,4,5);
        Loot botin2 = new Loot(2,3,4,5,6);
        
        SuppliesPackage paquete1 = new SuppliesPackage(1.5f,2.5f,3.5f);
        SuppliesPackage paquete2 = new SuppliesPackage(2.5f,3.5f,4.5f);
        
        ShieldBooster escudo1 = new ShieldBooster("escudo1",1.5f,1);
        ShieldBooster escudo2 = new ShieldBooster("escudo2",2.5f,2);
        
        Weapon arma1 = new Weapon("arma1", WeaponType.LASER, 1);
        Weapon arma2 = new Weapon("arma2", WeaponType.MISSILE, 2);
        
        Dice dado1 = new Dice();
        
        System.out.println("Consultores clase Loot: ");
        System.out.println(botin1.getNSupplies());
        System.out.println(botin2.getNSupplies());
        System.out.println(botin1.getNWeapons());
        System.out.println(botin2.getNWeapons());
        System.out.println(botin1.getNShields());
        System.out.println(botin2.getNShields());
        System.out.println(botin1.getNHangars());
        System.out.println(botin2.getNHangars());
        System.out.println(botin1.getNMedals());
        System.out.println(botin2.getNMedals());
        
        System.out.println("Consultores clase SuppliesPackage: ");
        System.out.println(paquete1.getAmmoPower());
        System.out.println(paquete2.getAmmoPower());
        System.out.println(paquete1.getFuelUnits());
        System.out.println(paquete2.getFuelUnits());
        System.out.println(paquete1.getShieldPower());
        System.out.println(paquete2.getShieldPower());
        
        System.out.println("Consultores clase ShieldBooster: ");
        System.out.println(escudo1.getBoost());
        System.out.println(escudo2.getBoost());
        System.out.println(escudo1.getUses());
        System.out.println(escudo2.getUses());
        
        System.out.println("Consultores clase Weapon: ");
        System.out.println(arma1.getType());
        System.out.println(arma2.getType());
        System.out.println(arma1.getUses());
        System.out.println(arma2.getUses());
        
        System.out.println("Método initWithNHangars: ");
        int contador0 = 0, contador1 = 0;
        
        for(int i = 0; i < 100; i++){
            if(dado1.initWithNHangars() == 0)
                contador0++;
            else
                contador1++;
        }
        
        System.out.println(contador0);
        System.out.println(contador1);
        
        System.out.println("Método initWithNWeapons: ");
        contador1 = 0;
        int contador2 = 0, contador3 = 0;
        
        for(int i = 0; i < 100; i++){
            if(dado1.initWithNWeapons() == 1){
                contador1++;
            }else{
                if(dado1.initWithNWeapons() == 2){
                    contador2++;
                }else{
                    contador3++;
                }
            }
        }
        
        System.out.println(contador1);
        System.out.println(contador2);
        System.out.println(contador3);
        
        System.out.println("Método initWithNShields: ");
        contador0 = 0;
        contador1 = 0;
        
        for(int i = 0; i < 100; i++){
            if(dado1.initWithNShields() == 0){
                contador0++;
            }else{
                contador1++;
            }
        }
        
        System.out.println(contador0);
        System.out.println(contador1);
        
        System.out.println("Constructor de copia SuppliesPackage: ");
        SuppliesPackage paquete3 = new SuppliesPackage(paquete1);
        System.out.println(paquete3.getAmmoPower());
        System.out.println(paquete3.getFuelUnits());
        System.out.println(paquete3.getShieldPower());
        
        System.out.println("Constructor de copia ShieldBooster: ");
        ShieldBooster escudo3 = new ShieldBooster(escudo1);
        System.out.println(escudo3.getBoost());
        System.out.println(escudo3.getUses());
        
        System.out.println("Constructor de copia Weapon: ");
        Weapon arma3 = new Weapon(arma1);
        System.out.println(arma3.getType());
        System.out.println(arma3.getUses());
        
        System.out.println("Método useIt de ShieldBooster: ");
        System.out.println(escudo1.useIt());
        System.out.println(escudo1.getUses());
        
        System.out.println("Método power de Weapon: ");
        System.out.println(arma1.power());
        
        System.out.println("Método useIt de Weapon: ");
        System.out.println(arma1.useIt());
        System.out.println(arma1.getUses());
        
        System.out.println("Método whoStarts de Dice: ");
        System.out.println(dado1.whoStarts(5));
        
        System.out.println("Método firstShot de Dice: ");
        int contadorSpaceStation = 0;
        int contadorEnemyStarship = 0;
        
        for(int i = 0; i < 100; i++){
            if(dado1.firstShot() == GameCharacter.SPACESTATION){
                contadorSpaceStation++;
            }else{
                contadorEnemyStarship++;
            }
        }
        
        System.out.println(contadorSpaceStation);
        System.out.println(contadorEnemyStarship);
        
        System.out.println("Método spaceStationMoves de Dice: ");
        int contadorTrue = 0;
        int contadorFalse = 0;
        
        for(int i = 0; i < 100; i++){
            if(dado1.spaceStationMoves(0.3f) == true){
                contadorTrue++;
            }else{
                contadorFalse++;
            }
        }
        
        System.out.println(contadorTrue);
        System.out.println(contadorFalse);
    }
}*/
