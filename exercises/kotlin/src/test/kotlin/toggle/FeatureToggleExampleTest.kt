package toggle

import kotlin.test.Ignore
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FeatureToggleExampleTest {

    @Test
    fun simpleScoring() {
        val bowlingCalculator = BowlingCalculator(false)
        assertEquals(bowlingCalculator.score(0, 0, 0, 0, 0, 0),0)
        assertEquals(bowlingCalculator.score(1, 1, 1, 1, 1, 1),6)
        assertEquals(bowlingCalculator.score(5, 5, 5, 5, 5, 5),30)
    }

    @Test
    @Ignore
    fun spareScoring() {
        val bowlingCalculator = BowlingCalculator(true)
        assertEquals(bowlingCalculator.score(5, 5, 5, 5, 5, 5),40)
    }
}