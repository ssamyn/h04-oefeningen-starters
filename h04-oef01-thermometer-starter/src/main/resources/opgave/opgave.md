# Opgave 01 - Thermometer (Deel 1)

## Exceptions werpen en opvangen in de UI-laag

![UML Diagram](images/uml.png)

### Beschrijving

Vervolledig de consoleapplicatie in de klasse `ThermometerApplicatie`. De applicatie moet een temperatuur in *
*Fahrenheit** opvragen, deze omzetten naar **Celsius** en het resultaat aan de gebruiker tonen.

### Domeinlogica en Architectuur

Gebruik de meegeleverde domeinklasse `Thermometer` voor de berekening. De conversieformule is als volgt geïmplementeerd:

$$°C = \frac{5}{9} \times (°F - 32)$$

**Beschrijving gegeven applicatie:**

* **Constructor:** De parameterloze constructor stelt de starttemperatuur in op **32 °F**.
* **Gelaagde structuur:** Respecteer het UML-diagram. Gebruik de klasse `DomeinController` als noodzakelijk doorgeefluik
  tussen de UI (`ThermometerApplicatie`) en het domein (`Thermometer`).
* **Entry point:** De applicatie wordt gestart via de klasse `StartUp` in de package `main`.

### Validatie en Exception Handling

Zorg voor een robuuste foutafhandeling in de **UI-laag** (`ThermometerApplicatie`). De applicatie mag niet crashen bij
foutieve invoer.

1. **Niet-numerieke invoer:** Vang fouten op wanneer de gebruiker tekst invoert in plaats van een getal.
2. **Bereikcontrole:** De invoer moet binnen het gesloten interval **[14 °F, 104 °F]** liggen.
3. **Afhandeling:** Alle exceptions moeten direct in `ThermometerApplicatie` worden afgehandeld met een duidelijke
   foutmelding naar de gebruiker.

---

### Verwachte Uitvoer

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