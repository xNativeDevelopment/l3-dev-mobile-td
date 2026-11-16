# TD 39 — Documenter la Card

Slide : S-39 — Couronner un composant complexe d'un en-tête KDoc · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-39-kdoc-composant
État du build : départ construit · solution construite

## Objectif

À la fin, je sais écrire un en-tête KDoc utile sur un composable complexe, avec les block tags qui comptent.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert, `git switch td-39-kdoc-composant`. Crée ta branche de travail : `git switch -c td-39-mon-travail`. Synchronise Gradle, puis Run.
Cette branche reprend l'état final du TD 38 (branche `td-38-design-system-solution`) : `AppCard`, la Card brandée, n'a aucun en-tête KDoc.
La solution est sur la branche `td-39-kdoc-composant-solution`.

## Étapes

1. Dans `ui/designsystem/AppCard.kt`, tape `/**` au-dessus de la fonction : c'est un en-tête KDoc.
2. Résume la Card en une ligne : ce que le code ne dit pas, pas une paraphrase de son nom.
3. Ajoute un `@param` pour `modifier` et pour `content` : qui règle la taille, qui règle les marges.
4. Termine par un `@see` vers un composant voisin (`AppButton`), ou un `@sample`.
5. Ajoute le plugin Dokka : dans `gradle/libs.versions.toml`, `dokka = "2.3.0"` sous `[versions]` et `dokka = { id = "org.jetbrains.dokka", version.ref = "dokka" }` sous `[plugins]` ; dans `app/build.gradle.kts`, `alias(libs.plugins.dokka)`. Gradle le télécharge : il faut une connexion.
6. Lance `./gradlew dokkaGenerate` (`.\gradlew dokkaGenerate` sous Windows), ouvre `app/build/dokka/html/index.html` et relis ton texte comme un autre développeur.
7. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 39"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-39-mon-travail`.

## Critères de réussite

- [ ] `AppCard` a un résumé d'une ligne, un `@param` par paramètre non évident et un `@see` ou `@sample` — `CRIT-DMA-D1-SE-3-M7` en-tête KDoc sur un composant complexe.
- [ ] Chaque phrase dit ce que le code ne dit pas.
- [ ] La page générée par `dokkaGenerate` affiche ton texte.
- [ ] Le projet se construit sans erreur.

## Pour aller plus loin

- Documente de la même façon `AppButton`, en expliquant ses deux styles.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-39 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
