# Opgave 07: Verplaatsing (Robuuste Foutafhandeling)

> **Let op:** Werk verder op de oefening *Verplaatsing* uit het hoofdstuk "Polymorfisme en interfaces". Gebruik het
> startproject `h04-oef07-verplaatsing-starter`.

In de domeinklassen `Verplaatsing`, `VerplaatsingPerAuto`, `VerplaatsingPerBusTram` en `Ticket` zijn de nodige
exceptions reeds geïmplementeerd. In deze opdracht bouwen we een robuuste applicatie die simuleert hoe fouten uit de
databanklaag (die doorvloeien naar de domeinlaag) opgevangen en afgehandeld worden.

---

## 1. Architectuur en Foutafhandeling

De applicatie moet fouten op verschillende niveaus kunnen isoleren en rapporteren:

1. **De UI-laag (Startup & Main)**

   1.1. **`Main`-methode**: De opstartlogica wordt volledig omsloten door een `try-catch` blok om kritieke fouten bij
   initialisatie te beheren.

   1.2. **Specifieke Catch**: Vang `IllegalArgumentException` op om gerichte feedback te geven over ongeldige
   configuraties of parameters.

   1.3. **Generieke Catch (All-Catcher)**: Implementeer een vangnet voor alle overige onverwachte uitzonderingen (
   `Exception`) met een algemene foutboodschap om een "harde crash" te voorkomen.

---

## 2. Implementatie details: Startup

### De `main`-methode

De focus ligt hier op het veilig opstarten van de applicatie. Gebruik de volgende structuur:

* **Try-blok**: Bevat de code voor de instantiatie van de controllers en het starten van de applicatie-interface.
* **Catch (IllegalArgumentException)**: Toon een duidelijke, gebruikersvriendelijke foutboodschap die aangeeft wat er
  mis is met de opgegeven startwaarden.
* **Catch (Exception)**: De "All-Catcher". Log de technische details (optioneel) maar toon aan de gebruiker een generiek
  bericht zoals: *"Onverwachte fout opgetreden bij het opstarten van de applicatie:"*
* **exit(1)**: Zorg dat het systeem wordt afgesloten met exit code 1 om aan te geven dat dit geen normale beëindiging
  van het programma was.

---

## 3. Simulatie van Foutscenario's

Het doel is om te verifiëren dat ongeldige verplaatsingsgegevens (afstand, tarieven) en technische fouten (geen databank
connectie) leiden tot de juiste afhandeling van de exception.

Je kan de lijntjes die in commentaar staan in de `KostenMapper` selectief uit commentaar halen en kijken of de
applicatie geschikt reageert.

### Voorbeeld uitvoer

```
[!] Foutieve gegevens in databank: de benzineprijs moet tussen 0.5 en 2 euro liggen.
Process finished with exit code 1
```

```
[!] Onverwachte fout opgetreden bij het opstarten van de applicatie: 
This is the simulated Database Error: SQLException: JDBC encountered an error.
Process finished with exit code 1
```