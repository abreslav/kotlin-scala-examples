package nulls.java

import _05_nulls.java.Container
import _05_nulls.java.ContainerClient

fun main(args : Array<String>) {
    val container = Container("example")

    // Nullable vs @NotNull
    val string = container.getT()
    println(string.charAt(0))


    // @NotNull parameters
//    container.setT(null)
    println(container.getT().charAt(0))

    // @NotNull and generics
    val client = ContainerClient()
    client.setContainer(container)
//    client.setContainer(container as Container<String?>)
}

class X : ContainerClient() {

    public override fun setContainer(c : Container<String?>?) {
        super<ContainerClient>.setContainer(c)
    }
}
