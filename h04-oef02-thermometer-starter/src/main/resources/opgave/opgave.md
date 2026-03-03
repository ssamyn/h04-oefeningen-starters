# Opgave 02 - Thermometer deel 2

## Fouten geworpen in domein-laag en UI-laag opvangen en afhandelen in de UI-laag

> De controle op het interval **[14, 104]** is een **domeinregel**. Dit zijn de grenzen van
> de thermometer. **Domeinregels MOET je steeds implementeren in het domein!**

In deel 1 werd de domeinregel niet geïmplementeerd in de domein-laag...

* Implementeer de domeinregel in de methode `setAantalGraden` in de klasse `Thermometer`:
    * de temperatuur van een thermometer moet ten aller tijde in het interval **[14, 104]** liggen.
    * werp een `IllegalArgumentException` indien niet aan de domeinregel is voldaan.
    * maak gebruik van de gegeven constanten
    * zorg dat alle unit testen slagen


* Pas de klasse `ThermometerApplicatie` aan
    * vang de exceptions geworpen in het domein op en handel ze af.

### Voorbeeld uitvoer (ongewijzigd):

```text
Geef een gehele temperatuur in °F uit het interval [14,104]: blabla
De invoer moet een geheel getal zijn!
Geef een gehele temperatuur in °F uit het interval [14,104]: 500
Waarde van temperatuur moet uit het interval [14,104] komen!
Geef een gehele temperatuur in °F uit het interval [14,104]: 10
Waarde van temperatuur moet uit het interval [14,104] komen!
Geef een gehele temperatuur in °F uit het interval [14,104]: 20
De temperatuur in °C is -6
```

__Merk op:__ je mag domeinregels ook afdwingen, implementeren, in de UI laag, dit doet men dikwijls om de
gebruiksvriendelijkheid van de applicatie
te verhogen. Dit betekent **niet** dat je de implementatie van de domeinregels mag
weglaten uit het domein...