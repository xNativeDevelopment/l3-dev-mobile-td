# TD 10 — La Card d'un personnage

Slide : S-10 — Créer un composant : une Card à partir des données d'une API · Dépôt : https://github.com/<COMPTE>/td-10-composant-card
État du build : à vérifier

## Objectif

À la fin, je sais construire un composable réutilisable qui affiche les données qu'on lui passe, et rien d'autre.

## Point de départ

Ce dépôt contient l'état final du TD 09.
Ouvrir ce dossier dans Android Studio (pas son dossier parent), attendre la synchronisation Gradle, puis Run.

## Étapes

1. Ouvrir `Character.kt` et `FakeCharacters.kt` : lire les champs d'un personnage, tels que l'API les renvoie.
2. Choisir les données à montrer sur la Card : le numéro, le nom et l'espèce.
3. Dans `CharacterCard.kt`, remplacer le stub : le composable reçoit un `Character` et un `modifier`, rien d'autre.
4. Poser la mise en page avec `Card`, `Row` et `Column`.
5. Ajouter une `@Preview` privée alimentée par `fakeCharacters.first()`.
6. Dans `MainActivity.kt`, afficher la Card à la place du `Greeting`, puis lancer l'app.

## Critères de réussite

- [ ] La Card ne charge rien elle-même : tout vient de ses paramètres — `CRIT-DMA-D1-SE-3-M3` composants au bon endroit.
- [ ] La Card est une brique réutilisable avec sa propre preview — `CRIT-DMA-D1-SE-3-M4` composables découpés en LEGO.
- [ ] La Card n'a qu'un rôle : afficher un personnage — `CRIT-DMA-D1-SF-3-M5` chaque composant a un rôle.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Afficher le statut du personnage avec une couleur de texte différente selon sa valeur.
- Passer deux Cards dans une `Column` pour vérifier que le composant se réutilise tel quel.

## Avec le tuteur

Facultatif. Ouvre une séance avec `tuteur-android` sur la sous-compétence S-10
(« séance tuteur, slide S-10 ») ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/<COMPTE>/td-04-tuteur-android/tree/main/tuteur-android
Sans agent : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
