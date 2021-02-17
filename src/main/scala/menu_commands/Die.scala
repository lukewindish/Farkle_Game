package menu_commands

class Die {
  
  var value = 1
  val r = scala.util.Random
  
  def roll: Int = {
    //value = 1 + r.nextInt(5)
    value
  }
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