

package deepspace;

import java.util.ArrayList;

/*
public class TestP2 {
    public static void main(String[] args){
        Hangar hangar1 = new Hangar(1);
        Hangar hangar2 = new Hangar(2);
        Hangar hangar3 = new Hangar(hangar2);
        
        Weapon arma1 = new Weapon("arma1", WeaponType.LASER, 1);
        Weapon arma2 = new Weapon("arma2", WeaponType.MISSILE, 2);
        Weapon arma3 = new Weapon("arma3", WeaponType.PLASMA, 0);
        
        ShieldBooster escudo1 = new ShieldBooster("escudo1",1.5f,1);
        ShieldBooster escudo2 = new ShieldBooster("escudo2",2.5f,2);
        ShieldBooster escudo3 = new ShieldBooster("escudo3",3.5f,0);
        
        Loot botin1 = new Loot(1,2,3,4,5);
        
        SuppliesPackage paquete1 = new SuppliesPackage(1.5f,2.5f,3.5f);
                
        ArrayList<WeaponType> aux5 = new ArrayList<>();
        aux5.add(WeaponType.LASER);
        aux5.add(WeaponType.MISSILE);
        ArrayList<Weapon> aux6 = new ArrayList<>();
        aux6.add(arma1);
        ArrayList<ShieldBooster> aux7 = new ArrayList<>();
        aux7.add(escudo1);
        aux7.add(escudo2);
        
        Damage damage1 = new Damage(1,1);
        Damage damage2 = new Damage(aux5,1);
        Damage damage3 = new Damage(damage1);
        Damage damage4 = new Damage(damage2);
        
        EnemyStarShip nave1 = new EnemyStarShip("nave1",1.5f,2.5f,botin1,damage1);
        
        SpaceStation estacion1 = new SpaceStation("estacion1", paquete1);
        SpaceStation estacion2 = new SpaceStation("estacion2", paquete1);
        SpaceStation estacion3 = new SpaceStation("estacion3", paquete1);
        
        System.out.println("Método addWeapon de Hangar: ");
        if(hangar1.addWeapon(arma1))
            System.out.println("True");
        else
            System.out.println("False");
        if(hangar1.addWeapon(arma2))
            System.out.println("True");
        else
            System.out.println("False");
        
        System.out.println("Método addShieldBooster de Hangar: ");
        if(hangar2.addShieldBooster(escudo1))
            System.out.println("True");
        else
            System.out.println("False");
        if(hangar1.addShieldBooster(escudo2))
            System.out.println("True");
        else
            System.out.println("False");
        
        System.out.println("Método removeWeapon de Hangar: ");
        Weapon aux = hangar1.removeWeapon(0);
        System.out.println(aux.toString());
        Weapon aux2 = hangar2.removeWeapon(0);
        if(aux2 != null)
            System.out.println(aux2.toString());
        else
            System.out.println("Objeto nulo");
        
        System.out.println("Método removeShieldBooster de Hangar: ");
        ShieldBooster aux3 = hangar2.removeShieldBooster(0);
        System.out.println(aux3.toString());
        ShieldBooster aux4 = hangar1.removeShieldBooster(0);
        if(aux4 != null)
            System.out.println(aux4.toString());
        else
            System.out.println("Objeto nulo");
        
        System.out.println("Método discardWeapon de Damage: ");
        damage2.discardWeapon(arma1);
        System.out.println(damage2.toString());
        damage1.discardWeapon(arma2);
        System.out.println(damage1.toString());
        
        System.out.println("Método discardShieldBooster de Damage: ");
        damage1.discardShieldBooster();
        System.out.println(damage1.toString());
        
        System.out.println("Método hasNoEffect de Damage: ");
        if(damage1.hasNoEffect())
            System.out.println("True");
        if(!damage3.hasNoEffect())
            System.out.println("False");
        damage2.discardWeapon(arma2);
        damage2.discardShieldBooster();
        if(damage2.hasNoEffect())
            System.out.println("True");
        if(!damage4.hasNoEffect())
            System.out.println("False");
        
        System.out.println("Método adjust de Damage: ");
        Damage damage5 = damage3.adjust(aux6, aux7);
        System.out.println(damage5.toString());
        Damage damage6 = damage4.adjust(aux6, aux7);
        System.out.println(damage6.toString());
        
        System.out.println("Método protection de EnemyStarShip: ");
        System.out.println(nave1.protection());
        
        System.out.println("Método fire de EnemyStarShip: ");
        System.out.println(nave1.fire());
        
        System.out.println("Método receiveShot de EnemyStarShip: ");
        System.out.println(nave1.receiveShot(3.5f));
        System.out.println(nave1.receiveShot(1.0f));
        
        System.out.println("Método receiveHangar de SpaceStation: ");
        estacion1.receiveHangar(hangar3);
        System.out.println(estacion1.toString());
        
        System.out.println("Método receiveWeapon de SpaceStation: ");
        estacion1.receiveWeapon(arma1);
        System.out.println(estacion1.toString());
        if(!estacion2.receiveWeapon(arma1))
            System.out.println("False");
        
        System.out.println("Método receiveShieldBooster de SpaceStation: ");
        estacion2.receiveHangar(hangar2);
        estacion2.receiveShieldBooster(escudo1);
        System.out.println(estacion2.toString());
        if(!estacion3.receiveShieldBooster(escudo1))
            System.out.println("False");
        
        System.out.println("Método discardHangar de SpaceStation: ");
        estacion1.discardHangar();
        System.out.println(estacion1.toString());
        
        System.out.println("Método receiveSupplies de SpaceStation: ");
        estacion1.receiveSupplies(paquete1);
        System.out.println(estacion1.toString());
        
        System.out.println("Método setPendingDamage de SpaceStation: ");
        estacion1.setPendingDamage(damage6);
        System.out.println(estacion1.toString());
        
        System.out.println("Método mountWeapon de SpaceStation: ");
        estacion2.receiveWeapon(arma2);
        estacion2.mountWeapon(0);
        System.out.println(estacion2.toString());
        
        System.out.println("Método mountShieldBooster de SpaceStation: ");
        estacion2.mountShieldBooster(0);
        System.out.println(estacion2.toString());
        
        System.out.println("Método discardWeaponInHangar de SpaceStation: ");
        estacion1.receiveHangar(hangar3);
        estacion1.discardWeaponInHangar(0);
        System.out.println(estacion1.toString());
        
        System.out.println("Método discardShieldBoosterInHangar de SpaceStation: ");
        estacion1.receiveShieldBooster(aux3);
        estacion1.discardShieldBoosterInHangar(0);
        System.out.println(estacion1.toString());
        
        System.out.println("Método getSpeed de SpaceStation: ");
        System.out.println(estacion1.getSpeed());
        
        System.out.println("Método move de SpaceStation: ");
        estacion1.move();
        System.out.println(estacion1.toString());
        
        System.out.println("Método validState de SpaceStation: ");
        if(estacion1.validState())
            System.out.println("True");
        
        System.out.println("Método cleanUpMountedItems de SpaceStation: ");
        estacion1.receiveWeapon(arma3);
        estacion1.receiveShieldBooster(escudo3);
        estacion1.mountWeapon(0);
        estacion1.mountShieldBooster(0);
        estacion1.cleanUpMountedItems();
        System.out.println(estacion1.toString());
    }
}
*/