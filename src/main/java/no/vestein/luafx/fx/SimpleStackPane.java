package no.vestein.luafx.fx;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import no.vestein.luafx.LuaFX;
import no.vestein.luafx.event.Event;
import no.vestein.luafx.event.Eventable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vestein on 25.01.2016.
 */
public class SimpleStackPane extends StackPane implements Simple, Eventable {

  private final String ID;
  protected Map<String, Node> children = new HashMap<>();

  public SimpleStackPane(String ID) {
    super();
    this.ID = ID;

    LuaFX.NODES.add(this);

  }

  public SimpleStackPane(String ID, int width, int height) {
    this(ID);
    setPrefSize(width, height);
    setMaxSize(width, height);
  }

  public void setChildAlignment(String key, Pos pos) {
    if (children.containsKey(key)) {
      setAlignment(children.get(key), pos);
    }
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
