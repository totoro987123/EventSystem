// IMPORTS
import java.util.HashMap;

/**
 * This static EventHandler class is used to store events in a hashmap
 * with their eventNames. This allows for the retrival of an existing
 * event with the same event name. getEvent() will either return the
 * event with that name, or make a new one. This allows for different
 * classes and different objects to access the same events, and thus one
 * can trigger something in the other.
 * @author Lawson Wright
 * @since 2020-09-18
 * @version 1.0.0
 */
public final class EventHandler {
    // STATIC VARIABLES
    /**
     * Stores all created events with their eventnames.
     */
    private static HashMap<String, Event> events = new HashMap<String, Event>();

    /** Private constructor to prevent instantiation.*/
    private EventHandler() {
        throw new UnsupportedOperationException();
    }

    // STATIC METHODS
    /**
     * Either returns an existing Event with the eventName (cached in a HashMap)
     * or will create a new event and return that one.
     * !This is the recommended way to create new Events. "new Event()" should
     * !NOT be used if you want events to work between classes & objects.
     * @param eventName the object to be passed into the method
     *                  calls as the firing parameter.
     * @return event the existing event with that name, or a new one.
     */
    public static Event getEvent(final String eventName) {
        Event newEvent = events.get(eventName);
        if (newEvent != null) {
            return newEvent;
        }

        newEvent = new Event(eventName);
        events.put(eventName, newEvent);
        return newEvent;
    }
}
