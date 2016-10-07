package tikkipeli.Logic;

import java.util.*;


public class Tikkilogiikka {

    private Maa valttiMaa;
    private Boolean onkoValttiJulistettu;

    public Tikkilogiikka() {
        onkoValttiJulistettu = false;
        valttiMaa = null;
    }
    
    public Boolean getOnkoValttia() {
        return onkoValttiJulistettu;
    }
    
    public Maa getValtti() {
        return valttiMaa;
    }

    public void julistaValtti(Maa maa) {
        valttiMaa = maa;
        onkoValttiJulistettu = true;
    }
    
    public void vaihdaValtti(Maa maa) {
        if (!maa.equals(valttiMaa)) {
            valttiMaa = maa;
        }
    }
    
    
    /*
    * Metodi kertoo mikä kortti voittaa tikin seuraten pelin korttijärjestyksen logiikkaa.
    */
    public Kortti tikinVoittavaKortti(ArrayList<Kortti> tikinKortit) {
        Kortti kortti = tikinKortit.get(0); // tikin aloittava kortti
        if (!this.onkoValttiJulistettu) {
            for (int i = 1; i < 4; i++) {
                if (tikinKortit.get(i).getMaa().equals(kortti.getMaa()) && tikinKortit.get(i).getArvo() > kortti.getArvo()) {
                    kortti = tikinKortit.get(i);
                }
            }
            return kortti;
        } else {
            if (valttiMaa.equals(kortti.getMaa())) {
                for (int i = 1; i < 4; i++) {
                    if (tikinKortit.get(i).getMaa().equals(kortti.getMaa()) && tikinKortit.get(i).getArvo() > kortti.getArvo()) {
                        kortti = tikinKortit.get(i);
                    }
                }
                return kortti;
            } else {
                for (int i = 1; i < 4; i++) {
                    if (tikinKortit.get(i).getMaa().equals(kortti.getMaa()) && tikinKortit.get(i).getArvo() > kortti.getArvo()) {
                        kortti = tikinKortit.get(i);
                    } else if (tikinKortit.get(i).getMaa().equals(valttiMaa)) {
                        kortti = tikinKortit.get(i);
                    }
                }
                return kortti;
            }
        }
        
    }
    
    public boolean voikoKortinPelataTikkiin(Tikki tikki, Kasi kasi) {
        Kortti tikinAloittanut = tikki.getKortit().get(0);
        for (int i = 0; i < tikki.getKortit().size(); i++) {
            
        }
        return false;
    }
}