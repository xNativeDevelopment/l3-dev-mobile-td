# TD 18 — Démonter la Card

Slide : S-18 — Découper ses composables en briques LEGO · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-18-lego
État du build : départ à vérifier · solution à vérifier

## Objectif

À la fin, je sais casser un composable trop long en petites briques réutilisables, chacune avec un rôle.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-18-lego` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-18-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 17 (branche `td-17-intent-solution`) : la Card affiche maintenant une pastille de lettre et un badge de statut, tout écrit dans la seule fonction `CharacterCard`.
La solution est sur la branche `td-18-lego-solution`.

## Étapes

1. Ouvre `ui/CharacterCard.kt` et repère trois blocs qui ont un nom : la pastille ronde, le texte du personnage, le badge de statut.
2. Extrais la pastille dans `CharacterAvatar(name, modifier)`, dans son fichier, avec un `@Preview` privé.
3. Extrais le badge dans `StatusBadge(status, modifier)`, avec son `@Preview`.
4. Extrais le bloc de texte dans `CharacterInfo(name, species, status, modifier)`, qui utilise `StatusBadge`, avec son `@Preview`.
5. Chaque brique reçoit des données simples (jamais le `Character` entier ni un ViewModel). Relis `CharacterCard` : elle ne fait plus qu'assembler.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 18"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-18-mon-travail`.

## Critères de réussite

- [ ] Trois briques, chacune dans son fichier avec son `@Preview` — `CRIT-DMA-D1-SE-3-M4` composables découpés en LEGO.
- [ ] Chaque brique a un seul rôle, dit par son nom — `CRIT-DMA-D1-SF-3-M5` chaque composant a un rôle.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Réutiliser `CharacterAvatar` dans un autre endroit de l'app, pour vérifier qu'elle ne dépend pas de la Card.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-18 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
