# Opgave 06 Interface Draagbaar

# Oefening: Robuuste applicatie bouwen voor Gebouwen en Voorwerpen

> **Let op:** We werken verder op de oefening *Voorwerp* uit het hoofdstuk "Polymorfisme en interfaces".
> Gebruik het startproject `h04-oef06-draagbaar-starter`.

De focus van
deze opdracht ligt op het bouwen van een **robuuste gebruikersinterface** die alle mogelijke foutmeldingen — zowel
ongeldige invoer of domein-fouten — **correct en uniform** afhandelt en zorgt voor een **gebruiksvriendelijke**
ervaring.

---

## 1. Architectuur en Ontwerp

De applicatie is onderverdeeld in twee lagen om de robuustheid te garanderen:

### **De domein-laag.**

In de domeinklassen `Voorwerp`, `Wapen`, `Sleutel` en `Gebouw` zijn de domeinregels geïmplementeerd.
In de setters en de controleermethodes worden `IllegalArgumentException`-s geworpen indien de domeinregels worden
overtreden.
Dit garandeert dat onze objecten zich steeds in een geldige toestand zullen bevinden.

### **De ui-laag (`DraagbaarApplicatie` & `Menu`)**

In de `IO` klasse zit de scanner gecentraliseerd. Deze ene scanner `INVOER` kan in alle user interface klassen gebruikt
worden.
De checks op geldige invoer zitten daar ook in hulpmethodes gecentraliseerd. In de applicatieklassen, zoals de
`DraagbaarApplicatie` kan je nu focussen op de applicatie logica.

_Merk op: als je de `IO` klasse gebruikt mag je voor de invoer van decimale getallen zowel de
decimale punt als de decimale komma gebruiken. De code kan met beide overweg._

1. **`Menu`**: Verantwoordelijk voor de validatie van de menukeuze. Het systeem blijft om invoer vragen tot de
   gebruiker een geldig cijfer binnen het bereik heeft ingevoerd. Pas de methode `geefKeuzeUitMenu` aan.

2. **`DraagbaarApplicatie`**: Handelt de specifieke invoer per type (Wapen, Sleutel, Gebouw) af. Pas de methodes
   `voegWapenToe` en `voegSleutelToe` aan. Maak gebruik van de hulpmethodes uit de klasse `IO`. Je kan je baseren op het
   voorbeeld `voegGebouwToe` dat reeds werd uitgewerkt. Merk op hoe in deze methodes nu ook de
   `IllegalArgumentException`s,
   die mogelijk in het domein worden geworpen, worden afgehandeld.

## Voorbeeld menu

```
Applicatie interface 'Draagbaar'

Gebouwen en voorwerpen
======================
1. Voeg wapen toe
2. Voeg sleutel toe
3. Voeg gebouw toe
4. Toon huidig overzicht
5. Beëindig deze applicatie
Geef je keuze (1 - 5) >  abc
🔴 Ongeldige keuze, voer een getal in.

Gebouwen en voorwerpen
======================
1. Voeg wapen toe
2. Voeg sleutel toe
3. Voeg gebouw toe
4. Toon huidig overzicht
5. Beëindig deze applicatie
Geef je keuze (1 - 5) >  88
🔴 Ongeldige keuze. Kies een optie tussen 1 en 5.

Gebouwen en voorwerpen
======================
1. Voeg wapen toe
2. Voeg sleutel toe
3. Voeg gebouw toe
4. Toon huidig overzicht
5. Beëindig deze applicatie
Geef je keuze (1 - 5) >  -1
🔴 Ongeldige keuze. Kies een optie tussen 1 en 5.

Gebouwen en voorwerpen
======================
1. Voeg wapen toe
2. Voeg sleutel toe
3. Voeg gebouw toe
4. Toon huidig overzicht
5. Beëindig deze applicatie
Geef je keuze (1 - 5) >  
🔴 Ongeldige keuze, voer een getal in.
```

## Voorbeeld toevoegen wapen en gebouw

```
Applicatie interface 'Draagbaar'

Gebouwen en voorwerpen
======================
1. Voeg wapen toe
2. Voeg sleutel toe
3. Voeg gebouw toe
4. Toon huidig overzicht
5. Beëindig deze applicatie
Geef je keuze (1 - 5) >  1

Geef de naam > Magisch zwaard
🔴 De naam mag geen spaties bevatten.

Geef de naam > MagischZwaard
Geef het gewicht > -100
🔴 Voer een waarde in tussen 0,00 en 999,00.

Geef het gewicht > 0,854
Geef het niveau > abc
🔴 Dit is geen geldig geheel getal. Probeer opnieuw.

Geef het niveau > 66
🔴 Voer een waarde in tussen 1 en 5.

Geef het niveau > 3
Geef de kracht > -6
🔴 Voer een positieve waarde in.

Geef de kracht > 32
Werd het wapen reeds gebruikt [ja/nee] > soms
🔴 Je moet antwoorden met 'ja' of 'nee'.

Werd het wapen reeds gebruikt [ja/nee] > JA
✅ Wapen succesvol toegevoegd

Gebouwen en voorwerpen
======================
1. Voeg wapen toe
2. Voeg sleutel toe
3. Voeg gebouw toe
4. Toon huidig overzicht
5. Beëindig deze applicatie
Geef je keuze (1 - 5) >  4

Draagbaar: Wapen 'MagischZwaard' met gewicht 0,854 kg uit niveau 3 en met kracht 32 al gebruikt.


Gebouwen en voorwerpen
======================
1. Voeg wapen toe
2. Voeg sleutel toe
3. Voeg gebouw toe
4. Toon huidig overzicht
5. Beëindig deze applicatie
Geef je keuze (1 - 5) >  3

Geef de naam > VervallenSchuur
Geef de hoogte > 2.5
🔴 Voer een waarde in die minstens 3,00 is.

Geef de hoogte > 3.0
✅ Gebouw succesvol toegevoegd

Gebouwen en voorwerpen
======================
1. Voeg wapen toe
2. Voeg sleutel toe
3. Voeg gebouw toe
4. Toon huidig overzicht
5. Beëindig deze applicatie
Geef je keuze (1 - 5) >  4

Draagbaar: Wapen 'MagischZwaard' met gewicht 0,854 kg uit niveau 3 en met kracht 32 al gebruikt.
Niet draagbaar: Gebouw 'VervallenSchuur' met hoogte 3,0.
```