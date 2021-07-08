import java.util.*;


public class GameObject {

  private GameObject bounty;
  private String name;

  public GameObject(String name) {
      this.name = name;
      bounty = null;
  }

  public GameObject(String name, GameObject bounty) {
    this.name = name;
    this.bounty = bounty;
  }

  public GameObject() {
    this.name = "None";
    this.bounty = null;
  }

  public GameObject interact() {
    Scanner s = new Scanner(System.in);
    System.out.println("You are now interacting with " + name);
    boolean interacting = true;
     System.out.println("Please input a command or a line of dialogue to interact with " + name);
    String input = s.nextLine();
    if (input.contains("/take")) {
      if (bounty != null) {
        System.out.println("Successfully interacted with " + name + ". It gave you a " + bounty.getName());
        return bounty;
      }
    }
    System.out.println("Successfully interacted with " + name);
    System.out.println("It didn't give you anything.");
    return new GameObject();
  }

  public String getName()
  {
    return name;
  }

  public String setBounty(GameObject bounty) {
    this.bounty = bounty;
  }
}