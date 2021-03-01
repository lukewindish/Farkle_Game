package menu_commands


/**A Player within the game application
 * @constructor Create a new player with a name
 * @param name The player's name
 *
 */
class Player(val name: String) {
  private var score = 0
  var isWinner = false

  /** Updates player's score after their turn has ended
   *  
   *  @param num The number to be added to the player's current score
   */
  def addScore(num: Int): Unit = {
    score += num
  }

  /** Since score is private, allows other classes to check player's score */
  def getScore : Int = {
    score
  }
  /** Checks if the player has enough points to win the game
   *  
   *  If any player reaches a score of 10,000, they win the game
   *
   */
  def checkWinner: Boolean = {
    if (score >= 10000) {
      isWinner = true
    }
    isWinner
  }
}
