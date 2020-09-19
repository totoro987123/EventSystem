public class Listener {
    
    private Event triggerEvent = Event.getEvent("triggerEvent");

    public Listener(){
        triggerEvent.connect(this);
    }

    public void triggerEvent(Object obj){
        System.out.printf("\n\nEvent triggered with this message: %s\n\n", obj);
    }
}
