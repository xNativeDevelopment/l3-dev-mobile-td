# TD 08 — Gradle lisible

Slide : S-08 — Structurer le build Gradle en sections commentées · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-08-gradle
État du build : départ construit le 2026-11-15 · solution construite le 2026-11-15 · absence de warning non vérifiée par l'enseignant (analyse Lint pas encore lancée)

## Objectif

À la fin, je sais lire mon `build.gradle.kts`, le découper en sections commentées et le garder sans warning.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-08-gradle` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-08-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 07 (branche `td-07-manifest-solution`).
La solution est sur la branche `td-08-gradle-solution`.
Prérequis : la dernière version stable d'Android Studio, avec la plateforme Android API 37 installée (Tools > SDK Manager > SDK Platforms).

## Étapes

1. Ouvrir `app/build.gradle.kts` : repérer les trois blocs `plugins`, `android` et `dependencies`, aujourd'hui dans le désordre.
2. Les remettre dans cet ordre : plugins, android, dependencies.
3. Placer au-dessus de chaque bloc un commentaire de section, par exemple `// ===== Plugins =====`.
4. Dans `dependencies`, regrouper les lignes par rôle et commenter chaque groupe. La ligne de `material3` garde sa version en dur : le TD 09 la déplace.
5. Lancer Sync Project with Gradle Files : aucun warning dans la sortie.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 08"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-08-mon-travail`.

## Critères de réussite

- [ ] Le fichier suit l'ordre plugins, android, dependencies, chaque section est commentée — `CRIT-DMA-D1-SE-1-M2` Gradle sans warning, sections commentées.
- [ ] La synchronisation Gradle ne signale aucun warning — `CRIT-DMA-D1-SF-1-M2` Gradle lisible, sans warning.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Lire la page sur la configuration du build Android et noter un bloc que tu ne connaissais pas.
- Expliquer, dans un commentaire, le rôle du plugin `kotlin.compose`.

## Avec le tuteur

Facultatif. Colle tout le contenu du fichier `SKILL.md` du tuteur (lien ci-dessous) au début d'une conversation avec l'assistant de ton choix, puis écris « séance tuteur, slide S-08 ». Reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`. Si ton assistant sait charger des skills, tu peux plutôt installer le dossier `tuteur-android/`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Aucun contenu tiers.
