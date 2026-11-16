# TD 46 — Zéro alerte

Slide : S-46 — Nommer selon les conventions Kotlin et passer le lint · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-46-lint-nommage
État du build : départ construit · solution construite

## Objectif

À la fin, je sais nommer classes, fonctions, écrans et ressources selon les conventions Kotlin et lancer le lint jusqu'à zéro alerte.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-46-lint-nommage` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-46-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche apporte un projet fourni, volontairement mal nommé : valeurs, classe, fonction, écran et ressource. La solution est sur la branche `td-46-lint-nommage-solution`.

## Étapes

1. À la racine du projet, lance `./gradlew ktlintCheck` : ktlint liste ce qui s'écarte des conventions, sans rien modifier.
2. Lance `./gradlew ktlintFormat` : l'outil répare seul la mise en page. Relance ensuite `ktlintCheck` : il ne reste que des noms.
3. Renomme à la main, avec le refactor de l'IDE (Shift+F6), pas fichier par fichier : la classe, ses propriétés et la fonction que ktlint signale.
4. Renomme l'écran en `XScreen` et la ressource texte en minuscules séparées par `_`. ktlint ne les signale pas.
5. Dans Android Studio, lance le lint (Code > Inspect Code) et corrige les noms qu'il souligne.
6. Relance `./gradlew ktlintCheck` jusqu'à zéro alerte, puis la même passe sur ton propre projet : copie `.editorconfig`, les deux lignes ktlint de `gradle/libs.versions.toml`, puis l'import `Bundling` et le bloc ktlint de `app/build.gradle.kts`.
7. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 46"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-46-mon-travail`.

## Critères de réussite

- [ ] `./gradlew ktlintCheck` se termine sans alerte — `CRIT-DMA-D1-SE-4-M2` conventions de nommage Kotlin.
- [ ] L'écran se nomme `XScreen`, ses fonctions en camelCase — `CRIT-DMA-D1-SE-3-M2` écrans bien nommés.
- [ ] Aucun nom de ressource en majuscules — `CRIT-DMA-D1-SE-1-M4` nommage des ressources conventionnel.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Préfixer les ressources d'un écran par son nom, par exemple `home_title`.

## Avec le tuteur

Facultatif. Colle tout le contenu du fichier `SKILL.md` du tuteur (lien ci-dessous) au début d'une conversation avec l'assistant de ton choix, puis écris « séance tuteur, slide S-46 ». Reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Aucun contenu tiers.
