// Sean O'Dell, CSE 142, Spring 2015, Section BG
// Programming Assignment #8, 06/02/15
//
// This object's behavior is to simulate the actions and characteristics of an bird and will be
// used in the critter game.

import java.awt.*;

public class Bird extends Critter {

   private int moveCount;
   private char lastMove;

   // Constructs a new bird
   public Bird() {
      lastMove = 'c';
      moveCount = 0;
   }
   
   // Determines and sets the color of bird's symbols
   public Color getColor() {
   	return Color.BLUE;
   }
   
   // Determines what fight action will be performed given an opponent type
   public Attack fight(String opponent) {
      if (opponent.equals("%")) {
		   return Attack.ROAR;
      }
      return Attack.POUNCE;
	}

   // Determines what move action will be performed
   public Direction getMove() {
      if (moveCount >= 12) {
         moveCount = 0;
      }
      moveCount++;
      if (moveCount <= 3) {
         lastMove = 'n';
         return Direction.NORTH;
      } else if (moveCount <= 6) {
         lastMove = 'e';
         return Direction.EAST;
      } else if (moveCount <= 9) {
         lastMove = 's';
         return Direction.SOUTH;
      } else {
         lastMove = 'w';
         return Direction.WEST;
      }
   }
   
   // Sets the visual symbol for a bird
   public String toString() {
      if (lastMove == 'e') {
         return ">";
      } else if (lastMove == 's') {
         return "V";
      } else if (lastMove == 'w') {
         return "<";
      } else {
         return "^";
      }
   }

}