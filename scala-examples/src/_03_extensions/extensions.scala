package _03_extensions

class C


class RichC(c : C) {
  def foo() {
    println(c)
  }
}


object Main extends App {
  val c = new C()
  c.foo()

  implicit def enrich(c : C) : RichC = new RichC(c)
}










object Test2 extends App {
  val c = new C()

  takeRich(c)

  def takeRich(r : RichBase) {}
  implicit def enrich(c : C) : RichC2 = new RichC2()
}

class RichBase {
  def bar() {}
}

class RichC2 extends RichBase {
  def foo() {}
}




object TestFor extends App {

  val c = new C()
  for (i <- c) {
    println(i)
  }

  class RichC {
    def foreach(x : Int => Unit) {
      x(1)
      x(2)
    }
  }

  implicit def enrich(c : C) : RichC = new RichC()


}