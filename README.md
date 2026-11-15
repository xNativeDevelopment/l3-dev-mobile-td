# TD 16 — Quel Context ?

Slide : S-16 — Obtenir le Context au bon endroit · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-16-context
État du build : départ à vérifier · solution à vérifier

## Objectif

À la fin, je sais d'où vient le Context (Application, Activity, `LocalContext`) et lequel passer à qui.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-16-context` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-16-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 15 (branche `td-15-cycle-de-vie-solution`). Elle ajoute trois services du système dans `system/Platform.kt` et trois appels dans `MainActivity`, marqués `TODO TD 16`, qui passent tous `this` sans réfléchir.
La solution est sur la branche `td-16-context-solution`.

## Étapes

1. Lis `system/Platform.kt` : repère les trois fonctions et ce que chacune fait du Context (afficher, stocker, lire une ressource).
2. Pour chaque appel marqué `TODO TD 16`, décide : l'objet vit-il longtemps (Context d'Application) ou sert-il à l'écran affiché (Context de l'Activity) ?
3. Compter les ouvertures est un travail de stockage : passe `applicationContext`, qui ne retient aucune Activity.
4. Dans le contenu Compose, récupère le Context avec `LocalContext.current` et passe-le au nom de l'app et au toast.
5. Remplace chaque `TODO TD 16` par un commentaire qui dit pourquoi ce Context, puis lance l'app et touche le bouton.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 16"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-16-mon-travail`.

## Critères de réussite

- [ ] Chaque appel reçoit le Context qui convient, et aucun Context d'Activity n'est stocké dans un objet qui vit plus longtemps qu'elle.
- [ ] Un commentaire dit pourquoi, au-dessus de chaque appel.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Expliquer ce qui arriverait si `showToast` gardait son Context dans un champ d'un objet `single` Koin.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-16 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
