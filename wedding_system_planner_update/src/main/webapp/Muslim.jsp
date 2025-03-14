<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Wedding Planning Form</title>
  <link rel="stylesheet" href="form.css">
</head>
<body class="muslimForm">
  <h1>
    <span style="--index: 1;">Wedding</span>
    <span style="--index: 2;">Planning</span>
    <span style="--index: 3;">Form</span>
  </h1>
  
  <form id="weddingForm" class="hinduWedding" action="HinduServlet" method="post">
    <label for="firstName">First Name:</label>
    <input type="text" id="firstName" name="firstName" placeholder="FirstName" required><br><br>
    
    <label for="lastName">Last Name:</label>
    <input type="text" id="lastName" name="lastName" placeholder="LastName" required><br><br>
    
    <label for="contactNumber">Contact Number:</label>
    <input type="text" id="contactNumber" name="contactNumber"  placeholder="ContactNumber" required><br><br>
    
    <label for="location">Location:</label>
    <input type="text" id="location" name="location"  placeholder="Location" required><br><br>
    
    <label for="weddingDate">Wedding Date:</label>
    <input type="date" id="weddingDate" name="weddingDate"  placeholder="WeddingDate" required><br><br>
    
    <label for="totalBudget">Total Budget:</label>
    <input type="number" id="totalBudget" name="totalBudget"  placeholder="TotalBudget" required><br><br>
    
    <input class="submit" type="submit" value="submit">
    <input class="reset" type="reset" value="Reset">
  </form>

  <script src="script.js"></script>
</body>
</html>
