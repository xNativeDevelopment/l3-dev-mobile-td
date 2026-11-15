# TD 03 — Journal d'apprentissage

Slide : S-03 — Apprendre avec une IA : la routine en quatre temps · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-03-routine-ia
État du build : départ sans projet Gradle · solution sans projet Gradle

## Objectif

À la fin, je sais prédire, exécuter, expliquer l'écart, puis demander à l'IA une question plutôt qu'une réponse, avec n'importe quel assistant.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-03-routine-ia` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-03-mon-travail`.
Un extrait de code fourni, écrit par une IA : `extrait/CharacterStats.kt`. Cette branche ne contient aucun projet Gradle : ouvre le dossier dans l'éditeur de ton choix, rien à compiler.
La solution est sur la branche `td-03-routine-ia-solution`.

## Étapes

1. Dans `JOURNAL.md`, écris ta prédiction : que renvoie `averageEpisodes` pour deux personnages, 3 et 2 épisodes ?
2. Exécute le raisonnement à la main, puis note le résultat.
3. Écris ton hypothèse sur l'écart.
4. Copie `invite-courte.md` dans l'assistant de ton choix, sans rien modifier, puis donne-lui ces trois éléments : note la question qu'il te pose, sans lui demander le code.
5. Annote l'extrait par des commentaires dans `extrait/CharacterStats.kt` : trois points vérifiés, un point faux ou injustifié, avec ta justification.
6. Après l'étape 5, lis le corrigé sans changer de branche : `git show td-03-routine-ia-solution:CORRIGE.md` (après un clone : `origin/td-03-routine-ia-solution:CORRIGE.md`).
7. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 03"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-03-mon-travail`.

## Critères de réussite

- [ ] `JOURNAL.md` contient une prédiction écrite avant l'ouverture de l'assistant.
- [ ] `JOURNAL.md` contient la question posée par l'IA et ton correctif écrit à la main.
- [ ] Les quatre points de l'extrait sont annotés : trois vérifiés, un faux justifié.

## Pour aller plus loin

- Refais la routine sur un message d'erreur de ton propre projet.
- Demande à l'assistant de te contredire, puis vérifie son argument toi-même.

## Avec le tuteur

Facultatif. Le tuteur `tuteur-android` est une invite plus longue : colle tout le contenu de son fichier `SKILL.md` (lien ci-dessous) au début d'une conversation avec l'assistant de ton choix, puis écris « séance tuteur, slide S-03 ». Reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`. Si ton assistant sait charger des skills, tu peux plutôt installer le dossier `tuteur-android/`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte de ce dépôt.

## Crédits

L'invite s'inspire de `socratic-tutor` (Jane Street), sous licence MIT : voir `NOTICE-socratic-tutor.md`.
