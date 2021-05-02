package az.squareroot.toy.javatest

import kotlin.math.PI
import kotlin.math.pow

fun main() {
    val squareCabin = SquareCabin(6, 50.0)
    val roundTower = RoundTower(4, 15.5)

    with(squareCabin) {
        println("\nSquare Cabin\n")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room: ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
    }

    RoundHut(3, 10.0).apply {
        println("\nRound Hut\n")
        println("Capacity: $capacity")
        println("Material: $buildingMaterial")
        println("Has room: ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
    }

    with(roundTower) {
        println("\nRound Tower\n==========")
        println("Material: $buildingMaterial")
        println("Capacity: $capacity")
        println("Has room? ${hasRoom()}")
        println("Floor area: %.2f".format(floorArea()))
    }
}

abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    abstract fun floorArea(): Double

    fun getRoom() {
        if (residents < capacity) {
            residents++
            println("You got a room!")
        } else {
            println("Sorry, at capacity and no rooms left.")
        }
    }
}

class SquareCabin(residents: Int, private val length: Double) : Dwelling(residents) {
    override val buildingMaterial: String
        get() = "Wood"
    override val capacity: Int
        get() = 6

    override fun floorArea(): Double {
        return length.pow(2)
    }
}

open class RoundHut(residents: Int, private val radius: Double) : Dwelling(residents) {
    override val buildingMaterial: String
        get() = "Straw"
    override val capacity: Int
        get() = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }
}

class RoundTower(residents: Int, radius: Double, private val floors: Int = 2) : RoundHut(residents, radius) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}