package menu_commands


/** Board displays player's dice and scores
 * 
 */
object Board {

   var dice = Array.ofDim[Die](6)
   for (i <- 0 until 6) dice(i) = new Die

   /** Funciton takes a number of dice and rolls each one
    *  
    *  @param numDie Number of dice to roll
    */
   protected def roll(numDie: Int): Unit = {
     for (i <- 0 until numDie) dice(i).roll
   }
   
   
   /** Funciton takes a number of dice and totals up the score that arrangement of dice makes
    *  
    *  @param numDie Number of dice in the array to score
    *  @return Integer for the score calculated
    */
   protected def calculate_score(numDie: Int): Int = {
     var values = List[Int]()
     var numPairs = 0
     var score = 0
     for (i <- 0 until numDie) values = dice(i).value :: values
     var numOnes = values.count(_ == 1)
     var scoreOnes = 0
     if (numOnes < 3) scoreOnes = 100*numOnes
     val numFives = values.count(_ == 5)
     var scoreFives = 0
     if (numFives < 3) scoreFives = 50*numFives
     if (numDie == 6) {
       //checks if player rolled 1,2,3,4,5,6
       if (values.sorted == (1 to 6).toList) {
         if(score < 1000) return 1000
       }
       for (i <- 1 to 6) {
         if (values.count(_ == i) == 2) numPairs += 1
       }
       if (numPairs == 3) {
         if (score < 750) return 750
       }
     }
     for (i <- 1 to numDie) {
       if (values.count(_ == i) == 6) {
         if (score < 3000) score += 3000
       }
       else if (values.count(_ == i) == 5) {
         if (score < 2000) score += 2000
       }
       else if (values.count(_ == i) == 4) {
         if (score < 1000 && numPairs == 1) return 1500
         else score += 1000
       }
       else if (values.count(_ == i) == 3) {
         if (i == 1) {
           score += 1000
         }
         if (i == 2) {
           score += 200
         }
         if (i == 3) {
           score += 300
         }
         if (i == 4) {
           score += 400
         }
         if (i == 5) {
           score += 500
         }
         if (i == 6) {
           score += 600
         }
       }
     }
     score += scoreOnes
     score += scoreFives
     score
   }

   /** Shows game board with dice and player scores
    * 
    * @return A string that represents the game area
    * 
    */
  def show : String = {

    //var dice = Array.ofDim[Die](6)
    //for (i <- 0 until 6) dice(i) = new Die

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
      result += p.getScore.toString + "\n"
      if (p.isWinner) {
        game_over = true
        winner += p.name
        winning_score = p.getScore
      }
    }
    result += "\n"
    if (game_over) {
      result += "The winner is " + winner
      result += " with a score of" + winning_score.toString + "\n"
    }
    result
  }
}
