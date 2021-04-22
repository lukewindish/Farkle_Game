package view

import controller._
import scala.swing._
import swing.Swing._
import event._
import java.awt.Color
import java.awt.Graphics2D
import java.awt.Font
import BorderPanel.Position._
import javax.swing.border.Border
import java.awt.ComponentOrientation
import java.awt.image.BufferedImage

class PolishedView extends TextView {
  
  override def update_GameArea {
    gameArea.repaint
    gameText.text = controller.get.showGameArea
  }
  
  class DicePanel extends Panel {
    var image = javax.imageio.ImageIO.read(new java.io.File("resources/1die.png"))
    
    def showDie(value: String) {
      image = javax.imageio.ImageIO.read(new java.io.File("resources/" + value + "die.png"))
      this.repaint
    }
    
    override def paint(g: Graphics2D) {
      g.drawImage(image, 20, 20, null)
    }
    
    
    
  }
}