# TD 04 — Réparer avec le tuteur

Slide : S-04 — Installer et utiliser le tuteur `tuteur-android` · Dépôt : https://github.com/<COMPTE>/td-04-tuteur-android
État du build : starter non construit : artefact absent hors ligne (androidx.savedstate:savedstate-android:1.3.2 et 6 autres, voir le journal de build) · solution non construit : artefact absent hors ligne (androidx.savedstate:savedstate-android:1.3.2 et 6 autres, voir le journal de build) · lint non exécuté

## Objectif

À la fin, je sais lancer une séance avec le tuteur, travailler une sous-compétence d'une slide et sauvegarder mon état.

## Point de départ

Un projet fourni : l'application de base avec un compteur qui repart à zéro quand l'écran tourne.
Ouvrir ce dossier dans Android Studio (pas son dossier parent), attendre la synchronisation Gradle, puis Run.

## Étapes

1. Dans `JOURNAL.md`, écris ta prédiction : que devient le compteur après une rotation de l'émulateur, et pourquoi ?
2. Lance l'app, monte le compteur à 3, tourne l'émulateur, puis note dans `JOURNAL.md` ce que tu observes.
3. Installe le tuteur : agent, copie le dossier `tuteur-android/` dans ton dossier de skills ; chatbot, colle le fichier `tuteur-android/SKILL.md` en début de conversation.
4. Ouvre une séance (« séance tuteur, slide S-04 ») sur la sous-compétence « l'état d'un composable face à la rotation ». Le tuteur ne t'écrit pas le code.
5. Corrige toi-même `Counter.kt`, relance, tourne l'émulateur, puis commite ta correction.
6. Dis `save state`, colle le bloc dans `TUTOR-STATE.md`, commite : le nombre de `just tell me` doit y être lisible.

## Critères de réussite

- [ ] Le compteur garde sa valeur après une rotation, grâce à ta correction écrite à la main.
- [ ] `JOURNAL.md` contient une prédiction écrite avant la séance.
- [ ] `TUTOR-STATE.md` est commité, avec le nombre de `just tell me`.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Fais la même séance sur une autre slide déjà vue, avec `harder`.
- Reprends ta séance un autre jour avec `resume from:` et ton `TUTOR-STATE.md`.

## Avec le tuteur

Exigé dans ce TD. Ouvre une séance avec `tuteur-android` sur la sous-compétence S-04
(« séance tuteur, slide S-04 ») ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/<COMPTE>/td-04-tuteur-android/tree/main/tuteur-android
Sans agent : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Le tuteur s'inspire de `socratic-tutor` (Jane Street), sous licence MIT : voir `NOTICE-socratic-tutor.md`.
