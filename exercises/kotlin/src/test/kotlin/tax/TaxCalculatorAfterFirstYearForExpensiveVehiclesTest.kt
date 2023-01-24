package tax

import kotlin.test.Ignore
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Month
import kotlin.test.assertEquals

@Ignore
class TaxCalculatorAfterFirstYearForExpensiveVehiclesTest {

    private val taxCalculator: TaxCalculator = DummyTaxCalculator()
    private val FIRST_OF_APRIL_2017 = LocalDate.of(2017, Month.APRIL, 1)


    @Test
    fun subsequentYearsTaxForPetrolIfOver40K() {
        val vehicle = Vehicle(206, FuelType.PETROL, FIRST_OF_APRIL_2017, 50000)
        assertEquals(450, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun subsequentYearsTaxForElectricIfOver40K() {
        val vehicle = Vehicle(206, FuelType.ELECTRIC, FIRST_OF_APRIL_2017, 50000)
        assertEquals(310, taxCalculator.calculateTax(vehicle))
    }

    @Test
    fun subsequentYearsTaxForAlternativeFuelIfOver40K() {
        val vehicle = Vehicle(206, FuelType.ALTERNATIVE_FUEL, FIRST_OF_APRIL_2017, 50000)
        assertEquals(440, taxCalculator.calculateTax(vehicle))
    }
}