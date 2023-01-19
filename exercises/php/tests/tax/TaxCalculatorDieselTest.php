<?php

namespace McrDigital\PhpFundamentals3\Tax;

use DateTime;
use PHPUnit\Framework\TestCase;

require_once "DummyTaxCalculator.php";

class TaxCalculatorDieselTest extends TestCase
{
    private static DateTime $FIRST_OF_JAN_2019;
    private TaxCalculator $taxCalculator;

    protected function setUp(): void
    {
        self::$FIRST_OF_JAN_2019 = new DateTime("2019-01-01");
        $this->taxCalculator = new DummyTaxCalculator();
    }

    public function testFirstYearsTaxForDiesel_0_grams_co2()
    {
        $vehicle = new Vehicle(0, FuelType::DIESEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(0, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForDiesel_1_to_50_grams_co2()
    {
        $vehicle = new Vehicle(50, FuelType::DIESEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(25, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForDiesel_51_to_75_grams_co2()
    {
        $vehicle = new Vehicle(75, FuelType::DIESEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(105, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForDiesel_76_to_90_grams_co2()
    {
        $vehicle = new Vehicle(90, FuelType::DIESEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(125, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForDiesel_91_to_100_grams_co2()
    {
        $vehicle = new Vehicle(100, FuelType::DIESEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(145, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForDiesel_101_to_110_grams_co2()
    {
        $vehicle = new Vehicle(110, FuelType::DIESEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(165, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForDiesel_111_to_130_grams_co2()
    {
        $vehicle = new Vehicle(130, FuelType::DIESEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(205, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForDiesel_131_to_150_grams_co2()
    {
        $vehicle = new Vehicle(150, FuelType::DIESEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(515, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForDiesel_151_to_170_grams_co2()
    {
        $vehicle = new Vehicle(170, FuelType::DIESEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(830, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForDiesel_171_to_190_grams_co2()
    {
        $vehicle = new Vehicle(190, FuelType::DIESEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(1240, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForDiesel_191_to_225_grams_co2()
    {
        $vehicle = new Vehicle(225, FuelType::DIESEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(1760, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForDiesel_226_to_255_grams_co2()
    {
        $vehicle = new Vehicle(255, FuelType::DIESEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(2070, $this->taxCalculator->calculateTax($vehicle));
    }

    public function testFirstYearsTaxForDiesel_over_255_grams_co2()
    {
        $vehicle = new Vehicle(256, FuelType::DIESEL, self::$FIRST_OF_JAN_2019, 20000);

        $this->assertEquals(2070, $this->taxCalculator->calculateTax($vehicle));
    }
}
