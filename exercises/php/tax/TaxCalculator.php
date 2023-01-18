<?php

namespace McrDigital\PhpFundamentals3\Tax;

date_default_timezone_set('UTC');

abstract class TaxCalculator
{
    private int $year;

    abstract function calculateTax(Vehicle $vehicle): int;

    public function __construct(?int $year = null)
    {
        if (is_null($year)) {
            $this->year = idate('Y');
        } else {
            $this->year = $year;
        }
    }

    public function getYear()
    {
        return $this->year;
    }
}
