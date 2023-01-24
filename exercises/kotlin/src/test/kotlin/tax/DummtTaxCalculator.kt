package tax

// DO NOT MAKE ANY CHANGES TO THIS CLASS - IT IS JUST HERE TO KEEP THE TESTS HAPPY TO BEGIN WITH
// DON'T BE LAZY - WRITE YOUR OWN NEW TAXCALCULATOR CLASS
@Deprecated("")
class DummyTaxCalculator : TaxCalculator() {
    override fun calculateTax(vehicle: Vehicle?): Int {
        return -1
    }
}