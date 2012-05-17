package generics.java

import java.util.List
import java.util.ArrayList

public fun main(args : Array<String>) {
//    val l : List<String> = Foo().getList()
    val l : List<out Any> = ArrayList<String>()
    l.clear()
    val out = 1
    println(out)
    val x : List<`out`>
}

class out {}

