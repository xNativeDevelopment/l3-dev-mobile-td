# TD 40 — Mon premier Manager

Slide : S-40 — Encapsuler une capacité native dans un Manager · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-40-manager
État du build : départ à vérifier · solution à vérifier

## Objectif

À la fin, je sais écrire un Manager qui cache l'accès au matériel derrière une interface, commenté, hors de la couche UI.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert, `git switch td-40-manager`. Crée ta branche de travail : `git switch -c td-40-mon-travail`. Synchronise Gradle, puis Run.
Cette branche reprend l'état final du TD 39 (branche `td-39-kdoc-composant-solution`) : l'app n'a encore aucune couche pour parler au matériel.
La solution est sur la branche `td-40-manager-solution`.

## Étapes

1. Dans le package `system`, crée `DeviceManager.kt` : une interface avec une seule fonction, `isReady()`. Ajoute un commentaire qui dit pourquoi l'écran ne parle qu'à elle.
2. Crée `AndroidDeviceManager.kt` : elle reçoit le Context de l'Application par son constructeur, jamais celui d'une Activity. Commente ce choix.
3. Dans `di/AppModule.kt`, déclare un `single<DeviceManager>` qui lui passe `androidContext()`.
4. Ajoute `DeviceManager` au constructeur de `CharacterListViewModel`, puis un troisième `get()` dans sa déclaration Koin.
5. Ajoute l'action `OnManagerClicked` : le ViewModel appelle `isReady()` et met un message dans l'état. Ajoute le bouton et ce message dans `CharacterListScreen`, avec leurs textes dans les deux `strings.xml`.
6. Lance l'app, touche le bouton, puis filtre Logcat sur `DeviceManager`.
7. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 40"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-40-mon-travail`.

## Critères de réussite

- [ ] Une interface cache l'accès au matériel, et son code est hors du package `ui` — `CRIT-DMA-D1-SE-4-M1` Managers pour les capacités natives
- [ ] Chaque Manager porte un commentaire qui dit pourquoi il existe — `CRIT-DMA-D1-SE-4-M3` commentaires des Managers clairs
- [ ] Aucun composable n'appelle un service système : seul le Manager le fera — `CRIT-DMA-D1-SF-4-M2` accès natif centralisé, détaché de l'UI
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Écris un faux `DeviceManager` et branche-le dans Koin : l'écran ne doit pas changer.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-40 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
