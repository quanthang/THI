<%@ page import="com.example.thilaiwcd.entity.Employee" %><%
   Employee user = (Employee)request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container">
    <h2>Text Opacity</h2>



    <div class="w3-panel w3-green">
        <h2 class="w3-opacity">Success full</h2>
    </div>
<div>Id: <%= user.getId()%></div>
<div>FullName: <%= user.getFullName()%></div>
<div>Birthday: <%= user.getBirthday()%></div>
<div>Address: <%= user.getAddress()%></div>
<div>Position: <%= user.getPosition()%></div>
<div>Department: <%= user.getDepartment()%></div>

</div>

</body>
</html>
