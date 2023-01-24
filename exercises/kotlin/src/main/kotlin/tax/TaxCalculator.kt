package tax

import java.time.LocalDate

abstract class TaxCalculator (val year: Int = LocalDate.now().year) {

    abstract fun calculateTax(vehicle: Vehicle?): Int
}