# TD 09 — Catalogue de versions

Slide : S-09 — Centraliser les versions dans le version catalog · Dépôt : https://github.com/<COMPTE>/td-09-version-catalog
État du build : starter construit le 2026-11-15 · solution construite le 2026-11-15 · lint non exécuté

## Objectif

À la fin, je sais déclarer chaque dépendance dans `libs.versions.toml` avec un nom parlant et une version lisible.

## Point de départ

Ce dépôt contient l'état final du TD 08.
Ouvrir ce dossier dans Android Studio (pas son dossier parent), attendre la synchronisation Gradle, puis Run.

## Étapes

1. Ouvrir `gradle/libs.versions.toml` et repérer ses trois blocs : `[versions]`, `[libraries]`, `[plugins]`.
2. Chercher dans `app/build.gradle.kts` la dépendance qui porte encore sa version en dur : `material3`.
3. Dans `[versions]`, ajouter `material3 = "1.4.0"`, puis une ligne dans `[libraries]` avec l'alias `androidx-compose-material3`.
4. Appeler `libs.androidx.compose.material3` à la place du texte en dur, puis synchroniser.
5. Vérifier qu'une seule clé `compose` porte la version de `ui`, `ui-tooling` et `ui-tooling-preview`, et commenter chaque clé de `[versions]`.

## Critères de réussite

- [ ] Chaque dépendance du catalogue porte un alias parlant et une version nommée — `CRIT-DMA-D1-SE-1-M3` versions des dépendances identifiables, bien nommées.
- [ ] Aucune version ne reste en dur dans `app/build.gradle.kts` — `CRIT-DMA-D1-SF-1-M3` versions centralisées.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Lire la page sur le Compose BOM et dire en une phrase ce qu'il change par rapport à la clé `compose`.
- Ajouter un bloc `[bundles]` pour regrouper les dépendances de preview.

## Avec le tuteur

Facultatif. Ouvre une séance avec `tuteur-android` sur la sous-compétence S-09
(« séance tuteur, slide S-09 ») ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/<COMPTE>/td-04-tuteur-android/tree/main/tuteur-android
Sans agent : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Aucun contenu tiers.
