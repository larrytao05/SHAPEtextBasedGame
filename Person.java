import java.util.Objects;
import java.util.Scanner;
import java.util.HashMap;

public class Person extends GameObject {

  public Person(String name, GameObject bounty) {
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
       if (input.contains("/ask")) {
           if (!Objects.isNull(bounty)) {
               System.out.println("You got a " + bounty.getName() + " from " + name + "!");
               GameObject retval = bounty;
               bounty = null;
               return retval;
           } else {
               System.out.println(name + " didn't give you anything.");
           }
       }
      return null;

  }
}