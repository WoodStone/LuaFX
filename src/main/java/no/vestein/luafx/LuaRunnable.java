package no.vestein.luafx;

import no.vestein.luafx.lua.function.Gui;
import no.vestein.luafx.lua.function.jos;
import no.vestein.luafx.lua.function.Number;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vestein on 25.01.2016.
 */
public class LuaRunnable implements Runnable {

  private final String path;
  private final Globals globals;
  private boolean initDone = false;
  private List<String> libs;

  public LuaRunnable(String path) {
    this.path = path;
    this.globals = JsePlatform.standardGlobals();
    libs = new ArrayList<>();
  }

  public void addLib(String path) {
    if (initDone) {
      throw new IllegalStateException("Can not add lua library after init");
    }
    libs.add(path);
  }

  @Override
  public void run() {
    initDone = true;
    initGlobals();
    initLibs();

    LuaValue chunk = globals.loadfile(path);
    chunk.call();
  }

  private void initLibs() {
    for (String lib : libs) {
      globals.loadfile(lib).call();
    }
  }

  private void initGlobals() {
    globals.load(new Number());
    globals.load(new Gui());
    globals.load(new jos());
  }

}
