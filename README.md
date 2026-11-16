# TD 19 — Mon premier écran

Slide : S-19 — Créer un écran : `xScreen.kt` avec Screen public, Content et Preview privés · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-19-ecran
État du build : départ construit · solution construite

## Objectif

À la fin, je sais construire un écran en trois fonctions, bien nommé, dont seule la Screen est publique.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-19-ecran` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-19-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 18 (branche `td-18-lego-solution`) : la Card est découpée en briques, mais `MainActivity` n'affiche qu'un personnage.
La solution est sur la branche `td-19-ecran-solution`.

## Étapes

1. Crée `ui/CharacterListScreen.kt`. Le nom dit le rôle : un écran, qui montre une liste de personnages.
2. Écris `CharacterListContent(characters, onShare, modifier)`, **privée** : elle affiche une `Column` de `CharacterCard`, sans rien décider.
3. Écris `CharacterListScreen(characters, onShare, modifier)`, **publique** : elle appelle `CharacterListContent`. Le ViewModel viendra s'y brancher.
4. Écris `CharacterListPreview`, **privée**, avec `@Preview` et des personnages fictifs : l'écran s'affiche sans lancer l'app.
5. Dans `MainActivity`, remplace la Card seule par `CharacterListScreen(catalog.all(), …)`. Le partage du TD 17 doit toujours marcher.
6. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 19"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-19-mon-travail`.

## Critères de réussite

- [ ] Le fichier `CharacterListScreen.kt` contient trois fonctions, et seule la Screen est publique — `CRIT-DMA-D1-SF-3-M4` Screen.kt séparé du reste.
- [ ] `CharacterListContent` ne contient que de l'affichage, aucune logique métier — `CRIT-DMA-D1-SF-3-M5` chaque composant a un rôle.
- [ ] Les noms disent ce qu'ils sont (`…Screen`, `…Content`, `…Preview`) — `CRIT-DMA-D1-SE-3-M2` écrans bien nommés.
- [ ] Tout le Compose reste dans le paquet `ui` ; `domain` et `data` n'importent rien de Compose — `CRIT-DMA-D1-SF-2-M2` UI rassemblée, rien ne fuit.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajouter un titre dans `CharacterListContent` et le voir dans l'aperçu.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-19 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
