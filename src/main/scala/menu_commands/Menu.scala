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
}
