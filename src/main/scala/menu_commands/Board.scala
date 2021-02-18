package menu_commands


object Board {

  def show : String = {

    var dice = Array.ofDim[Die](6)
    for (i <- 0 until 6) dice(i) = new Die

    var winner = ""
    var game_over = false
    var winning_score = 0

    var result = "Board:\n"
    result += "____________________\n"
    for (d <- dice) {
      result += d.show
    }
    result += "|__________________|\n"
    result += "\n" +
              "Scores:\n"
    for (p <- PlayerOrder.toArray) {
      result += p.name + " = "
      result += p.score.toString + "\n"
      if (p.isWinner) {
        game_over = true
        winner += p.name
        winning_score = p.score
      }
    }
    result += "\n"
    if (game_over) {
      result += "The winner is " + winner
      result += " with a score of" + winning_score.toString
    }
    result
  }
}
