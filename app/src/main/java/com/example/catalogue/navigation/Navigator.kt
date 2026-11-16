package com.example.catalogue.navigation

/**
 * Les intentions de navigation de l'app, rien d'autre.
 *
 * Un écran reçoit un Navigator et dit où il veut aller ; il ne sait
 * ni comment on y va, ni ce que contient la back stack.
 */
interface Navigator {
    /** Ouvre le détail du personnage dont l'identifiant est [id]. */
    fun goToDetail(id: Int)

    /** Revient à l'écran précédent ; sans effet depuis la liste. */
    fun back()
}
