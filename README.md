# TD 11 — L'architecture de mon projet

Slide : S-11 — Découper son projet en couches reliées par des interfaces · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-11-couches
État du build : départ construit le 2026-11-15 · solution construite le 2026-11-15

## Objectif

À la fin, je sais ranger mon code en couches présentation / domaine / données et les relier par des interfaces.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-11-couches` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-11-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 10 (branche `td-10-composant-card-solution`) : tous les fichiers sont dans un seul package.
La solution est sur la branche `td-11-couches-solution`.
Prérequis : la dernière version stable d'Android Studio, avec la plateforme Android API 37 installée (Tools > SDK Manager > SDK Platforms).

## Étapes

1. Créer trois packages sous `com.example.catalogue` : `ui`, `domain`, `data`.
2. Déplacer `Character.kt` dans `domain` et `CharacterCard.kt` dans `ui`, en corrigeant `package` et imports.
3. Dans `domain`, écrire l'interface `CharacterProvider` : le contrat qui donne la liste des personnages.
4. Dans `data`, écrire `FakeCharacterProvider`, qui implémente le contrat, et supprimer `FakeCharacters.kt`.
5. Dans `MainActivity.kt`, obtenir les personnages par le contrat. Dans `ui`, la preview crée son `Character` elle-même : aucun import de `data`.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 11"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-11-mon-travail`.

## Critères de réussite

- [ ] Trois packages distincts, chacun avec ses classes — `CRIT-DMA-D1-SF-2-M1` couches distinctes.
- [ ] Aucun fichier de `ui` n'importe `data` — `CRIT-DMA-D1-SF-2-M2` UI rassemblée, rien ne fuit.
- [ ] Chaque classe est dans la couche qui lui correspond — `CRIT-DMA-D1-SE-2-M3` chaque composant à sa place.
- [ ] Chaque couche a un rôle net : affichage, contrat, source de données — `CRIT-DMA-D1-SE-2-M4` architecture de chaque couche nette.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajouter une seconde implémentation du contrat, avec une liste plus courte, et la brancher dans `MainActivity`.

## Avec le tuteur

Facultatif. Colle le contenu du fichier `SKILL.md` du tuteur (lien ci-dessous) au début d'une conversation avec l'assistant de ton choix, puis écris « séance tuteur, slide S-11 ». Reprends avec `resume from:` et `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
