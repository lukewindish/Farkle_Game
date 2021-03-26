package menu_commands

class Model {
  val message = Board.show
  
  def getMessage = message
  
  def showGameArea = {
    Menu.showGameArea
  }
  
  def initializeGame = {
    Menu.INITIALIZE_GAME
  }
  
  def doMove = {
    Menu.DO_MOVE
  }
  
  def doTurn = {
    Menu.DO_TURN
  }
  
  def doGame = {
    Menu.DO_GAME
  }
  
  def checkForWinner = {
    Menu.CHECK_FOR_WINNER
  }
  
  def advancePlayerOrder = {
    Menu.advancePlayerOrder
  }
  
  def showPlayerOrder = {
    Menu.showPlayerOrder
  }
}