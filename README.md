# TD 01 — Premier projet qui démarre

Slide : S-01 — Créer un projet dans la sandbox et le lancer sur un émulateur · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-01-premier-projet
État du build : départ sans projet Gradle · solution construite le 2026-11-15

## Objectif

À la fin, je sais créer un projet Compose vide dans Android Studio et le lancer sur un émulateur que j'ai configuré.

## Point de départ

Cloner une fois, changer de branche : dans un terminal, dans le dossier `l3-dev-mobile-td`, `git switch td-01-premier-projet` (pas de nouveau clone). N'ouvre pas encore ce dossier dans Android Studio : l'assistant de l'étape 2 y crée le projet. Cette branche ne contient que cet énoncé et le fichier de configuration git `.gitignore` ; le projet se crée à la racine du dépôt.
La solution est sur la branche `td-01-premier-projet-solution`.
Prérequis : la dernière version stable d'Android Studio, avec la plateforme Android API 37 installée (Tools > SDK Manager > SDK Platforms).

## Étapes

1. Installe Android Studio (version stable) et ouvre son écran d'accueil.
2. New Project > Empty Activity : nom `Catalogue`, package `com.example.catalogue`, Minimum SDK API 26, langage de build Kotlin DSL ; comme emplacement (*Save location*), choisis le dossier `l3-dev-mobile-td`.
3. Attends la fin de la synchronisation Gradle. Si elle échoue (SDK ou JDK manquant), lis le message en entier avant de relancer.
4. Device Manager > Create Device : un téléphone et une image système récente, puis démarre-le.
5. Clique sur Run : l'app affiche « Hello Catalogue! ». Ajoute une capture de l'émulateur dans `docs/capture.png` et décris-la dans `docs/NOTE.md`.
6. Présente-toi à git avant ton premier commit, pour ce dépôt seulement (sans `--global`) : `git config user.name "Prénom Nom"`, puis `git config user.email "prenom.nom@exemple.fr"`.
7. Garde ton travail sur ta branche : `git switch -c td-01-mon-travail`, `git add -A`, `git commit -m "feat: finish TD 01"`. Sans ce commit, git refuse de passer au TD suivant.

## Critères de réussite

- [ ] L'app s'affiche sur l'émulateur que j'ai configuré, capture dans `docs/`.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Changer le texte affiché et relancer pour voir la modification.
- Créer un second émulateur à l'écran plus grand et y lancer la même app.

## Avec le tuteur

Facultatif. Colle tout le contenu du fichier `SKILL.md` du tuteur (lien ci-dessous) au début d'une conversation avec l'assistant de ton choix, puis écris « séance tuteur, slide S-01 ». Reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`. Si ton assistant sait charger des skills, tu peux plutôt installer le dossier `tuteur-android/`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Aucun contenu tiers.
