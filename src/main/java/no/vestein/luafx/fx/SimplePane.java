package no.vestein.luafx.fx;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import no.vestein.luafx.event.Event;
import no.vestein.luafx.event.Eventable;
import no.vestein.luafx.LuaFX;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vestein on 25.01.2016.
 */
public class SimplePane extends Pane implements Simple, Eventable {

  private final String ID;
  protected Map<String, Node> children = new HashMap<>();

  public SimplePane(String ID, int x, int y, int width, int height) {
    super();
    setLayoutX(x);
    setLayoutY(y);
    setPrefSize(width, height);
    setMaxSize(width, height);
    this.ID = ID;

    LuaFX.NODES.add(this);

    setOnMouseClicked(mouseEvent -> {
      LuaFX.EVENT_BUS.post(this, Event.MOUSE_CLICKED);
    });
    setOnMouseEntered(mouseEvent -> {
      LuaFX.EVENT_BUS.post(this, Event.MOUSE_ENTERED);
    });

  }

  public void setColor() {
    //TODO
  }

  public void addChild(Simple node) {
    addChild(node.getID(), (Node) node);
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
