package tax

import kotlin.test.Ignore
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Month
import kotlin.test.assertEquals

@Ignore
class TaxCalculatorAfterFirstYearTest {

    private val taxCalculator: TaxCalculator = DummyTaxCalculator()
    private val FIRST_OF_APRIL_2017 = LocalDate.of(2017, Month.APRIL, 1)

    @Test
    fun subsequentYearsTaxForPetrol() {
        val vehicle = Vehicle(206, FuelType.PETROL, FIRST_OF_APRIL_2017, 20000)

        assertEquals(140, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun subsequentYearsTaxForElectric() {
        val vehicle = Vehicle(206, FuelType.ELECTRIC, FIRST_OF_APRIL_2017, 20000)
        assertEquals(0, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun subsequentYearsTaxForAlternativeFuel() {
        val vehicle = Vehicle(206, FuelType.ALTERNATIVE_FUEL, FIRST_OF_APRIL_2017, 20000)
        assertEquals(130, taxCalculator.calculateTax(vehicle))
    }
}