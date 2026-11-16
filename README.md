# TD 25 — Actions de l'écran

Slide : S-25 — Nommer et traiter les actions de l'écran (UiAction) en flux unidirectionnel · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-25-ui-action
État du build : départ à vérifier · solution à vérifier

## Objectif

À la fin, je sais envoyer chaque geste de l'utilisateur au ViewModel par une action bien nommée.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-25-ui-action` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-25-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 24 (branche `td-24-screen-viewmodel-solution`) et ajoute un champ « Filtrer par nom » qui ne fait encore rien. Le clic sur une carte, lui, appelle le Navigator depuis l'écran : le ViewModel n'en sait rien.
La solution est sur la branche `td-25-ui-action-solution`.

## Étapes

1. Écris `CharacterListUiAction`, une `sealed interface` avec une action par intention : `OnFilterChanged(text)` et `OnCharacterClicked(id)`. Nomme chaque action d'après ce que veut l'utilisateur, pas d'après le widget.
2. Ajoute `filter` à `CharacterListUiState`, et une propriété `visibleCharacters` : les personnages dont le nom contient le filtre, sans tenir compte des majuscules.
3. Dans `CharacterListViewModel`, reçois le `Navigator` par le constructeur (mets `appModule` à jour) et écris `onAction(action)` : un `when` qui met à jour l'état pour le filtre et appelle `goToDetail` pour le clic.
4. Dans `CharacterListContent`, remplace les lambdas par un seul `onAction`. Le champ envoie `OnFilterChanged`, la carte envoie `OnCharacterClicked`.
5. Retire le `Navigator` de `CharacterListScreen`. Lance l'app : taper « mor » ne laisse que Morty, et un clic ouvre toujours le détail.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 25"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-25-mon-travail`.

## Critères de réussite

- [ ] Chaque geste passe par une action nommée d'après l'intention, traitée dans `onAction` — `CRIT-DMA-D1-SE-3-M5` actions du ViewModel bien nommées.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajoute une action `OnFilterCleared` et un bouton qui efface le champ.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-25 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
