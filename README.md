# TD 13 — Premier module Koin

Slide : S-13 — Injecter ses dépendances avec Koin : `single` et `factory` · Dépôt : https://github.com/<COMPTE>/td-13-koin
État du build : starter construit le 2026-11-15 · solution construite le 2026-11-15

## Objectif

À la fin, je sais déclarer un module Koin, le démarrer dans `Application` et choisir entre `single` et `factory` selon la durée de vie voulue.

## Point de départ

Ce dépôt contient l'état final du TD 12 : l'`Application` construit encore le fournisseur de personnages à la main, sans Koin.
Ouvrir ce dossier dans Android Studio (pas son dossier parent), attendre la synchronisation Gradle, puis Run.

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

Facultatif. Ouvre une séance avec `tuteur-android` sur la sous-compétence S-13
(« séance tuteur, slide S-13 ») ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/<COMPTE>/td-04-tuteur-android/tree/main/tuteur-android
Sans agent : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
