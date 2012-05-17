package extensions

class C

fun main(args : Array<String>) {
    val c = C()
    c.foo()

    c.iterator()
    for (i in c) {

    }
}










fun C.foo() {
    println(this)
}







fun test2() {
    val c = C()
    c.enrich().bar()
    takeRich(c.enrich())
}

fun takeRich(rich : RichBase) {

}

open class RichBase {
    fun bar() {}
}

class RichC(c : C) : RichBase() {

}

fun C.enrich() = RichC(this)











fun test3() {
    val c = C()
    for (i in c) {
        println(i)
    }
}

fun C.iterator() = arrayList(1, 2).iterator()