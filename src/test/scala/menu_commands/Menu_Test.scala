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
      
      // Initialize Game tests
      it("Can reset the game board") {
        
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
            
         Menu.INITIALIZE_GAME
         Menu.showGameArea should be (expectedResult)
      }
     
     // Do Move tests
      it("Has a player go through their move") {
        
        val expectedResult1 =
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
            "Player_1 = 3000\n" +
            "Player_2 = 0\n" +
            "Player_3 = 0\n" +
            "Player_4 = 0\n" +
            "\n"
        Menu.INITIALIZE_GAME
        Menu.DO_MOVE
        Menu.showGameArea should be (expectedResult1)
        
        val expectedResult2 =
            "Board:\n" +
            "____________________\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |         |    |\n" +
            "|   |       * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |         |    |\n" +
            "|   |       * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |         |    |\n" +
            "|   |       * |    |\n" +
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
            "Player_1 = 3000\n" +
            "Player_2 = 1200\n" +
            "Player_3 = 0\n" +
            "Player_4 = 0\n" +
            "\n"
         
        Menu.DO_MOVE 
        Menu.showGameArea should be (expectedResult2)
        
        
        val expectedResult3 =
            "Board:\n" +
            "____________________\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |    *    |    |\n" +
            "|   |       * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |    *    |    |\n" +
            "|   |       * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |    *    |    |\n" +
            "|   |       * |    |\n" +
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
            "Player_1 = 3000\n" +
            "Player_2 = 1200\n" +
            "Player_3 = 1300\n" +
            "Player_4 = 0\n" +
            "\n"
            
        Menu.DO_MOVE
        Menu.showGameArea should be (expectedResult3)
        
        val expectedResult4 =
            "Board:\n" +
            "____________________\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   |         |    |\n" +
            "|   | *     * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   |         |    |\n" +
            "|   | *     * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   |         |    |\n" +
            "|   | *     * |    |\n" +
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
            "Player_1 = 3000\n" +
            "Player_2 = 1200\n" +
            "Player_3 = 1300\n" +
            "Player_4 = 1400\n" +
            "\n"
        
        Menu.DO_MOVE
        Menu.showGameArea should be (expectedResult4)
        
        val expectedResult5 =
            "Board:\n" +
            "____________________\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   |    *    |    |\n" +
            "|   | *     * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   |    *    |    |\n" +
            "|   | *     * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   |    *    |    |\n" +
            "|   | *     * |    |\n" +
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
            "Player_1 = 4500\n" +
            "Player_2 = 1200\n" +
            "Player_3 = 1300\n" +
            "Player_4 = 1400\n" +
            "\n"
            
        Menu.DO_MOVE
        Menu.showGameArea should be (expectedResult5)
        
        val expectedResult6 =
            "Board:\n" +
            "____________________\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   | *     * |    |\n" +
            "|   | *     * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   | *     * |    |\n" +
            "|   | *     * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   | *     * |    |\n" +
            "|   | *     * |    |\n" +
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
            "Player_1 = 4500\n" +
            "Player_2 = 2800\n" +
            "Player_3 = 1300\n" +
            "Player_4 = 1400\n" +
            "\n"
            
        Menu.DO_MOVE
        Menu.showGameArea should be (expectedResult6)
        
        val expectedResult7 =
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
            "Player_1 = 4500\n" +
            "Player_2 = 2800\n" +
            "Player_3 = 4300\n" +
            "Player_4 = 1400\n" +
            "\n"
            
        Menu.DO_MOVE
        Menu.showGameArea should be (expectedResult7)
        
        val expectedResult8 =
            "Board:\n" +
            "____________________\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |         |    |\n" +
            "|   |       * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |         |    |\n" +
            "|   |       * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |         |    |\n" +
            "|   |       * |    |\n" +
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
            "Player_1 = 4500\n" +
            "Player_2 = 2800\n" +
            "Player_3 = 4300\n" +
            "Player_4 = 2600\n" +
            "\n"
        Menu.DO_MOVE
        Menu.showGameArea should be (expectedResult8)
      }
      
      // Do turn tests
      it("Makes every player do one turn in the game") {
        Menu.INITIALIZE_GAME
        val expectedResult4 =
            "Board:\n" +
            "____________________\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   |         |    |\n" +
            "|   | *     * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   |         |    |\n" +
            "|   | *     * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   |         |    |\n" +
            "|   | *     * |    |\n" +
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
            "Player_1 = 3000\n" +
            "Player_2 = 1200\n" +
            "Player_3 = 1300\n" +
            "Player_4 = 1400\n" +
            "\n"
        
        Menu.DO_TURN
        Menu.showGameArea should be (expectedResult4)
        
        val expectedResult8 =
            "Board:\n" +
            "____________________\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |         |    |\n" +
            "|   |       * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |         |    |\n" +
            "|   |       * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |         |    |\n" +
            "|   |       * |    |\n" +
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
            "Player_1 = 4500\n" +
            "Player_2 = 2800\n" +
            "Player_3 = 4300\n" +
            "Player_4 = 2600\n" +
            "\n"
        Menu.DO_TURN
        Menu.showGameArea should be (expectedResult8)
      }
      //Do Game Tests
      it ("Goes through player moves until a player reaches a score of 10000") {
      Menu.INITIALIZE_GAME
      Menu.DO_GAME
      
      val expectedResult =
            "Board:\n" +
            "____________________\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   |    *    |    |\n" +
            "|   | *     * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   |    *    |    |\n" +
            "|   | *     * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   |    *    |    |\n" +
            "|   | *     * |    |\n" +
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
            "Player_1 = 10300\n" +
            "Player_2 = 5400\n" +
            "Player_3 = 7100\n" +
            "Player_4 = 5600\n" +
            "The winner is Player_1 with a score of 10300\n" +
            "\n"
        Menu.showGameArea should be (expectedResult)
      }
      // Check for winner tests
      it ("Sees if any player has a score of 10000 yet") {
        Menu.INITIALIZE_GAME
        Menu.DO_TURN
        Menu.CHECK_FOR_WINNER should be (false)
        Menu.DO_GAME
        Menu.CHECK_FOR_WINNER should be (true)
      }
      // Set Player Strategy Tests
      it ("Can set the strategy for each player") {
        Menu.INITIALIZE_GAME
        val p1 = PlayerOrder.current
        val strat = new PlaySafe
        Menu.setPlayerStrategy(p1.name,strat)
        val expectedResult = "PlaySafe"
        p1.strategy.name should be (expectedResult)
      }
      
      //Show Strategies
      it ("Can show player availalbe strategies") {
        var expectedResult = "PlaySafe: One roll and you are done\n"
        expectedResult += "TwoRolls: Unless you score with all dice on the first roll, you will roll one more time\n"
        expectedResult += "AtLeast500: Roll until you have 500 points for that turn\n"
        expectedResult += "AllOrNothing: Roll until all dice have scored\n"
        Menu.showStrategies should be (expectedResult)
      }
      
      //Do Move (With Strategies)
      it ("Can do moves with player's new strategies") {
        Menu.INITIALIZE_GAME
        val p1 = PlayerOrder.current
        val strat = new PlaySafe
        Menu.setPlayerStrategy(p1.name,strat)
        Menu.advancePlayerOrder
        
        val p2 = PlayerOrder.current
        val strat2 = new TwoRolls
        Menu.setPlayerStrategy(p2.name,strat2)
        Menu.advancePlayerOrder
        
        val p3 = PlayerOrder.current
        val strat3 = new AtLeast500
        Menu.setPlayerStrategy(p3.name,strat3)
        Menu.advancePlayerOrder
        
        val p4 = PlayerOrder.current
        val strat4 = new AllOrNothing
        Menu.setPlayerStrategy(p4.name,strat4)
        Menu.advancePlayerOrder
        
        val expectedResult1 =
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
            "Player_1 = 3000\n" +
            "Player_2 = 0\n" +
            "Player_3 = 0\n" +
            "Player_4 = 0\n" +
            "\n"
            
        Menu.DO_MOVE
        Menu.showGameArea should be (expectedResult1)
        
        val expectedResult2 =
            "Board:\n" +
            "____________________\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |         |    |\n" +
            "|   |       * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |         |    |\n" +
            "|   |       * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |         |    |\n" +
            "|   |       * |    |\n" +
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
            "Player_1 = 3000\n" +
            "Player_2 = 1200\n" +
            "Player_3 = 0\n" +
            "Player_4 = 0\n" +
            "\n"
        
        Menu.DO_MOVE
        Menu.showGameArea should be (expectedResult2)
        
        val expectedResult3 =
            "Board:\n" +
            "____________________\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |    *    |    |\n" +
            "|   |       * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |    *    |    |\n" +
            "|   |       * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *       |    |\n" +
            "|   |    *    |    |\n" +
            "|   |       * |    |\n" +
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
            "Player_1 = 3000\n" +
            "Player_2 = 1200\n" +
            "Player_3 = 1300\n" +
            "Player_4 = 0\n" +
            "\n"
        
        Menu.DO_MOVE
        Menu.showGameArea should be (expectedResult3)
        
         val expectedResult4 =
            "Board:\n" +
            "____________________\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   |         |    |\n" +
            "|   | *     * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   |         |    |\n" +
            "|   | *     * |    |\n" +
            "|   -----------    |\n" +
            "|   -----------    |\n" +
            "|   | *     * |    |\n" +
            "|   |         |    |\n" +
            "|   | *     * |    |\n" +
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
            "Player_1 = 3000\n" +
            "Player_2 = 1200\n" +
            "Player_3 = 1300\n" +
            "Player_4 = 1400\n" +
            "\n"
            
        Menu.DO_MOVE
        Menu.showGameArea should be (expectedResult4)
        
      }
    }
  }
}
