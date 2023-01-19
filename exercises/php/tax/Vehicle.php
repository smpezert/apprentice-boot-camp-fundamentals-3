<?php

namespace McrDigital\PhpFundamentals3\Tax;

use DateTime;

class Vehicle
{
    private int $co2Emissions;
    private FuelType $fuelType;
    private DateTime $dateOfFirstRegistration;
    private int $listPrice;

    public function __construct(int $co2Emissions, FuelType $fuelType, DateTime $dateOfFirstRegistration, int $listPrice)
    {
        $this->co2Emissions = $co2Emissions;
        $this->fuelType = $fuelType;
        $this->dateOfFirstRegistration = $dateOfFirstRegistration;
        $this->listPrice = $listPrice;
    }

    public function getCo2Emissions()
    {
        return $this->co2Emissions;
    }

    public function getFuelType()
    {
        return $this->fuelType;
    }

    public function getDateOfFirstRegistration()
    {
        return $this->dateOfFirstRegistration;
    }

    public function getListPrice()
    {
        return $this->listPrice;
    }
}
