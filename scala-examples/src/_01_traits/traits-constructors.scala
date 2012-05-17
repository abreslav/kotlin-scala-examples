package _01_traits

trait A {
  val a = println("A")
}

trait B extends A {
  val b = println("B")
}

class C extends B with A {}

object Test extends App {
  new C()
}