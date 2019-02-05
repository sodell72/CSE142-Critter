// Sean O'Dell, CSE 142, Spring 2015, Section BG
// Programming Assignment #8, 06/02/15
//
// This object's behavior is to simulate the actions and characteristics of an vulture and will be
// used in the critter game.

public class Vulture extends Bird {

   private boolean hungry;

   // Constructs a new vulture
   public Vulture() {
      hungry = true;
   }

   // Determines under what conditions a vulture will eat
   public boolean eat() {
      if (hungry) {
         hungry = false;
         return true;
      }
      return false;
   }

   // Determines what fight action will be performed given an opponent type
	public Attack fight(String opponent) {
      Attack action = super.fight(opponent);
      hungry = true;
      return action;
	}
}