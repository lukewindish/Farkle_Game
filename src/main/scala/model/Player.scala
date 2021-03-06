package model


/**A Player within the game application 
 * @constructor Create a new player with a name
 * @param name The player's name
 *
 */
class Player(val name: String) {
  private var score = 0
  var strategy = new Strategy
  

  /** Updates player's score after their turn has ended
   *  
   *  @param num The number to be added to the player's current score
   */
  def addScore(num: Int): Unit = {
    score += num
  }
  
  
  /** Resets player's score to zero */
  def resetScore: Unit = {
    score = 0
  }
  

  /** Since score is private, allows other classes to check player's score */
  def getScore : Int = {
    score
  }
  
  
  /** Function returns player's current strategy */
  def getStrategy: Strategy = strategy
  
  
  /** Function sets player's strategy 
   *  @param s New strategy player will have
   */
  def setStrategy(s: Strategy): Unit = {
    strategy = s
  }
}
