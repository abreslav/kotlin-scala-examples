package traits

trait A {
    fun foo() = println("A")
}

trait B {
    fun foo() = println("B")
}

class C : B, A {
    override fun foo() {
        super<B>.foo()
        super<A>.foo()
    }
}

fun main(args : Array<String>) {
    C().foo()
}
