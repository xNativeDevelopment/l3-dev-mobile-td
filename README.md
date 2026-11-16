# TD 35 — Une échelle d'espacements

Slide : S-35 — Ranger ses dimensions dans `dimens.xml` · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-35-dimens
État du build : départ construit · solution construite

## Objectif

À la fin, je sais déclarer mes marges, tailles et rayons dans `dimens.xml`, nommés par rôle, et les lire en Compose.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-35-dimens` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-35-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 34 (branche `td-34-couleurs-solution`) : les couleurs sont rangées, mais les marges et les tailles sont encore des `16.dp` et des `8.dp` écrits dans les écrans.
La solution est sur la branche `td-35-dimens-solution`.

## Étapes

1. Cherche `.dp` dans `app/src/main/java` : note chaque valeur et le rôle qu'elle joue (marge d'écran, espace entre cartes, taille de l'avatar, marges du badge).
2. Crée `app/src/main/res/values/dimens.xml` et déclare une dimension par rôle, par exemple `screen_padding` ou `list_item_spacing`. Un nom dit à quoi sert la valeur, jamais combien elle vaut.
3. Dans `CharacterListScreen` et `CharacterDetailScreen`, remplace chaque `.dp` par `dimensionResource(R.dimen.…)`.
4. Fais de même dans `CharacterCard`, `CharacterAvatar` et `StatusBadge`, puis supprime les imports de `dp` devenus inutiles.
5. Cherche `.dp` une dernière fois : l'écran liste n'en contient plus.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 35"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-35-mon-travail`.

## Critères de réussite

- [ ] Chaque dimension de `dimens.xml` porte le nom d'un rôle, pas d'une valeur — `CRIT-DMA-D1-SE-1-M4` nommage des ressources conventionnel.
- [ ] Les marges, tailles et espacements viennent tous de `dimens.xml` — `CRIT-DMA-D1-SF-1-M4` ressources systématiques.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Change `screen_padding` : un seul endroit, tous les écrans suivent.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-35 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
