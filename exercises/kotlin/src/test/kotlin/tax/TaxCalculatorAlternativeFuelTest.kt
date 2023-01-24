package tax

import kotlin.test.Ignore
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Month
import kotlin.test.assertEquals

@Ignore
class TaxCalculatorAlternativeFuelTest {

    private val taxCalculator: TaxCalculator = DummyTaxCalculator()
    private val FIRST_OF_JAN_2019 = LocalDate.of(2019, Month.JANUARY, 1)


    @Test
    fun firstYearsTaxForAlternativeFuel_0_grams_co2() {
        val vehicle = Vehicle(0, FuelType.ALTERNATIVE_FUEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(0, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForAlternativeFuel_1_to_50_grams_co2() {
        val vehicle = Vehicle(50, FuelType.ALTERNATIVE_FUEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(0, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForAlternativeFuel_51_to_75_grams_co2() {
        val vehicle = Vehicle(75, FuelType.ALTERNATIVE_FUEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(15, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForAlternativeFuel_76_to_90_grams_co2() {
        val vehicle = Vehicle(90, FuelType.ALTERNATIVE_FUEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(95, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForAlternativeFuel_91_to_100_grams_co2() {
        val vehicle = Vehicle(100, FuelType.ALTERNATIVE_FUEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(115, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForAlternativeFuel_101_to_110_grams_co2() {
        val vehicle = Vehicle(110, FuelType.ALTERNATIVE_FUEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(135, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForAlternativeFuel_111_to_130_grams_co2() {
        val vehicle = Vehicle(130, FuelType.ALTERNATIVE_FUEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(155, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForAlternativeFuel_131_to_150_grams_co2() {
        val vehicle = Vehicle(150, FuelType.ALTERNATIVE_FUEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(195, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForAlternativeFuel_151_to_170_grams_co2() {
        val vehicle = Vehicle(170, FuelType.ALTERNATIVE_FUEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(505, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForAlternativeFuel_171_to_190_grams_co2() {
        val vehicle = Vehicle(190, FuelType.ALTERNATIVE_FUEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(820, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForAlternativeFuel_191_to_225_grams_co2() {
        val vehicle = Vehicle(225, FuelType.ALTERNATIVE_FUEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(1230, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForAlternativeFuel_226_to_255_grams_co2() {
        val vehicle = Vehicle(255, FuelType.ALTERNATIVE_FUEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(1750, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForAlternativeFuel_over_255_grams_co2() {
        val vehicle = Vehicle(256, FuelType.ALTERNATIVE_FUEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(2060, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForElectric() {
        val vehicle = Vehicle(0, FuelType.ELECTRIC, FIRST_OF_JAN_2019, 20000)
        assertEquals(0, taxCalculator.calculateTax(vehicle))
    }
}