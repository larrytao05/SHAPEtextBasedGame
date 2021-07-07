import java.util.*;

// starts world and runs throughout game
public class Main {

    public static void main(String[] args) {
        int currentLocation = 0;
        HashMap<String, Runnable> commands = new HashMap<>();
        Location[] locations;
        GameObject eiffelTower = new GameObject("Eiffel Tower");
        GameObject louvre = new GameObject("Louvre");
        GameObject cathedral = new GameObject("Notre Dame Cathedral");
        GameObject[] objects = {eiffelTower, louvre, cathedral};
        Location paris = new Location("Paris", objects);
        locations = new Location[1];
        locations[0] = paris;
        System.out.println(locations[0].getName());
        
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
                      interact(o);
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
                else if(c.equals("/quit"))
                //maybe set 'cont' equal to false here?
                  break;

            }




        }
    }

    public static void help() {
        System.out.println("This is a list of commands to help you get started.\n/interact (object): Allows you to interact with an object in your location. \n/list: Lists all objects and locations contained within your current location. \n/quit: Ends the game. \n/save: Saves your information to your device.");
    }

    public static void interact(GameObject o) {
        o.interact();
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

    public static void save() {
      // not sure how to do this, seeing as we don't have a database or a way of communicating with one
      // we could try saving it to a file on the user's computer
    }
}