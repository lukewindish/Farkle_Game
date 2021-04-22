package demo

import model._
import view._
import controller._

object Main {
  def main(args: Array[String]): Unit = {
    val model = new Model
    val view = new TextView
    //val view = new PolishedView
    val controller = new Controller(view, model)
    
    view.init(controller)
  }
}