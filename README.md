# TD 04 — Réparer avec le tuteur

Slide : S-04 — Installer et utiliser le tuteur `tuteur-android` · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android
État du build : départ construit le 2026-11-15 · solution construite le 2026-11-15

## Objectif

À la fin, je sais lancer une séance avec le tuteur, travailler une sous-compétence d'une slide et sauvegarder mon état.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-04-tuteur-android` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-04-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Un projet fourni : l'application de base avec un compteur qui repart à zéro quand l'écran tourne.
La solution est sur la branche `td-04-tuteur-android-solution`.
Prérequis : la dernière version stable d'Android Studio, avec la plateforme Android API 37 installée (Tools > SDK Manager > SDK Platforms).

## Étapes

1. Dans `JOURNAL.md`, écris ta prédiction : que devient le compteur après une rotation de l'émulateur, et pourquoi ?
2. Lance l'app, monte le compteur à 3, tourne l'émulateur, puis note dans `JOURNAL.md` ce que tu observes.
3. Dans une conversation avec l'assistant de ton choix, colle tout le contenu de `tuteur-android/SKILL.md`. Option : si ton assistant charge des skills, copie plutôt le dossier `tuteur-android/`.
4. Ouvre une séance (« séance tuteur, slide S-04 ») sur la sous-compétence « l'état d'un composable face à la rotation ». Le tuteur ne t'écrit pas le code.
5. Corrige toi-même `Counter.kt`, relance, tourne l'émulateur, puis commite ta correction.
6. Dis `save state`, colle le bloc dans `TUTOR-STATE.md`, commite : le nombre de `just tell me` doit y être lisible.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-04-mon-travail`.

## Critères de réussite

- [ ] Le compteur garde sa valeur après une rotation, grâce à ta correction écrite à la main.
- [ ] `JOURNAL.md` contient une prédiction écrite avant la séance.
- [ ] `TUTOR-STATE.md` est commité, avec le nombre de `just tell me`.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Fais la même séance sur une autre slide déjà vue, avec `harder`.

## Avec le tuteur

Exigé dans ce TD. Colle tout le contenu du fichier `SKILL.md` du tuteur (lien ci-dessous) au début d'une conversation avec l'assistant de ton choix, puis écris « séance tuteur, slide S-04 ». Reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Le tuteur s'inspire de `socratic-tutor` (Jane Street), sous licence MIT : voir `NOTICE-socratic-tutor.md`.
