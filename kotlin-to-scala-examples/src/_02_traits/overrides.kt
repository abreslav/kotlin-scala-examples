package traits.overrides

trait A {
    fun foo() {
        println("A")
    }
}

trait B : A {
    override fun foo() {
        println("B")
    }
}

trait C : A {
    override fun foo() {
        println("C")
    }
}

//class E : C, B {
//
//}

fun main(args : Array<String>) {
    //    E().foo()
}



