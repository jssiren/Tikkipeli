package tikkipeli;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Pakka pakka = new Pakka();
        pakka.sekoitaPakka();
        
        Kasi kasi1 = new Kasi();
        Kasi kasi2 = new Kasi();
        Kasi kasi3 = new Kasi();
        Kasi kasi4 = new Kasi();
        
        List<Kasi> kadet = pakka.jaaPakkaNeljaan();
        
        kasi1.setKortit(kadet.get(0).getKortit());
        kasi2.setKortit(kadet.get(1).getKortit());
        kasi3.setKortit(kadet.get(2).getKortit());
        kasi4.setKortit(kadet.get(3).getKortit());
        
        kasi1.kortitJarjestykseen();
        kasi2.kortitJarjestykseen();
        kasi3.kortitJarjestykseen();
        kasi4.kortitJarjestykseen();
        
        System.out.println(kasi1.getKortit());
        System.out.println(kasi2.getKortit());
        System.out.println(kasi3.getKortit());
        System.out.println(kasi4.getKortit());

    }
}
