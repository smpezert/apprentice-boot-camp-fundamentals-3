<?php

namespace McrDigital\PhpFundamentals3\Tax;

use DateTime;
use PHPUnit\Framework\TestCase;

require_once "DummyTaxCalculator.php";

class TaxCalculatorAfterFirstYearForExpensiveVehiclesTest extends TestCase
{
    private static DateTime $FIRST_OF_APRIL_2017;
    private TaxCalculator $taxCalculator;

    protected function setUp(): void
    {
        self::$FIRST_OF_APRIL_2017 = new DateTime("2017-04-01");
        $this->taxCalculator = new DummyTaxCalculator();
    }

    public function testSubsequentYearsTaxForPetrolIfOver40K(): void
    {
        $vehicle = new Vehicle(206, FuelType::PETROL, self::$FIRST_OF_APRIL_2017, 50000);

        $this->assertEquals(450, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testSubsequentYearsTaxForElectricIfOver40K(): void
    {
        $vehicle = new Vehicle(206, FuelType::ELECTRIC, self::$FIRST_OF_APRIL_2017, 50000);

        $this->assertEquals(310, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testSubsequentYearsTaxForAlternativeFuelIfOver40K(): void
    {
        $vehicle = new Vehicle(206, FuelType::ALTERNATIVE_FUEL, self::$FIRST_OF_APRIL_2017, 50000);

        $this->assertEquals(440, $this->taxCalculator->calculateTax($vehicle));
    }
}
