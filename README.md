# TD de développement mobile Android — L3

Un seul dépôt pour tous les TD : on le clone une fois, puis on change de branche pour passer d'un TD à l'autre.

## Prérequis

- Android Studio (version stable récente), avec la plateforme Android 37 installée (SDK Manager).
- Le JDK fourni avec Android Studio (JDK 21) ; git.
- Un compte GitHub n'est pas nécessaire pour cloner.

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

## Où est la solution

Sur la branche `td-<nn>-<slug>-solution`, à ouvrir après avoir essayé. Pour voir ce qui change :
`git diff td-<nn>-<slug> td-<nn>-<slug>-solution`.
La branche solution d'un TD apparaît après la séance : `git fetch origin`, puis `git switch td-<nn>-<slug>-solution`.

## Crédits

- TD 03 et TD 04 : le tuteur s'inspire de `socratic-tutor` (Jane Street), sous licence MIT : voir `NOTICE-socratic-tutor.md` sur ces branches.
- TD 10 à TD 13 : données d'exemple au format de The Rick and Morty API (https://rickandmortyapi.com/).
- Autres TD : aucun contenu tiers.
