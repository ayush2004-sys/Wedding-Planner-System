<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sign Up</title>
  <link rel="stylesheet" href="styles.css"> <!-- Link to your CSS file -->
  <script>
    function signUpSuccess() {
      // Display pop-up message
      alert("Sign up successful!");
      // Redirect to login page after the message is closed
      window.location.href = "signin.jsp";
    }
  </script>
</head>
<body>
  <div class="container">
    <div class="signin-box">
      <h2>Sign Up</h2>
      <form method="post" action="RegisterServlet"> <!-- Assuming signup.jsp is the JSP file handling signup -->
        <!-- Sign up form fields -->
        <input type="text" name="username" placeholder="Username" required>
        <input type="email" name="email" placeholder="Email" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Sign Up</button>
      </form>
    </div>
  </div>
</body>
</html>
