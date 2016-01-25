package no.vestein.luafx.lua.function;

import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

/**
 * Created by Vestein on 25.01.2016.
 */
public class os extends TwoArgFunction {

  @Override
  public LuaValue call(LuaValue modname, LuaValue env) {
    LuaValue library = tableOf();
    library.set("sleep", new sleep());
    library.set("eventBus", new eventBus());

    env.set("os", library);
    env.get("package").get("loaded").set("os", library);
    return library;
  }

  static class sleep extends OneArgFunction {
    @Override
    public LuaValue call(LuaValue arg) {
      try {
        Thread.sleep(arg.toint() * 1000);
      } catch (InterruptedException e) {

      }
      return null;
    }
  }

  static class eventBus extends OneArgFunction {

    @Override
    public LuaValue call(LuaValue arg) {
      LuaTable table = new LuaTable();

      return table;
    }
  }
}
