// Sean O'Dell, CSE 142, Spring 2015, Section BG
// Programming Assignment #8, 06/02/15
//
// This object's behavior is to simulate the actions and characteristics of an ant and will be used
// in the critter game.

import java.awt.*;

public class Ant extends Critter {

   private boolean walkSouth;
   private int moveCount;

   // Constructs a new ant
   public Ant(boolean walkSouth) {
      this.walkSouth = walkSouth;
      moveCount = 0;
   }
   
   // Determines and sets the color of ant's symbol
   public Color getColor() {
		return Color.RED;
	}
   
   // Determines under what conditions an ant will eat
   public boolean eat() {
		return true;
	}
   
   // Determines what fight action will be performed given an opponent type
   public Attack fight(String opponent) {
		return Attack.SCRATCH;
	}
   
   // Determines what move action will be performed
   public Direction getMove() {
      moveCount++;
      if (moveCount % 2 == 0) {
         return Direction.EAST;
      } else if (walkSouth) {
         return Direction.SOUTH;
      } else {
         return Direction.NORTH;
      }
   }

   // Sets the visual symbol for an ant
	public String toString() {
		return "%";
	}
}