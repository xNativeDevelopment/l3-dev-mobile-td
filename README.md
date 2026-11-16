# TD 30 — Mon repository

Slide : S-30 — Construire un repository et l'injecter dans le ViewModel · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-30-repository
État du build : départ construit · solution construite

## Objectif

À la fin, je sais écrire un repository derrière une interface, fourni par Koin, qui rend des modèles de domaine.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-30-repository` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-30-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 29 (branche `td-29-domaine-solution`) : les ViewModels lisent des listes fictives par `CharacterCatalog` et `CharacterProvider`, et la liste se charge avec un `Thread.sleep` qui bloque un thread.
La solution est sur la branche `td-30-repository-solution`.

## Étapes

1. Dans `domain`, écris l'interface `CharacterRepository` : `getCharacters()` rend des `Character.Preview`, `getCharacter(id)` rend un `Character.Details` ou `null`. Les deux fonctions sont `suspend`.
2. Dans `data`, écris `FakeCharacterRepository`, qui garde les données en mémoire. Chaque fonction attend avec `delay` : l'attente est derrière le repository.
3. Dans `AppModule`, lie `CharacterRepository` à `FakeCharacterRepository` avec `single`. Donne-le à `CharacterListViewModel`, puis retire `Thread.sleep` et `withContext`.
4. Fais de même pour `CharacterDetailViewModel` : il appelle `getCharacter(id)` dans `viewModelScope`. L'état gagne `isLoading`, le détail montre un indicateur pendant la lecture.
5. Supprime `CharacterProvider`, `FakeCharacterProvider` et `CharacterCatalog` : plus aucun fichier ne les nomme.
6. Lance l'app : la liste s'affiche après deux secondes sans figer l'écran.
7. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 30"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-30-mon-travail`.

## Critères de réussite

- [ ] Les ViewModels dépendent de `CharacterRepository`, jamais de `FakeCharacterRepository` — `CRIT-DMA-D1-SF-2-M3` accès aux données dans sa couche.
- [ ] Aucun écran n'appelle le repository : seuls les ViewModels le font.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajoute à l'interface une fonction qui rend les personnages dont le nom contient un texte.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-30 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
