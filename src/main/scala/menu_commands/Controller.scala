package menu_commands

import scala.swing._

class Controller(view: View, model: Model) {

  def hello = Action("Hello") {
    view.textArea.text = model.getMessage
  }
  
  /**
    def showGameAreaClick : Action {
      
    }
    def initializeGameClick : Action {
      
    }
    def doMoveClick : Action {
      
    }
    def doTurnClick : Action {
      
    }
    def doGameClick : Action {
      
    }
    def checkForWinnerClick : Action {
      
    }
    def advancePlayerOrderClick : Action {
      
    }
  **/
  
  def exit = Action("Exit") {
    sys.exit(0)
  }
}