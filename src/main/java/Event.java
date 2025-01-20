
public class Event extends Task{
    private String start;
    private String end;

    public Event(String name, String start, String end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[E]" + getStatusIcon() + " " + getName() + "(from: " + start + " to: "+end +")";
        //TODO: Implement DateTime
    }
}