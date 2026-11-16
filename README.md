# TD 44 — Étendre le Context

Slide : S-44 — Écrire une fonction d'extension sur Context, couronnée d'un en-tête KDoc · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-44-extension-context
État du build : départ à vérifier · solution à vérifier

## Objectif

À la fin, je sais écrire une fonction d'extension du Context utile au projet et la documenter en KDoc avec des block tags pertinents.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert, `git switch td-44-extension-context`. Crée ta branche de travail : `git switch -c td-44-mon-travail`. Synchronise Gradle, puis Run.
Cette branche reprend l'état final du TD 43 (branche `td-43-gps-solution`) : le `FusedLocationManager` y teste la permission lui-même, dans une fonction privée.
La solution est sur la branche `td-44-extension-context-solution`.

## Étapes

1. Dans `system/`, crée le fichier `ContextExtensions.kt` et écris `fun Context.hasPermission(permission: String): Boolean`. Elle appelle `ContextCompat.checkSelfPermission` et compare à `PERMISSION_GRANTED`. `ContextCompat` est déjà disponible : ne l'ajoute pas au catalogue.
2. Au-dessus de la fonction, écris l'en-tête KDoc : une phrase de résumé, puis `@param permission`, `@return` et `@see ContextCompat.checkSelfPermission`.
3. Dans `FusedLocationManager`, remplace la fonction privée `hasPermission()` par `appContext.hasPermission(...)`. Supprime les imports devenus inutiles.
4. Relis l'extension : elle outille le Context et rien d'autre, aucune règle du projet n'y est écrite.
5. Lance l'app : « Où suis-je ? » se comporte comme au TD 43, avec et sans permission.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 44"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-44-mon-travail`.

## Critères de réussite

- [ ] `Context.hasPermission` existe et sert au Manager — `CRIT-DMA-D1-SF-4-M3` extension sur le Context
- [ ] Son en-tête KDoc porte `@param`, `@return` et `@see` — `CRIT-DMA-D1-SE-4-M4` extension du Context avec en-tête KDoc
- [ ] L'extension est écrite sur `Context` — `CRIT-DMA-D1-SF-1-M6` extension sur ViewModel, Context ou Intent
- [ ] Le Manager n'a plus sa propre vérification de permission — `CRIT-DMA-D1-SE-1-M5` fonction d'extension avec en-tête KDoc
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Écris une deuxième extension sur `Context`, pour une autre action du projet.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-44 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
