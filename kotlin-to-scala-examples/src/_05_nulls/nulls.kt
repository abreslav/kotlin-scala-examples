package nulls

import java.io.File

fun strToInt(s : String) : Int? =
    try {
        Integer.parseInt(s)
    } catch(e : NumberFormatException) {
        null
    }

fun test1() {
    val a = strToInt("1")
    val b = strToInt("a")

    println("a = " + a)
    println("b = " + b)

//    val wrong = a + b

    val sum0 = a.orElse(0) + b.orElse(0)
    println("sum0 = $sum0")
    val sum01 = (a ?: 0) + (b ?: 0)
    println("sum01 = $sum01")

    val sum1 = if (a != null && b != null)
                   a + b
               else null
    println("sum1 = $sum1")

    val sum2 = a.map {(a : Int) -> b.map {(b : Int) -> a + b}}
    println("sum2 = " + sum2)

    //    val sum3 = for (x <- a; y <- b) yield x + y
    //    println("sum3 = " + sum3)
}

fun <T : Any> T?.orElse(v : T) = this ?: v



fun <T : Any, R> T?.map(f : (T) -> R) : R? {
    if (this == null) return null
    return f(this)
}


fun test2() {
    val files = File("test").listFiles()
//    println(files.size)
    println(files!!.size)

    if (files != null) {
        println(files.size)
    }






    println(files?.size)

    println(files?.size ?: "no files")

}








class List<out T>(val head : T, val tail : List<T>? = null)

fun print(l : List<String?>?) {
    if (l == null) return
    println(l.head)
    print(l.tail)
}

fun test3() {
    val l = List("a", List("b"))
    print(l)
}











trait Option<out T>
class Some<out T>(val t : T) : Option<T>
object None : Option<Nothing>

fun printOpt(l : List<Option<String>>?) {
    if (l == null) return
    println(l.head)
    print(l.tail)
}

fun test4() {
    val l = List("a", List("b"))
//    printOpt(l)
}












fun main(args : Array<String>) {
//    test1()
//    test2()
    test3()
}




// Nullable bounds
//fun <T : String?> test3(t : T) : T {
//    t.charAt(0)
//    return null
//}