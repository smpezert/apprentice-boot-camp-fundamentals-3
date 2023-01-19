<?php

namespace McrDigital\PhpFundamentals3\Tax;

class DummyTaxCalculator extends TaxCalculator
{
    public function calculateTax(Vehicle $vehicle): int
    {
        return -1;
    }
}
