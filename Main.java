import java.util.*;

// starts world and runs throughout game
public class Main {


    public static void main(String[] args) {
        int currentLocation = 0;
        ArrayList<GameObject> backpack = new ArrayList<>();
        HashMap<String, Runnable> commands = new HashMap<>();
        ArrayList<Location> locations = new ArrayList<>();
        // Paris initialization
        GameObject eiffelTower = new GameObject("Eiffel Tower");
        GameObject louvre = new GameObject("Louvre");
        GameObject coolPainting = new GameObject("Mona Lisa");
        louvre.setBounty(coolPainting);
        GameObject cathedral = new GameObject("Notre Dame Cathedral");
        Person npc1 = new Person("Charlie", eiffelTower);
        GameObject[] parisObjects = {eiffelTower, louvre, cathedral, npc1};
        Location paris = new Location("Paris", parisObjects);
        locations.add(paris);

        System.out.println(locations.get(0).getName());
        // London initialization
        GameObject palace = new GameObject("Buckingham Palace");
        GameObject bigBen = new GameObject("Big Ben");
        GameObject[] londonObjects = {palace, bigBen};
        Location london = new Location("London", londonObjects);
        locations.add(london);
        //Rome initialization
        GameObject colosseum = new GameObject("Colosseum");
        GameObject pantheon = new GameObject("Pantheon");
        GameObject cinqueTerre = new GameObject("Cinque Terre");
        GameObject[] italyObjects = {colosseum, pantheon, cinqueTerre};
        Location italy =  new Location("Italy", italyObjects);
        locations.add(italy);
        //NYC initializaiton
        GameObject wtc = new GameObject("World Trade Center");
        GameObject barclay = new GameObject("Barclays Center");
        GameObject yankeeStadium = new GameObject("Yankee Stadium");
        GameObject[] nyobjects = {wtc, barclay, yankeeStadium};
        Location nyc = new Location("New York City", nyobjects);
        locations.add(nyc);
        //LA initialization
        GameObject venice_beach = new GameObject("Venice Beach");
        GameObject hollywood_sign = new GameObject("Hollywood Sign");
        GameObject hollywood_walk = new GameObject("Hollywood Walk of Fame");
        GameObject[] LAObjects = {venice_beach, hollywood_sign, hollywood_walk};
        Location LA = new Location("Los Angeles", LAObjects);
        locations.add(LA);

        //China - great wall, forbidden city, terrecotta army
        GameObject greatWall = new GameObject("The Great Wall of China");
        GameObject forbiddenCity = new GameObject("The Forbidden City");
        GameObject terracotta = new GameObject("The Terracotta Army");
        GameObject[] chinaObjects = {greatWall, forbiddenCity, terracotta};
        Location china = new Location("China", chinaObjects);
        locations.add(China);


        //Korea - jeju island, busan, seoul tower

        GameObject jeju = new GameObject("Jeju Island");
        GameObject busan = new GameObject("Busan");
        GameObject tower = new GameObject("Seoul Tower");
        GameObject[] LAObjects = {jeju, busan, tower};
        Location KoreaObjects = new Location("Korea", LAObjects);
        locations.add(Korea);
        //Chicago - Lincoln Park, The Chicago bean, Wrigley Field

        GameObject park = new GameObject("Lincoln Park");
        GameObject chicago_bean = new GameObject("Cloud Gate");
        GameObject field = new GameObject("Wrigley Field");
        GameObject[] chicagoObjects = {park, chicago_bean, field};
        Location chicago = new Location("Chicago", chicagoObjects);
        locations.add(chicago);
        

        int length = 0;
        for (Location l: locations) {
            if (l.getObjects().length > 0) {
                length += l.getObjects().length;
            }
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
                    System.out.println("Teleporting!");
                    currentLocation = teleport(locations, currentLocation);
                }
                else if(c.equals("/quit"))
                {
                    break;
                } else if (c.equals("/backpack")) {
                    if (backpack.size() > 0) {
                        System.out.print("\n[");
                        for (GameObject o : backpack) {
                            System.out.print(o.getName() + ", ");
                        }
                        System.out.println("]");
                    } else {
                        System.out.println(backpack);
                    }

                }



            }




        }
    }

    public static void help() {
        System.out.println("This is a list of commands to help you get started.\n/interact (object): Allows you to interact with an object in your location. \n/list: Lists all objects and locations contained within your current location. \n/teleport: Allows you to switch locations. \n/quit: Ends the game. \n/save: Saves your information to your device.");
    }

    public static void interact(GameObject o, ArrayList<GameObject> backpack) {
        GameObject retval = o.interact();
        if (retval != null) {
            backpack.add(retval);
        }
    }

    public static void list(ArrayList<Location> locations, int currentLocation) {
        System.out.println("This is your location: " + locations.get(currentLocation).getName());
        System.out.println("These are the objects in your location:");
        GameObject[] objects = locations.get(currentLocation).getObjects();
        for (GameObject object : objects)
        {
            System.out.println("\t" + object.getName());
        }


    }

    public static int teleport(ArrayList<Location> locations, int currentLocation){
        Scanner s = new Scanner(System.in);
        System.out.println("Choose from the following locations to teleport to:");
        for (int i = 1; i <= locations.size(); i++)
        {
            System.out.println( "\t" + i + ". " + locations.get(i - 1).getName());
        }
        System.out.println("Select the number corresponding to the location you desire to teleport to: ");
        int destination = s.nextInt()-1;
        currentLocation = destination;
        try
        {
            System.out.println("You have arrived in: " + locations.get(currentLocation).getName() + ". Try the /list command to see what you can interact with.");
        }
        catch (NullPointerException ne)
        {
            System.out.println("The number you entered is outside the list of places you can go to. Please enter only a number from 1-" + locations.size());
            destination = s.nextInt()-1;
        }
        return currentLocation;
    }

    public static void save() {
        // not sure how to do this, seeing as we don't have a database or a way of communicating with one
        // we could try saving it to a file on the user's computer
    }
}