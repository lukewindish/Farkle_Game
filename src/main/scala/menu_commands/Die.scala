package menu_commands


/** A six-sided die that can be rolled by players
 * @constructor Creates a six-sided die
 */
class Die {
  var value = 1
  var current_roll = 0
  val r = scala.util.Random
  
  
  
  /**Rolls itself to give it a random number between 1 and 6
   * @return Integer between 1 and 6
   * 
   */
  def roll: Int = {
    if (Board.checkRandomness == "On") {
      value = 1 + r.nextInt(5)
    }
    if (current_roll == 0) {
      current_roll = 1
      return value
    }
    else {
      value += 1
      if (value == 7) {
        value = 1
      }
      return value
    }
  }
  
  
  /**Shows string representation of a die
   * 
   * @return A string that according to the die's value
   */
  def show: String = {
    value match {
      case 1 => "|   -----------    |\n" +
                "|   |         |    |\n" +
                "|   |    *    |    |\n" +
                "|   |         |    |\n" +
                "|   -----------    |\n"
      case 2 => "|   -----------    |\n" +
                "|   | *       |    |\n" +
                "|   |         |    |\n" +
                "|   |       * |    |\n" +
                "|   -----------    |\n"
      case 3 => "|   -----------    |\n" +
                "|   | *       |    |\n" +
                "|   |    *    |    |\n" +
                "|   |       * |    |\n" +
                "|   -----------    |\n"
      case 4 => "|   -----------    |\n" +
                "|   | *     * |    |\n" +
                "|   |         |    |\n" +
                "|   | *     * |    |\n" +
                "|   -----------    |\n"
      case 5 => "|   -----------    |\n" +
                "|   | *     * |    |\n" +
                "|   |    *    |    |\n" +
                "|   | *     * |    |\n" +
                "|   -----------    |\n"
      case 6 => "|   -----------    |\n" +
                "|   | *     * |    |\n" +
                "|   | *     * |    |\n" +
                "|   | *     * |    |\n" +
                "|   -----------    |\n"
    }
  }
}
