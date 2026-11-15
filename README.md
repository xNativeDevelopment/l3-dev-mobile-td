# TD 02 — Mon dépôt de TD

Slide : S-02 — Récupérer un TD depuis GitHub et versionner son travail · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-02-depot-git
État du build : départ construit le 2026-11-15 · solution construite le 2026-11-15

## Objectif

À la fin, je sais cloner le dépôt une fois, changer de branche à chaque TD et commiter à mon nom.

## Point de départ

Cloner une fois, changer de branche (étapes 1-3). Cette branche reprend l'état final du TD 01 (branche `td-01-premier-projet-solution`).
La solution est sur la branche `td-02-depot-git-solution`.

## Étapes

1. Une seule fois, récupère le dépôt du cours : `git clone <adresse ou dossier donné par l'enseignant>`, puis `cd l3-dev-mobile-td`. Depuis le TD 01 : commite-le d'abord (`td-01-mon-travail`).
2. Passe sur la branche du TD : `git switch td-02-depot-git`.
3. Ouvre ce dossier dans Android Studio (pas son parent), puis crée ta branche de travail : `git switch -c td-02-mon-travail`. Identité git : celle du TD 01 ; sur un nouveau clone, redonne-la (sans `--global`) :

```bash
git config user.name "Prénom Nom"
git config user.email "prenom.nom@exemple.fr"
```

4. Complète le `.gitignore` avec celui d'Android : `.gradle/`, `build/`, `.kotlin/`, `.idea/`, `local.properties`, `.DS_Store`.
5. Ajoute à la fin de ce README une ligne « Mon travail : branche `td-02-mon-travail` ».
6. Vérifie, valide, contrôle ton nom :

```bash
git status
git add -A
git commit -m "feat: finish TD 02"
git log --oneline -1
```

7. Sur GitHub, fais un *Fork* du dépôt du cours (copier `main` seule suffit ; ce fork est public), puis :

```bash
git remote add perso <adresse de ton fork>
git push -u perso td-02-mon-travail
```

Au premier `git push`, connecte-toi à GitHub (jeton d'accès personnel si git demande un mot de passe).

Ensuite : un commit par slide terminée, puis `git push`. Ne pousse jamais vers `origin` : c'est le dépôt du cours.

## Critères de réussite

- [ ] Je travaille sur ma branche `td-02-mon-travail`, créée depuis `td-02-depot-git`.
- [ ] Ma branche est sur mon fork.
- [ ] `git log` montre mon commit, à mon nom.
- [ ] `git status` ne montre ni `build/`, ni `.gradle/`, ni `local.properties`.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Pour t'exercer au geste : ouvre une pull request de `td-02-mon-travail` (ton fork) vers `td-02-depot-git` (dépôt du cours). Elle ne sera pas fusionnée et personne ne la relit.

## Avec le tuteur

Facultatif. Colle le contenu du fichier `SKILL.md` du tuteur (lien ci-dessous) au début d'une conversation avec l'assistant de ton choix, puis écris « séance tuteur, slide S-02 ». Reprends avec `resume from:` et `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Aucun contenu tiers.

Mon travail : branche `td-02-mon-travail` (exemple)
