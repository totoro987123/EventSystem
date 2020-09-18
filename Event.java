/**
 * This event class is used to create events that can be used between classes and trigger methods when fired.
 * Event retrival should be done via the Event.getEvent(eventName) method. 
 * This method will either return an already existing event with that name or create a new one.
 * A class can connect to an event via connect(Object). 
 * When an event is fired it will look for a method with the eventName specified in the constructor in all objects connected.
 * If found, this method will be triggered.
 * 
 * @author totoro987123
 * @version 1.0.0
 */


// IMPORTS
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Event {
    
    // INSTANCE VARIABLES
    private ArrayList<Object> connections = new ArrayList<Object>();
    private String eventName;


    // CONSTRUCTOR
    /** 
     * Class constructor.
     * 
     * @param eventName the event name to be used to find methods in connected objects.
     */
    public Event(String eventName){
        this.eventName = eventName;
    }


    // INSTANCE METHODS
    /** 
     * Connects an object to the event. 
     * When the event is fired, all connected objects will have the method by the name of eventName called.
     * 
     * @param connection the connection for which to bind the event to.
     */
    public void connect(Object connection) {
        this.connections.add(connection);
    }

    /** 
     * Removes all bound connections for this object.
     * 
     * @param connection the connection to be unbound.
     */
    public void disconnect(Object connection) {
        this.connections.remove(connection);
    }

    /** 
     * Fires the event, in turn calling the method with the same name as eventName in all bound objects.
     * 
     * @param object the object to be passed into the method calls as the firing parameter.
     */
    public void fire(Object obj) {
        for (Object listener : connections) {
            Method method;
            try {
                method = listener.getClass().getMethod(this.eventName, Object.class);
    
                try {
                    method.invoke(listener, obj);
                }
                catch (IllegalArgumentException e) {}
                catch (IllegalAccessException e) {}
                catch (InvocationTargetException e) {}
            } 
            catch (SecurityException e) {}
            catch (NoSuchMethodException e) {
                System.out.printf("EER: Could not find method %s in object %s.%n", this.eventName, listener.getClass().getName());
            }
        }
    }


    // STATIC METHODS
    private static HashMap<String, Event> Events = new HashMap<String, Event>();

    /** 
     * Either returns an existing Event with the eventName (cached in a HashMap) or will create a new event and return that one.
     * 
     * !This is the recommended way to create new Events. 
     * !"new Event()" should NOT be used if you want events to work between classes & objects.
     * 
     * @param eventName the object to be passed into the method calls as the firing parameter.
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
