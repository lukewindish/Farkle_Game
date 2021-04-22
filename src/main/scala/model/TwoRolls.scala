package model

/** Strategy that can be assigned to a player. TwoRolls rolls twice
 *  bearing that the first roll produced points. */
class TwoRolls extends Strategy {
  override val name = "TwoRolls"
  
  
   /** Function implements strategy logic 
   *  
   *  @return Boolean for whether or not player should roll again 
   *  
   */
  override def rollAgain: Boolean = {
    if (rollsSoFar < 2) true
    else false
  }
  
}
