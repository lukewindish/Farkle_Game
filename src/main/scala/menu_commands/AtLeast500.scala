package menu_commands

/** Strategy that can be assigned to a player. AtLeast500 rolls until
 *  the player has earned 500 points during that turn*/
class AtLeast500 extends Strategy {
  override val name = "AtLeast500"
  
  
  /** Function implements strategy logic 
   *  
   *  @param pointsSoFar Points player has scored during current move
   *  @param diceLeft How many dice player has left to roll
   *  @return Boolean for whether or not player should roll again 
   *  
   */
  override def rollAgain: Boolean = {
    if (scoreSoFar >= 500) false
    else true
  }
}