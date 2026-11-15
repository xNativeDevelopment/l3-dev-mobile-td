# TD 07 — Manifest propre

Slide : S-07 — Lire et ranger le Manifest · Dépôt : https://github.com/<COMPTE>/td-07-manifest
État du build : starter à vérifier · solution à vérifier

## Objectif

À la fin, je sais dire ce que déclare chaque balise de mon Manifest et le laisser sans warning, commenté.

## Point de départ

Ce dépôt contient l'état final du TD 02.
Ouvrir ce dossier dans Android Studio (pas son dossier parent), attendre la synchronisation Gradle, puis Run.

## Étapes

1. Ouvrir `app/src/main/AndroidManifest.xml` et lire `<manifest>`, `<application>` puis `<activity>` : noter ce que chaque balise déclare.
2. Supprimer `uses-permission` CAMERA : l'app ne s'en sert pas.
3. Remplacer le nom en dur `Catalogue` de `android:label` par `@string/app_name`.
4. Commenter chaque bloc : l'application, puis l'activité de lancement et son `intent-filter`.
5. Afficher les warnings du fichier (Android Studio, Analyze > Inspect Code, ou le panneau Problems) : il ne doit en rester aucun.

## Critères de réussite

- [ ] Le Manifest ne garde que ce que l'app utilise et sa balise `application` ne contient aucun texte en dur — `CRIT-DMA-D1-SE-1-M1` Manifest sans warning, commenté.
- [ ] Chaque bloc du Manifest porte un commentaire — `CRIT-DMA-D1-SF-1-M1` Manifest propre, sans warning.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Chercher dans la documentation ce que fait `android:allowBackup` et décider si tu le gardes.
- Dire pourquoi `android:exported="true"` est obligatoire sur l'activité de lancement.

## Avec le tuteur

Facultatif. Ouvre une séance avec `tuteur-android` sur la sous-compétence S-07
(« séance tuteur, slide S-07 ») ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/<COMPTE>/td-04-tuteur-android/tree/main/tuteur-android
Sans agent : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Aucun contenu tiers.
