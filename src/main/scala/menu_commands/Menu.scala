package menu_commands

object Menu {
  
  var player_order = List[String]("Player_1","Player_2","Player_3","Player_4")
  
  def showGameArea : String = {
    val board = 
            "Board:\n" +
            "___________________________________\n" +
            "|                                 |\n" +
            "|   -----------     -----------   |\n" +
            "|   | *  *  * |     | *  *  * |   |\n" +
            "|   | *  *  * |     | *  *  * |   |\n" +
            "|   | *  *  * |     | *  *  * |   |\n" +
            "|   -----------     -----------   |\n" +
            "|                                 |\n" +
            "|                                 |\n" +
            "|   -----------     -----------   |\n" +
            "|   | *  *  * |     | *  *  * |   |\n" +
            "|   | *  *  * |     | *  *  * |   |\n" +
            "|   | *  *  * |     | *  *  * |   |\n" +
            "|   -----------     -----------   |\n" +
            "|                                 |\n" +
            "|   -----------     -----------   |\n" +
            "|   | *  *  * |     | *  *  * |   |\n" +
            "|   | *  *  * |     | *  *  * |   |\n" +
            "|   | *  *  * |     | *  *  * |   |\n" +
            "|   -----------     -----------   |\n" +
            "|                                 |\n" +
            "|_________________________________|\n" +
            "\n" +
            "Scores:\n" +
            "Player_1 = 0, Player_2 = 0, Player_3 = 0, Player_4 = 0\n" +
            "\n" 
    board
  }

  def showPlayerOrder : String = {
    var current_order = ""
    for (i <- 0 to 3) {
      current_order = current_order.concat(player_order(i))
      if (i < 3) current_order = current_order.concat(", ")
    }
    current_order
  }

  def advancePlayerOrder : String = {
     player_order = player_order.tail :+ player_order.head
     var return_string = ""
     for (i <- 0 to 3) {
       return_string = return_string.concat(player_order(i))
        if (i < 3) return_string = return_string.concat(", ")
     }
     return_string
  }
} 