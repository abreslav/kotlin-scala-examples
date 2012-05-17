package flow_based

trait Expr
class Num(val value : Int) : Expr
class Sum(val left : Expr, val right : Expr) : Expr


fun eval(e : Expr) : Int {
    if (e is Num)
        return e.value

    if (e is Sum)
        return eval(e.left) + eval(e.right)

    throw IllegalArgumentException("Unknown expression")
}










fun evalWhen(e : Expr) : Int =
    when (e) {
        is Num -> e.value
        is Sum -> evalWhen(e.left) + evalWhen(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }












class BinOp(val operator : String, val left : Expr, val right : Expr) : Expr
class UnOp(val operator : String, val arg : Expr) : Expr

fun deepEval(e : Expr) : Int =
when (e) {
    is BinOp -> when (e.operator) {
        "+" -> deepEval(e.left) + deepEval(e.right)
        "-" -> deepEval(e.left) - deepEval(e.right)
        "*" -> deepEval(e.left) * deepEval(e.right)
        else -> 0
    }
    is Num -> e.value
    else -> 0
}



val Int.e : Num
    get() = Num(this)

fun Expr.plus(e : Expr) = Sum(this, e)

fun dslTest() {
    println(1.e + 2.e)
}



fun main(args : Array<String>) {
    println(eval(Sum(Num(1), Num(2))))
//    println(evalWhen(Sum(Num(1), Num(2))))
//    println(deepEval(BinOp("+", Num(1), Num(2))))

    dslTest()
}

