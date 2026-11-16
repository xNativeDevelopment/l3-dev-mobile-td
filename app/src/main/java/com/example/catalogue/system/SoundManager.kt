package com.example.catalogue.system

// Le Manager du son : l'écran dit quand, le Manager sait comment.
// load() et release() encadrent la vie du lecteur, play() le sert.
interface SoundManager {
    fun load()

    fun play()

    fun release()
}
