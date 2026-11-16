# TD 41 — Oui, non, plus tard

Slide : S-41 — Demander une permission à l'exécution · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-41-permissions
État du build : départ construit · solution construite

## Objectif

À la fin, je sais déclarer une permission, la demander au bon moment et traiter le refus.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert, `git switch td-41-permissions`. Crée ta branche de travail : `git switch -c td-41-mon-travail`. Synchronise Gradle, puis Run.
Cette branche reprend l'état final du TD 40 (branche `td-40-manager-solution`) : l'écran de la liste a un bouton pour le Manager, mais aucune permission n'est déclarée ni demandée.
La solution est sur la branche `td-41-permissions-solution`.

## Étapes

1. Dans `AndroidManifest.xml`, déclare `android.permission.ACCESS_COARSE_LOCATION`, avec un commentaire : la position approximative suffit, pas la précision GPS.
2. Dans `ui/`, crée `LocationPermission.kt` : une fonction composable qui obtient un lanceur avec `rememberLauncherForActivityResult` et le contrat `RequestPermission`, et rend une fonction qui le lance.
3. Dans ce lanceur, dis si la permission est accordée, et si le système accepte encore de la redemander (`shouldShowRequestPermissionRationale`) sur l'Activity, obtenue dans le composable avec `LocalActivity.current`.
4. Ajoute l'action `OnPermissionAnswered` et un message dans l'état : le ViewModel choisit entre trois messages (accordée, refusée, refusée pour de bon), écrits dans les deux `strings.xml`.
5. Dans `CharacterListScreen`, ajoute un bouton qui lance la demande, et un texte qui explique avant de demander pourquoi on veut la position.
6. Lance l'app et essaie les trois réponses : accorder, refuser une fois, refuser encore.
7. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 41"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-41-mon-travail`.

## Critères de réussite

- [ ] Le Manifest déclare `ACCESS_COARSE_LOCATION` et aucune autre permission de position.
- [ ] La demande passe par `rememberLauncherForActivityResult` et `RequestPermission`, sans bibliothèque en plus.
- [ ] Les trois réponses (accordée, refusée, refusée pour de bon) affichent chacune leur message.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Pour le refus définitif, ajoute un bouton qui ouvre les réglages de l'app.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-41 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
