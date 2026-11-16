# TD 22 — Mon Navigator

Slide : S-22 — Centraliser la navigation dans un Navigator commenté · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-22-navigator
État du build : départ construit · solution construite

## Objectif

À la fin, je sais isoler la back stack derrière un Navigator dont les écrans n'appellent que des intentions (`goToDetail`, `back`).

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-22-navigator` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-22-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 21 (branche `td-21-argument-type-solution`) : la navigation marche, mais l'écran de liste reçoit la back stack et la modifie lui-même.
La solution est sur la branche `td-22-navigator-solution`.

## Étapes

1. Crée `navigation/Navigator.kt` : une interface `Navigator` avec `goToDetail(id: Int)` et `back()`. Écris son KDoc : à quoi sert-elle, qui l'appelle.
2. Dans le même dossier, écris `BackStackNavigator`, qui **possède** la back stack (`mutableStateListOf<NavKey>(ListKey)`) et implémente `Navigator`. Commente la classe : ce qu'elle garde, ce qu'elle cache.
3. Déclare-la dans `appModule` : un `single` pour `BackStackNavigator`, et le même objet fourni sous le type `Navigator`.
4. Change les écrans : `CharacterListScreen` et `CharacterDetailScreen` reçoivent un `Navigator`, appellent `goToDetail` et `back`, et n'importent plus rien de `NavBackStack`.
5. `AppNavigation` affiche `navigator.backStack` et branche `onBack` sur `back()`. `MainActivity` récupère le navigateur avec `by inject()`.
6. Vérifie : cherche `NavBackStack` dans le dossier `ui`, il ne doit plus y en avoir. L'app navigue comme avant.
7. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 22"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-22-mon-travail`.

## Critères de réussite

- [ ] Aucun écran ne touche la back stack : ils n'appellent que `goToDetail` et `back` — `CRIT-DMA-D1-SF-3-M2` navigation par un Navigator.
- [ ] Le Navigator est fourni par Koin et son KDoc dit son rôle — `CRIT-DMA-D1-SE-3-M1` Navigator clairement commenté.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajouter une intention `goToSettings()` au Navigator avec une troisième clé, sans modifier aucun écran existant.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-22 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
