package view

import controller._
import scala.swing._
import swing.Swing._
import event._
import java.awt.Color
import java.awt.Font
import BorderPanel.Position._
import javax.swing.border.Border
import java.awt.ComponentOrientation
import java.awt.image.BufferedImage

class TextView extends MainFrame with View {
  
    // Player Order Panel
    object advancePlayerOrderButton extends Button
    object playerText extends TextArea {
      this.text = ""
      font = new Font("Ariel", java.awt.Font.BOLD, 12)
    }
    object northArea extends FlowPanel(FlowPanel.Alignment.Right)() {
      contents += playerText
      contents += advancePlayerOrderButton
    }
    
    
    
    // Game control buttons Panel

    object randomness extends ComboBox(List("Off" ,"On")) {
      this.maximumSize = new Dimension(20,20)
    }
    object initializeGameButton extends Button
    object doMoveButton extends Button
    object doTurnButton extends Button
    object doGameButton extends Button
    object showStrategiesButton extends Button
    object checkForWinnerButton extends Button
    
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
    object westArea extends GridPanel(32, 1) {
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
    

    
    // Game Display Area
    
    object gameText extends TextArea {
      border = new javax.swing.border.LineBorder(Color.BLACK, 2, true)
      background = Color.WHITE
      foreground = Color.BLACK
      lineWrap = true
      wordWrap = true
      this.text = ""
      font = new Font("Ariel", java.awt.Font.BOLD, 12)
    }
    object gameArea extends ScrollPane(gameText)

    
    
    // Position Panels
    
    object borderPanel extends BorderPanel {
      add(northArea, BorderPanel.Position.North)
      add(gameArea, BorderPanel.Position.Center)
      add(westArea, BorderPanel.Position.West)
    }
    
  
    
    // Additional items
    
      title = "Farkle"
      contents = borderPanel
      centerOnScreen
      size = new Dimension(650, 750)
    
    /**
     * View.init
     * @param controller
     */
    override def init(controller: Controller) {
      super.init(controller)
      
      update_PlayerOrder
      update_GameArea
      

      initializeGameButton.action  = controller.initializeGame
      doMoveButton.action  = controller.doMove
      doTurnButton.action  = controller.doTurn
      doGameButton.action  = controller.doGame
      showStrategiesButton.action = controller.showStrategies
      checkForWinnerButton.action  = controller.checkForWinner
      advancePlayerOrderButton.action  = controller.advancePlayerOrder
      
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
          controller.setPlayerStrat("Player_1", p1Strat)
        }
        case SelectionChanged(`strategyPullDown2`) => {
          val p2Strat = strategyPullDown2.selection.item
          controller.setPlayerStrat("Player_2", p2Strat)
        }
        case SelectionChanged(`strategyPullDown3`) => {
          val p3Strat = strategyPullDown3.selection.item
          controller.setPlayerStrat("Player_3", p3Strat)
        }
        case SelectionChanged(`strategyPullDown4`) => {
          val p4Strat = strategyPullDown4.selection.item
          controller.setPlayerStrat("Player_4", p4Strat)
        }
      }
      
      
      visible = true
    }
      
    def update_PlayerOrder {
      playerText.text = controller.get.showPlayerOrder
    }
    
    def update_GameArea {
      gameText.text = controller.get.showGameArea
    }
    
    def showWinner(result: String) {
      Dialog.showMessage(this, result, title="Winner?")
    }
    
    def showStrategies(result: String) {
      Dialog.showMessage(this, result, title="Strategies")
    }
    
}
