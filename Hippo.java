// Sean O'Dell, CSE 142, Spring 2015, Section BG
// Programming Assignment #8, 06/02/15
//
// This object's behavior is to simulate the actions and characteristics of an hippo and will be
// used in the critter game.

import java.awt.*;
import java.util.*;

public class Hippo extends Critter {

   private int hunger;
   private int randomNumber;
   private int moveCount;
   private Random rand;

   // Constructs a new hippo
   public Hippo(int hunger) {
      this.hunger = hunger;
      rand = new Random();
      randomNumber = rand.nextInt(4);
      moveCount = 0;
   }
   
   // Determines and sets the color of hippo's symbols
   public Color getColor() {
      if (hunger > 0) {
         return Color.GRAY;
      }
      return Color.WHITE;
   }
   
   // Determines under what conditions a hippo will eat
   public boolean eat() {
      if (hunger > 0) {
         hunger--;
         return true;
      }
      return false;
   }
   
   // Determines what fight action will be performed given an opponent type
   public Attack fight(String opponent) {
      if (hunger > 0) {
         return Attack.SCRATCH;
      }
      return Attack.POUNCE;
   }
   
   // Determines what move action will be performed
   public Direction getMove() {
      if (moveCount == 5) {
         randomNumber = rand.nextInt(4);
         moveCount = 0;
      }
      moveCount++;
      if (randomNumber == 0) {
         return Direction.NORTH;
      }  else if (randomNumber == 1) {
         return Direction.SOUTH;
      } else if (randomNumber == 2) {
         return Direction.EAST;
      } else {
         return Direction.WEST;
      }
   }
   
   // Sets the visual symbol for a hippo
   public String toString() {
      if (hunger <= 0) {
         return "0";
      }
      return "" + hunger;
   }
}