import java.util.Scanner;
import java.util.HashMap;

public class Person extends GameObject {
  protected String name;
  protected HashMap<String, GameObject> possessions;
  protected String location;

  public Person(String name, HashMap<String, GameObject> possessions, String location) {
    this.name = name;
    this.possessions = possessions;
    this.location = location;
  }

  @Override
  public GameObject interact() {
      Scanner s = new Scanner(System.in);
      for (GameObject g : possessions) {
       System.out.println(name + " has a " + g + " and they might give it to you if you use the right command.");
     }
       System.out.println("Please enter a command: ");
       String input = s.nextLine();
       GameObject retval = null;
       if (input.contains("/ask")) {
        for (String name : possessions.keySet()) {
          if (input.contains(name)) {
            return possessions.get(name);
          }
        }
       }
       //  retval.put()


  }
}