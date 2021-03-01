package menu_commands


/** A six-sided die that can be rolled by players
 * @constructor Creates a six-sided die
 *
 */
class Die {

  var value = 1
  val r = scala.util.Random
  /**Rolls itself to give it a random number between 1 and 6
   * @return Integer between 1 and 6
   * 
   */
  def roll: Int = {
    //value = 1 + r.nextInt(5)
    value = 2
    value
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
