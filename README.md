# TD 20 — Deux écrans, une back stack

Slide : S-20 — Mettre en place la navigation avec Navigation 3 · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-20-navigation-3
État du build : départ à vérifier · solution à vérifier

## Objectif

À la fin, je sais déclarer des clés de navigation, une back stack et un `NavDisplay` qui affiche l'écran du sommet.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-20-navigation-3` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-20-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 19 (branche `td-19-ecran-solution`) : l'écran de liste existe, et un détail vide (`ui/CharacterDetailScreen.kt`) attend d'être relié.
La solution est sur la branche `td-20-navigation-3-solution`.

## Étapes

1. Dans `gradle/libs.versions.toml`, déclare `navigation3-runtime` et `navigation3-ui` (1.1.7), `kotlinx-serialization-json` (1.11.0) et le plugin `kotlin-serialization` (version de Kotlin). Applique-les dans `app/build.gradle.kts`, puis synchronise.
2. Crée `navigation/Keys.kt` : `ListKey` et `DetailKey`, des `data object` `@Serializable` qui implémentent `NavKey`.
3. Crée `navigation/AppNavigation.kt` : une back stack avec `rememberNavBackStack(ListKey)`, puis un `NavDisplay` dont l'`entryProvider` affiche l'écran de chaque clé avec `entry<…>`. Le paramètre `onBack` retire le dernier élément.
4. Donne la back stack à l'écran de liste (version simple, le TD 22 la rangera) : un bouton ajoute `DetailKey`. Dans le détail, « Retour » retire le dernier élément.
5. Dans `MainActivity`, remplace l'écran de liste par `AppNavigation`. Ouvre le détail, puis retour système : tu reviens à la liste.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 20"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-20-mon-travail`.

## Critères de réussite

- [ ] Deux clés `@Serializable`, une back stack et un `NavDisplay` relient la liste au détail — `CRIT-DMA-D1-SF-3-M2` navigation par un Navigator (première étape : la back stack).
- [ ] Le retour système revient à la liste, et l'app se ferme depuis la liste.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Retirer le plugin `kotlin-serialization`, relancer, noter ce qui se passe, puis le remettre : tu reconnaîtras la panne.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-20 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
