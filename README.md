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

## TODOs
* CI/CD
* MongoDB Connection debuggen
* SLF4J für MongoDB Logs
* on branch
  * fixed junit warning in maven 
  * fixed auto-detecting tests by maven
  * warnings as errors
  * publish to dockerhub
    * https://docs.github.com/en/actions/publishing-packages/publishing-docker-images#publishing-images-to-docker-hub
  * using secrets
    * https://docs.github.com/en/actions/security-guides/using-secrets-in-github-actions


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
