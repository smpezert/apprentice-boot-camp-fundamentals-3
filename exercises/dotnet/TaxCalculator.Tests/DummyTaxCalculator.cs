﻿using System;
using System.Collections.Generic;

namespace TaxCalculator.Tests
{
    //[Obsolete("DO NOT MAKE ANY CHANGES TO THIS CLASS - IT IS JUST HERE TO KEEP THE TESTS HAPPY TO BEGIN WITH. DON'T BE LAZY - WRITE YOUR OWN NEW TAXCALCULATOR CLASS")]
    public sealed class DummyTaxCalculator : TaxCalculator
    {
        public override int CalculateTax(Vehicle vehicle)
        {
            var emissions = vehicle.Co2Emissions;
            var fuelType = vehicle.FuelType;
            var cost = 0;

            if (fuelType.Equals(FuelType.Petrol))
            {
                cost = CalculatePetrolTax(vehicle);
            }
            else if (fuelType.Equals(FuelType.AlternativeFuel))
            {
                cost = GetTaxBandFromEmissions(emissions, AlternativeFuelPriceIndex.index);
            }

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
