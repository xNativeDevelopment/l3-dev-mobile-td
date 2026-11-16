# TD 36 — Jour et nuit

Slide : S-36 — Poser un thème clair et sombre · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-36-theme-clair-sombre
État du build : départ construit · solution construite

## Objectif

À la fin, je sais définir deux schémas de couleurs Material 3 et laisser l'app suivre le mode du téléphone.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-36-theme-clair-sombre` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-36-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 35 (branche `td-35-dimens-solution`) : le thème n'a qu'un schéma clair, lu dans les couleurs métier de `colors.xml`.
La solution est sur la branche `td-36-theme-clair-sombre-solution`.

## Étapes

1. Dans `colors.xml`, ajoute au niveau métier une variante sombre de chaque couleur (`brand_primary_dark`, `on_brand_dark`, …), qui pointe sur de nouvelles teintes plus claires de la palette.
2. Dans `Theme.kt`, remets le paramètre `darkTheme: Boolean = isSystemInDarkTheme()`.
3. Écris `darkColorScheme`, alimenté par les couleurs métier sombres avec `colorResource`, et choisis entre les deux schémas avec `darkTheme`.
4. Vérifie que tes composables lisent `MaterialTheme.colorScheme`, jamais `R.color.palette_…` : sinon ils ne changent pas en mode sombre.
5. Lance l'app, bascule le téléphone en mode sombre (Réglages > Affichage), puis fais une capture de chaque mode : `docs/clair.png` et `docs/sombre.png`, qui s'affichent ci-dessous.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 36"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-36-mon-travail`.

![L'app en mode clair](docs/clair.png)

![L'app en mode sombre](docs/sombre.png)

## Critères de réussite

- [ ] L'app suit le mode du téléphone, clair comme sombre — `CRIT-DMA-D1-SF-1-M4` ressources systématiques, avec une variante.
- [ ] Aucun composable ne lit la palette brute : tout passe par le thème — `CRIT-DMA-D1-SF-3-M3` design system intégré.
- [ ] Les deux captures sont dans `docs/` et s'affichent ci-dessus.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajoute un aperçu `@Preview` en mode sombre pour la carte d'un personnage.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-36 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
