package menu_commands

/** Strategy that can be assigned to a player. AllOrNothing always rolls again
 *  until all dice have yielded points*/
class AllOrNothing extends Strategy {
  override val name = "AllOrNothing"
  
  
  /** Function implements strategy logic
   *  
   *  @param pointsSoFar Points player has scored during current move
   *  @param diceLeft How many dice player has left to roll
   *  @return Boolean for whether or not player should roll again 
   *  
   */
  override def rollAgain: Boolean = {true}
}