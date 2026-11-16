# Catalogue

## But de l'app

Catalogue affiche une liste de personnages au format de The Rick and Morty API, permet de la filtrer, d'ouvrir le détail d'un personnage et de le partager. Il sert aussi de projet fil rouge : chaque couche y a un rôle précis, pour que le code reste lisible par le développeur suivant.

## Arborescence par couche

Tout vit sous `app/src/main/java/com/example/catalogue/`.

| Dossier | Rôle | Pourquoi il est séparé |
|---|---|---|
| `domain/` | les modèles (`Character`) et le contrat `CharacterRepository` | il ne dépend ni d'Android, ni du réseau : c'est le vocabulaire commun |
| `data/` | le repository, les services (Ktor, mock) et les DTO | seul endroit qui connaît la forme de l'API |
| `di/` | `AppModule`, le module Koin | seul endroit qui construit les classes de `data` et choisit les implémentations |
| `navigation/` | les clés, `Navigator`, `BackStackNavigator`, `AppNavigation` | les écrans disent où aller sans connaître la back stack |
| `system/` | les Managers (son, position, appareil) et l'extension `Context.hasPermission` | tout ce qui touche au matériel et au Context reste hors des écrans |
| `ui/` | les écrans, leurs ViewModels, leurs `UiState` et `UiAction`, le thème et le design system | ce que l'utilisateur voit et les gestes qu'il fait |

Les ressources (`res/`) portent les textes en français et en anglais, les couleurs, les dimensions et le thème clair et sombre. Le dossier `corpus/` n'appartient pas à l'app : il contient les fiches de travail.

## Le flux d'un geste

```text
Screen -> ViewModel -> repository -> service
  ^           |
  +-- UiState +
```

1. La `Screen` affiche un `UiState` et remonte chaque geste sous forme d'`UiAction`.
2. Le `ViewModel` reçoit l'action, appelle le repository, puis remplace son `UiState`.
3. Le repository (`CharacterRepository`) demande les données au service et rend des modèles de domaine.
4. Le service (`CharacterService`) parle à l'API avec Ktor, ou renvoie des données de démonstration quand l'API manque.

L'état descend, les actions remontent : le flux va dans un seul sens, ce qui rend chaque écran prévisible.

## Choix techniques et raisons

- **Koin 4.2.2** : les dépendances arrivent par le constructeur et le module est le seul à construire. Changer de service, c'est changer une ligne.
- **Navigation 3 1.1.7** : la back stack est une liste que l'app possède, derrière l'interface `Navigator`.
- **ViewModel et StateFlow** : l'état survit à la rotation et un seul objet l'écrit.
- **Ktor 3.6.0** : un client réseau unique, fourni par Koin, derrière un service remplaçable par un mock.
- **Jetpack Compose** : un écran se découpe en `Screen` publique et `Content` privé, ce qui permet les aperçus sans lancer l'app.
- **Fonctions `suspend`** : le repository ne bloque jamais le fil principal.
