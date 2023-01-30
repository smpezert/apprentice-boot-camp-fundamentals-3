using System;

namespace TaxCalculator.Tests
{
    public sealed class DummyTaxCalculator : TaxCalculator
    {
        public override int CalculateTax(Vehicle vehicle)
        {
            if (vehicle.FuelType == FuelType.Petrol)
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
            else if (vehicle.FuelType == FuelType.Diesel)
            {
                if (vehicle.Co2Emissions > 49 && vehicle.Co2Emissions < 75)
                    return 25;
                else if (vehicle.Co2Emissions > 74 && vehicle.Co2Emissions < 90)
                    return 105;
                else if (vehicle.Co2Emissions > 89 && vehicle.Co2Emissions < 100)
                    return 125;
                else if (vehicle.Co2Emissions > 99 && vehicle.Co2Emissions < 110)
                    return 145;
                else if (vehicle.Co2Emissions > 109 && vehicle.Co2Emissions < 130)
                    return 165;
                else if (vehicle.Co2Emissions > 129 && vehicle.Co2Emissions < 150)
                    return 205;
                else if (vehicle.Co2Emissions > 149 && vehicle.Co2Emissions < 170)
                    return 515;
                else if (vehicle.Co2Emissions > 169 && vehicle.Co2Emissions < 190)
                    return 830;
                else if (vehicle.Co2Emissions > 189 && vehicle.Co2Emissions < 225)
                    return 1240;
                else if (vehicle.Co2Emissions == 225)
                    return 1760;
                else if (vehicle.Co2Emissions == 255)
                    return 2070;
                else if (vehicle.Co2Emissions > 255)
                    return 2070;
                else return 0;
            }
            else return 0;
        }
    }
}
