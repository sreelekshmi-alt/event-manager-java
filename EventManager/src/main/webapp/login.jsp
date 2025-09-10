<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Login</title></head>
<body>
<h2>Login</h2>
<form action="auth" method="post">
  <input type="hidden" name="action" value="login"/>
  <label>Username/Email: <input type="text" name="key"/></label><br/>
  <label>Password: <input type="password" name="password"/></label><br/>
  <button type="submit">Login</button>
</form>
<p><a href="register.jsp">Register</a></p>
</body>
</html>
