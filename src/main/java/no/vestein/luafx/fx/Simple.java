package no.vestein.luafx.fx;

import javafx.scene.Node;

public interface Simple {

  String getID();

  void addChild(Simple node);

  void addChild(String key, Node node);

  void removeChild(String key);

  <T extends Node> T getChild(String key);

}
