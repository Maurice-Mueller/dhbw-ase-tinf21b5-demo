# Demo Project

Das ist das Demo-Projekt für ASE.


## Übersicht der Eigenschaften

* WikiEntry erstellen
* WikiEntry löschen
* WikiEntry suchen
* WikiEntry-Übersicht
* Versionsverwaltung
* WikiEntry
  * Inhalt
  * Metadaten
    * Verlinkung
    * Author
    * Erstellungsdatum
    * Aktualisierungsdatum


## Technische Umsetzung

* WikiEntryRepository
* WikiEntry
    * Inhalt
    * Metadaten
        * Verlinkung
        * Author
        * Erstellungsdatum
        * Aktualisierungsdatum
* DB?
* CI/CD


## Ubiquitous Language

* WikiEntry: Ein Eintrag im Wiki


## Versionsverwaltung

* Option 1: WikiEntry enthält eine Liste der Versionen
  * (+) sehr einfache Verwaltung, weil es nur einen WikiEntry gibt
  * (o) Speicherverbrauch ~gleich zu Option 2
  * (o) es muss sich um Persistenz Gedanken gemacht werden
  * (-) höherer Speicherverbrauch als Option 3
  * (-) im Vergleich zu Option 2 etwas komplexer im Umgang mit den Versionen
* Option 2: WikiEntry wird mit `version` ergänzt
  * (+) sehr einfache Verwaltung der Versionen
  * (+) Komplexität der Persistenz erhöht sich nicht
  * (-) Historienhandhabung ist komplexer im Vergleich zu Option 1
  * (-) `created` und `lastUpdated` müssen neu gedacht werden
* Option 3: WikiEntry speichert die Diffs der Versionen
  * (+) Speichereffizienz
  * (+) sehr einfache Verwaltung, weil es nur einen WikiEntry gibt
  * (-) aktueller Stand und alle Zwischenstände müssen berechnet werden
    * Diffs sind ohne Kontext wertlos
