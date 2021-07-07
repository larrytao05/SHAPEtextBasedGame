public class Location{
  private String name;
  private GameObject[] objects;

  public Location(String name, GameObject[] objects) {
      this.name = name;
      this.objects = objects;
  }

  public String getName()
  {
    return name;
  }

  public GameObject[] getObjects()
  {
    return objects;
  }

}