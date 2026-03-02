# Opgave 02

## Fouten geworpen in domein-laag en UI-laag opvangen en afhandelen in de UI-laag

* Implementeer de volgende domeinregel in de methode `setAantalGraden` in de klasse `Thermometer`:
    * de temperatuur van een thermometer moet ten aller tijde in het interval **[14, 104]** liggen.
    * werp een `IllegalArgumentException` indien niet aan de domeinregel is voldaan.
    * maak gebruik van de constanten
    * zorg dat alle unit testen slagen


* Pas de klasse `ThermometerApplicatie` aan
    * vang de exceptions geworpen in het domein op en handel ze af.

> Merk op:
> de controle op het interval **[14, 104]** is een **domeinregel**. Dit zijn de grenzen van
> de thermometer. **Domeinregels MOET je steeds implementeren in het domein!**

_Je mag domeinregels ook afdwingen in de UI laag, dit doet men dikwijls om de gebruiksvriendelijkheid van de applicatie
te verhogen._