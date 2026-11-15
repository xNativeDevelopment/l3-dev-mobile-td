# TD 05 — Kotlin en console

Slide : S-05 — Écrire ses premières classes et fonctions Kotlin · Dépôt : https://github.com/<COMPTE>/td-05-kotlin-bases
État du build : starter construit le 2026-11-15 · solution construite le 2026-11-15

## Objectif

À la fin, je sais écrire `val`/`var`, une fonction, une `data class` et une `when` en Kotlin.

## Point de départ

Un projet console fourni : `src/main/kotlin/Main.kt` ne contient que des commentaires `TODO`.
Ouvrir ce dossier dans Android Studio (pas son dossier parent), attendre la synchronisation Gradle, puis lancer `main`. En ligne de commande : `./gradlew run`.

## Étapes

1. Déclarer l'`enum class Status` (`ALIVE`, `DEAD`, `UNKNOWN`) et la `data class Character` (identifiant, nom, statut). Tout en `val`.
2. Écrire `describe` et `isAlive` sous forme de fonctions à expression.
3. Écrire `statusLabel` avec un `when` exhaustif sur `Status`, sans branche `else`.
4. Dans `main`, créer deux personnages avec `val` et afficher le résultat des trois fonctions. Note d'abord la sortie que tu attends.
5. Lancer `./gradlew run` : la sortie correspond à ce que tu avais prévu.

## Critères de réussite

- [ ] `Character` est une `data class` dont toutes les propriétés sont des `val`.
- [ ] `statusLabel` utilise un `when` sans `else` : ajouter une valeur à `Status` casse la compilation.
- [ ] Aucun `var` dans le fichier.
- [ ] Le projet se construit (`./gradlew build`) sans erreur.

## Pour aller plus loin

- Afficher un personnage directement avec `println(character)` et observer le `toString` généré.
- Copier un personnage avec `copy(status = Status.DEAD)`.

## Avec le tuteur

Facultatif. Ouvre une séance avec `tuteur-android` sur la sous-compétence S-05
(« séance tuteur, slide S-05 ») ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/<COMPTE>/td-04-tuteur-android/tree/main/tuteur-android
Sans agent : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Aucun contenu tiers.
