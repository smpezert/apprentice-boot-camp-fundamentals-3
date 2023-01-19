import { Vehicle } from "./vehicle"

class TaxCalculator {
    year: number

    public constructor(year: number) {
        if (year === undefined) {
            let date = new Date()
            this.year = date.getFullYear()
        } else {
            this.year = year
        }
    }

    public getYear() {
        return this.year
    }

    public calculateTax(vehicle: Vehicle) {
        throw new Error('You have to implement the method doSomething!')
    }
}

export {TaxCalculator}