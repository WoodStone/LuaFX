package no.vestein.luafx.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vestein on 25.01.2016.
 */
public class EventBus {

  private Map<Event, List<EventListener>> bus;

  public EventBus() {
    bus = new HashMap<>();

    for (Event event : Event.values()) {
      bus.put(event, new ArrayList<>());
    }
  }

  public void post(Eventable eventable, Event event) {
    for (EventListener listener : bus.get(event)) {
      listener.update(eventable.getID(), event);
    }
  }

  public void register(Event event, EventListener listener) {
    if (!bus.get(event).contains(listener)) {
      bus.get(event).add(listener);
    }
  }

  public void unRegister(Event event, EventListener listener) {
    if (bus.get(event).contains(listener)) {
      bus.get(event).remove(listener);
    }
  }

}
