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

trait View {
  var controller: Option[Controller] = None

  def init(ctr: Controller) {
    controller = Some(ctr)
  }
  
  def update_GameArea
  def update_PlayerOrder
  def showWinner(result: String)

}