# TD 08 — Gradle lisible

Slide : S-08 — Structurer le build Gradle en sections commentées · Dépôt : https://github.com/<COMPTE>/td-08-gradle
État du build : starter à vérifier · solution à vérifier

## Objectif

À la fin, je sais lire mon `build.gradle.kts`, le découper en sections commentées et le garder sans warning.

## Point de départ

Ce dépôt contient l'état final du TD 07.
Ouvrir ce dossier dans Android Studio (pas son dossier parent), attendre la synchronisation Gradle, puis Run.

## Étapes

1. Ouvrir `app/build.gradle.kts` : repérer les trois blocs `plugins`, `android` et `dependencies`, aujourd'hui dans le désordre.
2. Les remettre dans cet ordre : plugins, android, dependencies.
3. Placer au-dessus de chaque bloc un commentaire de section, par exemple `// ===== Plugins =====`.
4. Dans `dependencies`, regrouper les lignes par rôle et commenter chaque groupe. La ligne de `material3` garde sa version en dur : le TD 09 la déplace.
5. Lancer Sync Project with Gradle Files : aucun warning dans la sortie.

## Critères de réussite

- [ ] Le fichier suit l'ordre plugins, android, dependencies, chaque section est commentée — `CRIT-DMA-D1-SE-1-M2` Gradle sans warning, sections commentées.
- [ ] La synchronisation Gradle ne signale aucun warning — `CRIT-DMA-D1-SF-1-M2` Gradle lisible, sans warning.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Lire la page sur la configuration du build Android et noter un bloc que tu ne connaissais pas.
- Expliquer, dans un commentaire, le rôle du plugin `kotlin.compose`.

## Avec le tuteur

Facultatif. Ouvre une séance avec `tuteur-android` sur la sous-compétence S-08
(« séance tuteur, slide S-08 ») ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/<COMPTE>/td-04-tuteur-android/tree/main/tuteur-android
Sans agent : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Aucun contenu tiers.
