# TD 43 — Où suis-je ?

Slide : S-43 — Deuxième capacité : lire la position GPS · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-43-gps
État du build : départ construit · solution construite

## Objectif

À la fin, je sais obtenir la position courante dans un `LocationManager` maison, après permission accordée.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert, `git switch td-43-gps`. Crée ta branche de travail : `git switch -c td-43-mon-travail`. Synchronise Gradle, puis Run.
Cette branche reprend l'état final du TD 42 (branche `td-42-son-solution`) : le Manager, la permission `ACCESS_COARSE_LOCATION` et son bouton existent déjà.
La solution est sur la branche `td-43-gps-solution`.

## Étapes

1. Ajoute `play-services-location` en version `21.4.0` dans `gradle/libs.versions.toml`, puis dans `app/build.gradle.kts`. Rien d'autre : pas `kotlinx-coroutines-play-services`.
2. Dans `system/`, écris l'interface `LocationManager` : une fonction `suspend` qui rend la position, ou `null`.
3. Écris `FusedLocationManager`, qui garde le Context de l'Application. Sans la permission, il rend `null`. Sinon il appelle `getCurrentLocation` avec `PRIORITY_BALANCED_POWER_ACCURACY` : la position approximative suffit.
4. Le résultat de `getCurrentLocation` arrive dans un callback. Enveloppe-le avec `suspendCancellableCoroutine` et annule la demande dans `invokeOnCancellation`.
5. Déclare le Manager dans Koin et passe-le au ViewModel. Une action `OnLocateClicked` lance la demande dans `viewModelScope` ; l'état garde la position, ou un message si elle manque.
6. Ajoute un bouton « Où suis-je ? » dans `CharacterListScreen`, qui affiche latitude et longitude.
7. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 43"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-43-mon-travail`.

## Critères de réussite

- [ ] La position s'affiche après un clic, lue par le Manager et non par l'écran — `CRIT-DMA-D1-SF-4-M1` deuxième capacité native
- [ ] Sans permission accordée, le Manager rend `null` et l'écran le dit.
- [ ] Seul `play-services-location` s'ajoute au catalogue.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Demande `ACCESS_FINE_LOCATION` : que change la boîte de dialogue ?

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-43 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Bibliothèque : `play-services-location` 21.4.0 (Google). La position n'a pas été observée ici sur un appareil.
Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
