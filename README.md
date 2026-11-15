# TD 17 — Partager un personnage

Slide : S-17 — Ouvrir une autre application avec un Intent · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-17-intent
État du build : départ à vérifier · solution à vérifier

## Objectif

À la fin, je sais lancer un Intent implicite (navigateur, partage) depuis un clic.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-17-intent` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-17-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 16 (branche `td-16-context-solution`) : la Card a maintenant un bouton « Partager », relié à `shareText` dans `system/Share.kt`, qui est encore vide.
La solution est sur la branche `td-17-intent-solution`.

## Étapes

1. Lance l'app et touche « Partager » : rien ne se passe, c'est normal.
2. Dans `shareText`, construis un Intent d'action `Intent.ACTION_SEND`, de type `text/plain`, avec le texte en extra `Intent.EXTRA_TEXT`.
3. Enveloppe-le dans `Intent.createChooser` : Android propose les applications capables de le recevoir.
4. Lance-le avec `context.startActivity` : le Context vient de `LocalContext.current`, comme au TD 16.
5. Entoure le lancement d'un `try` : si aucune application ne répond, attrape `ActivityNotFoundException` et affiche un message avec `showToast`.
6. Touche « Partager » sur l'émulateur : le nom du personnage arrive dans l'application choisie. Puis garde ton travail : `git add -A`, `git commit -m "feat: finish TD 17"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-17-mon-travail`.

## Critères de réussite

- [ ] Un clic sur « Partager » ouvre le sélecteur d'applications avec le nom du personnage.
- [ ] L'absence d'application capable est gérée sans plantage.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ouvrir une page web avec un Intent `ACTION_VIEW` et une adresse `Uri.parse(...)`.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-17 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
