package no.vestein.luafx.lua.function;

import javafx.application.Platform;
import no.vestein.luafx.LuaFX;
import no.vestein.luafx.fx.SimplePane;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

/**
 * Created by Vestein on 25.01.2016.
 */
public class Gui extends TwoArgFunction{

  @Override
  public LuaValue call(LuaValue modname, LuaValue env) {
    LuaValue library = tableOf();
    library.set("addNode", new addNode());
    library.set("removeNode", new removeNode());

    env.set("Gui", library);
    env.get("package").get("loaded").set("Gui", library);
    return library;
  }

  static class addNode extends TwoArgFunction {

    @Override
    public LuaValue call(LuaValue key, LuaValue node) {
      Platform.runLater(() -> {
          node.istable();
          final int x = node.get("x").toint();
          final int y = node.get("y").toint();
          final int width = node.get("width").toint();
          final int height = node.get("height").toint();
          System.out.println(x + "," + y + ";" + width + "," + height);
          SimplePane pane = new SimplePane(x, y, width, height);
          pane.setStyle("-fx-background-color: #FF0000");
          LuaFX.root.addChild(key.toString(), pane);

          System.out.println(LuaFX.root.getChildren().size());
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
