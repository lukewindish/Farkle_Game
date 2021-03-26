package menu_commands

import scala.swing._
import java.awt.Color
import BorderPanel.Position._

class View extends MainFrame {

    var _controller : Option[Controller] = None
    
    object initializeGameButton extends Button
    object doMoveButton extends Button
    object doTurnButton extends Button
    object doGameButton extends Button
    object checkForWinnerButton extends Button
    object advancePlayerOrderButton extends Button
        
    object strategyPullDown1 extends ComboBox(Seq("Play Safe", "Two Rolls", "At Least 500", " All or Nothing")) {
      this.maximumSize = new Dimension(100,20)
    }
    object strategyPullDown2 extends ComboBox(Seq("Play Safe", "Two Rolls", "At Least 500", " All or Nothing")) {
      this.maximumSize = new Dimension(100,20)
    }
    object strategyPullDown3 extends ComboBox(Seq("Play Safe", "Two Rolls", "At Least 500", " All or Nothing")) {
      this.maximumSize = new Dimension(100,20)
    }
    object strategyPullDown4 extends ComboBox(Seq("Play Safe", "Two Rolls", "At Least 500", " All or Nothing")) {
      this.maximumSize = new Dimension(100,20)
    }
    
    object northArea extends TextArea {
      this.background = Color.LIGHT_GRAY
      this.text = ""
    }
    
    object centralArea extends TextArea {
      this.text = ""
    }
    
    object westArea extends BoxPanel(Orientation.Vertical) {
      contents += initializeGameButton
      contents += doMoveButton
      contents += doTurnButton
      contents += doGameButton
      contents += checkForWinnerButton
      contents += strategyPullDown1
      contents += strategyPullDown2
      contents += strategyPullDown3
      contents += strategyPullDown4
    }
    
    object southArea extends FlowPanel {
      contents += advancePlayerOrderButton
    }
    
    
    
    object borderPanel extends BorderPanel {
      add(northArea, BorderPanel.Position.North)
      add(centralArea, BorderPanel.Position.Center)
      add(westArea, BorderPanel.Position.West)
      add(southArea, BorderPanel.Position.South)
    }
    
    
  
    /**
     * View.init
     * @param controller
     */
    def init(controller: Controller) {
      _controller = Some(controller)
      title = "Farkle GUI"
      contents = borderPanel
      centerOnScreen
      
      initializeGameButton.action  = controller.initializeGameClick
      doMoveButton.action  = controller.doMoveClick
      doTurnButton.action  = controller.doTurnClick
      doGameButton.action  = controller.doGameClick
      checkForWinnerButton.action  = controller.checkForWinnerClick
      advancePlayerOrderButton.action  = controller.advancePlayerOrderClick
  
      
  
  
      size = new Dimension(600, 750)
      visible = true
    }

}