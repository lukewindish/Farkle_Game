package menu_commands


object PlayerOrder extends scala.collection.mutable.Queue[Player] {

  this += new Player("Player_1")
  this += new Player("Player_2")
  this += new Player("Player_3")
  this += new Player("Player_4")

  def advance : String = {
    this += this.dequeue
    this.show
  }

  def show : String = {
    var current_order = ""
    for (p <- this.toList) {
      current_order = current_order.concat(p.name +  ", ")
    }
    return current_order.substring(0, current_order.length-2)
  }

  def current : Player = {
    return this.head
  }
}
