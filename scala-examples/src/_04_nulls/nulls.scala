package _04_nulls

import java.io.File

object Test extends App {

  def strToInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s))
    } catch {
      case _: NumberFormatException => None
    }
  }






  val a: Option[Int] = strToInt("1")
  val b: Option[Int] = strToInt("b")

  println("a = " + a)
  println("b = " + b)

  val sum0: Int = a.getOrElse(0) + b.getOrElse(0)
  println("sum0 = " + sum0)

  val sum1 = a match {
    case Some(a) => b match {
      case Some(b) => a + b
      case _ => None
    }
    case _ => None
  }
  println("sum1 = " + sum1)

  val sum2 = a.flatMap {a => b.map {b => a + b}}
  println("sum2 = " + sum2)

  val sum3 = for (x <- a; y <- b) yield x + y
  println("sum3 = " + sum3)
}






object FileTest extends App {
  val files = new File("test").listFiles()
  println(files.length)
}