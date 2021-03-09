package menu_commands

/** Defines a strategy for a player to use while playing the game */
class Strategy {
  var scoreSoFar = 0
  var rollsSoFar = 0
  
  
  def rollAgain(pointsSoFar:Int,diceLeft:Int): Boolean = {
    false
  }
  
  def updateScore(i:Int): Unit = {
    scoreSoFar += i
  }
  
  def updateRolls(i:Int): Unit = {
    rollsSoFar += i
  }
}