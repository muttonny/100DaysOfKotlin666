class Basics {


}

fun sum(a: Int, b: Int) : Int{
    return a + b
}

fun sum2(a: Int, b: Int) = a + b

fun maxOf(a: Int, b: Int) : Int{
    return if (a > b){
        a
    }else{
        b
    }
}

fun maxOf2(a: Int, b: Int) = if(a>b) a else b

open class Tiger(val origin: String) {
    open fun sayHello(){
        println("Tiger of orgin $origin")
    }
}

class SiberianTiger : Tiger("Siberia")

fun main(){
    println("Hello world")

    println("Sum is " + sum(10, 21))
    println("Sum2 is " + sum2(31, 54))

    //Variables
    //read-only variables
    val url: String = "https://"
    val a: Int = 1
    val b = 2
    val c: Int

    //variables that can be reassigned
    var x = 6
    println("x is $x")

    x = 30
    println("x: $x")

    val y = 9
    if (y in 1..x+1) {
        println("fits the range")
    }

    if(y !in 1 .. x) {
        println("Y not in range")
    } else {
        println("Y in range")
    }

    val list = listOf("apple", "mango", "pineapple")
    println("Item: ${list[0]}")
    println("LastIndex: ${list.lastIndex}")

    for (i in 1..5) println("i = $i")

    for(item in list){
        println("Item: $item")
    }

    when{
        "orange" in list -> println("Orange is juicy")
        "apple" in list -> println("Apple is good too")
    }

    val fruits = listOf("apples", "pineapples", "orange", "banana")
    fruits.filter { it.startsWith("a") || it.startsWith("b")}
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }

    //nullable values and null checks
    fun parseInt(str: String) : Int? {
        return null
    }

    fun printProduct(arg1: String, arg2: String){
        val x = parseInt(arg1)
        val y = parseInt(arg2)

        if(x != null && y != null){
            println(x*y)
        }else{
            println("arg1 or arg2 is not a number")
        }
    }

    val siberianTiger = SiberianTiger()
    siberianTiger.sayHello()

}