import java.util.HashMap;

public class GameObject {
  private String name;
  public GameObject(String name) {
      this.name = name;
  }

  public GameObject() {
    this.name = "None";
  }

  public GameObject interact() {
    return new GameObject();
  }
}