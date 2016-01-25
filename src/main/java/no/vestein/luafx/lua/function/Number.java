package no.vestein.luafx.lua.function;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.ZeroArgFunction;

/**
 * Created by Vestein on 25.01.2016.
 */
public class Number extends TwoArgFunction {

  @Override
  public LuaValue call(LuaValue modname, LuaValue env) {
    LuaValue library = tableOf();
    library.set("pi", new pi());

    env.set("Number", library);
    env.get("package").get("loaded").set("Number", library);
    return library;
  }

  static class pi extends ZeroArgFunction {

    @Override
    public LuaValue call() {
      return LuaValue.valueOf(Math.PI);
    }
  }

}
