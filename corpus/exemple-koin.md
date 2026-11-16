# Fiche de corpus — Koin (exemple)

*Fiche d'exemple : à lire pour voir le format, pas à recopier.*

## Ce que j'ai fait

- Déclaré `koin-android` dans `gradle/libs.versions.toml`, puis dans `app/build.gradle.kts`.
- Écrit `di/AppModule.kt` : un `single` par objet partagé, un `factory` pour un objet neuf à chaque demande.
- Appelé `startKoin` dans `CatalogueApplication`, une seule fois.

## Ce que j'ai compris

Le module est le seul endroit qui construit les classes de la couche `data`. Une classe reçoit ses dépendances par son constructeur : elle ne sait pas qui les a créées, ce qui permet de changer d'implémentation en une ligne.

## Le piège rencontré

Démarrer Koin dans l'Activity : il redémarre à chaque rotation. On le reconnaît à un plantage « déjà démarré » ou à des objets recréés après un changement d'orientation.
