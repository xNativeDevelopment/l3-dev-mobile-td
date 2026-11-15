# TD 10 — La Card d'un personnage

Slide : S-10 — Créer un composant : une Card à partir des données d'une API · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-10-composant-card
État du build : départ construit le 2026-11-15 · solution construite le 2026-11-15

## Objectif

À la fin, je sais construire un composable réutilisable qui affiche les données qu'on lui passe, et rien d'autre.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-10-composant-card` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-10-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 09 (branche `td-09-version-catalog-solution`).
La solution est sur la branche `td-10-composant-card-solution`.
Prérequis : la dernière version stable d'Android Studio, avec la plateforme Android API 37 installée (Tools > SDK Manager > SDK Platforms).

## Étapes

1. Ouvrir `Character.kt` et `FakeCharacters.kt` : lire les champs d'un personnage, tels que l'API les renvoie.
2. Choisir les données à montrer sur la Card : le numéro, le nom et l'espèce.
3. Dans `CharacterCard.kt`, remplacer le stub : le composable reçoit un `Character` et un `modifier`, rien d'autre.
4. Poser la mise en page avec `Card`, `Row` et `Column`.
5. Ajouter une `@Preview` privée alimentée par `fakeCharacters.first()`.
6. Dans `MainActivity.kt`, afficher la Card à la place du `Greeting`, puis lancer l'app.
7. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 10"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-10-mon-travail`.

## Critères de réussite

- [ ] La Card ne charge rien elle-même : tout vient de ses paramètres — `CRIT-DMA-D1-SE-3-M3` composants au bon endroit.
- [ ] La Card est une brique réutilisable avec sa propre preview — `CRIT-DMA-D1-SE-3-M4` composables découpés en LEGO.
- [ ] La Card n'a qu'un rôle : afficher un personnage — `CRIT-DMA-D1-SF-3-M5` chaque composant a un rôle.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Afficher le statut du personnage avec une couleur de texte différente selon sa valeur.
- Passer deux Cards dans une `Column` pour vérifier que le composant se réutilise tel quel.

## Avec le tuteur

Facultatif. Colle le contenu du fichier `SKILL.md` du tuteur (lien ci-dessous) au début d'une conversation avec l'assistant de ton choix, puis écris « séance tuteur, slide S-10 ». Reprends avec `resume from:` et `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
