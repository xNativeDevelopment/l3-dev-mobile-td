# TD 15 — Le bon moment

Slide : S-15 — Utiliser le cycle de vie à dessein et le commenter · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-15-cycle-de-vie
État du build : départ construit · solution construite

## Objectif

À la fin, je sais placer un traitement au bon moment du cycle de vie (Activity ou Compose) et le justifier par un commentaire.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-15-cycle-de-vie` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-15-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 14 (branche `td-14-packages-lint-solution`) et y ajoute un battement (`Heartbeat`) lancé dans `onCreate` de `MainActivity`, que personne n'arrête.
La solution est sur la branche `td-15-cycle-de-vie-solution`.

## Étapes

1. Lance l'app, ouvre Logcat avec le filtre `Heartbeat`, puis fais pivoter l'écran trois fois : les « tick » s'accélèrent, car chaque rotation relance un battement sans arrêter l'ancien.
2. Repère dans la documentation les états de l'Activity : à quel moment l'écran est-il visible, et à quel moment ne l'est-il plus ?
3. Garde le `Heartbeat` dans un champ de `MainActivity`, démarre-le dans `onStart` et arrête-le dans `onStop`.
4. Écris au-dessus un commentaire qui dit pourquoi ces deux moments, et pas `onCreate`.
5. Relance le test de rotation : un seul « tick » par seconde, et plus aucun quand l'app passe en arrière-plan.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 15"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-15-mon-travail`.

## Critères de réussite

- [ ] Le battement démarre et s'arrête avec la visibilité de l'écran, pas à la création — `CRIT-DMA-D1-SF-1-M5` cycle de vie judicieux, commenté.
- [ ] Un commentaire explique le choix des moments.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Faire la même chose dans un composable avec `DisposableEffect`, et comparer ce qui se passe quand l'app passe en arrière-plan.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-15 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
