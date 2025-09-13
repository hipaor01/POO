/*

package deepspace;

import java.util.ArrayList;


public class TestP4 {
    public static void main(String[] args){
        NumericDamage damage1 = new NumericDamage(8,6);
        Weapon arma1 = new Weapon("arma1",WeaponType.MISSILE,4);
        Weapon arma2 = new Weapon("arma2",WeaponType.PLASMA, 5);
        Weapon arma3 = new Weapon("arma3",WeaponType.LASER, 6);
        ShieldBooster escudo1 = new ShieldBooster("escudo1",3.5f,7);
        ShieldBooster escudo2 = new ShieldBooster("escudo2",5.6f,12);
        ArrayList<Weapon> aux1 = new ArrayList<>();
        aux1.add(arma1);
        aux1.add(arma2);
        aux1.add(arma3);
        ArrayList<ShieldBooster> aux2 = new ArrayList<>();
        aux2.add(escudo1);
        aux2.add(escudo2);
        SuppliesPackage paquete1 = new SuppliesPackage(1.7f,5.6f,4.3f);
        SuppliesPackage paquete2 = new SuppliesPackage(1.8f,5.7f,4.4f);
        SuppliesPackage paquete3 = new SuppliesPackage(2.0f,6.0f,5.0f);
        SpaceStation estacion1 = new SpaceStation("estacion1", paquete1);
        BetaPowerEfficientSpaceStation betaeficiente1 = new BetaPowerEfficientSpaceStation(estacion1);
        SpaceStation estacion2 = new SpaceStation("estacion2", paquete2);
        SpaceStation estacion3 = new SpaceStation("estacion3", paquete3);
        ArrayList<SpaceStation> aux3 = new ArrayList<>();
        aux3.add(estacion2);
        aux3.add(estacion3);
        SpaceCity ciudad1 = new SpaceCity(estacion1,aux3);
        PowerEfficientSpaceStation eficiente1 = new PowerEfficientSpaceStation(estacion2);
        ArrayList<WeaponType> aux4 = new ArrayList<>();
        aux4.add(WeaponType.LASER);
        aux4.add(WeaponType.MISSILE);
        aux4.add(WeaponType.PLASMA);
        SpecificDamage damage2 = new SpecificDamage(aux4,5);
        ArrayList<Weapon> aux5 = new ArrayList<>();
        aux5.add(arma1);
        aux5.add(arma2);
        
        System.out.println("Método toString de NumericDamage: \n");
        System.out.println(damage1.toString());
       
        System.out.println("Método adjust de NumericDamage: \n");
        System.out.println(damage1.adjust(aux1, aux2).toString());
        
        System.out.println("Método toString de BetaPowerEfficientSpaceStation: \n");
        System.out.println(betaeficiente1.toString());
        
        System.out.println("Método fire de BetaPowerEfficientSpaceStation: \n");
        System.out.println(betaeficiente1.fire());
        
        System.out.println("Método protection de BetaPowerEfficientSpaceStation: \n");
        System.out.println(betaeficiente1.protection());
        
        System.out.println("Método toString de SpaceCity: \n");
        System.out.println(ciudad1.toString());
        
        System.out.println("Método fire de SpaceCity: \n");
        System.out.println(ciudad1.fire());
        
        System.out.println("Método protection de SpaceCity: \n");
        System.out.println(ciudad1.protection());
        
        System.out.println("Método toString de PowerEfficientSpaceStation: \n");
        System.out.println(eficiente1.toString());
        
        System.out.println("Método fire de PowerEfficientSpaceStation: \n");
        System.out.println(eficiente1.fire());
        
        System.out.println("Método protection de PowerEfficientSpaceStation: \n");
        System.out.println(eficiente1.protection());
        
        System.out.println("Método toString de SpecificDamage: \n");
        System.out.println(damage2.toString());
        
        System.out.println("Método adjust de SpecificDamage: \n");
        System.out.println(damage2.adjust(aux5, aux2).toString());
    }
}
*/