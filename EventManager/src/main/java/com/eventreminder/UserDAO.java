package com.eventreminder;

import java.sql.*;

public class UserDAO {
    public boolean register(User u) throws SQLException {
        String sql = "INSERT INTO users (username, email, password, full_name) VALUES (?, ?, ?, ?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getFullName());
            return ps.executeUpdate() == 1;
        }
    }

    public User findByUsernameOrEmail(String key) throws SQLException {
        String sql = "SELECT * FROM users WHERE username=? OR email=?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, key);
            ps.setString(2, key);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User u = new User();
                    u.setId(rs.getInt("id"));
                    u.setUsername(rs.getString("username"));
                    u.setEmail(rs.getString("email"));
                    u.setPassword(rs.getString("password"));
                    u.setFullName(rs.getString("full_name"));
                    return u;
                }
            }
        }
        return null;
    }
}
