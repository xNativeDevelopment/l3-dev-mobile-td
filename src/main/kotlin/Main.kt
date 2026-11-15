data class Character(
    val id: Int,
    val name: String,
    val status: Status,
)

enum class Status { ALIVE, DEAD, UNKNOWN }

fun describe(character: Character): String =
    "${character.name} (#${character.id})"

fun statusLabel(status: Status): String = when (status) {
    Status.ALIVE -> "vivant"
    Status.DEAD -> "mort"
    Status.UNKNOWN -> "inconnu"
}

fun isAlive(character: Character): Boolean = character.status == Status.ALIVE

// TD 06 : lambdas et nullabilité.
data class CharacterDetail(val name: String, val origin: String?, val episodeCount: Int?)

fun forEachCharacter(
    characters: List<Character>,
    onEach: (Character) -> Unit,
) {
    for (character in characters) onEach(character)
}

// TODO 2 : écrire `originLabel(detail: CharacterDetail): String` avec `?.` et `?:`, sans `!!`.

// TODO 3 : écrire `episodesLabel(detail: CharacterDetail): String` avec `?:`, sans `!!`.

fun main() {
    // TODO 4 : remplacer la boucle ci-dessous par un appel à `forEachCharacter` avec une lambda.
    // TODO 5 : créer deux `CharacterDetail`, l'un complet, l'autre avec des champs `null`, et les afficher.
    val rick = Character(1, "Rick", Status.ALIVE)
    val ghost = Character(2, "Fantôme", Status.UNKNOWN)
    for (character in listOf(rick, ghost)) {
        println("${describe(character)} : ${statusLabel(character.status)}, vivant ? ${isAlive(character)}")
    }
}
