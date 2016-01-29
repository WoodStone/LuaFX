package no.vestein.luafx;

import no.vestein.luafx.event.Eventable;
import no.vestein.luafx.fx.Simple;

import java.util.HashMap;
import java.util.Map;

public class Nodes {

  private Map<String, Simple> nodes;

  public Nodes() {
    nodes = new HashMap<>();
  }

  public void add(Simple node) {
    if (!nodes.containsKey(node.getID())) {
      nodes.put(node.getID(), node);
    }
  }

  public void remove(String key) {
    nodes.remove(key);
  }

  public void remove(Simple node) {
    nodes.remove(node.getID());
  }

  public Simple get(String key) {
    return nodes.get(key);
  }

  public boolean contains(String key) {
    return nodes.containsKey(key);
  }

}
