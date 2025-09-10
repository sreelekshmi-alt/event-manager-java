<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Register</title></head>
<body>
<h2>Register</h2>
<form action="auth" method="post">
  <input type="hidden" name="action" value="register"/>
  <label>Username: <input type="text" name="username"/></label><br/>
  <label>Email: <input type="email" name="email"/></label><br/>
  <label>Password: <input type="password" name="password"/></label><br/>
  <label>Full Name: <input type="text" name="fullName"/></label><br/>
  <button type="submit">Register</button>
</form>
<p><a href="login.jsp">Login</a></p>
</body>
</html>
