package menu_commands

import scala.swing._

class Controller(view: View, model: Model) {

  
  def showGameAreaClick = Action("Show Game Area") {
    view.centralArea.text = model.showGameArea
  }
  
  def initializeGameClick = Action("Initialize Game") {
    model.initializeGame
    view.centralArea.text = model.showGameArea
  }
  
  def doMoveClick = Action("Do Move") {
    model.doMove
    view.centralArea.text = model.showGameArea
  }
  
  def doTurnClick = Action("Do Turn") {
    model.doTurn
    view.centralArea.text = model.showGameArea
  }
  
  def doGameClick = Action("Do Game") {
    model.doGame
    view.centralArea.text = model.showGameArea
  }
  
  def checkForWinnerClick = Action("Check For Winner") {
    model.checkForWinner
  }
  
  def advancePlayerOrderClick = Action("Advance Player Order") {
    model.advancePlayerOrder
  }
  
  def showPlayerOrder = Action("Show Player Order") {
    model.showPlayerOrder
  }

  def exit = Action("Exit") {
    sys.exit(0)
  }
}