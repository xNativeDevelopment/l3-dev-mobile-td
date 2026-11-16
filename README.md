# TD 42 — Le son du clic

Slide : S-42 — Première capacité : émettre un son au clic, et libérer le lecteur au bon moment · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-42-son
État du build : départ à vérifier · solution à vérifier

## Objectif

À la fin, je sais jouer un son court depuis un Manager déclenché par une action de l'écran, et le libérer au moment du cycle de vie que je justifie en commentaire.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert, `git switch td-42-son`. Crée ta branche de travail : `git switch -c td-42-mon-travail`. Synchronise Gradle, puis Run.
Cette branche reprend l'état final du TD 41 (branche `td-41-permissions-solution`) et ajoute un son court : `res/raw/click.wav`.
La solution est sur la branche `td-42-son-solution`.

## Étapes

1. Dans `system/`, écris l'interface `SoundManager` : `load()`, `play()` et `release()`.
2. Écris `SoundPoolSoundManager` : un `SoundPool` créé une seule fois dans `load()`, qui charge `R.raw.click`. `play()` attend que le son soit chargé. Ajoute un `Log.d` dans chaque fonction.
3. Reste muet en mode silencieux : lis le mode sonnerie avec `ContextCompat.getSystemService`, déjà disponible. Ne l'ajoute pas au catalogue.
4. Déclare le Manager dans Koin et passe-le au ViewModel. Les actions `OnStarted` et `OnStopped` appellent `load()` et `release()` ; `OnCharacterClicked` appelle `play()`.
5. Dans `CharacterListScreen`, deux `LifecycleEventEffect` : `ON_START` envoie `OnStarted`, `ON_STOP` envoie `OnStopped`. Commente : pourquoi pas `onDestroy` ?
6. Lance l'app, touche une Card, et filtre Logcat sur `SoundManager`.
7. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 42"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-42-mon-travail`.

## Critères de réussite

- [ ] Le son est chargé une fois et joué par une action de l'écran, sans lecteur à chaque clic — `CRIT-DMA-D1-SF-4-M1` première des deux capacités natives
- [ ] Le lecteur est libéré à `ON_STOP`, avec un commentaire qui dit pourquoi — `CRIT-DMA-D1-SF-1-M5` cycle de vie judicieux, commenté
- [ ] `ContextCompat` n'est pas déclaré dans `libs.versions.toml`.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Charge le son dans `ON_CREATE` à la place : que change la rotation de l'écran ?

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-42 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
