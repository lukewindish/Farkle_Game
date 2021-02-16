package menu_commands

import org.scalatest.FunSpec
import org.scalatest.FunSpec
import org.scalatest.Matchers
import org.scalatest.Matchers

class Menu_Test extends FunSpec with Matchers {

   describe("Farkle Simulation") {
    describe("has a menu") {

      //******* SHOW GAME AREA *******
      it("can show the game area and player scores") {

        val expectedResult = 
            "Board:\n" +
            "____________________\n" +
            "|   -----------    |\n" +
            "|   |         |    |\n" +
            "|   |    *    |    |\n" +
            "|   |         |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   |         |    |\n" +
            "|   |    *    |    |\n" +
            "|   |         |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   |         |    |\n" +
            "|   |    *    |    |\n" +
            "|   |         |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   |         |    |\n" +
            "|   |    *    |    |\n" +
            "|   |         |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   |         |    |\n" +
            "|   |    *    |    |\n" +
            "|   |         |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   |         |    |\n" +
            "|   |    *    |    |\n" +
            "|   |         |    |\n" +
            "|   -----------    |\n" +
            "|__________________|\n" +
            "\n" +
            "Scores:\n" +
            "Player_1 = 0\n" +
            "Player_2 = 0\n" +
            "Player_3 = 0\n" +
            "Player_4 = 0\n" +
            "\n" 

        Menu.showGameArea should be(expectedResult)
      }   

      //******* SHOW PLAYER ORDER *******
      it("can show the player order") {     
        val expectedResult = "Player_1, Player_2, Player_3, Player_4"
        Menu.showPlayerOrder should be(expectedResult)  
      }

      //******* ADVANCE ORDER *******
      it("can advance the player order") {     
        val expectedResult_0_advances = "Player_1, Player_2, Player_3, Player_4"
        val expectedResult_1_advances = "Player_2, Player_3, Player_4, Player_1"
        val expectedResult_2_advances = "Player_3, Player_4, Player_1, Player_2"        
        val expectedResult_3_advances = "Player_4, Player_1, Player_2, Player_3"
        
        Menu.showPlayerOrder should be(expectedResult_0_advances)  

        Menu.advancePlayerOrder should be(expectedResult_1_advances)  

        Menu.advancePlayerOrder 
        Menu.showPlayerOrder should be(expectedResult_2_advances)

        Menu.advancePlayerOrder should be(expectedResult_3_advances)

        Menu.advancePlayerOrder should be (expectedResult_0_advances)
        Menu.showPlayerOrder should be(expectedResult_0_advances)
        Menu.advancePlayerOrder
        Menu.showPlayerOrder should be(expectedResult_1_advances)
        
      }


    }
  }
} 