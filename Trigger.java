public class Trigger {
    
    private Event triggerEvent = Event.getEvent("triggerEvent");

    public Trigger() {}

    public void fireTriggerEvent(){
        this.triggerEvent.fire("message being sent across the event!");
    }

    //Driver
    public static void main(String[] args) {
        Listener exampleListener = new Listener();
        Trigger trigger = new Trigger();
        trigger.fireTriggerEvent();
    }
}
