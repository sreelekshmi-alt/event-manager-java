package com.eventreminder;

import java.time.LocalDateTime;

public class Event {

    int eventId;
    int userId;
    String eventName;
    LocalDateTime eventTime;

    public Event(int eventId, int userId, String eventName, LocalDateTime eventTime) {
        this.eventId = eventId;
        this.userId = userId;
        this.eventName = eventName;
        this.eventTime = eventTime;
    }

    public int getEventId() { return eventId; }
    public int getUserId() { return userId; }
    public String getEventName() { return eventName; }
    public LocalDateTime getEventTime() { return eventTime; }
}
