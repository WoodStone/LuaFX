package no.vestein.luafx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vestein on 25.01.2016.
 */
public class EventBus {

  private Map<String, List<EventListener>> bus;

  public EventBus() {
    bus = new HashMap<>();
  }

  public void post(Eventable eventable) {
    if (bus.containsKey(eventable.getID())) {
      for (EventListener listener : bus.get(eventable.getID())) {
        listener.update(eventable.getID());
      }
    }
  }

  public void register(String eventID, EventListener listener) {
    if (bus.containsKey(eventID)) {
      bus.get(eventID).add(listener);
    } else {
      List<EventListener> listeners = new ArrayList<>();
      listeners.add(listener);
      bus.put(eventID, listeners);
    }
  }

  public void unRegister(String eventID, EventListener listener) {
    if (bus.containsKey(eventID) && bus.get(eventID).contains(listener)) {
      bus.get(eventID).remove(listener);
    }
  }

}
