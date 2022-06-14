// import com.kotlinbasics.models.Car
import kotlin.random.Random

fun main() {
    var car1: Car = Car("BMW", "x5", "Aleksandr P.", "10 years", 50.0)
    // var car2: Car = Car("AUDI", "r8", "Fedor K.", "1 year")
    // var electricCar1: ElectricCar = ElectricCar("Tesla", "S-Model", "Aleksandr P.", "0 years", 99.9)
    car1.extendRange(70.0)
    car1.drive(120.0)
    // var valid: Boolean = car1.equals(car2)
    // println(valid)
    // println("${car1} equalation is ${valid} to ${car2}")
}

open class Car(val brand: String, val model: String, var owner: String? = null, val expluatationAge: String? = null, var tankCapacity: Double? = null){

    // generates personal car number
    private fun getPersonalCarNumber() : String {
        return (Random.nextInt(1, 1000000)).toString()
    }
    private var uniqueNumber : String = getPersonalCarNumber()
    
    // amount of range

    var range: Double = 0.0
    fun extendRange(amount: Double){
        if(tankCapacity != null || tankCapacity!! > 0 || amount > 0){
            // charging gas
            if(amount <= tankCapacity!!){
                range += amount
                println("you have filled your ${model} with ${amount} liters of gas")
                // if requested too many gas
            }else if (amount > tankCapacity!!){
                val lastRangeToTankCapacity: Double = (tankCapacity!! - range)
                range += lastRangeToTankCapacity
                println("You ${brand}-${model} is unable to have ${amount}Liters of gas, we filled ${lastRangeToTankCapacity}Liters, the maximum capacity is ${tankCapacity}Liters")
            }
        }else{
            println("You car has no tank or you have requested negative number")
        }
    }

    // drive possibilities
    fun drive(distance: Double? = null): Boolean {
        var driveDistance: Double = distance ?: 0.0
        var droveDistance: Double = 0.0
        if (driveDistance < 0.0) 
            driveDistance = 0.0  
        while (driveDistance != 0.0) {
            if (range - 5 <= 0) {
                println("Insufficient gas, current distance = ${driveDistance}") 
                break
            }
            if (driveDistance - 5 < 0) {
                range -= driveDistance
                println("Drove ${driveDistance}KM, current gas = ${range} Liters")
                driveDistance = 0.0
                break
            } 
            else{
                driveDistance -= 5
                droveDistance += 5
                range -= 5 
                println("Drove 5KM, passed distance is ${droveDistance}KM, current gas  = ${range} Liters")
            }
        }
        if(driveDistance == 0.0){
            println("Drove has been completed, the remaining gas = ${range} Liters")
            return true
        }else{
            println("Drove has ended, the remaining distance = ${driveDistance}KM, passed distance is ${droveDistance}KM")
            println("The remaining gas = ${range} Liters, which is not enought to pass ${driveDistance}KM,\nit's recommended to visit gas station")
            return false
        }
    }
    
    init{
        println("Initializing car{${this.brand} - ${this.model}}, owner : ${this.owner}, Car Number = ${this.uniqueNumber}")
    }
}

// Sub Class Childe class or Derived Class inherrited Class
class ElectricCar(brand: String, model: String, owner: String? = null, expluatationAge: String? = null, batteryLife: Double) 
    : Car(brand, model, owner, expluatationAge) {

}