package tax

import java.time.LocalDate

class Vehicle(
    val co2Emissions: Int,
    val fuelType: FuelType,
    val dateOfFirstRegistration: LocalDate,
    val listPrice: Int
)