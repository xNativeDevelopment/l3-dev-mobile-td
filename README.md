# TD 27 — Le détail pense seul

Slide : S-27 — Donner au détail son ViewModel sans le lier à l'entrée de navigation · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-27-viewmodel-detail
État du build : départ construit · solution construite

## Objectif

À la fin, je sais obtenir le ViewModel de l'écran de détail par Koin, avec l'identifiant en paramètre, sans module d'extension alpha.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-27-viewmodel-detail` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-27-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 26 (branche `td-26-liste-solution`). Le détail n'a pas de ViewModel : `AppNavigation` cherche le personnage et le passe à l'écran.
La solution est sur la branche `td-27-viewmodel-detail-solution`.

## Étapes

1. Écris `CharacterDetailUiState` (le personnage, ou `null` s'il est introuvable) et `CharacterDetailUiAction` avec `OnBackClicked`.
2. Écris `CharacterDetailViewModel(id, catalog, navigator)` : il lit le personnage dans le catalogue, expose un `StateFlow`, et `onAction` appelle `navigator.back()`.
3. Déclare-le dans `appModule` : `viewModel { params -> CharacterDetailViewModel(params.get(), get(), get()) }`.
4. Dans `CharacterDetailScreen`, remplace `character` et `navigator` par `id` et obtiens le ViewModel par `koinViewModel(key = "detail-$id") { parametersOf(id) }`. Piège : ce ViewModel reste dans le magasin de l'Activity jusqu'à la fin de l'Activity ; la clé sépare les instances, elle ne les libère pas.
5. Dans `AppNavigation`, appelle `CharacterDetailScreen(id = key.id)` et retire `catalog` des paramètres (et de `MainActivity`). Lance l'app : le détail et le retour fonctionnent.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 27"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-27-mon-travail`.

## Critères de réussite

- [ ] Le détail a son propre ViewModel, obtenu avec l'identifiant en paramètre, et son `UiState` — `CRIT-DMA-D1-SF-3-M4` Screen.kt – ViewModel.kt + UiState.
- [ ] Le détail et la liste ne partagent pas leur ViewModel.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajoute un bouton « Personnage suivant » qui ouvre le détail de `id + 1` : deux détails empilés ont chacun leur ViewModel.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-27 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
