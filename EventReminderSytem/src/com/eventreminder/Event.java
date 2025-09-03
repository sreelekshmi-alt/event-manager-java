package com.eventreminder;

import java.time.LocalDateTime;

public class Event {
    private int userId;
    private String eventName;
    private LocalDateTime eventTime;

    public Event(int userId, String eventName, LocalDateTime eventTime) {
        this.userId = userId;
        this.eventName = eventName;
        this.eventTime = eventTime;
    }

    public int getUserId() { return userId; }
    public String getEventName() { return eventName; }
    public LocalDateTime getEventTime() { return eventTime; }
}
