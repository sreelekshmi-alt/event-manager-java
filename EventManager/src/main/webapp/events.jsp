<%@ page import="java.util.*,com.eventreminder.*" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    EventDAO dao = new EventDAO();
    List<Event> events = dao.listEventsForUser(user.getId());
%>
<html>
<head><title>My Events</title></head>
<body>
<h2>Welcome, <%= user.getFullName() %></h2>
<a href="auth?action=logout">Logout</a>

<h3>Add Event</h3>
<form action="event" method="post">
  <input type="hidden" name="action" value="add"/>
  Name: <input type="text" name="name"/><br/>
  Description: <input type="text" name="description"/><br/>
  Category: <input type="text" name="category"/><br/>
  Location: <input type="text" name="location"/><br/>
  Date: <input type="date" name="event_date"/><br/>
  Time: <input type="time" name="event_time"/><br/>
  Priority: <select name="priority">
      <option value="0">Low</option>
      <option value="1">Medium</option>
      <option value="2">High</option>
  </select><br/>
  <button type="submit">Add Event</button>
</form>

<h3>Your Events</h3>
<table border="1">
<tr><th>Name</th><th>Date</th><th>Time</th><th>Priority</th></tr>
<% for (Event e : events) { %>
<tr>
  <td><%= e.getName() %></td>
  <td><%= e.getEventDate() %></td>
  <td><%= e.getEventTime() %></td>
  <td><%= e.getPriority() %></td>
</tr>
<% } %>
</table>
</body>
</html>
