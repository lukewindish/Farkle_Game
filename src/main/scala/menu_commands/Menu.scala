package menu_commands


object Menu {

  def showGameArea : String = {
    Board.show
  }

  def showPlayerOrder : String = {
    PlayerOrder.show
  }

  def advancePlayerOrder : String = {
    PlayerOrder.advance
 }
  def doMove : Unit = {
    
  }
  
  def INITIALIZE_GAME: Unit = {}
  def CHECK_FOR_WINNER: Boolean = {true}
  def DO_MOVE: Unit = {}
  def DO_TURN: Unit = {}
  def DO_GAME: Unit = {}
}
