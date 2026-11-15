# TD 06 — Lambdas et nulls

Slide : S-06 — Manier lambdas et nullabilité, comme Compose les emploie · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-06-kotlin-lambdas
État du build : départ construit le 2026-11-15 · solution construite le 2026-11-15

## Objectif

À la fin, je sais passer une lambda en paramètre et traiter une valeur nullable sans `!!`.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-06-kotlin-lambdas` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-06-mon-travail`.
Cette branche reprend l'état final du TD 05 (branche `td-05-kotlin-bases-solution`), plus un modèle `CharacterDetail` aux champs nullables et des commentaires `TODO` dans `Main.kt`.
Ouvrir le dépôt dans Android Studio et synchroniser Gradle quand il le propose : c'est un projet console, sans émulateur. Lancer `main` avec la flèche verte dans la marge de `Main.kt`. En ligne de commande : `./gradlew run`.
La solution est sur la branche `td-06-kotlin-lambdas-solution`.

## Étapes

1. Écrire `forEachCharacter` : elle reçoit la liste et une lambda `(Character) -> Unit`, placée en dernier paramètre.
2. Dans `main`, remplacer la boucle par `forEachCharacter(liste) { … }` : la lambda est écrite hors des parenthèses.
3. Écrire `originLabel` avec `?.` et `?:` : une origine absente donne « origine inconnue ».
4. Écrire `episodesLabel` avec `?:` : un nombre d'épisodes absent vaut 0.
5. Afficher un détail complet et un détail dont les champs valent `null` : le programme ne plante pas.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 06"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-06-mon-travail`.

## Critères de réussite

- [ ] Une fonction reçoit un callback de type `(Character) -> Unit` en dernier paramètre.
- [ ] Les champs nullables sont traités avec `?.` et `?:`, sans aucun `!!`.
- [ ] Le détail aux champs `null` s'affiche sans exception.
- [ ] Le projet se construit (`./gradlew build`) sans erreur.

## Pour aller plus loin

- Écrire la même fonction avec `let` sur la valeur nullable et comparer la lisibilité.
- Passer une référence de fonction (`::describe`) à la place de la lambda.

## Avec le tuteur

Facultatif. Colle le contenu du fichier `SKILL.md` du tuteur (lien ci-dessous) au début d'une conversation avec l'assistant de ton choix, puis écris « séance tuteur, slide S-06 ». Reprends avec `resume from:` et `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Aucun contenu tiers.
