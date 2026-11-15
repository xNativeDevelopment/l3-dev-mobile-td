# TD 02 — Mon dépôt de TD

Slide : S-02 — Récupérer un TD depuis GitHub et versionner son travail en privé · Dépôt : https://github.com/<COMPTE>/td-02-depot-git
État du build : starter à vérifier · solution à vérifier

## Objectif

À la fin, je sais récupérer un dossier de TD, en faire mon propre dépôt privé, y pousser mes commits et envoyer le lien dès sa création.

## Point de départ

Ce dépôt contient l'état final du TD 01.
Ouvrir ce dossier dans Android Studio (pas son dossier parent), attendre la synchronisation Gradle, puis Run.

## Étapes

1. Sur la page du dépôt du TD, cliquer « Use this template » > « Create a new repository », visibilité Private ; sans compte GitHub possible, télécharger le zip de la branche `main`.
2. Cloner ton nouveau dépôt, puis l'ouvrir comme projet dans Android Studio (le dossier du dépôt, pas son parent).
3. Compléter le `.gitignore` avec celui d'Android : `.gradle/`, `build/`, `.kotlin/`, `.idea/`, `local.properties`, `.DS_Store`.
4. Ajouter une dernière ligne « Mon dépôt : » suivie de l'adresse de ton dépôt à ce README.
5. Vérifier, valider et pousser, puis envoyer le lien du dépôt au responsable dès sa création :

```bash
git status
git add .
git commit -m "feat: finish TD 02"
git push -u origin main
```

Ensuite : un commit par slide terminée.

## Critères de réussite

- [ ] Mon dépôt est privé et son lien est envoyé.
- [ ] `git status` ne montre ni `build/` ni `local.properties`.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Lire la page de GitHub sur les liens permanents vers un fichier et en copier un.
- Essayer `git sparse-checkout` pour ne récupérer qu'un dossier d'un grand dépôt.

## Avec le tuteur

Facultatif. Ouvre une séance avec `tuteur-android` sur la sous-compétence S-02
(« séance tuteur, slide S-02 ») ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/<COMPTE>/td-04-tuteur-android/tree/main/tuteur-android
Sans agent : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Aucun contenu tiers.
