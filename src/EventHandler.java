/**
 * This static EventHandler class is used to store events in a hashmap with their eventNames. 
 * This allows for the retrival of an existing event with the same event name.
 * getEvent() will either return the event with that name, or make a new one.
 * This allows for different classes and different objects to access the same events, 
 * and thus one can trigger something in the other.
 * 
 * @author totoro987123
 * @since 2020-09-18
 * @version 1.0.0
 */

// IMPORTS
import java.util.HashMap;

public class EventHandler {
    // STATIC VARIABLES
    private static HashMap<String, Event> Events = new HashMap<String, Event>();

    // STATIC METHODS
    /** 
     * Either returns an existing Event with the eventName (cached in a HashMap) or will create a new event and return that one.
     * 
     * !This is the recommended way to create new Events. 
     * !"new Event()" should NOT be used if you want events to work between classes & objects.
     * 
     * @param eventName the object to be passed into the method calls as the firing parameter.
     * @return event the existing event with that name, or a new one. 
     */

    public static Event getEvent(String eventName){
        if (Events.get(eventName) != null){
            return Events.get(eventName);
        }

        Event newEvent = new Event(eventName);
        Events.put(eventName, newEvent);
        return newEvent;
    }
}
