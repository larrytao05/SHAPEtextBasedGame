import java.util.*;
import java.io.*;


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
        ArrayList<String> charlieDialogue = new ArrayList<>();
        charlieDialogue.add("Hi! My name is Charlie.");
        charlieDialogue.add("If there's anything you ever want to know about this city, you can ask me.");
        charlieDialogue.add("By the way, I heard from one of my sources that if you ever wanted to steal something from the Louvre, today's the day. All of the guards have mysteriously disappeared!");
        Person npc1 = new Person("Charlie", eiffelTower, charlieDialogue);
        ArrayList<String> macaronDialogue = new ArrayList<>();
        macaronDialogue.add("I'm Macaron, the president of this good-for-nothing country.");
        macaronDialogue.add("One of the most acclaimed paintings of all time was stolen from right under our noses a few days ago. I only hope that something like that doesn't happen again.");
        macaronDialogue.add("I'd leave this place by teleporting as soon as I could if I were you. Anywhere is better than here.");
        Person npc2 = new Person("Macaron", null, macaronDialogue);
        GameObject[] parisObjects = {eiffelTower, louvre, cathedral, npc1, npc2};
        Location paris = new Location("Paris", parisObjects);
        locations.add(paris);
        // London initialization
        ArrayList<String> victoriaDialogue = new ArrayList<>();
        victoriaDialogue.add("You sneak behind Victoria while she's preparing for an upcoming dinner party.");
        victoriaDialogue.add(" You stab her cleanly through the heart, the knife not even making a sound as it passes through her body.");
        victoriaDialogue.add(" Taking one last look at her crumpled figure on the floor, you jump out of the window of Buckingham Palace.");
        Person victoria = new Person("Victoria", null, victoriaDialogue);
        GameObject palace = new GameObject("Buckingham Palace", victoria);
        GameObject bigBen = new GameObject("Big Ben");
        GameObject royalCrown = new GameObject("Royal Crown of England");
        ArrayList<String> queenDialogue = new ArrayList<>();
        queenDialogue.add("Well, hello there. I see you are one of those travelers everyone's been going crazy about lately. If you don't mind, I have a small task for you to complete. Rest assured you will recieve a hefty reward shall you complete it.");
        queenDialogue.add("Your task is simple. There is a royal crown in my possession currently. If you wear the crown to Buckingham Palace, you will be allowed into the building no questions asked. Once you get in, assassinate my daughter Victoria and escape without getting caught.");
        queenDialogue.add("If you succeed, a guard by the name of Michael will be waiting outside with your reward.");
        queenDialogue.add("Good luck!");
        Person queen = new Person("Queen Elizabeth", royalCrown, queenDialogue);
        ArrayList<String> michaelDialogue = new ArrayList<>();
        michaelDialogue.add("Here is your reward. By the way, I heard from a little bird that Italy could be an attractive place for you to visit next, if you know what I mean.");
        Person michael = new Person("Michael the Guard", reward, michaelDialogue);
        GameObject[] londonObjects = {palace, bigBen, queen, michael};
        Location london = new Location("London", londonObjects);
        locations.add(london);
        //Rome initialization
        GameObject colosseum = new GameObject("Colosseum");
        GameObject pantheon = new GameObject("Pantheon");
        GameObject cinqueTerre = new GameObject("Cinque Terre");
        GameObject pasta = new GameObject("Pasta Carbonara");
        ArrayList<String> guideDialogue = new ArrayList<>();
        Person tourGuide = new Person("Antonio", pasta, guideDialogue);
        GameObject[] italyObjects = {colosseum, pantheon, cinqueTerre};
        Location italy =  new Location("Italy", italyObjects);
        locations.add(italy);
        //NYC initializaiton
        GameObject wtc = new GameObject("World Trade Center");
        GameObject barclay = new GameObject("Barclays Center");
        GameObject yankeeStadium = new GameObject("Yankee Stadium");
        ArrayList<String> fanDialogue = new ArrayList<>();
        fanDialogue.add("Hey!! Watch where your'e going man! I'm trying to get to the Yankee Stadium before all the good seats get taken! ");
        fan.Dialogue("Also, today is a gonna be a good game if you wanna come. Hoping to see Aaron Judge and Gary Sanchez get some home runs against those NY-counterfeit Mets. I hope your's not a Mets fan because if you are, you might as well run away before I do something about it. ");
        Person yankeeFan = new Person("Joseph", null, fanDialogue);
        GameObject[] nyobjects = {wtc, barclay, yankeeStadium, yankeeFan};
        Location nyc = new Location("New York City", nyobjects);
        locations.add(nyc);
        //LA initialization
        GameObject venice_beach = new GameObject("Venice Beach");
        GameObject hollywood_sign = new GameObject("Hollywood Sign");
        GameObject hollywood_walk = new GameObject("Hollywood Walk of Fame");
        GameObject[] LAObjects = {venice_beach, hollywood_sign, hollywood_walk};
        Location LA = new Location("Los Angeles", LAObjects);
        locations.add(LA);
        //China initialization
        GameObject greatWall = new GameObject("The Great Wall of China");
        GameObject forbiddenCity = new GameObject("The Forbidden City");
        GameObject terracotta = new GameObject("The Terracotta Army");
        GameObject[] chinaObjects = {greatWall, forbiddenCity, terracotta};
        Location china = new Location("China", chinaObjects);
        locations.add(china);
        //Korea initialization
        GameObject jeju = new GameObject("Jeju Island");
        GameObject busan = new GameObject("Busan");
        GameObject tower = new GameObject("Seoul Tower");
        GameObject[] koreaObjects = {jeju, busan, tower};
        Location korea = new Location("Korea", koreaObjects);
        locations.add(korea);
        //Chicago initialization
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

        //spawn
        System.out.println("Where would you like to spawn?");
        int spawn = s.nextInt();
        GameWorld w = new GameWorld(spawn, locations);
        currentLocation = spawn;
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
        System.out.println("This is a list of commands to help you get started.\n/interact (object): Allows you to interact with an object in your location. \n/list: Lists all objects and locations contained within your current location. \n/teleport: Allows you to switch locations. \n/quit: Ends the game. \n/save: Saves your information to your device. \n/backpack: shows you the contents of your backpack.");
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
        catch (IndexOutOfBoundsException ne)
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