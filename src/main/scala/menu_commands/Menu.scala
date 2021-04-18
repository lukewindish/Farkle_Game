package menu_commands


/**Has main functions to run the game */
object Menu {

  //** Returns a string representing the game board */
  def showGameArea : String = {
    Board.show
  }
  
  
  /** Returns a string representing the current player order */
  def showPlayerOrder : String = {
    PlayerOrder.show
  }
  
  
  /** Advances the player order by one and returns the new player on top */
  def advancePlayerOrder : String = {
    PlayerOrder.advance
 }
  
  
  /** Initializes the game board and resets player's scores */
  def INITIALIZE_GAME: String = {
    Board.resetDie
    for (p <- PlayerOrder.toArray){
      p.resetScore
    }
    PlayerOrder.resetOrder
    Board.show
  }
  

  /** Checks if any player has a score over 10000, returns a boolean */
  def CHECK_FOR_WINNER: Boolean = {
    for (i <- PlayerOrder.toArray) {
      if (i.getScore >= 10000) return true
    }
    false
  }

  
  /** Has player on top of player order execute their turn
   *  using their designated strategy.
   */
  def DO_MOVE: Unit = {
    val playerUp = PlayerOrder.current
    val playerStrategy = playerUp.strategy
    var points = 0
    var rolls = 0
    var diceLeft = 6

    //first roll
    Board.testRoll
    val firstRoll = Board.calculateScore(diceLeft)
    points += firstRoll._1
    diceLeft = diceLeft - firstRoll._2
    
    // updating scoreSoFar and rollsSoFar for strategy
    // to make decision to keep rolling
    playerStrategy.updateScore(points);
    playerStrategy.updateRolls(diceLeft);
    
    // player cannot have option to roll again if their first roll
    // yielded zero points
    if (points == 0) diceLeft = 0;

    var keepRolling = playerStrategy.rollAgain(points,diceLeft)

    while (keepRolling && diceLeft > 0) {
      Board.testRoll
      var roll = Board.calculateScore(diceLeft)
      points += roll._1
      
      // check if new roll scored more points, if not all points
      // player made are gone and cannot roll again
      if (roll._1 == 0) {
        points = 0
        diceLeft = 0
      }
      
      diceLeft = diceLeft - roll._2
      playerStrategy.updateScore(points);
      playerStrategy.updateRolls(diceLeft);
      keepRolling = playerStrategy.rollAgain(points,diceLeft)
    }

    playerUp.addScore(points)
    Menu.advancePlayerOrder
  }
  
  
  /** Executes a move for each player in the player order unless a winner is declared */
  def DO_TURN: Unit = {
    for (i <- PlayerOrder.toArray){
      if (Menu.CHECK_FOR_WINNER == false) {
        Menu.DO_MOVE
      }
    }
  }

  
  /** Executes through player moves until a player has a score over 10000 */
  def DO_GAME: Unit = {
    while (Menu.CHECK_FOR_WINNER == false) {
      Menu.DO_MOVE
    }
  }

  
  /** Sets a strategy to the designated player
   *
   *  @param playerName Name of player to be given the strategy
   *  @param strategy Strategy to be given to the player
   */
  def setPlayerStrategy(playerName: String,strategy: Strategy): Unit = {
    // loops through PlayerOrder to find player, then sets appropriate strategy
    for (i <- PlayerOrder) {
      if (i.name == playerName) i.setStrategy(strategy)
    }
  }

  
  /** Function returns a string of strategies available for players to use 
   *  @return String explaining the 4 different strategies
   */
  def showStrategies: String = {
    var strategies = "PlaySafe: One roll and you are done\n"
    strategies += "TwoRolls: Unless you score will all dice on the first roll, you will roll one more time\n"
    strategies += "AtLeast500: Roll until you have 500 points for that turn\n"
    strategies += "AllOrNothing: Roll until all dice have scored\n"
    strategies
  }
}
