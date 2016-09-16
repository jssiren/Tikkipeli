/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tikkipeli;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("blaa");
        Kortti kortti = new Kortti(0,1);
        //System.out.println(kortti);
        Pakka pakka = new Pakka();
        pakka.lisaaKortti();
        System.out.println(pakka.getKortit().toString());
    }
}
