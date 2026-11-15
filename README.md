# TD 09 — Catalogue de versions

Slide : S-09 — Centraliser les versions dans le version catalog · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-09-version-catalog
État du build : départ construit le 2026-11-15 · solution construite le 2026-11-15

## Objectif

À la fin, je sais déclarer chaque dépendance dans `libs.versions.toml` avec un nom parlant et une version lisible.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-09-version-catalog` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-09-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 08 (branche `td-08-gradle-solution`).
La solution est sur la branche `td-09-version-catalog-solution`.
Prérequis : la dernière version stable d'Android Studio, avec la plateforme Android API 37 installée (Tools > SDK Manager > SDK Platforms).

## Étapes

1. Ouvrir `gradle/libs.versions.toml` et repérer ses trois blocs : `[versions]`, `[libraries]`, `[plugins]`.
2. Chercher dans `app/build.gradle.kts` la dépendance qui porte encore sa version en dur : `material3`.
3. Dans `[versions]`, ajouter `material3 = "1.4.0"`, puis une ligne dans `[libraries]` avec l'alias `androidx-compose-material3`.
4. Appeler `libs.androidx.compose.material3` à la place du texte en dur, puis synchroniser.
5. Vérifier qu'une seule clé `compose` porte la version de `ui`, `ui-tooling` et `ui-tooling-preview`, et commenter les clés `compose` et `material3`.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 09"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-09-mon-travail`.

## Critères de réussite

- [ ] Chaque dépendance du catalogue porte un alias parlant et une version nommée — `CRIT-DMA-D1-SE-1-M3` versions des dépendances identifiables, bien nommées.
- [ ] Aucune version ne reste en dur dans `app/build.gradle.kts` — `CRIT-DMA-D1-SF-1-M3` versions centralisées.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Lire la page sur le Compose BOM et dire en une phrase ce qu'il change par rapport à la clé `compose`.
- Ajouter un bloc `[bundles]` pour regrouper les dépendances de preview.

## Avec le tuteur

Facultatif. Colle tout le contenu du fichier `SKILL.md` du tuteur (lien ci-dessous) au début d'une conversation avec l'assistant de ton choix, puis écris « séance tuteur, slide S-09 ». Reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`. Si ton assistant sait charger des skills, tu peux plutôt installer le dossier `tuteur-android/`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Aucun contenu tiers.
