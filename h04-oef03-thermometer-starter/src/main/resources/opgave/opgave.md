# Opgave 03 - Thermometer Deel 3

## Alle fouten die in de domein-laag geworpen worden opvangen in de UI-laag

* De methode `stelAantalGradenIn` in de klasse `Thermometer` heeft als parameter een String.
  Maak gebruik van `Integer.parseInt` om deze `String` om te zetten naar `int`.
  Roep de private setter aan met de verkregen waarde om effectief
  het aantal graden in te stellen.
* Zorg dat alle **unit testen** slagen.


* Bekijk de `ThermometerApplicatie` die werd overgenomen uit vorige oefening.
  Pas deze klasse, indien nodig aan.

### Verwachte uitvoer:

```text
Geef een gehele temperatuur in °F uit het interval [14,104]: blabla
De invoer moet een geheel getal zijn!
Geef een gehele temperatuur in °F uit het interval [14,104]: 500
Waarde van temperatuur moet uit het interval [14,104] komen!
Geef een gehele temperatuur in °F uit het interval [14,104]: 10
Waarde van temperatuur moet uit het interval [14,104] komen!
Geef een gehele temperatuur in °F uit het interval [14,104]: 20
De temperatuur in °C is -6