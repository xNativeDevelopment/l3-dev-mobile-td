# TD 37 — Deux langues

Slide : S-37 — Externaliser ses textes et ajouter une variante de langue · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-37-textes-langue
État du build : départ construit · solution construite

## Objectif

À la fin, je sais mettre tous mes textes dans `strings.xml`, les traduire dans `values-en` et vérifier l'app dans les deux langues.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-37-textes-langue` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-37-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 36 (branche `td-36-theme-clair-sombre-solution`) : les textes sont écrits en dur dans le code, et `strings.xml` ne contient que le nom de l'app.
La solution est sur la branche `td-37-textes-langue-solution`.

## Étapes

1. Dans `res/values/strings.xml`, écris en français une clé par texte visible : filtre, rechargement, partage, retour, « introuvable », messages d'erreur.
2. Crée `res/values-en/strings.xml` avec les mêmes clés, traduites en anglais.
3. Dans `ui/`, remplace chaque texte par `stringResource(R.string.…)`.
4. Dans les ViewModels, l'état porte un `@StringRes Int` (`errorMessage`, `networkError`) que l'écran résout. Dans `Share.kt`, utilise `context.getString`.
5. Laisse les noms de personnages, `Alive` et les aperçus : ce sont des données d'exemple.
6. Passe l'émulateur en anglais (Réglages > Système > Langues) et vérifie qu'aucun texte ne reste en français.
7. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 37"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-37-mon-travail`.

## Critères de réussite

- [ ] Aucun texte n'est écrit en dur dans `ui/` ; en anglais, rien ne reste en français — `CRIT-DMA-D1-SF-1-M4` ressources systématiques, avec une variante.
- [ ] Les deux `strings.xml` ont les mêmes clés, nommées par rôle — `CRIT-DMA-D1-SE-1-M4` nommage des ressources.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajoute une troisième langue dans `values-xx/strings.xml`.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-37 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
