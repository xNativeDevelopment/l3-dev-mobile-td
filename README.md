# TD 07 — Manifest propre

Slide : S-07 — Lire et ranger le Manifest · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-07-manifest
État du build : départ construit le 2026-11-15 · solution construite le 2026-11-15 · absence de warning non vérifiée par l'enseignant (analyse Lint pas encore lancée)

## Objectif

À la fin, je sais dire ce que déclare chaque balise de mon Manifest et le laisser sans warning, commenté.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-07-manifest` (pas de nouveau clone). Attendre la synchronisation Gradle, puis Run.
Cette branche reprend l'état final du TD 02 (branche `td-02-depot-git-solution`).
La solution est sur la branche `td-07-manifest-solution`.
Prérequis : la dernière version stable d'Android Studio, avec la plateforme Android API 37 installée (Tools > SDK Manager > SDK Platforms).

## Étapes

1. Ouvrir `app/src/main/AndroidManifest.xml` et lire `<manifest>`, `<application>` puis `<activity>` : noter ce que chaque balise déclare.
2. Supprimer `uses-permission` CAMERA : l'app ne s'en sert pas.
3. Remplacer le nom en dur `Catalogue` de `android:label` par `@string/app_name`.
4. Commenter chaque bloc : l'application, puis l'activité de lancement et son `intent-filter`.
5. Afficher les warnings du fichier (Android Studio, Analyze > Inspect Code, ou le panneau Problems) : il ne doit en rester aucun.

## Critères de réussite

- [ ] Chaque bloc du Manifest porte un commentaire — `CRIT-DMA-D1-SE-1-M1` Manifest sans warning, commenté.
- [ ] Le Manifest ne garde que ce que l'app utilise et sa balise `application` ne contient aucun texte en dur — `CRIT-DMA-D1-SF-1-M1` Manifest propre, sans warning.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Chercher dans la documentation ce que fait `android:allowBackup` et décider si tu le gardes.
- Dire pourquoi `android:exported="true"` est obligatoire sur l'activité de lancement.

## Avec le tuteur

Facultatif. Colle tout le contenu du fichier `SKILL.md` du tuteur (lien ci-dessous) au début d'une conversation avec l'assistant de ton choix, puis écris « séance tuteur, slide S-07 ». Reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`. Si ton assistant sait charger des skills, tu peux plutôt installer le dossier `tuteur-android/`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Aucun contenu tiers.
