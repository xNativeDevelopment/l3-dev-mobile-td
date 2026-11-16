# Fiche de corpus — ViewModel et UiState (exemple)

*Fiche d'exemple : à lire pour voir le format, pas à recopier.*

## Ce que j'ai fait

- Écrit un `UiState` en `data class` et un `UiAction` en `sealed interface`.
- Écrit un ViewModel qui garde un `MutableStateFlow` privé et expose un `StateFlow`.
- Lu l'état dans la `Screen` avec `collectAsStateWithLifecycle`.

## Ce que j'ai compris

L'état descend vers l'écran, les actions remontent vers le ViewModel : le flux va dans un seul sens. Le ViewModel est le seul à écrire l'état, avec `update` et `copy`.

## Le piège rencontré

Écrire un nouvel `UiState` à la main au lieu de `copy` : un champ oublié repart à sa valeur par défaut. On le voit quand un filtre se vide après un rechargement.
