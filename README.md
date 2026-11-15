# TD 12 — Une Application, une Activity

Slide : S-12 — Suivre le chemin de lancement et garder une seule Activity · Dépôt : https://github.com/<COMPTE>/td-12-lancement-single-activity
État du build : starter non construit : dépendance absente du cache local (androidx.compose.foundation:foundation-android:1.10.0) · solution non construite : dépendance absente du cache local (androidx.compose.foundation:foundation-android:1.10.0) · lint non exécuté

## Objectif

À la fin, je sais suivre Manifest → Application → MainActivity et pourquoi l'app n'a qu'une Activity.

## Point de départ

Ce dépôt contient l'état final du TD 11 : `MainActivity` construit elle-même le fournisseur de personnages et il n'existe pas de classe `Application`.
Ouvrir ce dossier dans Android Studio (pas son dossier parent), attendre la synchronisation Gradle, puis Run.

## Étapes

1. Créer `CatalogueApplication.kt` : une classe qui hérite de `Application` et qui porte le `CharacterProvider`.
2. La déclarer dans `AndroidManifest.xml` avec `android:name=".CatalogueApplication"`.
3. Dans `MainActivity.kt`, ne plus rien construire : lire le fournisseur dans l'`Application`, puis `setContent`.
4. Poser un commentaire à chaque étape du lancement : Manifest, `Application`, `MainActivity`.
5. Vérifier qu'il n'y a qu'une seule balise `<activity>` dans le Manifest, puis lancer l'app.

## Critères de réussite

- [ ] Une seule Activity dans le Manifest, et l'app affiche toujours la Card — `CRIT-DMA-D1-SF-3-M1` une seule Activity.
- [ ] L'`Application` est déclarée dans le Manifest et la `MainActivity` ne construit plus rien.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajouter un `Log.d` dans `Application.onCreate` et dans `MainActivity.onCreate`, puis lire l'ordre dans Logcat.
- Faire pivoter l'écran et observer lequel des deux logs reparaît.

## Avec le tuteur

Facultatif. Ouvre une séance avec `tuteur-android` sur la sous-compétence S-12
(« séance tuteur, slide S-12 ») ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/<COMPTE>/td-04-tuteur-android/tree/main/tuteur-android
Sans agent : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
