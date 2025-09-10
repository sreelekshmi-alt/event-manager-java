package com.eventreminder;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {
    public boolean addEvent(Event e) throws SQLException {
        String sql = "INSERT INTO events (user_id, name, description, category, location, event_date, event_time, priority) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, e.getUserId());
            ps.setString(2, e.getName());
            ps.setString(3, e.getDescription());
            ps.setString(4, e.getCategory());
            ps.setString(5, e.getLocation());
            ps.setDate(6, Date.valueOf(e.getEventDate()));
            if (e.getEventTime() != null) ps.setTime(7, Time.valueOf(e.getEventTime()));
            else ps.setNull(7, Types.TIME);
            ps.setInt(8, e.getPriority());
            return ps.executeUpdate() == 1;
        }
    }

    public List<Event> listEventsForUser(int userId) throws SQLException {
        List<Event> list = new ArrayList<>();
        String sql = "SELECT * FROM events WHERE user_id=? ORDER BY event_date, event_time";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, userId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Event e = new Event();
                    e.setId(rs.getInt("id"));
                    e.setUserId(rs.getInt("user_id"));
                    e.setName(rs.getString("name"));
                    e.setDescription(rs.getString("description"));
                    e.setCategory(rs.getString("category"));
                    e.setLocation(rs.getString("location"));
                    Date d = rs.getDate("event_date");
                    if (d != null) e.setEventDate(d.toLocalDate());
                    Time t = rs.getTime("event_time");
                    if (t != null) e.setEventTime(t.toLocalTime());
                    e.setPriority(rs.getInt("priority"));
                    list.add(e);
                }
            }
        }
        return list;
    }
}
