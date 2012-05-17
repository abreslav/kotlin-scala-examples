package _02_patterns

trait Expr
case class Num(value : Int) extends Expr
case class Sum(left : Expr, right : Expr) extends Expr

object Main extends App {
  def eval(e : Expr) : Int = e match {
    case Num(v) => v
    case Sum(a, b) => eval(a) + eval(b)
  }


  println(eval(Sum(Num(1), Num(2))))

}







object ExprDSL {
  class IntForExpr(i : Int) {
    def e = Num(i)
  }
  implicit def int4expr(i : Int) = new IntForExpr(i)
  class Addable(e : Expr) {
    def +(other : Expr) : Expr = Sum(e, other)
  }
  implicit def expr2addable[E <% Expr](e : E) = new Addable(e)
}



object DSLTest extends App {
  import ExprDSL._

  println(1 .e)
  println(Num(1) + Num(2))
  println(1 .e + 2 .e)
}