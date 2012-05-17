package kool.swing

import javax.swing.*
import java.awt.*
import java.awt.event.*

var Container.south : JComponent
    get() = throw UnsupportedOperationException()
    set(comp) {add(comp, BorderLayout.SOUTH)}

var Container.north : JComponent
    get() = throw UnsupportedOperationException()
    set(comp) {add(comp, BorderLayout.NORTH)}

var Container.east : JComponent
    get() = throw UnsupportedOperationException()
    set(comp) {add(comp, BorderLayout.EAST)}

var Container.west : JComponent
    get() = throw UnsupportedOperationException()
    set(comp) {add(comp, BorderLayout.WEST)}

var Container.center : JComponent
    get() = throw UnsupportedOperationException()
    set(comp) {add(comp, BorderLayout.CENTER)}






fun JFrame(title : String, init : JFrame.() -> Unit) : JFrame {
    val result = JFrame(title)
    result.init()
    return result
}





fun JPanel(init : JPanel.() -> Unit) : JPanel {
    val p = JPanel()
    p.init()
    return p
}





fun JButton(text : String, action : (ActionEvent) -> Unit) : JButton {
    val result = JButton(text)
    result.addActionListener(object : ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            action(e!!)
        }
    })
    return result
}

var JFrame.title : String
    get() = getTitle().sure()
    set(t) {setTitle(t)}

var JFrame.size : #(Int, Int)
    get() = #(getSize().sure().getWidth().toInt(), getSize().sure().getHeight().toInt())
    set(dim) {setSize(Dimension(dim._1, dim._2))}

var JFrame.height : Int
    get() = getSize().sure().getHeight().toInt()
    set(h) {setSize(width, h)}

var JFrame.width : Int
    get() = getSize().sure().getWidth().toInt()
    set(w) {setSize(height, w)}

var JFrame.defaultCloseOperation : Int
    get() = getDefaultCloseOperation()
    set(def) {setDefaultCloseOperation(def)}

