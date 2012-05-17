package intro

fun main(args : Array<String>) {
    println("Hello, Lausanne!")
    Greeter().greet()
}

class Greeter(name : String = "world") {
    val greeting = "Hello, $name!"
    fun greet() {
        println(greeting)
    }
}