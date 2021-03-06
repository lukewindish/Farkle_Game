package model

/** Board displays player's dice and scores */
object Board {
   var dice = Array.ofDim[Die](6)
   for (i <- 0 until 6) dice(i) = new Die
   
   // boolean to toggle for randomness
   var random = false
   
   /** Function changes random value for testing 
    *  @return New value for random
    *  */
   def toggleRandom(mode: Boolean): Boolean = {
     if (mode == false) random = false
     else if (mode == true) random = true
     return random
   }
   
   
   /** Function allows other files to see what random value is
    *  @return Boolean value of random var
    */
   def getRandomValue: Boolean = {
     random
   }

   /** Function resets the die to initialized version of the game */
   def resetDie : Unit = {
     for (i <- 0 until 6) dice(i) = new Die
   }
   
   /** Function takes a number of dice and rolls each one
    *  
    *  @param numDie Number of dice to roll
    */
   def roll(numDie: Int): Unit = {
     if (random)
       for (i <- 0 until numDie) dice(i).roll
     else
       for (i <- 0 until 3) dice(i).roll
   }

   
   /** Funciton takes a number of dice and totals up the score that arrangement of dice makes
    *  
    *  @param numDie Number of dice in the array to score
    *  @return Integer for the score calculated and Integer for dice that provided the score
    */
   def calculateScore(numDie: Int): (Int,Int) = {
     var scoringDice = 0
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
         if(score < 1000) return (1000,6)
       }
       for (i <- 1 to 6) {
         if (values.count(_ == i) == 2) numPairs += 1
       }
       if (numPairs == 3) {
         if (score < 750) return (750,6)
       }
     }
     for (i <- 1 to numDie) {
       if (values.count(_ == i) == 6) {
         return (3000,6)
       }
       else if (values.count(_ == i) == 5) {
         if (score < 2000) {
           score += 2000
           scoringDice += 5
         }
       }
       else if (values.count(_ == i) == 4) {
         if (score < 1000 && numPairs == 1) return (1500,6)
         else {
           score += 1000
           scoringDice += 4
         }
       }
       else if (values.count(_ == i) == 3) {
         if (i == 1) {
           score += 1000
           scoringDice += 3
         }
         if (i == 2) {
           score += 200
           scoringDice += 3
         }
         if (i == 3) {
           score += 300
           scoringDice += 3
         }
         if (i == 4) {
           score += 400
           scoringDice += 3
         }
         if (i == 5) {
           score += 500
           scoringDice += 3
         }
         if (i == 6) {
           score += 600
           scoringDice += 3
         }
       }
     }
     score += scoreOnes
     scoringDice += numOnes
     score += scoreFives
     scoringDice += numFives
     (score,scoringDice)
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
    var game_over = Menu.CHECK_FOR_WINNER
    var winning_score = 0

    var result = "Board:\n"
    result += "____________________\n"
    for (d <- dice) {
      result += d.show
    }
    result += "|__________________|\n"
    result += "\n" +
              "Scores:\n"
    val players = PlayerOrder.toList.sortWith(_.name < _.name)
    for (p <- players) {
      result += p.name + " = "
      result += p.getScore.toString + "\n"
    }
    if (game_over) {
      for (p <- players) {
        if (p.getScore >= 10000) {
          winning_score = p.getScore
          winner = p.name
        }
      }
      result += "The winner is " + winner
      result += " with a score of " + winning_score.toString + "\n"
    }
    result += "\n"
    result
  }
}
