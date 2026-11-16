# TD 47 — Mon README

Slide : S-47 — Rédiger le README qui présente l'architecture · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-47-readme
État du build : départ à vérifier · solution à vérifier

## Objectif

À la fin, je sais écrire un README qui montre la structure du projet et le rôle de chaque couche.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-47-readme` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-47-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 45 (branche `td-45-corpus-solution`) : le projet fil rouge et ton `corpus/`, sans README d'architecture.
La solution est sur la branche `td-47-readme-solution`.
Dans ton propre projet, le texte que tu écris ici est le `README.md` de la racine ; ici il vit dans `docs/README.md`, car ce `README.md`-ci est l'énoncé du TD.

## Étapes

1. Crée `docs/README.md`. Commence par le but de l'app, en deux ou trois phrases.
2. Écris l'arborescence par couche : `data`, `di`, `domain`, `navigation`, `system`, `ui`. Pour chaque dossier, une ligne qui dit son rôle.
3. Décris le flux d'un geste : Screen, puis ViewModel, puis repository, puis service. Un petit schéma en texte suffit.
4. Liste les choix techniques (Koin, Navigation 3, Ktor, Compose) avec, pour chacun, la raison.
5. Relis : chaque fichier ou dossier cité doit dire pourquoi il est là, pas seulement qu'il existe.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 47"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-47-mon-travail`.

## Critères de réussite

- [ ] `docs/README.md` présente le but de l'app, l'arborescence par couche, le flux et les choix techniques — `CRIT-DMA-D1-SE-2-M1` README qui explique l'architecture
- [ ] Chaque choix technique a sa raison, chaque couche son rôle.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajoute une section « Ce que je ferais ensuite » de trois lignes.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-47 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
