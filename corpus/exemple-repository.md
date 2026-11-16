# Fiche de corpus — Repository (exemple)

*Fiche d'exemple : à lire pour voir le format, pas à recopier.*

## Ce que j'ai fait

- Défini l'interface `CharacterRepository` dans `domain/`.
- Écrit `ApiCharacterRepository` dans `data/`, qui s'appuie sur un `CharacterService`.
- Fourni le repository en `single` dans `AppModule`, reçu par les ViewModels.

## Ce que j'ai compris

Le ViewModel ne sait pas d'où viennent les données : il parle à l'interface. Le service peut devenir un mock quand l'API manque, sans toucher à l'écran.

## Le piège rencontré

Laisser le ViewModel appeler le service directement : le jour où la source change, tous les écrans changent. Le repository est la seule porte vers les données.
