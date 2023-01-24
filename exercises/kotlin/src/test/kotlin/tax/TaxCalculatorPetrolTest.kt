package tax

import kotlin.test.Ignore
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Month
import kotlin.test.assertEquals

@Ignore
class TaxCalculatorPetrolTest {

    private val taxCalculator: TaxCalculator = DummyTaxCalculator()
    private val FIRST_OF_JAN_2019 = LocalDate.of(2019, Month.JANUARY, 1)

    @Test
    fun firstYearsTaxForPetrol_0_grams_co2() {
        val vehicle = Vehicle(0, FuelType.PETROL, FIRST_OF_JAN_2019, 20000)
        assertEquals(0, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForPetrol_1_to_50_grams_co2() {
        val vehicle = Vehicle(50, FuelType.PETROL, FIRST_OF_JAN_2019, 20000)
        assertEquals(10, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForPetrol_51_to_75_grams_co2() {
        val vehicle = Vehicle(75, FuelType.PETROL, FIRST_OF_JAN_2019, 20000)
        assertEquals(25, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForPetrol_76_to_90_grams_co2() {
        val vehicle = Vehicle(90, FuelType.PETROL, FIRST_OF_JAN_2019, 20000)
        assertEquals(105, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForPetrol_91_to_100_grams_co2() {
        val vehicle = Vehicle(100, FuelType.PETROL, FIRST_OF_JAN_2019, 20000)
        assertEquals(125, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForPetrol_101_to_110_grams_co2() {
        val vehicle = Vehicle(110, FuelType.PETROL, FIRST_OF_JAN_2019, 20000)
        assertEquals(145, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForPetrol_111_to_130_grams_co2() {
        val vehicle = Vehicle(130, FuelType.PETROL, FIRST_OF_JAN_2019, 20000)
        assertEquals(165, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForPetrol_131_to_150_grams_co2() {
        val vehicle = Vehicle(150, FuelType.PETROL, FIRST_OF_JAN_2019, 20000)
        assertEquals(205, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForPetrol_151_to_170_grams_co2() {
        val vehicle = Vehicle(170, FuelType.PETROL, FIRST_OF_JAN_2019, 20000)
        assertEquals(515, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForPetrol_171_to_190_grams_co2() {
        val vehicle = Vehicle(190, FuelType.PETROL, FIRST_OF_JAN_2019, 20000)
        assertEquals(830, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForPetrol_191_to_225_grams_co2() {
        val vehicle = Vehicle(225, FuelType.PETROL, FIRST_OF_JAN_2019, 20000)
        assertEquals(1240, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForPetrol_226_to_255_grams_co2() {
        val vehicle = Vehicle(255, FuelType.PETROL, FIRST_OF_JAN_2019, 20000)
        assertEquals(1760, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun firstYearsTaxForPetrol_over_255_grams_co2() {
        val vehicle = Vehicle(256, FuelType.PETROL, FIRST_OF_JAN_2019, 20000)
        assertEquals(2070, taxCalculator.calculateTax(vehicle))
    }
}