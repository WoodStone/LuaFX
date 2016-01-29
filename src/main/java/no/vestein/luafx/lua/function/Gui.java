package no.vestein.luafx.lua.function;

import javafx.application.Platform;
import javafx.scene.Node;
import no.vestein.luafx.LuaFX;
import no.vestein.luafx.fx.SimplePane;
import no.vestein.luafx.fx.SimpleStackPane;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.ThreeArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

/**
 * Created by Vestein on 25.01.2016.
 */
public class Gui extends TwoArgFunction{

  @Override
  public LuaValue call(LuaValue modname, LuaValue env) {
    LuaValue library = tableOf();
    library.set("makeNode", new makeNode());
    library.set("setStyle", new setStyle());
    library.set("addChild", new addChild());
    library.set("removeChild", new removeChild());
    library.set("removeNode", new removeNode());

    env.set("Gui", library);
    env.get("package").get("loaded").set("Gui", library);
    return library;
  }

  static class makeNode extends ThreeArgFunction {

    @Override
    public LuaValue call(LuaValue type, LuaValue key, LuaValue data) {
      switch (type.toString().toLowerCase()) {
        case "pane":
          pane(key, data);
        case "stackpane":
          stackpane(key, data);
      }

      return LuaValue.TRUE;
    }

    private void pane(LuaValue key, LuaValue data) {
      if (data.istable()) {
        final int x = data.get("x").toint();
        final int y = data.get("y").toint();
        final int width = data.get("width").toint();
        final int height = data.get("height").toint();

        SimplePane pane = new SimplePane(key.toString(), x, y, width, height);
      }
    }

    private void stackpane(LuaValue key, LuaValue data) {
      if (data.istable()) {
        final int width = data.get("width").toint();
        final int height = data.get("height").toint();

        SimpleStackPane pane = new SimpleStackPane(key.toString(), width, height);
      }
    }

  }

  static class setStyle extends TwoArgFunction {

    @Override
    public LuaValue call(LuaValue key, LuaValue style) {
      Platform.runLater(() -> {
        Node node = (Node) LuaFX.NODES.get(key.toString());
        node.setStyle(style.toString());
      });

      return LuaValue.TRUE;
    }

  }

  static class addChild extends TwoArgFunction {

    @Override
    public LuaValue call(LuaValue parentKey, LuaValue childKey) {
      Platform.runLater(() -> {
        if (LuaFX.NODES.contains(parentKey.toString()) && LuaFX.NODES.contains(childKey.toString())) {
          LuaFX.NODES.get(parentKey.toString()).addChild(LuaFX.NODES.get(childKey.toString()));
        }
      });
      return LuaValue.valueOf(true);
    }

  }

  static class removeChild extends TwoArgFunction {

    @Override
    public LuaValue call(LuaValue parentKey, LuaValue childKey) {
      Platform.runLater(() -> {
        if (LuaFX.NODES.contains(parentKey.toString()) && LuaFX.NODES.contains(childKey.toString())) {
          LuaFX.NODES.get(parentKey.toString()).removeChild(childKey.toString());
        }
      });
      return LuaValue.valueOf(true);
    }

  }

  static class removeNode extends OneArgFunction {

    @Override
    public LuaValue call(LuaValue key) {
      Platform.runLater(() -> {
        LuaFX.root.removeChild(key.toString());
      });

      return LuaValue.valueOf(true);
    }

  }

}
