package no.vestein.luafx;

import no.vestein.luafx.lua.function.Gui;
import no.vestein.luafx.lua.function.os;
import no.vestein.luafx.lua.function.Number;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

/**
 * Created by Vestein on 25.01.2016.
 */
public class LuaRunnable implements Runnable {

  private final String path;
  private final Globals globals;

  public LuaRunnable(String path) {
    this.path = path;
    this.globals = JsePlatform.standardGlobals();
  }

  @Override
  public void run() {
    initGlobals();

    LuaValue chunk = globals.loadfile(path);
    chunk.call();
  }

  private void initGlobals() {
    globals.load(new Number());
    globals.load(new Gui());
    globals.load(new os());
  }

}
