/*

package deepspace;

import java.util.ArrayList;


public class TestP3 {
    public static void main(String[] args){
        SuppliesPackage paquete1 = new SuppliesPackage(1.5f,2.5f,3.5f);
        
        SpaceStation estacion1 = new SpaceStation("estacion1", paquete1);
        SpaceStation estacion2 = new SpaceStation("estacion2", paquete1);
        SpaceStation estacion3 = new SpaceStation("estacion3", paquete1);
        
        Hangar hangar1 = new Hangar(4);
        
        Weapon arma1 = new Weapon("arma1", WeaponType.LASER, 1);
        Weapon arma2 = new Weapon("arma2", WeaponType.MISSILE, 2);
        
        ShieldBooster escudo1 = new ShieldBooster("escudo1",1.5f,1);
        ShieldBooster escudo2 = new ShieldBooster("escudo2",2.5f,2);
        
        Loot botin1 = new Loot(1,2,3,4,5);
        
        ArrayList<WeaponType> aux6 = new ArrayList<>();
        aux6.add(arma1.getType());
        
        Damage damage1 = new Damage(aux6,0);
        Damage damage2 = new Damage(2,1);
        
        GameUniverse game = new GameUniverse();
        
        ArrayList<String> aux1 = new ArrayList<>();
        aux1.add("Higinio");
        aux1.add("Jose");
        
        System.out.println("Método fire de SpaceStation: ");
        estacion1.receiveHangar(hangar1);
        estacion1.receiveWeapon(arma1);
        estacion1.receiveWeapon(arma2);
        estacion1.mountWeapon(0);
        estacion1.mountWeapon(0);
        System.out.println(estacion1.fire());
        
        System.out.println("Método protection de SpaceStation: ");
        estacion1.receiveShieldBooster(escudo1);
        estacion1.receiveShieldBooster(escudo2);
        estacion1.mountShieldBooster(0);
        estacion1.mountShieldBooster(0);
        System.out.println(estacion1.protection());
        
        
        System.out.println("Método receiveShot de SpaceStation: ");
        System.out.println(estacion1.receiveShot(14.0f));
        System.out.println(estacion1.toString());
        estacion1.receiveSupplies(paquete1);
        estacion1.receiveShieldBooster(escudo1);
        estacion1.receiveShieldBooster(escudo2);
        estacion1.mountShieldBooster(0);
        estacion1.mountShieldBooster(0);
        System.out.println(estacion1.receiveShot(12.0f));
        System.out.println(estacion1.toString());
        
        System.out.println("Método setLoot de SpaceStation: ");
        estacion2.setLoot(botin1);
        System.out.println(estacion2.toString());
        
        System.out.println("Método discardWeapon de SpaceStation: ");
        estacion3.receiveHangar(hangar1);
        estacion3.receiveWeapon(arma1);
        estacion3.mountWeapon(0);
        estacion3.setPendingDamage(damage1);
        estacion3.discardWeapon(0);
        System.out.println(estacion3.toString());
        
        System.out.println("Método discardShieldBooster de SpaceStation: ");
        estacion3.receiveShieldBooster(escudo2);
        estacion3.mountShieldBooster(0);
        estacion3.setPendingDamage(damage2);
        estacion3.discardShieldBooster(0);
        System.out.println(estacion3.toString());
        
        System.out.println("Método init de GameUniverse: ");
        game.init(aux1);
        System.out.println(game.toString());
        
        System.out.println("Método combat de GameUniverse: ");
        System.out.println(game.combat());
        
        System.out.println("Método nextTurn de GameUniverse: ");
        System.out.println(game.nextTurn());
    }
}
*/