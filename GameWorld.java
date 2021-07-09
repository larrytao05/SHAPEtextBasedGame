import java.util.ArrayList;

public class GameWorld
{
// fields
private ArrayList<Location> locations;
private GameObject[] objects;


  public GameWorld(int spawn, ArrayList<Location> locations)
  {
    this.locations = locations;
    System.out.println("You have spawned in at " + locations.get(spawn).getName() + ". Type in a command to begin or /help if you need help.");

  }
  


  
}