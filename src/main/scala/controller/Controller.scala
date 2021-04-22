package controller

import model._
import view._
import scala.swing._

class Controller(view: View, model: Model) {

  
  def showGameArea: String = {
    model.menu.showGameArea
  }
  
  
  def initializeGame = Action("Initialize Game") {
    model.menu.INITIALIZE_GAME
    view.update_PlayerOrder
    view.update_GameArea
  }
  
  
  def doMove = Action("Do Move") {
    model.menu.DO_MOVE
    view.update_PlayerOrder
    view.update_GameArea
    checkForWinner
  }
  
  
  def doTurn = Action("Do Turn") {
    model.menu.DO_TURN
    view.update_PlayerOrder
    view.update_GameArea
    checkForWinner
  }
  
  
  def doGame = Action("Do Game") {
    model.menu.DO_GAME
    view.update_PlayerOrder
    view.update_GameArea
    checkForWinner
  }
  
  
  def showStrategies = Action("Show Strategies") {
    view.showWinner(model.menu.showStrategies)
  }
  
  
  def checkForWinner = Action("Check For Winner") {
    if (!(model.menu.CHECK_FOR_WINNER)) {
      view.showWinner("There is NOT a winner!")
    }
    else view.showWinner("We have a winner!")
  }
  
  
  def advancePlayerOrder = Action("Advance Player Order") {
    model.menu.advancePlayerOrder
    view.update_PlayerOrder
    view.update_GameArea
  }
  
  
  def showPlayerOrder : String = {
    model.menu.showPlayerOrder
  }
  
  
  def setPlayerStrat(player: String, strategy: String) = {
    if (strategy == "Play Safe") {
      model.menu.setPlayerStrategy(player, new PlaySafe)
    }
    else if (strategy == "Two Rolls") {
      model.menu.setPlayerStrategy(player, new TwoRolls)
    }
    else if (strategy == "At Least 500") {
      model.menu.setPlayerStrategy(player, new AtLeast500)
    }
    else if (strategy == "All or Nothing") {
      model.menu.setPlayerStrategy(player, new AllOrNothing)
    }
  }
  
  
  def toggleRandom(mode: String) = {
    model.menu.toggleRandom(mode)
  }
  
  
  def exit = Action("Exit") {
    sys.exit(0)
  }
}