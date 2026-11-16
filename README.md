# TD 24 — Screen et ViewModel

Slide : S-24 — Brancher un écran sur son ViewModel avec un UiState · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-24-screen-viewmodel
État du build : départ construit · solution construite

## Objectif

À la fin, je sais exposer un `StateFlow<UiState>` en lecture seule et l'observer depuis la Screen.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-24-screen-viewmodel` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-24-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 23 (`td-23-coroutines-solution`) : l'écran de liste reçoit de `AppNavigation` les personnages du catalogue ; le ViewModel du TD 23 ne sert qu'à un bouton de démonstration.
La solution est sur la branche `td-24-screen-viewmodel-solution`.

## Étapes

1. Ajoute `io.insert-koin:koin-compose-viewmodel` (clé `koin`) et `androidx.lifecycle:lifecycle-runtime-compose` (clé `lifecycle`) à `gradle/libs.versions.toml`, puis à `app/build.gradle.kts`.
2. Écris `CharacterListUiState` : une `data class` avec la liste des personnages et un booléen `isLoading`.
3. Écris `CharacterListViewModel`, qui reçoit le `CharacterCatalog` par son constructeur. Il garde un `MutableStateFlow` privé et n'expose qu'un `StateFlow` (`asStateFlow()`). Au démarrage il charge les personnages dans `viewModelScope` et remplace l'état avec `update { it.copy(…) }`. Garde l'attente simulée de 2 s du TD 23.
4. Déclare-le dans `appModule` avec `viewModel { … }` (import `org.koin.core.module.dsl.viewModel`).
5. Dans `CharacterListScreen`, obtiens le ViewModel avec `koinViewModel()` (import `org.koin.compose.viewmodel.koinViewModel`) et observe son état avec `collectAsStateWithLifecycle()`. Le Content n'affiche que l'état reçu ; `AppNavigation` ne passe plus la liste.
6. Supprime `LoadViewModel` et l'import `androidx.lifecycle.viewmodel.compose.viewModel`, puis lance l'app : un cercle, puis la liste.
7. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 24"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-24-mon-travail`.

## Critères de réussite

- [ ] La Screen observe l'état du ViewModel avec `collectAsStateWithLifecycle` — `CRIT-DMA-D1-SF-3-M4` Screen.kt – ViewModel.kt + UiState.
- [ ] Le `MutableStateFlow` reste privé et l'état est remplacé avec `copy`, jamais modifié — `CRIT-DMA-D1-SE-3-M6` State bien formé.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajoute un champ `errorMessage: String?` à l'état et affiche-le quand il n'est pas nul.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-24 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
