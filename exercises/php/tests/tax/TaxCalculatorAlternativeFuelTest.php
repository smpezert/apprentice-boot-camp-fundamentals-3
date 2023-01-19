<?php

namespace McrDigital\PhpFundamentals3\Tax;

use DateTime;
use PHPUnit\Framework\TestCase;

require_once "DummyTaxCalculator.php";

class TaxCalculatorAlternativeFuelTest extends TestCase
{
    private static DateTime $FIRST_OF_JAN_2019;
    private TaxCalculator $taxCalculator;

    protected function setUp(): void
    {
        self::$FIRST_OF_JAN_2019 = new DateTime("2019-01-01");
        $this->taxCalculator = new DummyTaxCalculator();
    }

    public function testFirstYearsTaxForAlternativeFuel_0_grams_co2()
    {
        $vehicle = new Vehicle(0, FuelType::ALTERNATIVE_FUEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(0, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForAlternativeFuel_1_to_50_grams_co2()
    {
        $vehicle = new Vehicle(50, FuelType::ALTERNATIVE_FUEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(0, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForAlternativeFuel_51_to_75_grams_co2()
    {
        $vehicle = new Vehicle(75, FuelType::ALTERNATIVE_FUEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(15, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForAlternativeFuel_76_to_90_grams_co2()
    {
        $vehicle = new Vehicle(90, FuelType::ALTERNATIVE_FUEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(95, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForAlternativeFuel_91_to_100_grams_co2()
    {
        $vehicle = new Vehicle(100, FuelType::ALTERNATIVE_FUEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(115, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForAlternativeFuel_101_to_110_grams_co2()
    {
        $vehicle = new Vehicle(110, FuelType::ALTERNATIVE_FUEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(135, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForAlternativeFuel_111_to_130_grams_co2()
    {
        $vehicle = new Vehicle(130, FuelType::ALTERNATIVE_FUEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(155, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForAlternativeFuel_131_to_150_grams_co2()
    {
        $vehicle = new Vehicle(150, FuelType::ALTERNATIVE_FUEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(195, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForAlternativeFuel_151_to_170_grams_co2()
    {
        $vehicle = new Vehicle(170, FuelType::ALTERNATIVE_FUEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(505, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForAlternativeFuel_171_to_190_grams_co2()
    {
        $vehicle = new Vehicle(190, FuelType::ALTERNATIVE_FUEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(820, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForAlternativeFuel_191_to_225_grams_co2()
    {
        $vehicle = new Vehicle(225, FuelType::ALTERNATIVE_FUEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(1230, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForAlternativeFuel_226_to_255_grams_co2()
    {
        $vehicle = new Vehicle(255, FuelType::ALTERNATIVE_FUEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(1750, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForAlternativeFuel_over_255_grams_co2()
    {
        $vehicle = new Vehicle(256, FuelType::ALTERNATIVE_FUEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(2060, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForElectric()
    {
        $vehicle = new Vehicle(0, FuelType::ELECTRIC, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(0, $this->taxCalculator->calculateTax($vehicle));
    }
}
