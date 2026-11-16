# TD 32 — Du JSON au domaine

Slide : S-32 — Décoder la réponse JSON en DTO et la convertir en domaine · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-32-json-dto
État du build : départ construit · solution construite

## Objectif

À la fin, je sais décoder un JSON en DTO `@Serializable` et le convertir en modèle de domaine dans la couche données.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-32-json-dto` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-32-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 31 (branche `td-31-service-ktor-solution`) : le service rend le texte brut de l'API et les écrans l'affichent tel quel.
La solution est sur la branche `td-32-json-dto-solution`.

## Étapes

1. Vérifie que le plugin `kotlin-serialization` et `kotlinx-serialization-json` sont déjà dans le catalogue. Ajoute `ktor-client-content-negotiation` et `ktor-serialization-kotlinx-json` (version `ktor`), puis dans `app/build.gradle.kts`.
2. Dans `data`, marque `CharacterDto` avec `@Serializable`. Écris `CharactersPageDto` : `info` (`count`, `pages`, `next` et `prev` nullables) et `results`. Garde `toDomain()`.
3. Dans `AppModule`, configure `HttpClient(Android)` : `install(ContentNegotiation)` avec `json(Json { ignoreUnknownKeys = true })`, et `expectSuccess = true`.
4. `CharacterService` rend maintenant des DTO avec `body()`, plus du texte.
5. Remplace le texte brut dans le repository : retire `getRawPage` et `getRawCharacter`, supprime `FakeCharacterRepository`. `ApiCharacterRepository` appelle le service puis `toDomain()` ; un personnage inconnu (erreur 404, `catch (e: ClientRequestException)`) donne `null`.
6. Dans les ViewModels et les écrans, retire le texte brut et affiche un message si le réseau manque. Lance l'app : les vrais personnages s'affichent.
7. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 32"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-32-mon-travail`.

## Critères de réussite

- [ ] Aucune classe de DTO n'apparaît hors du paquet `data` — `CRIT-DMA-D1-SF-2-M3` accès aux données dans sa couche.
- [ ] Un champ inconnu dans le JSON ne fait pas planter le décodage.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajoute un champ `gender` au DTO et au domaine, avec une valeur par défaut.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-32 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
