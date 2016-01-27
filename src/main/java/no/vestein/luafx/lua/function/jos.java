package no.vestein.luafx.lua.function;

import no.vestein.luafx.LuaFX;
import no.vestein.luafx.event.Event;
import no.vestein.luafx.event.EventListener;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;

/**
 * Created by Vestein on 25.01.2016.
 */
public class jos extends TwoArgFunction {

  @Override
  public LuaValue call(LuaValue modname, LuaValue env) {
    LuaValue library = tableOf();
    library.set("sleep", new sleep());
    library.set("eventBus", new eventBus());

    env.set("javaOS", library);
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

  static class eventBus extends OneArgFunction implements EventListener {

    private String returnValue = "";

    public eventBus() {
      LuaFX.EVENT_BUS.register(Event.MOUSE_CLICKED, this);
    }

    @Override
    public LuaValue call(LuaValue arg) {
      LuaValue value = LuaValue.valueOf(returnValue);
      return value;
    }

    @Override
    public void update(String ID, Event event) {
      returnValue = ID + ";" + event.toString();
    }
  }
}
