# TD 34 — Mes couleurs

Slide : S-34 — Architecturer `colors.xml` : palette, couleurs métier, couleurs de composants · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-34-couleurs
État du build : départ construit · solution construite

## Objectif

À la fin, je sais ranger mes couleurs en trois niveaux nommés selon une convention.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-34-couleurs` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-34-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 33 (branche `td-33-mock-solution`) : les couleurs sont en dur dans le code. `Color.kt` porte six codes hexadécimaux et `StatusBadge` utilise `Color.White` : c'est le piège de la slide, une couleur en dur dans un composable.
La solution est sur la branche `td-34-couleurs-solution`.

## Étapes

1. Crée `app/src/main/res/values/colors.xml`. Premier niveau, la palette brute : bleu, vert, jaune, orange, rouge, violet, gris, nommés `palette_<teinte>_<nuance>`.
2. Deuxième niveau, les couleurs métier : `brand_primary`, `brand_secondary`, `brand_tertiary`, `brand_container`, `on_brand`, `alert`. Chacune pointe sur la palette (`@color/…`).
3. Troisième niveau, les couleurs de composants : déplace `ic_launcher_background` dans ce fichier, supprime `ic_launcher_background.xml`, et crée `launcher_foreground`, puis fais-le lire par `res/drawable/ic_launcher_foreground.xml` (`android:fillColor="@color/launcher_foreground"`).
4. Dans `Theme.kt`, retire le schéma sombre écrit par l'assistant, puis nourris `lightColorScheme` avec `colorResource(R.color.…)` sur les couleurs métier. Supprime `Color.kt`.
5. Dans `StatusBadge`, remplace `Color.White` par un rôle du thème : `onPrimary` (vivant) ou `onError`.
6. Cherche `Color(0x` et `Color.` dans le code : aucune couleur en dur ne doit rester.
7. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 34"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-34-mon-travail`.

## Critères de réussite

- [ ] `colors.xml` a trois niveaux et chaque niveau pointe sur celui du dessous — `CRIT-DMA-D1-SF-1-M4` ressources systématiques.
- [ ] Les noms suivent une convention (`palette_…`, `brand_…`) — `CRIT-DMA-D1-SE-1-M4` nommage des ressources conventionnel.
- [ ] Les composables lisent le thème, jamais une couleur en dur — `CRIT-DMA-D1-SF-3-M3` design system intégré.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Change `brand_primary` : un seul endroit, toute l'app suit.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-34 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
