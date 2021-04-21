package menu_commands

/** Strategy that can be assigned to a player. TwoRolls rolls twice
 *  bearing that the first roll produced points. */
class TwoRolls extends Strategy {
  override val name = "TwoRolls"
  
  
   /** Function implements strategy logic 
   *  
   *  @param pointsSoFar Points player has scored during current move
   *  @param diceLeft How many dice player has left to roll
   *  @return Boolean for whether or not player should roll again 
   *  
   */
  override def rollAgain(pointsSoFar:Int,diceLeft:Int): Boolean = {
    if (rollsSoFar < 2) true
    else false
  }
  
}