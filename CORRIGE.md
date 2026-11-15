# Corrigé — TD 03

## Les quatre points

1. **Vrai.** `isEmpty()` est testé avant la division : une liste vide renvoie `0.0`.
2. **Faux.** `sumOf` et `size` sont des entiers : la division est entière, elle tronque, puis `.toDouble()` convertit trop tard. Pour 3 et 2 épisodes, le résultat est `2.0` et non `2.5`. Correctif : `sumOf { it.episodes }.toDouble() / characters.size`.
3. **Vrai.** `maxByOrNull` renvoie le premier élément maximal, ou `null` si la liste est vide.
4. **Vrai.** `map` crée une nouvelle liste ; `sorted()` en renvoie une copie triée.

## La question utile

Une bonne question de l'IA ressemble à : « Quel est le type de `sumOf` et celui de `size` ? Que donne `5 / 2` en Kotlin ? »
