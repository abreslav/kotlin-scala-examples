package extensions.builders

import java.io.File
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JScrollPane
import java.util.List
import java.util.ArrayList
import java.util.Collection

fun <T> Collection<T>.join(sep : String = "", prep : String = "") : String {
    val sb = StringBuilder()
    var it = iterator()
    if (it.hasNext()) {
        sb.append(prep)
    }
    while (it.hasNext()) {
        sb.append(it.next())
        if (it.hasNext()) {
            sb.append(sep)
        }
    }
    return sb.toString()!!
}

class Attribute(val name : String, val value : String) {
    fun toString() = """$name="$value" """
}

abstract class Tag(val name : String) {
    val children : List<Tag> = ArrayList()
    val attributes : List<Attribute> = ArrayList()
    open fun toString() = "<$name${attributes.join(prep = " ")}>${children.join()}</$name>"
}

class HTML : Tag("html")
class Table : Tag("table")
class TR : Tag("tr")
class TD : Tag("td")
class B : Tag("b")
class Text(val text : String) : Tag("b") {
    override fun toString() = text
}

fun Tag.doInit<T : Tag>(t : T, f : T.() -> Unit) : T{
    t.f()
    children.add(t)
    return t
}

fun <T : Tag> T.set(name : String, value : String) : T {
    attributes.add(Attribute(name, value))
    return this
}

fun html(init : HTML.() -> Unit) : HTML {
    val r = HTML()
    r.init()
    return r
}

fun HTML.table(border : Int = 1, init : Table.() -> Unit) = doInit(Table(), init).set("border", border.toString())
fun Table.tr(init : TR.() -> Unit) = doInit(TR(), init)
fun TR.td(align : String = "left", init : TD.() -> Unit) = doInit(TD(), init).set("align", align)
fun Tag.text(s : Any?) = doInit(Text(s.toString()), {})
fun Tag.bold(s : Any?) = doInit(B(), {text(s)})


fun renderChildren(f : File) : String {
    return html {
        table {
            tr {
                td {
                    bold(f.getCanonicalFile()?.getName())
                }
                td {
                    text("# children")
                }
            }
            for (child in f.listFiles()!! filter {it!!.isDirectory()}) {
                tr {
                    td(align = "right") {
                        text(child!!.getName())
                    }
                    td {
                        text(child!!.listFiles()?.size)
                    }
                }
            }
        }
    }.toString()
}


fun main(args : Array<String>) {
    val frame = JFrame("Files")
    frame.setSize(800, 600)
    val scrollPane = JScrollPane(JLabel(
            renderChildren(File("."))
    ))
    frame.add(scrollPane)
    frame.show()
}
