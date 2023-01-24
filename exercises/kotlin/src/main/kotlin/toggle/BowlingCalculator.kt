package toggle

class BowlingCalculator (private val spareScoring: Boolean) {

    fun score(vararg bowls: Int): Int {
        var score = 0
        if (spareScoring) {
            // Work in progress
            for (bowl in bowls.indices) {
                if (bowl >= 2 && bowls[bowl - 1] + bowls[bowl - 2] == 10) {
                    score += bowls[bowl]
                }
                score += bowls[bowl]
            }
        } else {
            for (bowl in bowls) {
                score += bowl
            }
        }
        return score
    }
}