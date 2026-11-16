# Fiche de corpus — Un écran (exemple)

*Fiche d'exemple : à lire pour voir le format, pas à recopier.*

## Ce que j'ai fait

- Écrit `CharacterDetailScreen.kt` avec une `Screen` publique, un `Content` privé et une `Preview` privée.
- Passé à `Content` l'état et les lambdas, jamais le ViewModel.

## Ce que j'ai compris

La `Screen` branche l'écran sur son ViewModel ; le `Content` ne fait qu'afficher ce qu'il reçoit. Grâce à cette coupure, la `Preview` s'affiche avec un état fictif, sans lancer l'app.

## Le piège rencontré

Rendre le `Content` public et lui donner le ViewModel : l'aperçu ne s'affiche plus, car il faudrait fabriquer un ViewModel pour le montrer.
