# Opgave 06 Voorwerpen

# Oefening: Voorwerp (robuuste Applicatie)

> **Let op:** We werken verder op de oefening *Voorwerp* uit het hoofdstuk "Polymorfisme en interfaces".
> Gebruik het startproject `h04-oef06-voorwerp-starter`.

In de domeinklassen `Voorwerp`, `Wapen`, `Sleutel` en `Gebouw` zijn de nodige exceptions reeds toegevoegd. De focus van
deze opdracht ligt op het bouwen van een robuuste gebruikersinterface die alle mogelijke foutmeldingen (zoals ongeldige
invoer of domein-fouten) correct en uniform afhandelt.

---

## 1. Architectuur en Ontwerp

De applicatie is onderverdeeld in twee lagen om de robuustheid te garanderen:

1. **De UI-laag (`VoorwerpApplicatie` & `Menu`)**

   1.1. **`Menu`**: Verantwoordelijk voor de validatie van de menukeuze. Het systeem blijft om invoer vragen tot de
   gebruiker een geldig cijfer binnen het bereik heeft ingevoerd. Pas de methode `geefKeuzeUitMenu` aan.

   1.2. **`VoorwerpApplicatie`**: Handelt de specifieke invoer per type (Wapen, Sleutel, Gebouw) af. Bij een foutieve
   waarde voor een attribuut worden **alle** vragen voor dat specifieke item opnieuw gesteld. Pas de methodes
   `vraagNaam` en `start` aan.

2. **De Domein-laag (`Voorwerp` en subklassen)**

   2.1. **Validatie**: De domeinklassen werpen exceptions zodra er logische fouten optreden (bijv. een negatief gewicht
   of een ongeldige sterkte). Dit werd reeds geïmplementeerd en garandeert de integriteit van onze objecten:

   2.2. **Integriteit**: Zorgt dat de objecten altijd in een geldige staat verkeren, ongeacht de aansturing
   vanuit de UI.

## Voorbeeld uitvoer Menu

```
HOGENT VOORWERPEN

MENU
====
1. Voeg wapen toe
2. Voeg sleutel toe
3. Voeg gebouw toe
4. Toon huidig overzicht
5. Beëindig deze applicatie
Geef je keuze (1 - 5) >  abc
[!] Ongeldige keuze, voer een getal in

MENU
====
1. Voeg wapen toe
2. Voeg sleutel toe
3. Voeg gebouw toe
4. Toon huidig overzicht
5. Beëindig deze applicatie
Geef je keuze (1 - 5) >  88
[!] Ongeldige keuze. Kies een optie tussen 1 en 5

.MENU
====
1. Voeg wapen toe
2. Voeg sleutel toe
3. Voeg gebouw toe
4. Toon huidig overzicht
5. Beëindig deze applicatie
Geef je keuze (1 - 5) >  -1
[!] Ongeldige keuze. Kies een optie tussen 1 en 5

.MENU
====
1. Voeg wapen toe
2. Voeg sleutel toe
3. Voeg gebouw toe
4. Toon huidig overzicht
5. Beëindig deze applicatie
Geef je keuze (1 - 5) >  
[!] Ongeldige keuze, voer een getal in

MENU
====
1. Voeg wapen toe
2. Voeg sleutel toe
3. Voeg gebouw toe
4. Toon huidig overzicht
5. Beëindig deze applicatie
Geef je keuze (1 - 5) >  1 2 3
[!] Ongeldige keuze, voer een getal in
```

## Voorbeeld uitvoer toevoegen voorwerp

```
HOGENT VOORWERPEN

MENU
====
1. Voeg wapen toe
2. Voeg sleutel toe
3. Voeg gebouw toe
4. Toon huidig overzicht
5. Beëindig deze applicatie
Geef je keuze (1 - 5) >  1

Geef de naam op: Magisch zwaard
[!] Ongeldige invoer: naam mag geen spaties bevatten..

Geef de naam op: MagischZwaard
Geef het gewicht: -100
Geef het niveau: 5
Geef de kracht: 4
Werd het wapen reeds gebruikt (true/false)? ja
[!] Ongeldige invoer: gewicht moet groter of gelijk aan 0 en minder dan 1000 kg zijn.

Geef de naam op: MagischZwaard
Geef het gewicht: 0.5
Geef het niveau: 4
Geef de kracht: 2
Werd het wapen reeds gebruikt (true/false)? alles behalve letterlijk true zal false opleveren


MENU
====
1. Voeg wapen toe
2. Voeg sleutel toe
3. Voeg gebouw toe
4. Toon huidig overzicht
5. Beëindig deze applicatie
Geef je keuze (1 - 5) >  4

Draagbaar: Wapen 'MagischZwaard' met gewicht 0,500 kg uit niveau 4 en met kracht 2 nog niet gebruikt.
```

```
HOGENT VOORWERPEN

MENU
====
1. Voeg wapen toe
2. Voeg sleutel toe
3. Voeg gebouw toe
4. Toon huidig overzicht
5. Beëindig deze applicatie
Geef je keuze (1 - 5) >  3

Geef de naam op: MagicTower
Geef de hoogte: -10
[!] Ongeldige invoer: de hoogte moet minstens 3m zijn!.

Geef de naam op: MagicTower
Geef de hoogte: 55


MENU
====
1. Voeg wapen toe
2. Voeg sleutel toe
3. Voeg gebouw toe
4. Toon huidig overzicht
5. Beëindig deze applicatie
Geef je keuze (1 - 5) >  4

Niet draagbaar: Gebouw 'MagicTower' met hoogte 55,0.
```