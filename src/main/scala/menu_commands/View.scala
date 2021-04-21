package menu_commands

import scala.swing._
import swing.Swing._
import event._
import java.awt.Color
import java.awt.Font
import BorderPanel.Position._
import javax.swing.border.Border
import java.awt.ComponentOrientation

class View extends MainFrame {

    var _controller : Option[Controller] = None
    
    object initializeGameButton extends Button
    object doMoveButton extends Button
    object doTurnButton extends Button
    object doGameButton extends Button
    object showStrategiesButton extends Button
    object checkForWinnerButton extends Button
    object advancePlayerOrderButton extends Button
    object showPlayerOrderButton extends Button
    
    object randomness extends ComboBox(List("Off" ,"On")) {
      this.maximumSize = new Dimension(20,20)
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

    
    object playerText extends TextArea {
      this.text = ""
      font = new Font("Ariel", java.awt.Font.BOLD, 12)
    }
    
    
    object northArea extends FlowPanel(FlowPanel.Alignment.Right)() {
      contents += playerText
      contents += advancePlayerOrderButton
    }
    
    object centralArea extends TextArea {
      border = new javax.swing.border.LineBorder(Color.BLACK, 1, true)
      lineWrap = true
      wordWrap = true
      this.text = ""
      font = new Font("Ariel", java.awt.Font.BOLD, 12)
    }
    
    object westArea extends GridPanel(34, 1) {
      preferredSize = new Dimension(170,200)
      contents += new Label("Randomness") {
        font = new Font("Ariel", java.awt.Font.BOLD, 18)
      }
      contents += Swing.VStrut(5)
      contents += randomness
      contents += Swing.VStrut(5)
      contents += new Label("_______________________")   
      
      contents += Swing.VStrut(5)
      contents += new Label("Options") {
        font = new Font("Ariel", java.awt.Font.BOLD, 18)
      }
      contents += Swing.VStrut(5)
      contents += initializeGameButton
      contents += Swing.VStrut(20)
      contents += showPlayerOrderButton
      contents += Swing.VStrut(20)
      contents += doMoveButton
      contents += Swing.VStrut(20)
      contents += doTurnButton
      contents += Swing.VStrut(20)
      contents += doGameButton
      contents += Swing.VStrut(20)
      contents += showStrategiesButton
      contents += Swing.VStrut(20)
      contents += checkForWinnerButton
      contents += Swing.VStrut(5)
      
      contents += new Label("_______________________")
      contents += Swing.VStrut(5)
      contents += new Label("Strategies") {
        font = new Font("Ariel", java.awt.Font.BOLD, 18)
      }
      contents += Swing.VStrut(10)
      contents += new Label("Player_1") {
        font = new Font("Ariel", java.awt.Font.ITALIC, 14)
      }
      contents += strategyPullDown1
      contents += new Label("Player_2") {
        font = new Font("Ariel", java.awt.Font.ITALIC, 14)
      }
      contents += strategyPullDown2
      contents += new Label("Player_3") {
        font = new Font("Ariel", java.awt.Font.ITALIC, 14)
      }
      contents += strategyPullDown3
      contents += new Label("Player_4") {
        font = new Font("Ariel", java.awt.Font.ITALIC, 14)
      }
      contents += strategyPullDown4
    }
    
    
    
    
    object borderPanel extends BorderPanel {
      add(northArea, BorderPanel.Position.North)
      add(centralArea, BorderPanel.Position.Center)
      add(westArea, BorderPanel.Position.West)
      
    }
    
    
  
    /**
     * View.init
     * @param controller
     */
    def init(controller: Controller) {
      _controller = Some(controller)
      title = "Farkle"
      contents = borderPanel
      centerOnScreen
      
      initializeGameButton.action  = controller.initializeGameClick
      doMoveButton.action  = controller.doMoveClick
      doTurnButton.action  = controller.doTurnClick
      doGameButton.action  = controller.doGameClick
      showStrategiesButton.action = controller.showStrategiesClick
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
      
  
      
  
  
      size = new Dimension(650, 750)
      visible = true
    }

}