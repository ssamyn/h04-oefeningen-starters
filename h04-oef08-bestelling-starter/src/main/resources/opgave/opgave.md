# Opgave 08 Bestelling

## Robuust Bestelsysteem voor printers, scanners & laptops

Ontwikkel een robuuste console-applicatie voor het beheren van bestellingen. De focus van deze oefening ligt op *
*validatie in meerdere lagen** en het correct afhandelen van **custom exceptions**.

### 1. Domeinregels (Validatie)

Een bestelling is alleen geldig als deze voldoet aan de volgende strikte kwantitatieve restricties:

| Artikeltype  | Maximum aantal |
|:-------------|:---------------|
| **Printers** | Hoogstens 4    |
| **Scanners** | Hoogstens 3    |
| **Laptops**  | Hoogstens 2    |

**Totaaloverzicht:** Een volledige bestelling moet **minimaal 1** en **maximaal 8** artikelen in totaal bevatten.

### 2. Foutafhandeling & Exception Strategie

Implementeer een hiërarchie in foutmeldingen om de robuustheid te garanderen:

1. **Een eigen exception klasse `BestellingException`**

* Voeg in een package `exceptions` een klasse `BestellingException` toe.
  Deze exception klasse erft van `Exception`.
* Zorg ervoor dat een `BestellingException` kan geworpen worden met als
  standaardboodschap "Ongeldige bestelling", maar ook met een zelf gekozen foutboodschap.

2. **De Domein-laag (`Bestelling`)**

   2.1. **Validatie**: Voert een finale controle uit op zowel de individuele maxima per artikel als het algemene totaal.
    * Werp een `IllegalArgumentException` indien een **individueel aantal** de limiet per type overschrijdt (gebruik dit
      in de setters).
    * Werp een `BestellingException` indien het **totaal aantal artikelen** (minimaal 1 en maximaal 8 artikelen) niet
      geldig is (gebruik dit in
      constructor)

   2.3 **Unit testen**: Zodra je de `BestellingException` hebt toegevoegd en je het domein robuust hebt gemaakt slagen
   alle unit testen!

3. **De UI-laag**

   3.1. **`Menu`**: Controleert de gemaakte menukeuze. Geeft directe feedback aan de gebruiker indien er sprake is van
   ongeldige invoer (zoals tekst in plaats van cijfers of keuzes buiten het bereik). Dit is reeds geïmplementeerd.

   3.2. **`BestellingApplicatie`**: Controleert direct de individuele aantallen per type. Dit zorgt voor snelle feedback
   naar de gebruiker zonder onnodige communicatie met de domeinlaag. Zie `// TODO`.

### Voorbeeld uitvoer

```
HOGENT Bestellingen printers, scanner en laptops

BESTELLINGEN
============
1. Nieuwe bestelling plaatsen
2. Overzicht bestellingen tonen
3. Stoppen
Geef je keuze (1 - 3) > 1

Geef aantal printers > 4
Geef aantal laptops > 2
Geef aantal scanners > 3
🔴 Bestelling kon niet geplaatst worden: bestelling moet minstens 1 en mag maximaal 8 artikelen bevatten.
Geef de gegevens voor de bestelling opnieuw in

Geef aantal printers > 66
🔴 Voer een waarde in tussen 0 en 4.

Geef aantal printers > abc
🔴 Dit is geen geldig geheel getal. Probeer opnieuw.

Geef aantal printers > 4
Geef aantal laptops > 0
Geef aantal scanners > 1
✅ Je bestelling werd succesvol geplaatst...

BESTELLINGEN
============
1. Nieuwe bestelling plaatsen
2. Overzicht bestellingen tonen
3. Stoppen
Geef je keuze (1 - 3) > 2

- Bestelling voor 4 printers, 0 laptops en 1 scanner.


BESTELLINGEN
============
1. Nieuwe bestelling plaatsen
2. Overzicht bestellingen tonen
3. Stoppen
Geef je keuze (1 - 3) > 3

Tot een volgende keer...
```