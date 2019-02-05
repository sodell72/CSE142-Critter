// Sean O'Dell, CSE 142, Spring 2015, Section BG
// Programming Assignment #8, 06/02/15
//
// This object's behavior is to simulate the actions and characteristics of an husky and will be
// used in the critter game.

import java.awt.*;
import java.util.*;

public class Husky extends Critter {
   private int moveCount;
   private int randomMove;
   private int randomDirection;
   private Random randMove;
   private Random randDirection;
   private int bumpCount;
   private int waitToEat;

   // Constructs a new husky
   public Husky() {
      moveCount = 0;
      randMove = new Random();
      randomMove = randMove.nextInt(100);
      randDirection = new Random();
      randomDirection = randDirection.nextInt(2);
      waitToEat = 0;
      bumpCount = 0;
   }
   
   // Determines and sets the color of husky's symbol
   public Color getColor() {
      return Color.DARK_GRAY;
   }
   
   // Determines under what conditions a husky will eat
   public boolean eat() {
      if (waitToEat >= 100) {
         return true;
      } else {
         return false;
      }
   }
   
   // Determines what fight action will be performed given an opponent type
   public Attack fight(String opponent) {
      if (opponent.equals("V") || opponent.equals(">") || opponent.equals("<") || 
          opponent.equals("^") || opponent.equals("S")) {
         return Attack.POUNCE;
      } else if (opponent.equals("0")) {
         return Attack.SCRATCH;
      } else {
         return Attack.ROAR;
      }
   }
   
   // Determines what move action will be performed
   public Direction getMove() {
      waitToEat++;
      if (moveCount < randomMove && randomDirection == 0) {
         moveCount++;
         if (getNeighbor(Direction.EAST).equals("%")) {
            bumpCount++;
            if (bumpCount >= 2) {
               bumpCount = 0;
               return Direction.SOUTH;
            }
         }
         return Direction.EAST;
      } else if (moveCount < randomMove && randomDirection == 1) {
         moveCount++;
         return Direction.WEST;
      } else {
         moveCount = 0;
         randomMove = randMove.nextInt(100);
         return Direction.NORTH;
      }
   }
   
   // Sets the visual symbol for a husky
   public String toString() {
      return "%";
   }
}