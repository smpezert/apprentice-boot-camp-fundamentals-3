using System.Collections.Generic;

namespace TaxCalculator
{
    public static class DieselPriceIndex
    {
        public static Dictionary<int, int> index = new Dictionary<int, int>()
        {
            {0,0},
            {50, 25},
            {75, 110},
            {90, 130},
            {100, 150},
            {110, 170},
            {130, 210},
            {150, 530},
            {170, 855},
            {190, 1280},
            {225, 1815},
            {255, 2135},
            {int.MaxValue, 2135}
        };
    }
}
