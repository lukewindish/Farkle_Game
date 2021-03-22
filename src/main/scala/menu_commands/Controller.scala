package menu_commands

import scala.swing._

class Controller(view: View, model: Model) {

  def hello = Action("Hello") {
    view.textArea.text = model.getMessage
  }

  def exit = Action("Exit") {
    sys.exit(0)
  }
}