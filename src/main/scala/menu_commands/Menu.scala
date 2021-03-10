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
  def CHECK_FOR_WINNER: Boolean = {true}
  
  /** Has player on top of player order execute their turn */
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
    
    var keepRolling = true
    keepRolling = playerStrategy.rollAgain(points,diceLeft)
    
    while (keepRolling && diceLeft > 0) {
      Board.testRoll
      var roll = Board.calculateScore(diceLeft)
      points += roll._1
      diceLeft = diceLeft - roll._2
      keepRolling = playerStrategy.rollAgain(points,diceLeft)
    }
    playerUp.addScore(points)
  }
  /** Executes a move for each player in the player order unless a winner is declared */
  def DO_TURN: Unit = {}
  
  /** Executes through player moves until a player has a score over 10000 */
  def DO_GAME: Unit = {}
  
  /** Sets a strategy to the designated player
   *  
   *  @param playerName Name of player to be given the strategy
   *  @param strategy Strategy to be given to the player
   */
  def setPlayerStrategy(playerName: String,strategy: Strategy): Unit = {}
  
  /** Function returns a string of strategies available for players to use */
  def showStrategies: String = {
    return "fail"
  }
}
