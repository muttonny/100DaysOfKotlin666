//data classes
data class User(val name: String, val id: Int){

    override fun equals(other: Any?) = other is User && other.id == this.id

}

//enum classes
enum class State{
    IDLE, RUNNING, FINISHED
}

enum class Color(val rgb: Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00);

    fun containsRed() = (this.rgb and 0xFF0000 != 0)
}

//sealed classes
sealed class Mammal(val name: String)

class Cat(val catName: String) : Mammal(catName)
class Human(val humanName: String, val job: String) : Mammal(humanName)

fun greetMammal(mammal: Mammal): String{
    when (mammal){
        is Cat -> return "Hello ${mammal.name}"
        is Human -> return "Hello ${mammal.name}, You're working as ${mammal.job}"
    }
}

//object keyword
//object Expression
fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int){

    val dayRates = object {
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays
    }

    val total = dayRates.standard + dayRates.festivity + dayRates.special
    println("Total Price: $total")
}

//object Declaration
object DoAuth {
    fun takeParams(username: String, password: String){
        println("Input Auth parameters: $username : $password")
    }
}

fun main(){

    val user = User("Alex", 1)
    println(user)

    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)

    println("user == secondUser ${user == secondUser}")
    println("user == thirdUser ${user == thirdUser}")

    println(user.hashCode())
    println(secondUser.hashCode())
    println(thirdUser.hashCode())

    println(user.copy())
    println(user == user.copy())

    println(user.copy("Max"))
    println(user.copy(id = 3))

    println("id = ${user.component2()}")
    println("name = ${user.component1()}")

    val state = State.RUNNING

    val message = when(state){
        State.IDLE -> "It's Idle"
        State.RUNNING -> "It's Running"
        State.FINISHED -> "It's Finished"
    }

    println(message)

    val red = Color.RED
    println(red)
    println(red.containsRed())
    println(Color.BLUE.containsRed())
    println(Color.YELLOW.containsRed())

    println(greetMammal(Cat("Snowy")))
    println(greetMammal(Human("Tony", "Mechanic")))

    rentPrice(10, 2, 1)

    DoAuth.takeParams("foo", "qwerty") //Directly access members


}