# TD 38 — Mon design system

Slide : S-38 — Construire un petit design system : boutons, champs, composants brandés · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-38-design-system
État du build : départ construit · solution construite

## Objectif

À la fin, je sais créer mes propres composants de base, rangés dans un package reconnaissable de la couche UI.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-38-design-system` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-38-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 37 (branche `td-37-textes-langue-solution`) : les écrans utilisent directement les composants Material `Button`, `OutlinedTextField`, `Card` et `TextButton`.
La solution est sur la branche `td-38-design-system-solution`.

## Étapes

1. Crée le package `ui/designsystem`. Dans `dimens.xml`, ajoute deux dimensions nommées par rôle : `button_corner_radius` et `component_corner_radius`.
2. Écris `AppButton` : un texte, un clic et deux styles (plein ou texte). Sa forme vient de `dimens.xml`, ses couleurs de `MaterialTheme`.
3. Écris `AppTextField` : une valeur, un libellé et une forme brandée, sur le modèle de `OutlinedTextField`.
4. Écris `AppCard`, la Card brandée : coins arrondis, couleur de fond lue dans le thème, contenu libre.
5. Ajoute une `@Preview` par composant, dans son fichier, entourée de `CatalogueTheme`.
6. Dans `CharacterListScreen`, `CharacterDetailScreen` et `CharacterCard`, remplace `Button`, `TextButton`, `OutlinedTextField` et `Card` par tes composants.
7. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 38"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-38-mon-travail`.

## Critères de réussite

- [ ] `AppButton`, `AppTextField` et `AppCard` vivent dans `ui/designsystem` et lisent le thème — `CRIT-DMA-D1-SF-3-M3` design system intégré à l'UI.
- [ ] Aucun écran n'appelle plus `Button`, `OutlinedTextField`, `Card` ni `TextButton` — `CRIT-DMA-D1-SE-3-M3` composants au bon endroit.
- [ ] Chaque composant a un aperçu qui s'affiche dans Android Studio.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajoute un style « contour » à `AppButton`.
- Affiche l'aperçu de la Card en mode sombre.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-38 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
