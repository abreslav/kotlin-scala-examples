package _03_extensions

import java.io.File
import javax.swing.JFrame
import javax.swing.JScrollPane
import javax.swing.JLabel

object Swing extends App {
  val frame = new JFrame("Files")
  frame.setSize(800, 600)
  val scrollPane = new JScrollPane(new JLabel(
    renderChildren(new File("."))
  ))
  frame.add(scrollPane)
  frame.show()

  def renderChildren(f : File) : String = {
      <html>
        <table border="1">
          <tr>
            <td>{f.getCanonicalFile().getName()}</td>
            <td># children</td>
          </tr>
          {
            for (c <- f.listFiles())
              yield <tr>
                      <td>{c.getName()}</td>
                      <td>{if (c.isDirectory()) c.listFiles().length else "-"}</td>
                    </tr>
          }
        </table>
      </html>.toString()
  }
}
