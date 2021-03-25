package menu_commands

import scala.swing._
import java.awt.Color
import BorderPanel.Position._

class View extends MainFrame {

    var _controller : Option[Controller] = None
    object showGameAreaButton extends Button("Show Game Area")
    object initializeGameButton extends Button("Initialize Game")
    object doMoveButton extends Button("Do Move")
    object doTurnButton extends Button("Do Turn")
    object doGameButton extends Button("Do Game")
    object checkForWinnerButton extends Button("Check For Winner")
    object advancePlayerOrderButton extends Button("Advance Player Order")
    
    
    object borderPanel extends BorderPanel {
      layout += new Label("Current Scores") {
        background = Color.cyan
        opaque = true} -> North
      layout += new Label("Buttons") {
        background = Color.yellow
        opaque = true} -> West
      layout += new Label("Game Text Area") {
        background = Color.pink
        opaque = true} -> Center
      layout += new Label("Player Order") {
        background = Color.green
        opaque = true} -> South
    }
  // Components
  val textArea = new TextArea
  val scrollPane = new ScrollPane(textArea)

  /**
   * View.init
   * @param controller
   */
  def init(controller: Controller) {
    _controller = Some(controller)
    title = "Farkle GUI"
    contents = borderPanel
    centerOnScreen
    /**
    showGameAreaButton.action  = controller.showGameAreaClick
    initializeGameButton.action  = controller.initializeGameClick
    doMoveButton.action  = controller.doMoveClick
    doTurnButton.action  = controller.doTurnClick
    doGameButton.action  = controller.doGameClick
    checkForWinnerButton.action  = controller.checkForWinnerClick
    advancePlayerOrderButton.action  = controller.advancePlayerOrderClick
    **/

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