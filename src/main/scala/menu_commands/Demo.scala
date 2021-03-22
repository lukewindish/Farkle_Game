package menu_commands

object Demo {
  
  def main(args: Array[String]): Unit = {
      
    val model = new Model
    val view  = new View   
    val controller = new Controller(view, model)
    
    view.init(controller)    
  }
  
}