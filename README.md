# TD 01 — Premier projet qui démarre

Slide : S-01 — Créer un projet dans la sandbox et le lancer sur un émulateur · Dépôt : https://github.com/<COMPTE>/td-01-premier-projet
État du build : starter à vérifier · solution à vérifier

## Objectif

À la fin, je sais créer un projet Compose vide dans Android Studio et le lancer sur un émulateur que j'ai configuré.

## Point de départ

Rien : on part de l'assistant d'Android Studio. Ce dépôt ne contient que cet énoncé et un `.gitignore` ; le projet se crée à sa racine.

## Étapes

1. Installer Android Studio (version stable) et ouvrir son écran d'accueil.
2. New Project > Empty Activity : nom `Catalogue`, package `com.example.catalogue`, Minimum SDK API 26, langage de build Kotlin DSL ; choisir ce dossier comme emplacement.
3. Attendre la fin de la synchronisation Gradle. Si elle échoue (SDK ou JDK manquant), lire le message en entier avant de relancer.
4. Device Manager > Create Device : un téléphone et une image système récente, puis le démarrer.
5. Cliquer Run : l'app affiche « Hello Catalogue! ». Ajouter une capture de l'émulateur dans `docs/capture.png` et la décrire dans `docs/NOTE.md`.

## Critères de réussite

- [ ] L'app s'affiche sur l'émulateur que j'ai configuré, capture dans `docs/`.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Changer le texte affiché et relancer pour voir la modification.
- Créer un second émulateur à l'écran plus grand et y lancer la même app.

## Avec le tuteur

Facultatif. Ouvre une séance avec `tuteur-android` sur la sous-compétence S-01
(« séance tuteur, slide S-01 ») ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/<COMPTE>/td-04-tuteur-android/tree/main/tuteur-android
Sans agent : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Aucun contenu tiers.
