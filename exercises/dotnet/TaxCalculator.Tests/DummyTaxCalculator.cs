﻿using Microsoft.VisualBasic.FileIO;
using System;
using System.Collections.Generic;
using TaxCalculator;

namespace TaxCalculator.Tests
{
    public sealed class DummyTaxCalculator : TaxCalculator
    {
        public bool IsAfterTheFirstYear { get; }
        public bool IsExpensive { get; }

        public DummyTaxCalculator(bool isAfterTheFirstYear = false, bool isExpensive = false)
        {
            IsAfterTheFirstYear = isAfterTheFirstYear;
            IsExpensive = isExpensive;
        }

        public override int CalculateTax(Vehicle vehicle)
        {
            var emissions = vehicle.Co2Emissions;
            var fuelType = vehicle.FuelType;
            var cost = 0;

            if (vehicle.DateOfFirstRegistration.Year < 2019)
            {
                if (IsExpensive && vehicle.ListPrice > 40000)
                {
                    return CalculateAfterFirstYear(vehicle, 450, 440, 310);
                }
                else if (IsAfterTheFirstYear)
                {
                    return CalculateAfterFirstYear(vehicle, 140, 130, 0);
                }
            }

            if (fuelType.Equals(FuelType.Petrol))
            {
                cost = CalculatePetrolTax(vehicle);
            }

            else if (vehicle.FuelType.Equals(FuelType.Diesel))
            {
                cost = GetTaxBandFromEmissions(emissions, DieselPriceIndex.index);
            }

            else if(fuelType.Equals(FuelType.AlternativeFuel))
            {
                cost = GetTaxBandFromEmissions(emissions, AlternativeFuelPriceIndex.index);
            }

            return cost;
        }

        private int CalculateAfterFirstYear(Vehicle vehicle, int petrolDieselPrice, int alternativeFuelPrice, int electricPrice)
        {
            var cost = 0;
            if (vehicle.FuelType.Equals(FuelType.Petrol) || vehicle.FuelType.Equals(FuelType.Diesel))
            {
                cost = petrolDieselPrice;
            }
            else if (vehicle.FuelType.Equals(FuelType.AlternativeFuel))
            {
                cost = alternativeFuelPrice;
            }
            else cost = electricPrice;
            return cost;
        }

        private static int CalculatePetrolTax(Vehicle vehicle)
        {
            if (vehicle.Co2Emissions > 49 && vehicle.Co2Emissions < 75)
                return 10;
            else if (vehicle.Co2Emissions > 74 && vehicle.Co2Emissions < 90)
                return 25;
            else if (vehicle.Co2Emissions > 89 && vehicle.Co2Emissions < 100)
                return 105;
            else if (vehicle.Co2Emissions > 99 && vehicle.Co2Emissions < 110)
                return 125;
            else if (vehicle.Co2Emissions > 109 && vehicle.Co2Emissions < 130)
                return 145;
            else if (vehicle.Co2Emissions > 129 && vehicle.Co2Emissions < 150)
                return 165;
            else if (vehicle.Co2Emissions > 149 && vehicle.Co2Emissions < 169)
                return 205;
            else if (vehicle.Co2Emissions > 169 && vehicle.Co2Emissions < 190)
                return 515;
            else if (vehicle.Co2Emissions > 189 && vehicle.Co2Emissions < 225)
                return 830;
            else if (vehicle.Co2Emissions == 225)
                return 1240;
            else if (vehicle.Co2Emissions == 255)
                return 1760;
            else if (vehicle.Co2Emissions > 255)
                return 2070;
            else return 0;
        }

        private static int GetTaxBandFromEmissions(int emissions, Dictionary<int, int> index)
        {
            var result = 0;
            foreach (var taxband in index)
            {
                if (emissions <= taxband.Key)
                {
                    result = taxband.Value;
                    break;
                }
            }
            return result;              
            }
          }
}