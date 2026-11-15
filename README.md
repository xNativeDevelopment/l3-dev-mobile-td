# TD 12 — Une Application, une Activity

Slide : S-12 — Suivre le chemin de lancement et garder une seule Activity · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-12-lancement-single-activity
État du build : départ construit le 2026-11-15 · solution construite le 2026-11-15

## Objectif

À la fin, je sais suivre Manifest → Application → MainActivity et pourquoi l'app n'a qu'une Activity.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-12-lancement-single-activity` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-12-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 11 (branche `td-11-couches-solution`) : `MainActivity` construit elle-même le fournisseur de personnages et il n'existe pas de classe `Application`.
La solution est sur la branche `td-12-lancement-single-activity-solution`.
Prérequis : la dernière version stable d'Android Studio, avec la plateforme Android API 37 installée (Tools > SDK Manager > SDK Platforms).

## Étapes

1. Créer `CatalogueApplication.kt` : une classe qui hérite de `Application` et qui porte le `CharacterProvider`.
2. La déclarer dans `AndroidManifest.xml` avec `android:name=".CatalogueApplication"`.
3. Dans `MainActivity.kt`, ne plus rien construire : lire le fournisseur dans l'`Application`, puis `setContent`.
4. Poser un commentaire à chaque étape du lancement : Manifest, `Application`, `MainActivity`.
5. Vérifier qu'il n'y a qu'une seule balise `<activity>` dans le Manifest, puis lancer l'app.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 12"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-12-mon-travail`.

## Critères de réussite

- [ ] Une seule Activity dans le Manifest, et l'app affiche toujours la Card — `CRIT-DMA-D1-SF-3-M1` une seule Activity.
- [ ] L'`Application` est déclarée dans le Manifest et la `MainActivity` ne construit plus rien.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajouter un `Log.d` dans `Application.onCreate` et dans `MainActivity.onCreate`, puis lire l'ordre dans Logcat.
- Faire pivoter l'écran et observer lequel des deux logs reparaît.

## Avec le tuteur

Facultatif. Colle tout le contenu du fichier `SKILL.md` du tuteur (lien ci-dessous) au début d'une conversation avec l'assistant de ton choix, puis écris « séance tuteur, slide S-12 ». Reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`. Si ton assistant sait charger des skills, tu peux plutôt installer le dossier `tuteur-android/`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
