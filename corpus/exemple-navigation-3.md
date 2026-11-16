# Fiche de corpus — Navigation 3 (exemple)

*Fiche d'exemple : à lire pour voir le format, pas à recopier.*

## Ce que j'ai fait

- Déclaré une clé sérialisable par écran dans `navigation/Keys.kt`.
- Écrit `AppNavigation` : un `NavDisplay` et une `entry` par clé.
- Gardé la back stack dans `BackStackNavigator`, fourni en `single` par Koin.

## Ce que j'ai compris

Avec Navigation 3, la back stack est une simple liste que l'app possède. Les écrans demandent où aller par l'interface `Navigator` et ne voient jamais la liste.

## Le piège rencontré

Passer un objet entier dans la clé au lieu de son identifiant : la clé grossit et se périme. On n'y met que l'identifiant, le détail recharge le reste.
