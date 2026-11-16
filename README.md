# TD 23 — Chargement sans gel

Slide : S-23 — Lancer un travail hors du thread principal avec les coroutines · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-23-coroutines
État du build : départ construit · solution construite

## Objectif

À la fin, je sais lancer une coroutine dans `viewModelScope` et envoyer le travail lourd sur `Dispatchers.IO`.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-23-coroutines` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-23-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 22 (branche `td-22-navigator-solution`) et y ajoute un ViewModel minimal, `LoadViewModel`, et un bouton « Charger » sur l'écran de liste. Son chargement simulé dure 2 secondes et bloque le thread principal : appuie sur le bouton : rien ne bouge pendant 2 secondes (aucun cercle), puis « Chargé » apparaît d'un coup.
La solution est sur la branche `td-23-coroutines-solution`.

## Étapes

1. Ajoute la bibliothèque des coroutines dans `gradle/libs.versions.toml` (`kotlinx-coroutines-android`, version 1.11.0, clé `coroutines`), puis dans `app/build.gradle.kts`.
2. Dans `LoadViewModel`, lance le travail avec `viewModelScope.launch` : `load()` rend aussitôt la main.
3. Écris l'attente simulée (`Thread.sleep`) dans une fonction `suspend` (`slowCall`) qui passe sur `Dispatchers.IO` avec `withContext` ; appelle-la depuis `launch`, puis remets l'état à jour.
4. Ignore un appui sur « Charger » quand un chargement est en cours.
5. Lance l'app, appuie sur « Charger » : le cercle tourne pendant 2 secondes, puis « Chargé » apparaît. Tourne l'écran en plein chargement : le ViewModel survit à la rotation.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 23"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-23-mon-travail`.

## Critères de réussite

- [ ] Pendant le chargement de 2 secondes, le cercle tourne et l'écran reste utilisable.
- [ ] Le travail bloquant s'exécute sur `Dispatchers.IO`, lancé dans `viewModelScope`.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Remplace `Thread.sleep` par `delay(2_000)` et compare : que devient le besoin de `Dispatchers.IO` ?
- Ajoute un bouton « Annuler » qui arrête le chargement en cours.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-23 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
