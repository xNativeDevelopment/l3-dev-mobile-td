# TD 13 — Premier module Koin

Slide : S-13 — Injecter ses dépendances avec Koin : `single` et `factory` · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-13-koin
État du build : départ construit le 2026-11-15 · solution construite le 2026-11-15

## Objectif

À la fin, je sais déclarer un module Koin, le démarrer dans `Application` et choisir entre `single` et `factory` selon la durée de vie voulue.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-13-koin` (pas de nouveau clone). Attendre la synchronisation Gradle, puis Run.
Cette branche reprend l'état final du TD 12 (branche `td-12-lancement-single-activity-solution`) : l'`Application` construit encore le fournisseur de personnages à la main, sans Koin.
La solution est sur la branche `td-13-koin-solution`.
Prérequis : la dernière version stable d'Android Studio, avec la plateforme Android API 37 installée (Tools > SDK Manager > SDK Platforms).

## Étapes

1. Déclarer `koin-android` (version 4.2.2) dans `gradle/libs.versions.toml`, puis l'ajouter dans `app/build.gradle.kts`.
2. Écrire `CharacterCatalog` dans `domain` : une classe qui reçoit un `CharacterProvider` par son constructeur.
3. Écrire `di/AppModule.kt` : `single` pour le fournisseur, `factory` pour le catalogue, avec `get()`.
4. Dans `CatalogueApplication`, retirer la construction à la main et appeler `startKoin` avec `androidContext` et le module.
5. Dans `MainActivity`, obtenir le catalogue avec `by inject()`, puis lancer l'app.

## Critères de réussite

- [ ] Aucune classe ne construit une autre classe de la couche `data` : seul le module le fait.
- [ ] `startKoin` n'est appelé que dans `CatalogueApplication`, jamais dans l'Activity.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Remplacer `single` par `factory` pour le fournisseur et expliquer ce qui change pour qui le reçoit.
- Faire pivoter l'écran : vérifier que Koin n'est pas redémarré.

## Avec le tuteur

Facultatif. Colle tout le contenu du fichier `SKILL.md` du tuteur (lien ci-dessous) au début d'une conversation avec l'assistant de ton choix, puis écris « séance tuteur, slide S-13 ». Reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`. Si ton assistant sait charger des skills, tu peux plutôt installer le dossier `tuteur-android/`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
