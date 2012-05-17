package _01_traits.overriding

trait A {
  def foo() {
    println("A")
  }
}

trait B extends A {
  override def foo() {
    println("B")
  }
}

trait C extends A {
  override def foo() {
    println("C")
  }
}

class E extends C with B {

}


object Test extends App {
  new E().foo()
}