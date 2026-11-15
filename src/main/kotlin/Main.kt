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

fun main() {
    val rick = Character(1, "Rick", Status.ALIVE)
    val ghost = Character(2, "Fantôme", Status.UNKNOWN)
    for (character in listOf(rick, ghost)) {
        println("${describe(character)} : ${statusLabel(character.status)}, vivant ? ${isAlive(character)}")
    }
}
