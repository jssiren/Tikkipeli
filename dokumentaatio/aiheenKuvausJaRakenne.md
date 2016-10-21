#Aiheen kuvaus ja rakenne:

###Kuvaus:
Tikkipeli on kahden peliparin, eli nelj�n pelaajan, korttipeli, jossa 36 kortin pakka sekoitetaan ja jaetaan tasan pelaajien kesken. Ennen korttien pelaamista suoritetaan huutokauppa, jonka voittaja, eli pelaaja joka huutaa eniten, aloittaa ensimm�isen tikin pelaamisen. Tikin suurin kortti voittaa, jolloin tikin voittaja aloittaa seuraavan tikin. Tikkeihin pelattavilla korteilla on maantunnustuspakko, eli jos ensimm�inen pelaaja aloitaa tikin hertalla, mik�li omasta k�dest� sit� l�ytyy, t�ytyy muidenkin pelaajien pelata herttaa. Mik�li pystyy viel� laittamaan arvoltaan suurempaa korttia n�in t�ytyy my�s tehd�. T�t� kutsutaan ylimenopakoksi, ja p�tee ainoastaan tikin aloittavan kortin suhteen. Mik�li ei ole tunnustaa maata, voi laittaa mink�tahansa muun kortin tikkiin ja ylimenopakko ei en�� p�de. Kun kaikki 9 tikki� on pelattu, korteista lasketaan pisteet pelipareittain. Se kumpi pelipareista p��see ensimm�isen� yli 500 pisteeseen, voittaa. 

Korttij�rjestys on Tikkipelissa my�s erityinen. Korttien arvoj�rjestys menee seuraavasti suurimmasta pienimp��n: �ss�, kymppi, kuningas, rouva, j�tk�, 9,8,7, ja 6.

Koska jokainen pelaaja pelaa alustavasti samalla ruudulla, t�ytyy omien korttien n�kyvyys peitt��, jolloin k�ytt�liittym� kysyy milloni siirryt��n seuraavaan pelaajaan.

K�ytt�liittym�n� toimii yksi ruutu, josta n�hd��n koko ajan kaikki.


**K�ytt�j�t**: Pelaajat, 4 kpl.

**Kaikkien k�ytt�jien toiminnot**:
- Nimien asettaminen pelaajille
- Pelikortin pelaaminen 
- Huutokaupassa teht�v� "huuto" tai passaus

###Luokkakaavio:
![luokkakaavio](/dokumentaatio/luokkakaavio.png "Luokkakaavio")


###Rakennekuvaus:
Peli koostuu pakasta, nelj�st� pelaajasta ja pelattavista kierroksista. Pelaajat luodaa ja heille asetetaan kierroksen alussa aina uudet kortit k�teen. Pelaaja vuorollaa pelaa yhden kortin tikkiin, joka sis�lt�� enint��n 4 korttia. Tikin voittaja jatkaa peli� ja ikist� saa pisteit�.
###Sekvenssiokaavio 1:
![sekvenssikaavio](/dokumentaatio/sekvenssikaavio1.PNG "Kortin pelaaminen tikkiin")

###Sekvenssiokaavio 2:
![sekvenssikaavio](/dokumentaatio/sekvenssikaavio2.PNG "Voiko kortin ylip��t�ns� pelata")