# TD 21 — Vers le détail

Slide : S-21 — Naviguer de la liste au détail avec un argument typé · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-21-argument-type
État du build : départ construit · solution construite

## Objectif

À la fin, je sais porter l'identifiant d'un élément dans la clé de navigation et le lire sur l'écran de détail.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-21-argument-type` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-21-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 20 (branche `td-20-navigation-3-solution`) : un bouton ouvre un détail, mais ce détail ne sait pas de quel personnage il s'agit.
La solution est sur la branche `td-21-argument-type-solution`.

## Étapes

1. Dans `CharacterCatalog`, ajoute `byId(id: Int): Character?` : elle retrouve un personnage par son identifiant.
2. Dans `navigation/Keys.kt`, transforme `DetailKey` en `data class DetailKey(val id: Int) : NavKey`, toujours `@Serializable`. Seul l'identifiant voyage, jamais le personnage entier.
3. Rends chaque Card cliquable dans `CharacterListContent` : le clic appelle `onOpenDetail(character.id)`, et la Screen ajoute `DetailKey(id)` à la back stack. Supprime le bouton du TD 20.
4. Dans l'`entryProvider`, écris `entry<DetailKey> { key -> … }`, retrouve le personnage avec `catalog.byId(key.id)` et passe-le à `CharacterDetailScreen`.
5. Fais de `CharacterDetailScreen` un écran en trois fonctions (TD 19) : il affiche le nom, l'espèce et le statut, ou « Personnage introuvable » si l'identifiant est inconnu.
6. Lance l'app : chaque Card ouvre le détail du bon personnage, et retour système revient à la liste.
7. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 21"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-21-mon-travail`.

## Critères de réussite

- [ ] `DetailKey` porte un `id` et reste `@Serializable`.
- [ ] Un clic sur la Card du deuxième personnage ouvre le détail du deuxième personnage.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Tourner l'écran sur le détail d'un personnage : vérifier qu'il reste le même, puisque l'identifiant est dans la back stack sauvegardée.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-21 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
