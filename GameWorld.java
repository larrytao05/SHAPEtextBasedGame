public class GameWorld
{
// fields
private Location[] locations;
private GameObject[] objects;


  public GameWorld(int spawn, Location[] locations)
  {
    this.locations = locations;
    System.out.println("You have spawned in at " + locations[spawn] + ". Type in a command to begin or /help if you need help.");

  }
  


  
}