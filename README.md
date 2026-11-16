# TD 28 — Message une seule fois

Slide : S-28 — Émettre un événement ponctuel depuis le ViewModel · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-28-evenement-ponctuel
État du build : départ à vérifier · solution à vérifier

## Objectif

À la fin, je sais faire afficher un message ou déclencher une navigation une seule fois à partir du ViewModel.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-28-evenement-ponctuel` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-28-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 27 (branche `td-27-viewmodel-detail-solution`) et ajoute un bouton « Recharger » dont l'échec est simulé. Le message d'erreur est rangé dans `errorMessage`, dans l'état : lance l'app, appuie sur « Recharger », puis fais pivoter l'écran. Le message revient à chaque rotation.
La solution est sur la branche `td-28-evenement-ponctuel-solution`.

## Étapes

1. Repère dans `CharacterListScreen` l'effet `LaunchedEffect(uiState.errorMessage)` : il affiche le message, mais personne ne le retire de l'état.
2. Ajoute à `CharacterListUiAction` l'action `OnErrorShown`, nommée d'après l'intention : « le message a été montré ».
3. Dans `onAction` du ViewModel, traite-la en remettant `errorMessage` à `null`.
4. Dans `CharacterListContent`, envoie `OnErrorShown` juste après `showSnackbar` : l'événement est consommé.
5. Lance l'app, appuie sur « Recharger », attends que le message disparaisse, fais pivoter l'écran : il ne revient plus. Un second appui sur « Recharger » l'affiche de nouveau.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 28"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-28-mon-travail`.

## Critères de réussite

- [ ] Le message d'erreur s'affiche une fois après « Recharger », et pas à la rotation.
- [ ] Un second échec réaffiche le message.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajoute un second événement ponctuel : une fois le rechargement réussi, un message « Liste à jour ».

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-28 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
