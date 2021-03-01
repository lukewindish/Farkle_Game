package menu_commands


/** A queue that represents the order of players in the game */
object PlayerOrder extends scala.collection.mutable.Queue[Player] {

  this += new Player("Player_1")
  this += new Player("Player_2")
  this += new Player("Player_3")
  this += new Player("Player_4")

  
 /**Advances the player order by one position
  * @return The new player at the top of the queue
  */
  def advance : String = {
    this += this.dequeue
    this.show
  }

  /**Represents queue order in a string with player's names */
  def show : String = {
    var current_order = ""
    for (p <- this.toList) {
      current_order = current_order.concat(p.name +  ", ")
    }
    return current_order.substring(0, current_order.length-2)
  }
 
  /** Returns player object of the top player in the queue */
  def current : Player = {
    return this.head
  }
}
