# TD 29 — Trois modèles

Slide : S-29 — Modéliser le domaine à part du DTO et du UiState · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-29-domaine
État du build : départ à vérifier · solution à vérifier

## Objectif

À la fin, je sais écrire un modèle de domaine (sealed interface si besoin) distinct de ce que renvoie l'API et de ce qu'affiche l'écran.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-29-domaine` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-29-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 28 (branche `td-28-evenement-ponctuel-solution`) : une seule classe `Character` sert à la fois aux données, au métier et à l'écran.
La solution est sur la branche `td-29-domaine-solution`.

## Étapes

1. Dans `data`, écris `CharacterDto` : ce que l'API renverrait (`id`, `name`, `status`, `species`, `image`). `FakeCharacterProvider` le construit, puis `toDomain()` le convertit en `Character`.
2. Dans `ui`, écris `CharacterUiState` : ce que l'écran affiche. Ajoute `Character.toUiState()` : les ViewModels convertissent, les écrans ne voient plus que des `CharacterUiState`.
3. Dans `domain`, transforme `Character` en `sealed interface` : `Preview` pour la liste, `Details` (avec `image`) pour le détail. `toDomain()` produit un `Details`, `CharacterCatalog.all()` rend des `Preview`.
4. Dans `toUiState()`, traite les deux cas avec un `when` sans `else` : un cas oublié ne compile pas.
5. Lance l'app : la liste et le détail s'affichent comme avant.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 29"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-29-mon-travail`.

## Critères de réussite

- [ ] Aucun fichier de `domain` n'importe `data` ni `ui` — `CRIT-DMA-D1-SF-2-M4` couche domaine démontrée.
- [ ] Chaque couche a son modèle : `CharacterDto` dans `data`, `Character` dans `domain`, `CharacterUiState` dans `ui` — `CRIT-DMA-D1-SE-2-M4` couches nettes.
- [ ] `CharacterUiState` est immuable et construit par un mapper, jamais à la main dans un écran — `CRIT-DMA-D1-SE-3-M6` State bien formé.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajoute un troisième cas à `Character` et lis l'erreur du compilateur.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-29 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
