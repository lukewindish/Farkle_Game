package menu_commands

import scala.swing._

class Controller(view: View, model: Model) {

  
  def showGameAreaClick = Action("Show Game Area") {
    view.centralArea.text = model.showGameArea
    view.northArea.text = "Player Order: " + model.showPlayerOrder
  }
  
  def initializeGameClick = Action("Initialize Game") {
    model.initializeGame
    view.centralArea.text = model.showGameArea
    view.northArea.text = "Player Order: " + model.showPlayerOrder
  }
  
  def doMoveClick = Action("Do Move") {
    model.doMove
    view.centralArea.text = model.showGameArea
    view.northArea.text = "Player Order: " + model.showPlayerOrder
  }
  
  def doTurnClick = Action("Do Turn") {
    model.doTurn
    view.centralArea.text = model.showGameArea
    view.northArea.text = "Player Order: " + model.showPlayerOrder
  }
  
  def doGameClick = Action("Do Game") {
    model.doGame
    view.centralArea.text = model.showGameArea
    view.northArea.text = "Player Order: " + model.showPlayerOrder
  }
  
  def checkForWinnerClick = Action("Check For Winner") {
    view.centralArea.text = model.showGameArea
    if (!(model.checkForWinner)) {
      view.centralArea.text += "There is NOT a winner!"
    }
  

  }
  
  def advancePlayerOrderClick = Action("Advance Player Order") {
    model.advancePlayerOrder
    view.northArea.text = "Player Order: " + model.showPlayerOrder
  }
  
  def showPlayerOrderClick = Action("Show Player Order") {
    view.northArea.text = "Player Order: " + model.showPlayerOrder
  }
  
  def setPlayerStratClick(player: String, strategy: String) {
    model.setPlayerStrat(player, strategy)
  }
  
  def setRandomnessClick(mode: String) {
    model.setRandomness(mode)
  }

  def exit = Action("Exit") {
    sys.exit(0)
  }
}