# TD 14 — Une arborescence qui se lit

Slide : S-14 — Nommer ses packages selon une convention et passer Lint · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-14-packages-lint
État du build : départ construit · solution construite

## Objectif

À la fin, je sais nommer mes packages d'une seule façon dans tout le projet et vérifier qu'aucune alerte Lint ne reste.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-14-packages-lint` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-14-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 13 (branche `td-13-koin-solution`) : l'application fonctionne, mais ses packages sont nommés de trois façons différentes (`view`, `data_layer`, `ui`).
La solution est sur la branche `td-14-packages-lint-solution`.

## Étapes

1. Dans la vue Project d'Android Studio, passe en mode Packages et repère les packages qui ne suivent pas la même règle (synonyme d'un autre, tiret bas).
2. Choisis la règle : minuscules, sans tiret bas, un seul mot par niveau, un nom par couche (`ui`, `domain`, `data`, `di`).
3. Renomme `view` en `ui` et `data_layer` en `data` avec Refactor > Rename (clic droit sur le package). Les imports se corrigent seuls.
4. Lance Analyze > Inspect Code sur le projet entier, lis la catégorie des conventions de nommage et corrige ce qui reste.
5. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 14"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-14-mon-travail`.

## Critères de réussite

- [ ] Aucun package ne contient de majuscule ni de tiret bas, et chaque couche a un seul nom — `CRIT-DMA-D1-SE-2-M2` nommage des packages.
- [ ] Le dossier de chaque fichier correspond à sa ligne `package`.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajouter un package par fonctionnalité sous `ui` (par exemple `ui.catalogue`) en gardant la même règle.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-14 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
