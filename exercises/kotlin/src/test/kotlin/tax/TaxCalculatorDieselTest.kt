package tax

import kotlin.test.Ignore;
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Month
import kotlin.test.assertEquals

@Ignore
class TaxCalculatorDieselTest {

    private val taxCalculator: TaxCalculator = DummyTaxCalculator()
    private val FIRST_OF_JAN_2019 = LocalDate.of(2019, Month.JANUARY, 1)

    @Test
    fun firstYearsTaxForDiesel_0_grams_co2() {
        val vehicle = Vehicle(0, FuelType.DIESEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(0, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForDiesel_1_to_50_grams_co2() {
        val vehicle = Vehicle(50, FuelType.DIESEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(25, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForDiesel_51_to_75_grams_co2() {
        val vehicle = Vehicle(75, FuelType.DIESEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(105, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForDiesel_76_to_90_grams_co2() {
        val vehicle = Vehicle(90, FuelType.DIESEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(125, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForDiesel_91_to_100_grams_co2() {
        val vehicle = Vehicle(100, FuelType.DIESEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(145, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForDiesel_101_to_110_grams_co2() {
        val vehicle = Vehicle(110, FuelType.DIESEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(165, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForDiesel_111_to_130_grams_co2() {
        val vehicle = Vehicle(130, FuelType.DIESEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(205, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForDiesel_131_to_150_grams_co2() {
        val vehicle = Vehicle(150, FuelType.DIESEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(515, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForDiesel_151_to_170_grams_co2() {
        val vehicle = Vehicle(170, FuelType.DIESEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(830, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForDiesel_171_to_190_grams_co2() {
        val vehicle = Vehicle(190, FuelType.DIESEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(1240, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForDiesel_191_to_225_grams_co2() {
        val vehicle = Vehicle(225, FuelType.DIESEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(1760, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForDiesel_226_to_255_grams_co2() {
        val vehicle = Vehicle(255, FuelType.DIESEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(2070, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForDiesel_over_to_255_grams_co2() {
        val vehicle = Vehicle(256, FuelType.DIESEL, FIRST_OF_JAN_2019, 20000)
        assertEquals(2070, taxCalculator.calculateTax(vehicle))
    }
}