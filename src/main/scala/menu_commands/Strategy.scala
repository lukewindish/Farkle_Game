package menu_commands

/** Defines a strategy for a player to use while playing the game */
class Strategy {
  val name = "SimpleStrategy"
  var scoreSoFar = 0
  var rollsSoFar = 0
  
  /** Function implements strategy logic 
   *  
   *  @param pointsSoFar Points player has scored during current move
   *  @param diceLeft How many dice player has left to roll
   *  @return Boolean for whether or not player should roll again 
   *  
   */
  def rollAgain: Boolean = {
    false
  }
  /** Function to update scoreSoFar for strategy logic */
  def updateScore(i:Int): Unit = {
    scoreSoFar = i
  }
  /** Function to update rollsSoFar for strategy logic */
  def updateRolls(i:Int): Unit = {
    rollsSoFar = i
  }
}
