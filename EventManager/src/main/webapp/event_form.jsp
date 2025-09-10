<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.eventreminder.*" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    // If editing, you could pass ?id=xxx and fetch event by id
    String idParam = request.getParameter("id");
    Event event = new Event();
    if (idParam != null) {
        try {
            int id = Integer.parseInt(idParam);
            EventDAO dao = new EventDAO();
            for (Event e : dao.listEventsForUser(user.getId())) {
                if (e.getId() == id) {
                    event = e;
                    break;
                }
            }
        } catch (Exception ex) {
            // ignore if error
        }
    }
%>
<html>
<head><title><%= (event.getId() > 0 ? "Edit Event" : "Add Event") %></title></head>
<body>
<h2><%= (event.getId() > 0 ? "Edit Event" : "Add Event") %></h2>

<form action="event" method="post">
    <input type="hidden" name="action" value="<%= (event.getId() > 0 ? "update" : "add") %>"/>
    <% if (event.getId() > 0) { %>
        <input type="hidden" name="id" value="<%= event.getId() %>"/>
    <% } %>

    Name: <input type="text" name="name" value="<%= event.getName() == null ? "" : event.getName() %>"/><br/>
    Description: <input type="text" name="description" value="<%= event.getDescription() == null ? "" : event.getDescription() %>"/><br/>
    Category: <input type="text" name="category" value="<%= event.getCategory() == null ? "" : event.getCategory() %>"/><br/>
    Location: <input type="text" name="location" value="<%= event.getLocation() == null ? "" : event.getLocation() %>"/><br/>
    Date: <input type="date" name="event_date" value="<%= event.getEventDate() == null ? "" : event.getEventDate() %>"/><br/>
    Time: <input type="time" name="event_time" value="<%= event.getEventTime() == null ? "" : event.getEventTime() %>"/><br/>
    Priority:
    <select name="priority">
        <option value="0" <%= event.getPriority() == 0 ? "selected" : "" %>>Low</option>
        <option value="1" <%= event.getPriority() == 1 ? "selected" : "" %>>Medium</option>
        <option value="2" <%= event.getPriority() == 2 ? "selected" : "" %>>High</option>
    </select><br/>

    <button type="submit"><%= (event.getId() > 0 ? "Update Event" : "Add Event") %></button>
</form>

<p><a href="events.jsp">Back to Events</a></p>
</body>
</html>
