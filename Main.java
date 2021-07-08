import java.lang.reflect.Array;
import java.util.*;

// starts world and runs throughout game
public class Main {

    public static void main(String[] args) {
        int currentLocation = 0;
        ArrayList<GameObject> backpack = new ArrayList<>();
        HashMap<String, Runnable> commands = new HashMap<>();
        Location[] locations = new Location[2];
        // Paris initialization
        GameObject eiffelTower = new GameObject("Eiffel Tower");
        GameObject louvre = new GameObject("Louvre");
        GameObject coolPainting = new GameObject("Mona Lisa");
        louvre.setBounty(coolPainting);
        GameObject cathedral = new GameObject("Notre Dame Cathedral");
        GameObject[] parisObjects = {eiffelTower, louvre, cathedral};
        Location paris = new Location("Paris", parisObjects);
        locations[0] = paris;
        System.out.println(locations[0].getName());
        // London initialization
        GameObject palace = new GameObject("Buckingham Palace");
        GameObject bigBen = new GameObject("Big Ben");
        GameObject[] londonObjects = {palace, bigBen};
        Location london = new Location("London", londonObjects);
        locations[1] = london;
        System.out.println(locations[1].getName());
        int length = 0;
        for (Location l: locations) {
            length += l.getObjects().length;
        }
        GameObject[] objects = new GameObject[length];
        int counter = 0;
        for (Location l : locations) {
            for (GameObject o: l.getObjects()) {
                objects[counter] = o;
                counter ++;
            }
        }
        
        Scanner s = new Scanner(System.in);
        GameWorld w = new GameWorld(0, locations);
        Boolean cont = true;

        // everything that happens during the game happens here
        while (cont) {
            String input = s.nextLine();
            String c = input;
            

            //running functions based on user commands
            if (!c.equals(null)) {
                if (c.contains("/interact"))
                {
                  for (GameObject o : objects) {
                    if (c.contains(o.getName())) {
                      interact(o, backpack);
                    }
                  }
                }
                else if(c.equals("/list"))
                {
                  list(locations, currentLocation);
                }
                else if(c.equals("/help"))
                {
                  help();
                }
                else if(c.contains("/teleport"))
                {
                  //teleport();
                    System.out.println("Teleporting!");
                }
                else if(c.equals("/quit"))
                {
                  break;
                } else if (c.equals("/backpack")) {
                    System.out.println(backpack);
                }

                  

            }




        }
    }

    public static void help() {
        System.out.println("This is a list of commands to help you get started.\n/interact (object): Allows you to interact with an object in your location. \n/list: Lists all objects and locations contained within your current location. \n/quit: Ends the game. \n/save: Saves your information to your device.");
    }

    public static void interact(GameObject o, ArrayList<GameObject> backpack) {
        GameObject retval = o.interact();
        if (retval != null) {
            backpack.add(retval);
        }
    }

    public static void list(Location[] locations, int currentLocation) {
      System.out.println("This is your location: " + locations[currentLocation].getName());
      System.out.println("These are the objects in your location:");
      GameObject[] objects = locations[currentLocation].getObjects();
      for (GameObject object : objects)
      {
        System.out.println("\t" + object.getName());
      }
      
      
    }
    /*
    public void teleport(Location[] locations){
      System.out.println("Choose from the following locations to teleport to:");
      for (int i = 1; i <= locations.length; i++)
      {
        System.out.println( "\t" i + ". " locations[i-1].getName());
      }
      System.out.println("Select the number corresponding to the location you desire to teleport to: ");
      int destination = s.nextInt();
      currentLocation = destination;
      try
      {
        System.out.println("You have arrived in: " + locations[currentLocation].getName() + ". Try the /list command to see what you can interact with.")
      } c
    }

     */

    public static void save() {
      // not sure how to do this, seeing as we don't have a database or a way of communicating with one
      // we could try saving it to a file on the user's computer
    }
}