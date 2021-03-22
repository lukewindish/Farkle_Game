package menu_commands

import scala.swing._

class View extends MainFrame {

   var _controller : Option[Controller] = None

  // Components
  val textArea = new TextArea

  /**
   * View.init
   * @param controller
   */
  def init(controller: Controller) {
    _controller = Some(controller)
    title = "My GUI"
    contents = textArea
    centerOnScreen

    menuBar = new MenuBar {
      contents += new Menu("Menu 1") {
        contents += new MenuItem(controller.hello)
        contents += new MenuItem("MenuItem 2")
        contents += new Separator
        contents += new MenuItem(controller.exit) // end Exit menuItem
      } // end Menu 1
    } // end MenuBar

    size = new Dimension(500, 500)
    visible = true
  }

}