# TD 45 — Mon corpus

Slide : S-45 — Tenir son corpus personnel et répliquer un squelette · Dépôt : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-45-corpus
État du build : départ à vérifier · solution à vérifier

## Objectif

À la fin, je sais garder une fiche par sous-sujet du deck et en tirer un squelette d'écran que je réplique.

## Point de départ

Cloner une fois, changer de branche : dans le dossier `l3-dev-mobile-td` déjà ouvert dans Android Studio, `git switch td-45-corpus` (pas de nouveau clone). Crée ta branche de travail : `git switch -c td-45-mon-travail`. Synchroniser Gradle quand Android Studio le propose, puis Run.
Cette branche reprend l'état final du TD 44 (branche `td-44-extension-context-solution`) et ajoute un dossier `corpus/` avec une fiche modèle vide.
La solution est sur la branche `td-45-corpus-solution`.

## Étapes

1. Ouvre `corpus/FICHE-MODELE.md` : trois rubriques, ce que j'ai fait, ce que j'ai compris, le piège rencontré.
2. Copie-la en `corpus/koin.md` et remplis-la avec tes mots pour le TD 13. Ne recopie pas la slide : reformule.
3. Fais de même pour quatre autres sous-sujets de ton choix : cinq fiches en tout, une par sous-sujet.
4. Prends l'écran de détail comme squelette : `Screen`, `ViewModel`, `UiState` et `UiAction` dans `ui/`. Réplique-le pour un écran « À propos » (`AboutScreen`, `AboutViewModel`, `AboutUiState`, `AboutUiAction`).
5. Branche l'écran : une clé dans `navigation/`, son entrée dans `AppNavigation`, son `viewModel` dans `di/AppModule.kt`, ses textes en français et en anglais, un bouton dans la liste.
6. Lance l'app : ouvre l'écran, puis reviens à la liste.
7. Garde ton travail : `git add -A`, puis `git commit -m "feat: finish TD 45"`. Sans ce commit, git refuse de passer au TD suivant.

Facultatif, vers ton fork (TD 02) : `git push -u perso td-45-mon-travail`.

## Critères de réussite

- [ ] Cinq fiches existent dans `corpus/`, chacune avec ses trois rubriques et écrite avec tes mots.
- [ ] Le nouvel écran suit le squelette : une `Screen` publique, un `Content` privé, un `ViewModel` qui écrit l'état.
- [ ] Le projet se construit (Build > Make Project) sans erreur.

## Pour aller plus loin

- Ajoute une sixième fiche pour le sous-sujet où tu as perdu le plus de temps.

## Avec le tuteur

Facultatif. Colle le contenu de `SKILL.md` (lien ci-dessous) au début d'une conversation avec ton assistant, puis écris « séance tuteur, slide S-45 » ; reprends ton état avec `resume from:` et ton `TUTOR-STATE.md`.
Le tuteur : https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android/tuteur-android
Sans tuteur : la routine en quatre temps et l'invite courte du TD 03.

## Crédits

Données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
