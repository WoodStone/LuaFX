package no.vestein.luafx.fx;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import no.vestein.luafx.Eventable;
import no.vestein.luafx.LuaFX;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vestein on 25.01.2016.
 */
public class SimplePane extends Pane implements Eventable {

  private final String ID;
  protected Map<String, Node> children = new HashMap<>();

  public SimplePane(String ID, int x, int y, int width, int height) {
    super();
    setLayoutX(x);
    setLayoutY(y);
    setPrefSize(width, height);
    setMaxSize(width, height);
    this.ID = ID;

    setOnMouseClicked(mouseEvent -> {
      LuaFX.EVENT_BUS.post(this);
    });
  }

  public void setColor() {
    //TODO
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

  @Override
  public String getID() {
    return ID;
  }
}