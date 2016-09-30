package tikkipeli;

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

    public Kortti tikinVoittavaKortti(Kortti[] tikinKortit) {
        Kortti kortti = tikinKortit[0]; // tikin aloittava kortti
        if (!this.onkoValttiJulistettu) {
            for (int i = 1; i < 4; i++) {
                if (tikinKortit[i].getMaa().equals(kortti.getMaa()) && tikinKortit[i].getArvo() > kortti.getArvo()) {
                    kortti = tikinKortit[i];
                }
            }
            return kortti;
        } else {
            if (valttiMaa.equals(kortti.getMaa())) {
                for (int i = 1; i < 4; i++) {
                    if (tikinKortit[i].getMaa().equals(kortti.getMaa()) && tikinKortit[i].getArvo() > kortti.getArvo()) {
                        kortti = tikinKortit[i];
                    }
                }
                return kortti;
            } else {
                for (int i = 1; i < 4; i++) {
                    if (tikinKortit[i].getMaa().equals(kortti.getMaa()) && tikinKortit[i].getArvo() > kortti.getArvo()) {
                        kortti = tikinKortit[i];
                    } else if (tikinKortit[i].getMaa().equals(valttiMaa)) {
                        kortti = tikinKortit[i];
                    }
                }
                return kortti;
            }
        }
        
    }
   
//    public Boolean voikoKortinLisata() {
//        return true;
//    }
}