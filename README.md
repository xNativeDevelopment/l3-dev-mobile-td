# TD 11 — L'architecture de mon projet

Slide : S-11 — Découper son projet en couches reliées par des interfaces · Dépôt : https://github.com/<COMPTE>/td-11-couches
État du build : starter construit le 2026-11-15 · solution construite le 2026-11-15

## Objectif

À la fin, je sais ranger mon code en couches présentation / domaine / données et les relier par des interfaces.

## Point de départ

Ce dépôt contient l'état final du TD 10 : tous les fichiers sont dans un seul package.
Ouvrir ce dossier dans Android Studio (pas son dossier parent), attendre la synchronisation Gradle, puis Run.

## Étapes

1. Créer trois packages sous `com.example.catalogue` : `ui`, `domain`, `data`.
2. Déplacer `Character.kt` dans `domain` et `CharacterCard.kt` dans `ui`, en corrigeant `package` et imports.
3. Dans `domain`, écrire l'interface `CharacterProvider` : le contrat qui donne la liste des personnages.
4. Dans `data`, écrire `FakeCharacterProvider`, qui implémente le contrat, et supprimer `FakeCharacters.kt`.
5. Dans `MainActivity.kt`, obtenir les personnages par le contrat. Dans `ui`, la preview crée son `Character` elle-même : aucun import de `data`.

## Critères de réussite

- [ ] Trois packages distincts, chacun avec ses classes — `CRIT-DMA-D1-SF-2-M1` couches distinctes.
- [ ] Aucun fichier de `ui` n'importe `data` — `CRIT-DMA-D1-SF-2-M2` UI rassemblée, rien ne fuit.
- [ ] Chaque classe est dans la couche qui lui correspond — `CRIT-DMA-D1-SE-2-M3` chaque composant à sa place.
- [ ] Chaque couche a un rôle net : affichage, contrat, source de données — `CRIT-DMA-D1-SE-2-M4` architecture de chaque couche nette.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajouter une seconde implémentation du contrat, avec une liste plus courte, et la brancher dans `MainActivity`.
- Chercher dans le projet un import qui ferait remonter une classe de `data` vers `ui`.

## Avec le tuteur

Facultatif. Ouvre une séance avec `tuteur-android` sur la sous-compétence S-11
(« séance tuteur, slide S-11 ») ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/<COMPTE>/td-04-tuteur-android/tree/main/tuteur-android
Sans agent : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
