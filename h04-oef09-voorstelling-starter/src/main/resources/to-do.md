# Oef 09 - Voorstelling

In het hoofdstuk over polymorfisme maakten jullie reeds kennis met de applicatie om voorstellingen te bekijken en toe te
voegen. We gaan nu deze applicatie volledig robuut maken. Open het project **h04-oef09-voorstelling-starter** en volg de
richtlijnen.

### Klasse `LegeStringException` toevoegen

* Voeg in een package `exceptions` een klasse `LegeStringException` toe.
  Deze exception klasse erft van `Exception`.
* Zorg ervoor dat een `LegeStringException` kan geworpen worden met als
  standaardboodschap "Alle velden zijn verplicht!",
  maar ook met een zelf gekozen foutboodschap.

### Aanpassingen in het domein en de testklassen

#### `Film`

* verander in de methode `setNaam` het werpen van een `IllegalArgumentException` naar het werpen van een
  `LegeStringException`
* daar dit een **checked exception** is zal je andere stukken in je code ook moeten aanpassen, maak overal
  waar nodig gebruik van een `throws` clausule, bekijk ook de unit test klassen

#### `ConcertRegistratie`

* verander nu ook in de methode `controleerIngevuld` het werpen van een `IllegalArgumentException` naar het werpen van
  een
  `LegeStringException` en pas op analoge wijze je code aan

#### `FilmTest`

* verander in de methode `maakFilm_legeNaam_werptException` het type van de verwachte exception van
  `IllegalArgumentException.class` naar
  `LegeStringException.class`

#### `ConcertRegistratieTest`

* doe dit ook in de methodes `maakConcertRegistratie_ongeldigeArtiest_werptException` en
  `maakConcertRegistratie_ongeldigeongeldigeConcertNaam_werptException`

Alle unit testen zouden nu moeten slagen.

### Aanpassingen in de applicatieklasse `VertoonbaarApplicatie`

* zet in de methode `voegVoorstellingToe` de volgende twee lijntjes code in een `try`-blok:

```
    dc.voegVoorstellingToe(gegevens);
    System.out.println("Voorstelling toegevoegd...");
```

* maak geschikte catch-blokken om de exceptions uit het domein op te vangen, dit zijn `NumberFormatException`,
  `LegeStringException` en `IllegalArgumentException`. Voeg ook een all-catch (`Exception`) toe. Zorg voor duidelijke
  foutboodschappen waarbij je eventueel gebruik maakt van de _message_ die in het exception-object zit.

### Aanpassingen in `StartUp`

* zet de code uit de main methode in een try-blok
* zet een all-catcher die aangeeft dat het programma stopt omdat de data uit de database corrupt is
* haal selectief één lijntje commentaar in de `VertoonbaarMapper` uit commentaar en kijk of je programma gepast reageert
    * de commentaarlijntjes simuleren corrupte data uit de databank

## Voorbeeld uitvoer

```
VOORSTELLINGEN
==============
1. Toon overzicht van de voorstellingen
2. Voeg een voorstelling toe
3. Geef het het aantal voorstellingen in een bepaalde zaal
4. Beëindig het programma
Geef je keuze > 2

VOORSTELLING TOEVOEGEN
======================
1. Voeg een film toe
2. Voeg een concertregistratie toe
3. Keer terug naar hoofdmenu
Geef je keuze > 2
Geef de naam van de artiest: Zwangere Guy
Geef de benaming van het concert: 
Voorstelling werd niet geregistreerd: Alle velden zijn verplicht!

VOORSTELLINGEN
==============
1. Toon overzicht van de voorstellingen
2. Voeg een voorstelling toe
3. Geef het het aantal voorstellingen in een bepaalde zaal
4. Beëindig het programma
Geef je keuze > 
```

```
VOORSTELLING TOEVOEGEN
======================
1. Voeg een film toe
2. Voeg een concertregistratie toe
3. Keer terug naar hoofdmenu
Geef je keuze > 1
Geef de naam van de film: Avatar
Geef het jaar waarin de film uitkwam: 2025
Hoeveel sterren verdient deze film: 10000
Voorstelling werd niet geregistreerd: aantal sterren voor een film moet in het interval [0,5] liggen
```

```
VOORSTELLING TOEVOEGEN
======================
1. Voeg een film toe
2. Voeg een concertregistratie toe
3. Keer terug naar hoofdmenu
Geef je keuze > 1
Geef de naam van de film: Avatar
Geef het jaar waarin de film uitkwam: 1802
Hoeveel sterren verdient deze film: 3
Voorstelling werd niet geregistreerd: het jaar waarin de film uitkomt moet in het interval [1900 - 2026] liggen
```

Indien in de mapper incorrecte data wordt aangeleverd:

```
Het programma kon niet gestart worden, corrupte data in de databank...
```