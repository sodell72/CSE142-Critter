import java.awt.*;
import java.util.*;


public class Husky2 extends Critter {
   private static final int NUM = 100;


   private static Map<String, Attack> attackPrev;
   private Attack last;
   private String lastEnemy;
   private boolean group;
   private int step;
   public Husky2() {
      step = 0;
      if (getX() > getWidth()/2) {
         group = true;
      } else {
         group = false;
      }
      last = Attack.ROAR;
      lastEnemy = "%";
      attackPrev = new HashMap<String,Attack>();
      attackPrev.put("%", Attack.POUNCE);
      attackPrev.put("^", Attack.ROAR);
      attackPrev.put("V", Attack.ROAR);
      attackPrev.put(">", Attack.ROAR);
      attackPrev.put("<", Attack.ROAR);
      for (int i=1; i <= 9; i++) {
         attackPrev.put(""+i, Attack.ROAR);
      }
      attackPrev.put("0", Attack.POUNCE);
   }
   
   public boolean eat() {
      if (step < NUM && group) {
         return false;
      } else if (step > NUM && group) {
         return true;
      }   else if (step < NUM && group == false) {
         return true;
      } else {
         return false;
      }
   }
   
   public Attack fight(String opponent) {
      
      lastEnemy = opponent;
      if (attackPrev.containsKey(opponent)) {
         last = attackPrev.get(opponent);
         return attackPrev.get(opponent);
      } else {
         last = Attack.POUNCE;
         return Attack.POUNCE; 
      }
   }
   
   public Color getColor() {
      return Color.PINK;
   }
   public void win() {

      attackPrev.put(lastEnemy, last);
   }
   
   public void lose() {

      if (last == Attack.ROAR) {
         attackPrev.put(lastEnemy, Attack.POUNCE);
      }
      else if (last == Attack.POUNCE) {
         attackPrev.put(lastEnemy, Attack.SCRATCH);
      }
      else {
         attackPrev.put(lastEnemy, Attack.ROAR);
      }
   }
   
   
   public Direction getMove() {

      step++;
      int character = (int)(Math.random()*4+1);
      if (step < NUM && group) {
         if (getY() < getHeight()/2) {
            return Direction.SOUTH;
         } else if ( getY() > getHeight()/2) {
            return Direction.NORTH;
         } else if ( getX() > getWidth()/4) {
            return Direction.WEST;
         } else if ( getX() < getWidth()/4) {
            return Direction.EAST;
         } else {
            return Direction.CENTER;
         }
         
      }
      else if (step > NUM && group && step < NUM*2) {
         if (character == 0) {
            return Direction.SOUTH;
         } else if (character == 1) {
            return Direction.NORTH;
         } else if (character == 2) {
            return Direction.WEST;
         } else if (character == 3) {
            return Direction.EAST;
         } else {
            return Direction.CENTER;
         }
      }
      else if  (step > NUM && group == false && step < NUM*2) {
         if ( getY() < getHeight()/2) {
            return Direction.SOUTH;
         } else if ( getY() > getHeight()/2) {
            return Direction.NORTH;
         } else if ( getX() > getWidth()/4) {
            return Direction.WEST;
         } else if ( getX() < getWidth()/4) {
            return Direction.EAST;
         } else {
            return Direction.CENTER;
         }
      }
      else {
         if (character == 0) {
            return Direction.SOUTH;
         } else if (character == 1) {
            return Direction.NORTH;
         } else if (character == 2) {
            return Direction.WEST;
         } else if (character == 3) {
            return Direction.EAST;
         } else {
            return Direction.CENTER;
         }
      }
   }
   
   public String toString() {
      int character = (int)(Math.random()*5);
      if (character == 0) {
         return "@";
      } else if (character == 1) {
         return "!";
      } else if (character == 2) {
         return "}";
      } else if (character == 3) {
         return "-";
      } else {
         return "~";
      }
   }
}