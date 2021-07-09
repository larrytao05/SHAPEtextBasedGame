import java.util.Objects;
import java.util.Scanner;
import java.util.HashMap;

public class Person extends GameObject {
  private String[] dialogue;

  public Person(String name, GameObject bounty, String[] dialogue) {
    this.dialogue = dialogue;
    super(name, bounty);
  }

  @Override
  public GameObject interact() {
      Scanner s = new Scanner(System.in);
      if (!Objects.isNull(bounty)) {
          System.out.println(name + " has a " + bounty.getName() + " and they might give it to you if you enter the right command.");
      }
       System.out.println("Please enter a command: ");
       String input = s.nextLine();
       if (input.contains("/take")) {
           if (!Objects.isNull(bounty)) {
               System.out.println("You got a " + bounty.getName() + " from " + name + "!");
               GameObject retval = bounty;
               bounty = null;
               return retval;
           } else {
               System.out.println(name + " didn't give you anything.");
           }
       } else if (input.contains("/talk")) {
         System.out.println(name + ": ");
         String input1 = s.nextLine();
         if input.contains("/continue") {
           System.out.println(name + ": ");
         }
       }
      return null;

  }
}