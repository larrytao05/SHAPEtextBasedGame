import java.util.*;

// starts world and runs throughout game
public class Main {
    int currentLocation = 0;
    public static void main(String[] args) {

        HashMap<String, Runnable> commands = new HashMap<>();
        Location[] locations;
        GameObject eiffelTower = new GameObject();
        Location paris = new Location("Paris", new GameObject[]{eiffelTower});
        locations = new Location[1];
        locations[0] = paris;
        System.out.println(locations[0].getName());
        commands.put("/help", Main::help);
        
        Scanner s = new Scanner(System.in);
        GameWorld w = new GameWorld(0, locations);
        Boolean cont = true;

        // everything that happens during the game happens here
        while (cont) {
            String input = s.nextLine();
            String c = "/none";
            for (String command : commands.keySet()) {
                if (input.contains(command)) {
                    c = command;
                    break;
                }
            }

            //running functions based on user commands
            if (!c.equals("/none")) {
                if (c.contains("/interact"))
                {
                  for (GameObject o : locations[0].getObjects()) {
                    if (c.contains(o.getName)) {
                      o.interact();
                    }
                  }
                }
                else if(c.equals("/list"))
                {
                  list(locations);
                }
                else if(c.equals("/help"))
                {
                  help();
                }
                else if(c.equals("/quit"))
                  cont = false;

            }




        }
    }

    public static void help() {
        System.out.println("This is a list of commands to help you get started.\n/interact (object): Allows you to interact with an object in your location. \n/list: Lists all objects and locations contained within your current location. \n/quit: Ends the game. \n/save: Saves your information to your device.");
    }

    public static void interact(GameObject o) {
        o.interact();
    }

    public static void list(Location[] locations) {
      System.out.println("These are the objects in your location:\n");
      for (GameObject o : locations[currentLocation])
      {
        if (location[currentLocation] == 0)
        {
          GameObject[] objects = paris.getObjects();
          for (GameObject object : objects)
          {
            System.out.println(object.getName());
          }
        }
      }
      
    }

    public static void save() {
      // not sure how to do this, seeing as we don't have a database or a way of communicating with one
      // we could try saving it to a file on the user's computer
    }
}