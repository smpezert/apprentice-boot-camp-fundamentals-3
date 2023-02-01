using Microsoft.VisualBasic.FileIO;
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
                cost = GetTaxBandFromEmissions(emissions, PetrolPriceIndex.index);
            }

            else if (vehicle.FuelType.Equals(FuelType.Diesel))
            {
                cost = GetTaxBandFromEmissions(emissions, DieselPriceIndex.index);
            }

            else if (fuelType.Equals(FuelType.AlternativeFuel))
            {
                cost = GetTaxBandFromEmissions(emissions, AlternativeFuelPriceIndex.index);
            }

            return cost;
        }

        private int CalculateAfterFirstYear(Vehicle vehicle, int petrolDieselPrice, int alternativeFuelPrice, int electricPrice)
        {
            int cost;

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