package com.kotlinbasics.models

// realisation of inheritance from interface and abstract class
// fun main() {
//     val myMeal: Meal = Meal("fried chicken", "predator")
//     val humanBeeing: Human = Human("Aleksandr", "mammal", 75.0)
//     humanBeeing.move()
//     humanBeeing.consume(myMeal)
//     humanBeeing.breath()
//     humanBeeing.greet()

// }
// moveable obj abstract interface
interface MoveableObject{ 
    abstract fun move()
    abstract fun breakage()

}
// food class
open class Meal(val name: String, val type: String){

}

// abstract mammal class for inheritance, uses MobeableObject interface
abstract class Mammal(val name: String, val origin: String, val weight: Double) 
    : MoveableObject{
        abstract var diet: String
        abstract fun breath()
        abstract fun consume(food: Meal)
    }
// human class inherrited from mammal
open class Human(name: String, origin: String, weight: Double, override var diet: String = "omnivore") 
    : Mammal(name, origin, weight){
        // MoveableObject methods realisation for class Human
        override fun move(){
            println("${name} is moving by 2 legs")
        }
        override fun breakage(){
            println("${name} is ill, he is in need for cure")
        }
        // Mammal methods realisation for class Human
        override fun breath(){
            println("${name} is taking a breath..")
        }
        override fun consume(food: Meal){
            if(diet != "omnivore"){ // can eat both
                if(food.type != diet) // herbivore || predator
                    println("${name} can't eat this ${food.name}")
            }else println("${name} consumed ${food.name}")
        }
        // Human class methods
        fun greet(){
            println("Hello, my name is ${name}")
        }
        init{
            println("Met a human: he's name is ${name}, he belongs to ${origin}, his weight: ${weight}, he's ${diet}")
        }
    }