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

fun originLabel(detail: CharacterDetail): String =
    detail.origin?.uppercase() ?: "origine inconnue"

fun episodesLabel(detail: CharacterDetail): String =
    "${detail.episodeCount ?: 0} épisode(s)"

fun main() {
    val rick = Character(1, "Rick", Status.ALIVE)
    val ghost = Character(2, "Fantôme", Status.UNKNOWN)
    forEachCharacter(listOf(rick, ghost)) {
        println("${describe(it)} : ${statusLabel(it.status)}")
    }
    val details = listOf(
        CharacterDetail("Rick", "Terre", 51),
        CharacterDetail("Fantôme", null, null),
    )
    for (detail in details) {
        println("${detail.name} : ${originLabel(detail)}, ${episodesLabel(detail)}")
    }
}
