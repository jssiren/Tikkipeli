#Aiheen kuvaus ja rakenne:

###Kuvaus:
Tikkipeli on kahden peliparin, eli neljän pelaajan, korttipeli, jossa 36 kortin pakka sekoitetaan ja jaetaan tasan pelaajien kesken. Ennen korttien pelaamista suoritetaan huutokauppa, jonka voittaja, eli pelaaja joka huutaa eniten, aloittaa ensimmäisen tikin pelaamisen. Tikin suurin kortti voittaa, jolloin tikin voittaja aloittaa seuraavan tikin. Tikkeihin pelattavilla korteilla on maantunnustuspakko, eli jos ensimmäinen pelaaja aloitaa tikin hertalla, mikäli omasta kädestä sitä löytyy, täytyy muidenkin pelaajien pelata herttaa. Mikäli pystyy vielä laittamaan arvoltaan suurempaa korttia näin täytyy myös tehdä. Tätä kutsutaan ylimenopakoksi, ja pätee ainoastaan tikin aloittavan kortin suhteen. Mikäli ei ole tunnustaa maata, voi laittaa minkätahansa muun kortin tikkiin ja ylimenopakko ei enää päde. Kun kaikki 9 tikkiä on pelattu, korteista lasketaan pisteet pelipareittain. Se kumpi pelipareista pääsee ensimmäisenä yli 500 pisteeseen, voittaa. 

Korttijärjestys on Tikkipelissa myös erityinen. Korttien arvojärjestys menee seuraavasti suurimmasta pienimpään: ässä, kymppi, kuningas, rouva, jätkä, 9,8,7, ja 6.

Koska jokainen pelaaja pelaa alustavasti samalla ruudulla, täytyy omien korttien näkyvyys peittää, jolloin käyttöliittymä kysyy milloni siirrytään seuraavaan pelaajaan.

Käyttöliittymänä toimii yksi ruutu, josta nähdään koko ajan kaikki.


**Käyttäjät**: Pelaajat, 4 kpl.

**Kaikkien käyttäjien toiminnot**:
- Nimien asettaminen pelaajille
- Pelikortin pelaaminen 
- Huutokaupassa tehtävä "huuto" tai passaus

###Luokkakaavio:
![luokkakaavio](/dokumentaatio/luokkakaavio.png "Luokkakaavio")


###Rakennekuvaus:
Peli koostuu pakasta, neljästä pelaajasta ja pelattavista kierroksista. Pelaajat luodaa ja heille asetetaan kierroksen alussa aina uudet kortit käteen. Pelaaja vuorollaa pelaa yhden kortin tikkiin, joka sisältää enintään 4 korttia. Tikin voittaja jatkaa peliä ja ikistä saa pisteitä.
###Sekvenssiokaavio 1:
![sekvenssikaavio](/dokumentaatio/sekvenssikaavio1.PNG "Kortin pelaaminen tikkiin")

###Sekvenssiokaavio 2:
![sekvenssikaavio](/dokumentaatio/sekvenssikaavio2.PNG "Voiko kortin ylipäätänsä pelata")