# TD 26 — La liste des personnages

Slide : S-26 — Afficher une liste avec LazyColumn · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-26-liste
État du build : départ construit · solution construite

## Objectif

À la fin, je sais afficher une liste issue du UiState avec `LazyColumn` et des clés stables.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-26-liste` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-26-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 25 (branche `td-25-ui-action-solution`) avec douze personnages au lieu de cinq. La liste est une `Column` : lance l'app en mode paysage, les dernières cartes sont coupées et on ne peut pas faire défiler.
La solution est sur la branche `td-26-liste-solution`.

## Étapes

1. Dans `CharacterListContent`, remplace la boucle `forEach` par un `LazyColumn` placé sous le champ de filtre. Lance l'app en paysage : la liste défile.
2. Alimente-le avec `items(uiState.visibleCharacters)` : le filtre du TD 25 continue de fonctionner, car la liste vient toujours du `UiState`.
3. Donne à chaque élément une clé stable : `key = { it.id }`. Une clé identifie un élément même quand sa position change.
4. Espace les cartes avec `verticalArrangement = Arrangement.spacedBy(8.dp)`.
5. Vérifie le clic : il envoie toujours `OnCharacterClicked(id)` au ViewModel, qui appelle le Navigator du TD 22. Le détail s'ouvre, le retour te ramène à la liste.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 26"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-26-mon-travail`.

## Critères de réussite

- [ ] La liste est un `LazyColumn` alimenté par `visibleCharacters`, chaque élément porte la clé `it.id`, et la liste défile — `CRIT-DMA-D1-SF-3-M4` Screen.kt – ViewModel.kt + UiState.
- [ ] Le filtre et le clic sur une carte fonctionnent comme au TD 25.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Affiche un texte « Aucun personnage » quand le filtre ne trouve personne.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-26 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
