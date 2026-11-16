# TD 31 — Le service réseau

Slide : S-31 — Appeler une API par un service Ktor derrière le repository · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-31-service-ktor
État du build : départ construit · solution construite

## Objectif

À la fin, je sais déclarer un `HttpClient` Ktor dans un service de la couche données et l'appeler depuis le repository.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-31-service-ktor` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-31-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 30 (`td-30-repository-solution`) : données en mémoire, sans réseau.
La solution est sur la branche `td-31-service-ktor-solution`.

## Étapes

1. Dans `gradle/libs.versions.toml`, déclare la version `ktor = "3.6.0"`, `io.ktor:ktor-client-core` et `io.ktor:ktor-client-android` ; ajoute-les dans `app/build.gradle.kts`.
2. Dans `AndroidManifest.xml`, ajoute la permission `INTERNET`, sans laquelle toute requête échoue.
3. Dans `data`, écris `CharacterService` : une fonction `suspend` par endpoint, `fetchPage(page)` pour `https://rickandmortyapi.com/api/character?page=N` et `fetchCharacter(id)` pour `https://rickandmortyapi.com/api/character/{id}`. Chacune rend la réponse brute avec `bodyAsText()`.
4. Dans `AppModule`, fournis `HttpClient(Android)` (import `io.ktor.client.engine.android.Android`) et `CharacterService` avec `single`.
5. Ajoute `getRawPage()` et `getRawCharacter(id)` à `CharacterRepository` ; `FakeCharacterRepository` rend un texte fixe. Écris `ApiCharacterRepository(service, local) : CharacterRepository by local`, qui appelle le service et délègue le reste ; lie-le dans `AppModule` avec `FakeCharacterRepository()` en `local`.
6. Les ViewModels lisent ces textes dans un `try` ; `catch (e: IOException)` (import `java.io.IOException`) donne un message. L'état les garde, les écrans les affichent.
7. Lance l'app : le texte JSON s'affiche. Coupe le réseau.
8. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 31"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-31-mon-travail`.

## Critères de réussite

- [ ] Seul `CharacterService` connaît Ktor ; les ViewModels passent par `CharacterRepository` — `CRIT-DMA-D1-SF-2-M3` accès aux données dans sa couche.
- [ ] La permission `INTERNET` est dans le Manifest et le client vient de Koin.
- [ ] Réseau coupé, un message remplace le texte.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajoute un paramètre de page à `getRawPage` et lis la page 2.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-31 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
