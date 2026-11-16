package com.example.catalogue.system

// Le Manager est la seule porte vers le matériel : l'écran ne parle qu'à
// cette interface, jamais à un service système. On peut ainsi remplacer
// l'implémentation (un faux, un autre capteur) sans toucher à l'écran.
interface DeviceManager {
    // Vrai quand le Manager est prêt. Il n'a encore aucune capacité :
    // les TD suivants lui en donnent une.
    fun isReady(): Boolean
}
