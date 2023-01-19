class Vehicle {
  co2Emissions: number
  fuelType: string
  dateOfFirstRegistration: Date
  listPrice: number

  public constructor(co2Emissions: number, fuelType: string, dateOfFirstRegistration: Date, listPrice: number) {
    this.co2Emissions = co2Emissions;
    this.fuelType = fuelType;
    this.dateOfFirstRegistration = dateOfFirstRegistration;
    this.listPrice = listPrice;
  }

}

export { Vehicle }