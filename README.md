# TD 06 — Lambdas et nulls

Slide : S-06 — Manier lambdas et nullabilité, comme Compose les emploie · Dépôt : https://github.com/<COMPTE>/td-06-kotlin-lambdas
État du build : starter à vérifier · solution à vérifier

## Objectif

À la fin, je sais passer une lambda en paramètre et traiter une valeur nullable sans `!!`.

## Point de départ

Ce dépôt contient l'état final du TD 05, plus un modèle `CharacterDetail` aux champs nullables et des commentaires `TODO` dans `Main.kt`.
Ouvrir ce dossier dans Android Studio (pas son dossier parent), attendre la synchronisation Gradle, puis lancer `main`. En ligne de commande : `./gradlew run`.

## Étapes

1. Écrire `forEachCharacter` : elle reçoit la liste et une lambda `(Character) -> Unit`, placée en dernier paramètre.
2. Dans `main`, remplacer la boucle par `forEachCharacter(liste) { … }` : la lambda est écrite hors des parenthèses.
3. Écrire `originLabel` avec `?.` et `?:` : une origine absente donne « origine inconnue ».
4. Écrire `episodesLabel` avec `?:` : un nombre d'épisodes absent vaut 0.
5. Afficher un détail complet et un détail dont les champs valent `null` : le programme ne plante pas.

## Critères de réussite

- [ ] Une fonction reçoit un callback de type `(Character) -> Unit` en dernier paramètre.
- [ ] Les champs nullables sont traités avec `?.` et `?:`, sans aucun `!!`.
- [ ] Le détail aux champs `null` s'affiche sans exception.
- [ ] Le projet se construit (`./gradlew build`) sans erreur.

## Pour aller plus loin

- Écrire la même fonction avec `let` sur la valeur nullable et comparer la lisibilité.
- Passer une référence de fonction (`::describe`) à la place de la lambda.

## Avec le tuteur

Facultatif. Ouvre une séance avec `tuteur-android` sur la sous-compétence S-06
(« séance tuteur, slide S-06 ») ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/<COMPTE>/td-04-tuteur-android/tree/main/tuteur-android
Sans agent : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Aucun contenu tiers.
