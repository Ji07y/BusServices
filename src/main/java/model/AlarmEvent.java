package model;



public class AlarmEvent {
    private String name;
    private String severity;

    public AlarmEvent(String name, String severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public String getSeverity() {
        return severity;
    }
}
