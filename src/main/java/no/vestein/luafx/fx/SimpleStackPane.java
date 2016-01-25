package no.vestein.luafx.fx;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vestein on 25.01.2016.
 */
public class SimpleStackPane extends StackPane {

  protected Map<String, Node> children = new HashMap<>();

  public SimpleStackPane() {
    super();
  }

  public SimpleStackPane(int width, int height) {
    super();
    setPrefSize(width, height);
    setMaxSize(width, height);
  }

  public void setChildAlignment(String key, Pos pos) {
    if (children.containsKey(key)) {
      setAlignment(children.get(key), pos);
    }
  }

  public void addChild(String key, Node node) {
    if (!children.containsKey(key)) {
      getChildren().add(node);
      children.put(key, node);
    }
  }

  public void removeChild(String key) {
    if (children.containsKey(key)) {
      getChildren().remove(children.get(key));
      children.remove(key);
    }
  }

  public <T extends Node> T getChild(String key) {
    return (T) children.get(key);
  }

}
