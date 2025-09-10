package com.eventreminder;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {
    private int id;
    private int userId;
    private String name;
    private String description;
    private String category;
    private String location;
    private LocalDate eventDate;
    private LocalTime eventTime;
    private int priority;

    // Getters & Setters
    public int getId() 
    { 
    	return id; 
    }
    public void setId(int id) 
    { 
    	this.id = id;
    }

    public int getUserId() 
    { 
    	return userId; 
    }
    public void setUserId(int userId) 
    { 
    	this.userId = userId;
    	}

    public String getName() 
    { 
    	return name; 
    	}
    public void setName(String name)
    { 
    	this.name = name; 
    	}

    public String getDescription()
    { 
    	return description; 
    	}
    public void setDescription(String description) 
    { 
    	this.description = description; 
    	}

    public String getCategory() 
    { 
    	return category; 
    	}
    public void setCategory(String category) 
    { 
    	this.category = category; 
    	}

    public String getLocation() 
    { 
    	return location; 
    	}
    public void setLocation(String location) 
    { 
    	this.location = location; 
    	}

    public LocalDate getEventDate() 
    { 
    	return eventDate; 
    	}
    public void setEventDate(LocalDate eventDate) 
    { 
    	this.eventDate = eventDate; 
    	}

    public LocalTime getEventTime() 
    { 
    	return eventTime; 
    	}
    public void setEventTime(LocalTime eventTime) 
    { 
    	this.eventTime = eventTime; 
    	}

    public int getPriority() 
    { 
    	return priority; 
    	}
    public void setPriority(int priority) 
    { 
    	this.priority = priority; 
    	}
}
