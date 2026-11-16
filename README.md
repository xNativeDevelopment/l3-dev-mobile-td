# TD de développement mobile Android — L3

Un seul dépôt pour tous les TD : on le clone une fois, puis on change de branche pour passer d'un TD à l'autre.

## Prérequis

- Android Studio (version stable récente), avec la plateforme Android 37 installée (SDK Manager).
- Le JDK fourni avec Android Studio (JDK 21) ; git.
- Un compte GitHub n'est pas nécessaire pour cloner (il en faut un à partir du TD 02).

## Cloner une fois

    git clone https://github.com/xNativeDevelopment/l3-dev-mobile-td.git

Passer d'abord sur la branche du TD (`git switch td-<nn>-<slug>`), puis ouvrir le dossier `l3-dev-mobile-td` dans Android Studio, une seule fois pour tout le module. Seule exception, le TD 01 : son projet se crée dans ce dossier avec l'assistant d'Android Studio.

Cette adresse fonctionne dès que l'enseignant a publié le dépôt. Avant cela, ou si l'adresse ne répond pas, l'autre moyen de l'obtenir est le dossier que l'enseignant distribue : le copier sur sa machine, puis l'ouvrir de la même façon.

## Changer de branche

Pour commencer le TD <nn> : `git switch td-<nn>-<slug>` (ou, dans Android Studio, Git > Branches, puis Checkout).
Android Studio propose alors de synchroniser le projet Gradle : accepter, attendre la fin, puis Run. Pour garder ton travail avant de passer au TD suivant :
`git switch -c td-<nn>-mon-travail`, puis `git add -A` et `git commit -m "feat: finish TD <nn>"` (`add -A` prend aussi les fichiers neufs).

## Liste des TD

| TD | Titre | Branche de départ | Branche solution |
|---|---|---|---|
| 01 | Premier projet qui démarre | [`td-01-premier-projet`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-01-premier-projet) | [`td-01-premier-projet-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-01-premier-projet-solution) |
| 02 | Mon dépôt de TD | [`td-02-depot-git`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-02-depot-git) | [`td-02-depot-git-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-02-depot-git-solution) |
| 03 | Journal d'apprentissage | [`td-03-routine-ia`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-03-routine-ia) | [`td-03-routine-ia-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-03-routine-ia-solution) |
| 04 | Réparer avec le tuteur | [`td-04-tuteur-android`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android) | [`td-04-tuteur-android-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-04-tuteur-android-solution) |
| 05 | Kotlin en console | [`td-05-kotlin-bases`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-05-kotlin-bases) | [`td-05-kotlin-bases-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-05-kotlin-bases-solution) |
| 06 | Lambdas et nulls | [`td-06-kotlin-lambdas`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-06-kotlin-lambdas) | [`td-06-kotlin-lambdas-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-06-kotlin-lambdas-solution) |
| 07 | Manifest propre | [`td-07-manifest`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-07-manifest) | [`td-07-manifest-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-07-manifest-solution) |
| 08 | Gradle lisible | [`td-08-gradle`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-08-gradle) | [`td-08-gradle-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-08-gradle-solution) |
| 09 | Catalogue de versions | [`td-09-version-catalog`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-09-version-catalog) | [`td-09-version-catalog-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-09-version-catalog-solution) |
| 10 | La Card d'un personnage | [`td-10-composant-card`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-10-composant-card) | [`td-10-composant-card-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-10-composant-card-solution) |
| 11 | L'architecture de mon projet | [`td-11-couches`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-11-couches) | [`td-11-couches-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-11-couches-solution) |
| 12 | Une Application, une Activity | [`td-12-lancement-single-activity`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-12-lancement-single-activity) | [`td-12-lancement-single-activity-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-12-lancement-single-activity-solution) |
| 13 | Premier module Koin | [`td-13-koin`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-13-koin) | [`td-13-koin-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-13-koin-solution) |
| 14 | Une arborescence qui se lit | [`td-14-packages-lint`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-14-packages-lint) | [`td-14-packages-lint-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-14-packages-lint-solution) |
| 15 | Le bon moment | [`td-15-cycle-de-vie`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-15-cycle-de-vie) | [`td-15-cycle-de-vie-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-15-cycle-de-vie-solution) |
| 16 | Quel Context ? | [`td-16-context`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-16-context) | [`td-16-context-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-16-context-solution) |
| 17 | Partager un personnage | [`td-17-intent`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-17-intent) | [`td-17-intent-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-17-intent-solution) |
| 18 | Démonter la Card | [`td-18-lego`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-18-lego) | [`td-18-lego-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-18-lego-solution) |
| 19 | Mon premier écran | [`td-19-ecran`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-19-ecran) | [`td-19-ecran-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-19-ecran-solution) |
| 20 | Deux écrans, une back stack | [`td-20-navigation-3`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-20-navigation-3) | [`td-20-navigation-3-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-20-navigation-3-solution) |
| 21 | Vers le détail | [`td-21-argument-type`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-21-argument-type) | [`td-21-argument-type-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-21-argument-type-solution) |
| 22 | Mon Navigator | [`td-22-navigator`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-22-navigator) | [`td-22-navigator-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-22-navigator-solution) |
| 23 | Chargement sans gel | [`td-23-coroutines`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-23-coroutines) | [`td-23-coroutines-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-23-coroutines-solution) |
| 24 | Screen et ViewModel | [`td-24-screen-viewmodel`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-24-screen-viewmodel) | [`td-24-screen-viewmodel-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-24-screen-viewmodel-solution) |
| 25 | Actions de l'écran | [`td-25-ui-action`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-25-ui-action) | [`td-25-ui-action-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-25-ui-action-solution) |
| 26 | La liste des personnages | [`td-26-liste`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-26-liste) | [`td-26-liste-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-26-liste-solution) |
| 27 | Le détail pense seul | [`td-27-viewmodel-detail`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-27-viewmodel-detail) | [`td-27-viewmodel-detail-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-27-viewmodel-detail-solution) |
| 28 | Message une seule fois | [`td-28-evenement-ponctuel`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-28-evenement-ponctuel) | [`td-28-evenement-ponctuel-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-28-evenement-ponctuel-solution) |
| 29 | Trois modèles | [`td-29-domaine`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-29-domaine) | [`td-29-domaine-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-29-domaine-solution) |
| 30 | Mon repository | [`td-30-repository`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-30-repository) | [`td-30-repository-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-30-repository-solution) |
| 31 | Le service réseau | [`td-31-service-ktor`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-31-service-ktor) | [`td-31-service-ktor-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-31-service-ktor-solution) |
| 32 | Du JSON au domaine | [`td-32-json-dto`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-32-json-dto) | [`td-32-json-dto-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-32-json-dto-solution) |
| 33 | Le mock de secours | [`td-33-mock`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-33-mock) | [`td-33-mock-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-33-mock-solution) |
| 34 | Mes couleurs | [`td-34-couleurs`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-34-couleurs) | [`td-34-couleurs-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-34-couleurs-solution) |
| 35 | Une échelle d'espacements | [`td-35-dimens`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-35-dimens) | [`td-35-dimens-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-35-dimens-solution) |
| 36 | Jour et nuit | [`td-36-theme-clair-sombre`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-36-theme-clair-sombre) | [`td-36-theme-clair-sombre-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-36-theme-clair-sombre-solution) |
| 37 | Deux langues | [`td-37-textes-langue`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-37-textes-langue) | [`td-37-textes-langue-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-37-textes-langue-solution) |
| 38 | Mon design system | [`td-38-design-system`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-38-design-system) | [`td-38-design-system-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-38-design-system-solution) |
| 39 | Documenter la Card | [`td-39-kdoc-composant`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-39-kdoc-composant) | [`td-39-kdoc-composant-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-39-kdoc-composant-solution) |
| 40 | Mon premier Manager | [`td-40-manager`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-40-manager) | [`td-40-manager-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-40-manager-solution) |
| 41 | Oui, non, plus tard | [`td-41-permissions`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-41-permissions) | [`td-41-permissions-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-41-permissions-solution) |
| 42 | Le son du clic | [`td-42-son`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-42-son) | [`td-42-son-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-42-son-solution) |
| 43 | Où suis-je ? | [`td-43-gps`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-43-gps) | [`td-43-gps-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-43-gps-solution) |
| 44 | Étendre le Context | [`td-44-extension-context`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-44-extension-context) | [`td-44-extension-context-solution`](https://github.com/xNativeDevelopment/l3-dev-mobile-td/tree/td-44-extension-context-solution) |

## Où est la solution

Sur la branche `td-<nn>-<slug>-solution`, à ouvrir après avoir essayé. La branche solution d'un TD apparaît après la séance.
Après un clone : `git fetch origin`, puis `git diff td-<nn>-<slug> origin/td-<nn>-<slug>-solution`.
Avec le dossier distribué, les branches solution sont déjà là : pas de `fetch`, et `git diff td-<nn>-<slug> td-<nn>-<slug>-solution`.

## Crédits

- TD 03 et TD 04 : le tuteur s'inspire de `socratic-tutor` (Jane Street), sous licence MIT : voir `NOTICE-socratic-tutor.md` sur ces branches.
- TD 10 à TD 44 : données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
- Autres TD : aucun contenu tiers.
