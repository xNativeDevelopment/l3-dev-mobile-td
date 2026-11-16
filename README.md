# TD 33 — Le mock de secours

Slide : S-33 — Remplacer le service par un mock quand l'API manque · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-33-mock
État du build : départ construit · solution construite

## Objectif

À la fin, je sais fournir une implémentation factice de mon service pour que le projet compile et tourne sans réseau.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-33-mock` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-33-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 32 (branche `td-32-json-dto-solution`) : l'app lit les personnages sur le réseau, et sans connexion la liste reste vide.
La solution est sur la branche `td-33-mock-solution`.

## Étapes

1. Dans `data`, transforme `CharacterService` en interface avec ses deux fonctions `suspend`. Un personnage inconnu rend `null` : `fetchCharacter` rend un `CharacterDto?`.
2. Déplace le code Ktor dans `KtorCharacterService`, qui implémente l'interface. Il rend `null` quand l'API répond par une erreur 4xx. Le repository reçoit l'interface, jamais la classe.
3. Écris `MockCharacterService` : une liste fixe de `CharacterDto` au format de l'API, rendue après un `delay`, sans aucun appel réseau.
4. Dans `AppModule`, lie `CharacterService` à `KtorCharacterService` avec `single`.
5. Essaie la bascule : change cette seule ligne pour `MockCharacterService()`, lance l'app en mode avion, puis remets le vrai service.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 33"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-33-mon-travail`.

## Critères de réussite

- [ ] Le repository, les ViewModels et les écrans ne changent pas quand on bascule — `CRIT-DMA-D1-SF-2-M3` accès aux données dans sa couche.
- [ ] Un seul endroit change pour passer du réseau au mock : la ligne de `AppModule`.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Fais échouer le mock pour un identifiant précis et observe l'écran de détail.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-33 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
