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
  
  def setPlayerStrat(player: String, strategy: String) = {
    if (strategy == "Play Safe") {
      Menu.setPlayerStrategy(player, new PlaySafe)
    }
    else if (strategy == "Two Rolls") {
      Menu.setPlayerStrategy(player, new TwoRolls)
    }
    else if (strategy == "At Least 500") {
      Menu.setPlayerStrategy(player, new AtLeast500)
    }
    else if (strategy == "All or Nothing") {
      Menu.setPlayerStrategy(player, new AllOrNothing)
    }
  }
  
  def toggleRandom(mode: String) = {
    if (mode == "On") Board.toggleRandom(true)
    else Board.toggleRandom(false)
  }
 
  
  
}