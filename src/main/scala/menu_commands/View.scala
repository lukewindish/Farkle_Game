package menu_commands

import scala.swing._
import event._
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
    object showPlayerOrderButton extends Button
    
    object randomness extends ComboBox(List("Off" ,"On")) {
      this.maximumSize = new Dimension(50,20)
    }
        
    object strategyPullDown1 extends ComboBox(List("", "Play Safe", "Two Rolls", "At Least 500", "All or Nothing")) {
      this.maximumSize = new Dimension(100,20)
    }
    object strategyPullDown2 extends ComboBox(List("", "Play Safe", "Two Rolls", "At Least 500", "All or Nothing")) {
      this.maximumSize = new Dimension(100,20)
    }
    object strategyPullDown3 extends ComboBox(List("", "Play Safe", "Two Rolls", "At Least 500", "All or Nothing")) {
      this.maximumSize = new Dimension(100,20)
    }
    object strategyPullDown4 extends ComboBox(List("", "Play Safe", "Two Rolls", "At Least 500", "All or Nothing")) {
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
      contents += new Label {
        text = "Randomness"
      }
      contents += randomness
      contents += doMoveButton
      contents += doTurnButton
      contents += doGameButton
      contents += checkForWinnerButton
      contents += new Label("Player 1 Strategy")
      contents += strategyPullDown1
      contents += new Label("Player 2 Strategy")
      contents += strategyPullDown2
      contents += new Label("Player 3 Strategy")
      contents += strategyPullDown3
      contents += new Label("Player 4 Strategy")
      contents += strategyPullDown4
    }
    
    object southArea extends FlowPanel {
      contents += advancePlayerOrderButton
      contents += showPlayerOrderButton
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
      showPlayerOrderButton.action = controller.showPlayerOrderClick
      
      listenTo(randomness.selection)
      listenTo(strategyPullDown1.selection)
      listenTo(strategyPullDown2.selection)
      listenTo(strategyPullDown3.selection)
      listenTo(strategyPullDown4.selection)
      
      reactions += {
        case SelectionChanged(`randomness`) => {
          val rand = randomness.selection.item
          controller.toggleRandom(rand)
        }
        case SelectionChanged(`strategyPullDown1`) => {
          val p1Strat = strategyPullDown1.selection.item
          controller.setPlayerStratClick("Player_1", p1Strat)
        }
        case SelectionChanged(`strategyPullDown2`) => {
          val p2Strat = strategyPullDown2.selection.item
          controller.setPlayerStratClick("Player_2", p2Strat)
        }
        case SelectionChanged(`strategyPullDown3`) => {
          val p3Strat = strategyPullDown3.selection.item
          controller.setPlayerStratClick("Player_3", p3Strat)
        }
        case SelectionChanged(`strategyPullDown4`) => {
          val p4Strat = strategyPullDown4.selection.item
          controller.setPlayerStratClick("Player_4", p4Strat)
        }
      }
      
  
      
  
  
      size = new Dimension(600, 750)
      visible = true
    }

}